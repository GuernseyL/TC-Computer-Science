package Q1.Java.Langdocs.Prog901a;

public class Node {
    private String mydata;
    public Node mynext;
    public Node myprev;
    private String myReverse = "";

    public Node(String data) {
        mydata = data;
        mynext = null;
        myprev = null;
        //StringBuilder SB = new StringBuilder(data);
        //myReverse = SB.reverse().toString();
        for (int r = data.length()-1; r >= 0; r--) {
            myReverse += data.charAt(r);
        }
    }

    public String getForward() { return mydata; }

    public String getReverse() { return myReverse; }

}
