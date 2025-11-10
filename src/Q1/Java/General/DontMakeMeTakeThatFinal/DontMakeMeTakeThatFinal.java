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
                /*if (!Data.isEmpty()) {
                }*/
            }
        for (Students f : Data) {
            if (f.getGrade() < 89) {
                Data.remove(f);
            }
        }
            Iterator<Students> iterator = Data.iterator();
            /*for (int i = 1; i <= disciplines; ++i) {
                String name = file.next();
                file.next();
                file.nextInt();
                for (Students f : Data) {
                    if (f.getName().equals(name)) {
                        f.changeReferals(true);
                        Data.remove(f);
                    }
                }
            }*/
        for (Students student : Data) {
            System.out.println(student.getName());
        }
    }
}
