package Q1.Java.General.DontMakeMeTakeThatFinal;

public class Students <T extends Comparable<T>> {
    private T name;
    private int grade;
    private int referals;

    public Students(T name, int grade, int referals) {
        this.name = name;
        this.grade = grade;
        this.referals = referals;
    }

    public T getName() {return name;}
    public int getGrade() {return grade;}
    public int getReferals() {return referals;}
}
