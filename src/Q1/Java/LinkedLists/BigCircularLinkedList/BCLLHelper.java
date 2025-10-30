package Q1.Java.LinkedLists.BigCircularLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class BCLLHelper {
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

    public void addLast(int num){
        Node spot = new Node(num);
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

    public int getCount() {
        int count = 1;
        Node temp = head.mynext;
        while (temp != head) {
            count++;
            temp = temp.mynext;
        }
        return count;
    }

    public void add(int num1, int num2) {
        Node spot = new Node(num1);
        Node temp = head;
        while (num2 != 0) {
            temp = temp.mynext;
            --num2;
        }
        spot.mynext = temp;
        temp.myprev.mynext = spot;
        spot.myprev = temp.myprev;
        temp.myprev = spot;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean isThere(int num) {
        Node temp = head;
        if (temp.getVal() == num) {
            return true;
        }
        temp = temp.mynext;
        while (temp != head) {
            if (temp.getVal() == num) {
                return true;
            }
            temp = temp.mynext;
        }
        return false;
    }

    public int getFirst() {
        if (!isEmpty()){
            return head.getVal();
        }
        return -1;
    }

    public int getLast() {
        if (!isEmpty()){
            Node temp = head;
            while (temp.mynext != head){
                temp = temp.mynext;
            }
            return temp.getVal();
        }
        return -1;
    }

    public int getSpot(int spot) {
        if (!isEmpty()){
            Node temp = head;
            while (spot > 0) {
                temp = temp.mynext;
                --spot;
            }
            return temp.getVal();
        }
        return -1;
    }

    public void removeFirst() {
        head.myprev.mynext = head.mynext;
        head.mynext.myprev = head.myprev;
        head = head.mynext;
    }

    public void removeLast() {
        Node temp = head;
        while (temp.mynext!=head){
            temp = temp.mynext;
        }
        head.myprev = temp.myprev;
        temp.myprev.mynext = head;
        temp = temp.mynext;
    }

    public int countLess10() {
        int count = 0;
        Node temp = head;
        if (temp.getVal() < 10) {
            ++count;
        }
        while (temp != head) {
            if (temp.getVal() < 10) {
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public void removeSpot(int spot) {
        if (!isEmpty()){
            Node temp = head;
            while (spot > 0) {
                temp = temp.mynext;
                --spot;
            }
            temp.myprev.mynext = temp.mynext;
            temp.mynext.myprev = temp.myprev;
            temp = temp.mynext;
        }
    }

    public void clear() {
        Node temp = head.mynext;
        while (temp != head) {
            temp.mynext.myprev = temp.myprev;
            temp.myprev.mynext = temp.mynext;
            temp = temp.mynext;
        }
        head = null;
    }

    public boolean checkForNum(int num) {
        Node temp = head;
        if (temp.getVal() == num) { return true; }
        temp = temp.mynext;
        while (temp != head) {
            if (temp.getVal() == num) { return true; }
            temp = temp.mynext;
        }
        return false;
    }

    public int getNum(int pos) {
        Node temp = head;
        while (pos != 0) {
            temp = temp.mynext;
            --pos;
        }
        return temp.getVal();
    }

    public BCLLHelper getReverse() {
        BCLLHelper temp = new BCLLHelper();
        Node temp2 = head.myprev;
        while (temp2 != head) {
            temp.addFront(temp2.getVal());
            temp2 = temp2.myprev;
        }
        temp.addFront(temp2.getVal());
        return temp;
    }

    public Iterator<Integer> iterator() {
        ArrayList<Integer> stuff = new ArrayList<Integer>();
        Node temp = head;
        stuff.add(temp.getVal());
        temp = temp.mynext;
        while (temp != head) {
            stuff.add(temp.getVal());
            temp = temp.mynext;
        }
        return stuff.iterator();
    }

    public double avg() {
        Node temp = head;
        double total = 0.0;
        total += temp.getVal();
        temp = temp.mynext;
        while (temp != head) {
            total += temp.getVal();
            temp = temp.mynext;
        }
        return total / (double)getCount();
    }

    public int getMax() {
        Node temp = head;
        int max = 0;
        if (temp.getVal() > max) { max = temp.getVal(); }
        temp = temp.mynext;
        while (temp != head) {
            if (temp.getVal() > max) { max = temp.getVal(); }
            temp = temp.mynext;
        }
        return max;
    }

    public int getMin() {
        Node temp = head;
        int min = temp.getVal();
        temp = temp.mynext;
        while (temp != head) {
            if (temp.getVal() < min) { min = temp.getVal(); }
            temp = temp.mynext;
        }
        return min;
    }

    public int findSlotMaxFirst() {
        Node temp = head;
        int data = this.getMax();
        int pos = 0;
        if (temp.getVal() == data) { return pos; }
        temp = temp.mynext;
        ++pos;
        while (temp != head) {
            if (temp.getVal() == data) { return pos; }
            temp = temp.mynext;
            ++pos;
        }
        return -1;
    }

    public int findSlotMaxLast() {
        Node temp = head;
        int data = this.getMin();
        int pos = 0;
        int last = pos;
        temp = temp.mynext;
        ++pos;
        while (temp != head) {
            ++pos;
            if (temp.getVal() == data) { last = pos; }
            temp = temp.mynext;
        }
        return last;
    }

    public int findSlotMinFirst() {
        Node temp = head;
        int data = this.getMin();
        int pos = 0;
        while (temp != null) {
            if (temp.getVal() < data) { return pos; }
            temp = temp.mynext;
            ++pos;
        }
        return 0;
    }

    public BCLLHelper sort() {
        int[] data = new int[getCount()];
        for (int i = 0; i < getCount(); ++i) {
            data[i] = getNum(i);
        }
        for (int i = 0; i < data.length; ++i) {
            for (int j = i + 1; j < data.length; ++j) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        BCLLHelper temp = new BCLLHelper();
        for (int i = 0; i < data.length; i++) {
            temp.addLast(data[i]);
        }
        return temp;
    }

    public int lose58() {
        int count = 0;
        while (head.getVal() == 58) {
            head.mynext.myprev = head.myprev;
            head.myprev.mynext = head.mynext;
            head = head.mynext;
            ++count;
        }
        Node temp = head.mynext;
        while (temp != head) {
            if (temp.getVal() == 58) {
                temp.mynext.myprev = temp.myprev;
                temp.myprev.mynext = temp.mynext;
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public int getEvenCount() {
        Node temp = head;
        int count = 0;
        if (temp.getVal() % 2 == 0) {
            ++count;
        }
        temp = temp.mynext;
        while (temp != head) {
            if (temp.getVal() % 2 == 0) {
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public void killOdds() {
        while (head.getVal() % 2 == 1) {
            head.mynext.myprev = head.myprev;
            head.myprev.mynext = head.mynext;
            head = head.mynext;
        }
        Node temp = head.mynext;
        while (temp != head) {
            if (temp.mynext.getVal() % 2 == 1) {
                temp.mynext.myprev = temp.myprev;
                temp.myprev.mynext = temp.mynext;
            }
            temp = temp.mynext;
        }
    }

    public void print() {
        System.out.println(head.getVal());
        Node temp = head.mynext;
        while (temp != head) {
            System.out.println(temp.getVal());
            temp = temp.mynext;
        }
    }
}
/*
58
95
63
0
74
50
11
66
12
25
90
36
22
29
55
20
92
49
53
94
66
11
33
35
80
100
94
13
22
89
2
52
31
32
92
20
56
36
44
11
74
8
9
71
24
60
65
83
47
18
96
13
49
3
12
71
69
7
48
38
48
89
70
92
87
38
6
41
70
13
65
59
73
92
23
35
19
61
7
4
52
95
40
64
73
76
22
40
89
22
49
22
15
11
70
33
59
13
41
77
45
57
45
41
91
4
53
45
39
2
14
40
43
62
74
80
63
99
28
41
64
70
64
52
71
12
8
72
45
7
10
48
43
92
12
69
55
16
11
14
38
95
11
17
36
49
63
18
59
33
44
29
83
46
100
6
74
51
31
36
36
77
6
75
36
28
49
48
72
57
0
97
83
75
19
10
63
9
53
60
16
80
52
45
37
45
11
4
0
0
41
69
74
68
14
80
15
24
16
18


200

List is not empty
58
95
63
0
74
50
11
66
12
25
90
36
22
29
55
20
92
49
53
94
66
11
33
35
80
100
94
13
22
89
2
52
31
32
92
20
56
36
44
11
74
8
9
71
24
60
65
83
47
18
96
13
49
3
12
71
69
7
48
38
48
89
70
92
87
38
6
41
70
13
65
59
73
92
23
35
19
61
7
4
52
95
40
64
73
76
22
40
89
22
49
22
15
11
70
33
59
13
41
77
45
92
57
45
41
91
4
53
45
39
2
14
40
43
62
74
80
63
99
28
41
64
70
64
52
71
12
8
72
45
7
10
48
43
92
12
69
55
16
11
14
38
95
11
17
36
49
63
18
59
33
44
29
83
46
100
6
74
51
31
36
36
77
6
75
36
28
49
48
72
57
0
97
83
75
19
10
63
9
53
60
16
80
52
45
37
45
11
4
0
0
41
69
74
68
14
80
15
24
16
18


First : 58


Last : 18


Number at spot 52 is : 49


95
63
0
74
50
11
66
12
25
90
36
22
29
55
20
92
49
53
94
66
11
33
35
80
100
94
13
22
89
2
52
31
32
92
20
56
36
44
11
74
8
9
71
24
60
65
83
47
18
96
13
49
3
12
71
69
7
48
38
48
89
70
92
87
38
6
41
70
13
65
59
73
92
23
35
19
61
7
4
52
95
40
64
73
76
22
40
89
22
49
22
15
11
70
33
59
13
41
77
45
92
57
45
41
91
4
53
45
39
2
14
40
43
62
74
80
63
99
28
41
64
70
64
52
71
12
8
72
45
7
10
48
43
92
12
69
55
16
11
14
38
95
11
17
36
49
63
18
59
33
44
29
83
46
100
6
74
51
31
36
36
77
6
75
36
28
49
48
72
57
0
97
83
75
19
10
63
9
53
60
16
80
52
45
37
45
11
4
0
0
41
69
74
68
14
80
15
24
16


Numbers less than 10 : 0

List does contain : 65
22


16
24
15
80
14
68
74
69
41
0
0
4
11
45
37
45
52
80
16
60
53
9
63
10
19
75
83
97
0
57
72
48
49
28
36
75
6
77
36
36
31
51
74
6
100
46
83
29
44
33
59
18
63
49
36
17
11
95
38
14
11
16
55
69
12
92
43
48
10
7
45
72
8
12
71
52
64
70
64
41
28
99
63
80
74
62
43
40
14
2
39
45
53
4
91
41
45
57
92
45
77
41
13
59
33
70
11
15
22
49
22
89
40
22
76
73
64
40
95
52
4
7
61
19
35
23
92
73
59
65
13
70
41
38
87
92
70
89
48
38
48
7
69
71
12
3
49
13
96
18
47
83
65
60
24
71
9
8
74
11
44
36
56
20
92
32
31
52
2
89
22
13
94
100
80
35
33
11
66
94
53
49
92
20
55
29
22
36
90
25
12
66
11
50
74
0
63
95


95
63
0
74
50
11
66
12
25
90
36
22
29
55
20
92
49
53
94
66
11
33
35
80
100
94
13
22
89
2
52
31
32
92
20
56
36
44
11
74
8
9
71
24
60
65
83
47
18
96
13
49
3
12
71
69
7
48
38
48
89
70
92
87
38
41
70
13
65
59
73
92
23
35
19
61
7
4
52
95
40
64
73
76
22
40
89
22
49
22
15
11
70
33
59
13
41
77
45
92
57
45
41
91
4
53
45
39
2
14
40
43
62
74
80
63
99
28
41
64
70
64
52
71
12
8
72
45
7
10
48
43
92
12
69
55
16
11
14
38
95
11
17
36
49
63
18
59
33
44
29
83
46
100
6
74
51
31
36
36
77
6
75
36
28
49
48
72
57
0
97
83
75
19
10
63
9
53
60
16
80
52
45
37
45
11
4
0
0
41
69
74
68
14
80
15
24
16


Average of all numbers in list : 46.08585858585859


Smallest number in list : 0


Largest number in list : 100


Slot of first Largest number in list : 24


Slot of last Largest number in list : 189


0
0
0
0
2
2
3
4
4
4
6
6
7
7
7
8
8
9
9
10
10
11
11
11
11
11
11
11
12
12
12
12
13
13
13
13
14
14
14
15
15
16
16
16
17
18
18
19
19
20
20
22
22
22
22
22
23
24
24
25
28
28
29
29
31
31
32
33
33
33
35
35
36
36
36
36
36
36
37
38
38
38
39
40
40
40
41
41
41
41
41
43
43
44
44
45
45
45
45
45
45
46
47
48
48
48
48
49
49
49
49
49
50
51
52
52
52
52
53
53
53
55
55
56
57
57
59
59
59
60
60
61
62
63
63
63
63
64
64
64
65
65
66
66
68
69
69
69
70
70
70
70
71
71
71
72
72
73
73
74
74
74
74
74
75
75
76
77
77
80
80
80
80
83
83
83
87
89
89
89
90
91
92
92
92
92
92
92
94
94
95
95
95
96
97
99
100
100


Number of 58's deleted : 0
0
0
0
0
2
2
3
4
4
4
6
6
7
7
7
8
8
9
9
10
10
11
11
11
11
11
11
11
12
12
12
12
13
13
13
13
14
14
14
15
15
16
16
16
17
18
18
19
19
20
20
22
22
22
22
22
23
24
24
25
28
28
29
29
31
31
32
33
33
33
35
35
36
36
36
36
36
36
37
38
38
38
39
40
40
40
41
41
41
41
41
43
43
44
44
45
45
45
45
45
45
46
47
48
48
48
48
49
49
49
49
49
50
51
52
52
52
52
53
53
53
55
55
56
57
57
59
59
59
60
60
61
62
63
63
63
63
64
64
64
65
65
66
66
68
69
69
69
70
70
70
70
71
71
71
72
72
73
73
74
74
74
74
74
75
75
76
77
77
80
80
80
80
83
83
83
87
89
89
89
90
91
92
92
92
92
92
92
94
94
95
95
95
96
97
99
100
100


Number of even numbers in list : 101


0
0
0
0
2
3
4
4
4
6
7
8
9
10
11
12
12
12
13
14
14
15
16
16
17
18
19
20
20
22
22
22
22
23
24
25
28
31
35
36
36
36
36
36
37
38
38
39
40
40
43
44
45
47
48
48
48
49
51
52
52
52
55
59
60
61
63
64
64
65
66
66
69
70
70
70
71
72
73
74
74
74
74
75
77
80
80
80
89
91
92
92
92
92
92
92
94
95
99
100
100


List has been cleared


32
 */