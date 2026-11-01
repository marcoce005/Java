package it.polito.oop.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

class RequirementCondition implements ExecutionCondition {
    private static final Pattern REQUIREMENT_BRANCH_PATTERN = Pattern.compile("^(\\d+)-r(\\d+)(?:-.+)?$");
    private static final String currentBranch = resolveCurrentBranch();

    private static String resolveCurrentBranch() {
        String current = System.getenv("CI_COMMIT_REF_NAME");
        if (current == null) {
            try {
                String head = Files.readString(Path.of(".git/HEAD"));
                if (head.startsWith("ref:")) {
                    current = head.substring(head.lastIndexOf("/") + 1).trim();
                } else {
                    current = "main";
                }
            } catch (IOException e) {
                current = "main";
            }
        }
        return current;
    }

    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
        // Method-level annotation takes priority
        Requirement methodAnn = context.getTestMethod()
                .map(m -> m.getAnnotation(Requirement.class))
                .orElse(null);
        if (methodAnn != null) {
            return evaluate(methodAnn.value());
        }

        // Fall back to class-level annotation
        Requirement classAnn = context.getTestClass()
                .map(c -> c.getAnnotation(Requirement.class))
                .orElse(null);
        if (classAnn != null) {
            return evaluate(classAnn.value());
        }

        return ConditionEvaluationResult.enabled("No @Requirement annotation present");
    }

    private ConditionEvaluationResult evaluate(int reqNo) {
        if ("main".equals(currentBranch)) {
            return ConditionEvaluationResult.enabled("Running on main, all requirements active");
        }

        Matcher matcher = REQUIREMENT_BRANCH_PATTERN.matcher(currentBranch);
        if (!matcher.matches()) {
            return ConditionEvaluationResult.enabled("Unrecognized branch format, running all tests");
        }

        int branchRequirement = Integer.parseInt(matcher.group(2));
        if (branchRequirement >= reqNo) {
            return ConditionEvaluationResult.enabled(
                    "Branch r" + branchRequirement + " includes requirement r" + reqNo);
        } else {
            return ConditionEvaluationResult.disabled(
                    "Skipping: branch " + currentBranch + " only covers up to r" + branchRequirement
                    + ", not r" + reqNo);
        }
    }
}