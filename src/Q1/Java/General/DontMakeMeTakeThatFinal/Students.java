package Q1.Java.General.DontMakeMeTakeThatFinal;



public class Students implements Comparable<Students> {
    private String name;
    private int grade;
    private boolean referals;

    public Students(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public boolean changeLowestGrade(int lower) {
        grade = lower;
        if (grade < 89) {
            referals = true;
        }
        return referals;
    }

    public void changeReferals(boolean referals) {
        this.referals = referals;
    }

    @Override
    public int compareTo(Students o) {
        return this.name.compareTo(o.name);
    }

    public String getName() {return name;}
    public int getGrade() {return grade;}
    public boolean getReferals() {return referals;}


}
