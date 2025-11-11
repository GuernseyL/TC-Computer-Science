package Q1.Java.BluePelican.DontMakeMeTakeThatFinal;



public class Students implements Comparable<Students> {
    private String name;
    private int grade;
    private boolean referals;

    public Students(String name, int grade) {
        this.name = name;
        this.grade = grade;
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
