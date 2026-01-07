package Q1.Java.Langdocs;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prog1060z {
    public static void main(String[] args) throws IOException {
        Scanner file = new Scanner(new File("langdat/prg1060z.dat"));
        PriorityQueue<String> data = new PriorityQueue<>();
        while (file.hasNextLine()) {
            String dats = file.nextLine();
            String stad;
            if (dats.equals("W")) {
                System.out.println("Processing Queue Report...");
                if (file.hasNextLine()) {
                    stad = file.nextLine();
                    while (!(stad.equals("W")) && !(stad.equals("P"))) {
                        data.add(stad);
                        System.out.println(stad);
                        stad = file.nextLine();
                    }
                }
                System.out.println("End of Report");
            }
            else if (dats.equals("P")) {
                if (!data.isEmpty()) {
                    System.out.println("Pop Accepted. Cause : Available Node\nCurrently Proccessing Job : " + data.poll());
                }
                else {
                    System.out.println("Pop Denied. Caused : Empty Queue");
                }
            }
        }
    }
}
/*
Processing Queue Report...
AA11
AB12
AC13
End of Report
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AA11
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AB12
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AC13
Pop Denied. Caused : Empty Queue
Processing Queue Report...
AS15
AP16
AQ17
AR18
AA19
AS20
AQ21
AR22
AS23
AP24
AQ25
AR26
AW27
AP28
AQ29
AR30
AT31
AP32
AQ33
AT34
AS35
AP36
AQ37
AR38
AA39
AS40
AQ41
AR42
AS43
AP44
AQ45
AR46
AW47
AP48
AQ49
AR50
AT51
AP52
AQ53
AT54
End of Report
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AA19
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AA39
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AP16
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AP24
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AP28
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AP32
Pop Accepted. Cause : Available Node
Currently Proccessing Job : AP36
Processing Queue Report...
End of Report
Processing Queue Report...
End of Report
 */
