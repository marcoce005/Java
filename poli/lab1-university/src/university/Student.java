package university;

public class Student {
    private int id;
    private String name;
    private String surname;

    private static final int MAX_COURSES = 25;
    private final Course[] coursesSubs = new Course[MAX_COURSES];
    private int cont = 0;

    private int totGrades = 0;
    private int totExams = 0;

    private double points = 0;

    public Student(int id, String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + surname;
    }

    public int subCourse(Course c) {
        if (cont < MAX_COURSES && c.isAvailable()) {
            coursesSubs[cont] = c;
            return cont++;
        }
        return -1;
    }

    public String allSubCourses() {
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < cont; i++) {
            str.append(coursesSubs[i].toString() + "\n");
        }
        return str.toString();
    }

    public void regExam(int grade) {
        totGrades += grade;
        totExams++;
        updatePoints();
    }

    public String avgGrades() {
        if (totExams == 0) {
            return "Student " + id + " hasn't taken any exams";
        }
        return "Student " + id + " : " + "%.1f".formatted((float) totGrades / totExams);
    }

    public void updatePoints() {
        if (totExams == 0) {
            points = 0;
        }
        points = ((double)totGrades / totExams) + (((double)totExams / cont) * 10);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getPoints() {
        return points;
    }
}