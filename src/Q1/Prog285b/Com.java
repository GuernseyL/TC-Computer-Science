package Q1.Prog285b;

public class Com {
    private int myid;
    private int mycode;
    private double mysales;
    private double mycom;

    public Com(int id, int c, double s){
        myid = id;
        mycode = c;
        mysales = s;
        mycom = 0;
    }

    public void calc(){
        if((mycode ==5)||(mycode == 8)) {
            if (mysales <= 5000) {
                mycom = mysales*.75;
            }
            else {
                mycom = 5000*.075+(mysales-5000) *.085;
            }
        }
        if((mycode == 17)) {
            if (mysales <= 35000) {
                mycom = mysales*.095;
            }
            else {
                mycom = 35000*.095+(mysales-35000) *.12;
            }
        }
    }
    public String toString(){
        return myid+"\t"+mycode+"\t"+mysales+"\t"+mycom;
    }
}

