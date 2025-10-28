package Q1.Prog1045a;

import Q1.BigCircularLinkedList.Node;

public class Prog1045aHelper {
    private Node head;

    public void addFront(int num) {
        Node spot = new Node(num);
        if (head == null){
            head = spot;
            head.mynext = spot;
            head.myprev = spot;
        }
        else {
            Node temp = head;
            spot.mynext = head;
            head.myprev = spot;
            while(temp.mynext != head) {
                temp = temp.mynext;
            }
            temp.mynext = spot;
            spot.myprev = temp;
        }
    }

    public int lastSpot() {
        Node temp2 = head;
        while (head.mynext != head) {
            if (temp2.mynext == head) {
                temp2.mynext = temp2.mynext.mynext;
                temp2.mynext.myprev = temp2;
                head = temp2.mynext;
            }
            else {
                temp2.mynext = temp2.mynext.mynext;
                temp2.mynext.myprev = temp2;
            }
            temp2 = temp2.mynext;
        }
        return head.getVal();
    }
}
/*
Enter number of people laid off: 7
When releasing 7 employees, you need to be in position : 7

Enter number of people laid off: 10
When releasing 10 employees, you need to be in position : 5

Enter number of people laid off: 24
When releasing 24 employees, you need to be in position : 17

Enter number of people laid off: 20
When releasing 20 employees, you need to be in position : 9

Enter number of people laid off: 16
When releasing 16 employees, you need to be in position : 1

Enter number of people laid off: 5
When releasing 5 employees, you need to be in position : 3
 */
