package Q1.Java.Langdocs.Prog901a;

public class Prog901aHelper {
    Node head;

    public void addLast(String line){
        Node spot = new Node(line);
        if (head == null) {
            head = spot;
            head.mynext = spot;
            head.myprev = spot;
        }
        else {
            Node temp = head;
            while(temp.mynext!=head){
                temp = temp.mynext;
            }
            temp.mynext = spot;
            spot.myprev = temp;
            spot.mynext = head;
            head.myprev = spot;
        }
    }

    public void printForward() {
        System.out.print(head.getForward() + "\n");
        Node temp = head.mynext;
        while (temp != head) {
            System.out.print(temp.getForward() + "\n");
            temp = temp.mynext;
        }
    }

    public void printReverse() {
        Node temp = head.myprev;
        while (temp != head) {
            System.out.print(temp.getReverse() + "\n");
            temp = temp.myprev;
        }
        System.out.print(head.getReverse() + "\n");
    }
}
/*
Good morning life and all
Things glad and beautiful
My pockets nothing hold
But he that owns the gold
The sun is my great friend
His spending has no end
Hail to the morning sky
Which bright clouds measure high
Hail to you birds whose throats
Would number leaves by notes
Hail to you shady bowers
And you green fields of flowers
Hail to you women fair
That make a show so rare
In cloth as white as milk
Be it calico or silk
Good morning life and all
Things glad and beautiful

lufituaeb dna dalg sgnihT
lla dna efil gninrom dooG
klis ro ocilac ti eB
klim sa etihw sa htolc nI
erar os wohs a ekam tahT
riaf nemow uoy ot liaH
srewolf fo sdleif neerg uoy dnA
srewob ydahs uoy ot liaH
seton yb sevael rebmun dluoW
staorht esohw sdrib uoy ot liaH
hgih erusaem sduolc thgirb hcihW
yks gninrom eht ot liaH
dne on sah gnidneps siH
dneirf taerg ym si nus ehT
dlog eht snwo taht eh tuB
dloh gnihton stekcop yM
lufituaeb dna dalg sgnihT
lla dna efil gninrom dooG
 */
