package Q1.Java.General.DontMakeMeTakeThatFinal;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class DontMakeMeTakeThatFinal {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("src/Q1/Java/General/DontMakeMeTakeThatFinal/Data.txt"));
        TreeSet<Students> Data = new TreeSet<>();

        int grades = file.nextInt();
        int disciplines = file.nextInt();
        for (int i = 1; i <= grades; ++i) {
            String name = file.next();
            file.next();
            int grade = file.nextInt();
            Students student = new Students(name, grade);
            Data.add(student);
        }
        Iterator<Students> iterator = Data.iterator();
        while (iterator.hasNext()) {
            Students student = iterator.next();
            if (student.getGrade() < 89) {
                iterator.remove();
            }
        }
        iterator = Data.iterator();
        for (int i = 1; i <= disciplines; ++i) {
            String name = file.next();
            file.next();
            file.nextInt();
            for (Students f : Data) {
                if (f.getName().equals(name)) {
                    f.changeReferals(true);
                }
            }
        }

        while (iterator.hasNext()) {
            Students student = iterator.next();
            if (student.getReferals()) {
                iterator.remove();
            }
        }
        for (Students student : Data) {
            System.out.println(student.getName());
        }
    }
}
/*
Larry
Wilbur
 */
