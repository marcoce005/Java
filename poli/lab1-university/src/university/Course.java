package university;

public class Course {
    private int id;
    private String name;
    private String teacherName;

    private static final int MAX_STUDENTS = 100;
    private final Student[] studentsSubs = new Student[MAX_STUDENTS];
    private int cont = 0;

    private int totGrades = 0;
    private int totTry = 0;

    public Course(int id, String name, String teacherName) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + teacherName;
    }

    public boolean isAvailable() {
        return cont < MAX_STUDENTS;
    }

    public int subStudent(Student s) {
        if (cont < MAX_STUDENTS) {
            studentsSubs[cont] = s;
            return cont++;
        }
        return -1;
    }

    public String allSubStudents() {
        StringBuffer str = new StringBuffer("");
        for (int i = 0; i < cont; i++) {
            str.append(studentsSubs[i].toString() + "\n");
        }
        return str.toString();
    }

    public void regExam(int grade) {
        totGrades += grade;
        totTry++;
    }

    public String avgGrades() {
        if (totTry == 0) {
            return "No student has taken the exam in " + name;
        }
        return "The average for the course " + name + " is: " + "%.1f".formatted((float) totGrades / totTry);
    }
}