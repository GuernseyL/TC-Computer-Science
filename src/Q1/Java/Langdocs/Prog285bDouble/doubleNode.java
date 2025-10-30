package Q1.Java.Langdocs.Prog285bDouble;

public class doubleNode {
    public  doubleNode myPrev;
    private int        myId;
    private int        myCode;
    private double     mySales;
    private double     myCom;
    public  doubleNode myNext;

    public doubleNode(int id, int c, double s) {
        myPrev  = null;
        myId    = id;
        myCode  = c;
        mySales = s;
        myCom   = 0;
        myNext  = null;
    }

    public void calc(){
        if((myCode ==5)||(myCode == 8)) {
            if (mySales <= 5000) {
                myCom = mySales*.75;
            }
            else {
                myCom = 5000*.075+(mySales-5000) *.085;
            }
        }
        if((myCode == 17)) {
            if (mySales <= 35000) {
                myCom = mySales*.095;
            }
            else {
                myCom = 35000*.095+(mySales-35000) *.12;
            }
        }
    }

    public String toString(){
        return myId + "\t" + myCode + "\t" + mySales + "\t" + myCom;
    }

    public double getCom() {
        return myCom;
    }
}
