package it.polito.oop.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Marks a test class or test method as belonging to a specific requirement,
 * enabling selective test execution based on the current Git branch.
 *
 * <p>When running on a feature branch named {@code <issue>-r<N>[-description]},
 * only tests whose requirement number is less than or equal to {@code N} are
 * executed; all others are skipped. On {@code main} or any branch that does
 * not match the expected naming pattern, all annotated tests run unconditionally.
 *
 * <p>When applied to both a class and a method, the method-level annotation
 * takes priority.
 *
 * <p>This annotation is meta-annotated with
 * {@link org.junit.jupiter.api.extension.ExtendWith @ExtendWith}({@link RequirementCondition}.class),
 * so no additional registration is required on the test class.
 *
 * <p>Example at class level:
 * 
 * <pre>{@code
 * @Requirement(2)
 * class SignupTests{
 *     &#064;Test
 *     void testValidSignup() { … }
 * }
 * }</pre>
 *
 * <p>Example at method level:
 * <pre>{@code
 * class AuthTests {
 *
 *     @Test
 *     @Requirement(1)
 *     void testLogin() { … }
 *
 *     &#064;Test
 *     @Requirement(2)
 *     void testOAuthLogin() { … }
 * }
 * }</pre>
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ExtendWith(RequirementCondition.class)
public @interface Requirement {
    int value();
}