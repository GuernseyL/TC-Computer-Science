package Q1.Java.LinkedLists.BigDoubleLinkedList;

import java.util.ArrayList;
import java.util.Iterator;

public class BDLLHelper {
    private Node myroot;



    public void addFront(int num) {
        Node spot = new Node(num);
        if (myroot == null){
            myroot = spot;
        }
        else {
            spot.mynext = myroot;
            myroot.myprev = spot;
            myroot = spot;
        }
    }

    public void addLast(int num){
        Node spot = new Node(num);
        if (myroot == null) {
            myroot = spot;
        }
        else {
            Node temp = myroot;
            while(temp.mynext!=null){
                temp = temp.mynext;
            }
            temp.mynext = spot;
            spot.myprev = temp;
        }
    }

    public int getCount() {
        int count = 0;
        Node temp = myroot;
        while (temp != null) {
            count++;
            temp = temp.mynext;
        }
        return count;
    }

    public void add(int num1, int num2) {
        Node spot = new Node(num1);
        Node temp = myroot;
        while (num2 != 0) {
            temp = temp.mynext;
            --num2;
        }
        spot.mynext = temp.mynext.mynext;
        temp.mynext = spot;
        spot.myprev = temp;
    }

    public boolean isEmpty() {
        return myroot == null;
    }

    public boolean isThere(int num) {
        Node temp = myroot;
        while (temp != null) {
            if (temp.getVal() == num) {
                return true;
            }
            temp = temp.mynext;
        }
        return false;
    }

    public int getFirst() {
        if (!isEmpty()){
            return myroot.getVal();
        }
        return -1;
    }

    public int getLast() {
        if (!isEmpty()){
            Node temp = myroot;
            while (temp.mynext!=null){
                temp = temp.mynext;
            }
            return temp.getVal();
        }
        return -1;
    }

    public int getSpot(int spot) {
        if (!isEmpty()){
            Node temp = myroot;
            while (spot > 0) {
                temp = temp.mynext;
                --spot;
            }
            return temp.getVal();
        }
        return -1;
    }

    public void removeFirst() {
        myroot = myroot.mynext;
    }

    public void removeLast() {
        Node temp = myroot;
        while (temp.mynext!=null){
            temp = temp.mynext;
        }
        temp = null;
    }

    public int countLess10() {
        int count = 0;
        Node temp = myroot;
        while (temp != null) {
            if (temp.getVal() < 10) {
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public void removeSpot(int spot) {
        if (!isEmpty()){
            Node temp = myroot;
            while (spot > 0 && temp.mynext!=null) {
                temp = temp.mynext;
                --spot;
            }
            if (temp.mynext == null){
                temp = null;
                return;
            }
            temp.mynext = temp.mynext.mynext;
            temp.mynext.myprev = temp;
        }
    }

    public void clear() {
        while (myroot.mynext != null) {
            Node temp = myroot;
            while (temp.mynext.mynext != null) {
                temp = temp.mynext;
            }
            temp.mynext = null;
            myroot = myroot.mynext;
        }
        myroot = null;
    }

    public boolean checkForNum(int num) {
        Node temp = myroot;
        while (temp != null) {
            if (temp.getVal() == num) { return true; }
            temp = temp.mynext;
        }
        return false;
    }

    public int getNum(int pos) {
        Node temp = myroot;
        while (pos != 0) {
            temp = temp.mynext;
            --pos;
            if (temp == null) { return -1; }
        }
        return temp.getVal();
    }

    public BDLLHelper getReverse() {
        BDLLHelper temp = new BDLLHelper();
        int[] data = new int[getCount()];
        int reverse = 0;
        for (int i = getCount() - 1; i >= 0; --i) {
            data[reverse] = getNum(i);
            ++reverse;
        }
        for (int i = 0; i < getCount() - 1; ++i) {
            temp.addLast(data[i]);
        }
        return temp;
    }

    public Iterator<Integer> iterator() {
        ArrayList<Integer> stuff = new ArrayList<Integer>();
        Node temp = myroot;
        while (temp!= null) {
            stuff.add(temp.getVal());
            temp = temp.mynext;
        }
        return stuff.iterator();
    }

    public double avg() {
        Node temp = myroot;
        double total = 0.0;
        while (temp != null) {
            total += temp.getVal();
            temp = temp.mynext;
        }
        return total / (double)getCount();
    }

    public int getMax() {
        Node temp = myroot;
        int max = 0;
        while (temp != null) {
            if (temp.getVal() > max) { max = temp.getVal(); }
            temp = temp.mynext;
        }
        return max;
    }

    public int getMin() {
        Node temp = myroot;
        int min = temp.getVal();
        while (temp != null) {
            if (temp.getVal() < min) { min = temp.getVal(); }
            temp = temp.mynext;
        }
        return min;
    }

    public int findSlotMaxFirst() {
        Node temp = myroot;
        int data = this.getMax();
        int pos = 0;
        while (temp != null) {
            if (temp.getVal() == data) { return pos; }
            temp = temp.mynext;
            ++pos;
        }
        return -1;
    }

    public int findSlotMaxLast() {
        Node temp = myroot;
        int data = this.getMin();
        int pos = 0;
        int last = pos;
        while (temp != null) {
            ++pos;
            if (temp.getVal() == data) { last = pos; }
            temp = temp.mynext;
        }
        return last;
    }

    public int findSlotMinFirst() {
        Node temp = myroot;
        int data = this.getMin();
        int pos = 0;
        while (temp != null) {
            if (temp.getVal() < data) { return pos; }
            temp = temp.mynext;
            ++pos;
        }
        return 0;
    }

    public BDLLHelper sort() {
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
        BDLLHelper temp = new BDLLHelper();
        for (int i = 0; i < data.length; i++) {
            temp.addLast(data[i]);
        }
        return temp;
    }

    public int lose58() {
        Node temp = myroot;
        int count = 0;
        while (temp.mynext != null) {
            if (temp.mynext.getVal() == 58) {
                temp.mynext = temp.mynext.mynext;
                temp.mynext.myprev = temp;
                ++count;
            }
            else { temp = temp.mynext; }
        }
        return count;
    }

    public int getEvenCount() {
        Node temp = myroot;
        int count = 0;
        while (temp != null) {
            if (temp.getVal() % 2 == 0) {
                ++count;
            }
            temp = temp.mynext;
        }
        return count;
    }

    public void killOdds() {
        Node temp = myroot;
        while (temp.mynext != null) {
            if (temp.mynext.getVal() % 2 == 1) {
                temp.mynext = temp.mynext.mynext;
                temp.mynext.myprev = temp;
            }
            else { temp = temp.mynext; }
        }
    }

    public void print() {
        Node temp = myroot;
        while (temp != null) {
            System.out.println(temp.getVal());
            temp = temp.mynext;
        }
    }
}
/*
4
53
69
72
87
19
51
92
4
95
72
94
40
54
42
90
80
99
91
85
2
11
21
75
0
82
56
99
60
88
10
53
50
43
69
81
100
50
41
93
68
99
26
82
31
16
13
27
48
73
97
27
64
57
80
74
76
12
4
84
72
93
19
35
11
57
78
76
5
34
37
18
14
22
91
5
94
100
49
43
20
53
71
18
100
77
94
56
45
75
13
73
57
73
32
38
59
28
48
60
31
61
87
77
91
77
60
57
85
74
35
71
39
27
38
94
55
69
13
86
76
91
76
70
75
58
35
3
33
60
58
18
68
2
59
2
91
16
99
51
47
26
56
9
51
15
0
85
97
77
71
3
45
36
43
39
97
85
42
32
95
61
41
83
40
70
25
89
92
24
44
55
92
48
66
99
46
82
2
26
36
76
80
62
52
56
68
42
68
5
88
13
9
0
74
1
70
78
49
33


200

List is not empty
4
53
69
72
87
19
51
92
4
95
72
94
40
54
42
90
80
99
91
85
2
11
21
75
0
82
56
99
60
88
10
53
50
43
69
81
100
50
41
93
68
99
26
82
31
16
13
27
48
73
97
27
64
57
80
74
76
12
4
84
72
93
19
35
11
57
78
76
5
34
37
18
14
22
91
5
94
100
49
43
20
53
71
18
100
77
94
56
45
75
13
73
57
73
32
38
59
28
48
60
31
61
87
77
91
77
60
57
85
74
35
71
39
27
38
94
55
69
13
86
76
91
76
70
75
58
35
3
33
60
58
18
68
2
59
2
91
16
99
51
47
26
56
9
51
15
0
85
97
77
71
3
45
36
43
16
97
85
42
32
95
61
41
83
40
70
25
89
92
24
44
55
92
48
66
99
46
82
2
26
36
76
80
62
52
56
68
42
68
5
88
13
9
0
74
1
70
78
49
33


First : 4


Last : 33


Number at spot 40 is : 68


53
69
72
87
19
51
92
4
95
72
94
40
54
42
90
80
99
91
85
2
11
21
75
0
82
56
99
60
88
10
53
50
43
69
81
100
50
41
93
68
99
26
82
31
16
13
27
48
73
97
27
64
57
80
74
76
12
4
84
72
93
19
35
11
57
78
76
5
34
37
18
14
22
91
5
94
100
49
43
20
53
71
18
100
77
94
56
45
75
13
73
57
73
32
38
59
28
48
60
31
61
87
77
91
77
60
57
85
74
35
71
39
27
38
94
55
69
13
86
76
91
76
70
75
58
35
3
33
60
58
18
68
2
59
2
91
16
99
51
47
26
56
9
51
15
0
85
97
77
71
3
45
36
43
16
97
85
42
32
95
61
41
83
40
70
25
89
92
24
44
55
92
48
66
99
46
82
2
26
36
76
80
62
52
56
68
42
68
5
88
13
9
0
74
1
70
78
49
33


Numbers less than 10 : 17

List does contain : 83
99


33
49
78
70
1
74
0
9
13
88
5
68
42
68
56
52
62
80
76
36
26
2
82
46
99
66
48
92
55
44
24
92
89
25
70
40
83
41
61
95
32
42
85
97
16
43
36
45
3
71
77
97
85
0
15
51
9
56
26
47
51
99
16
91
2
59
2
68
18
58
60
33
3
35
58
75
70
76
91
76
86
13
69
55
94
38
27
39
71
35
74
85
57
60
77
91
77
87
61
31
60
48
28
59
38
32
73
57
73
13
75
45
56
94
77
100
18
71
53
20
43
49
100
94
5
91
22
14
18
37
34
5
76
78
57
11
35
19
93
72
84
4
12
76
74
80
57
64
27
97
73
48
27
13
16
31
82
26
99
68
93
41
50
100
81
69
43
50
53
10
88
60
99
56
82
0
75
21
11
2
85
91
99
80
90
42
54
40
94
72
95
4
51
19
87
72
69


53
69
72
87
19
51
4
95
72
94
40
54
42
90
80
99
91
85
2
11
21
75
0
82
56
99
60
88
10
53
50
43
69
81
100
50
41
93
68
99
26
82
31
16
13
27
48
73
97
27
64
57
80
74
76
12
4
84
72
93
19
35
11
57
78
76
5
34
37
18
14
22
91
5
94
100
49
43
20
53
71
18
100
77
94
56
45
75
13
73
57
73
32
38
59
28
48
60
31
61
87
77
91
77
60
57
85
74
35
71
39
27
38
94
55
69
13
86
76
91
76
70
75
58
35
3
33
60
58
18
68
2
59
2
91
16
99
51
47
26
56
9
51
15
0
85
97
77
71
3
45
36
43
16
97
85
42
32
95
61
41
83
40
70
25
89
92
24
44
55
92
48
66
99
46
82
2
26
36
76
80
62
52
56
68
42
68
5
88
13
9
0
74
1
70
78
49
33


Average of all numbers in list : 54.156565656565654


Smallest number in list : 0


Largest number in list : 100


Slot of first Largest number in list : 34


Slot of last Largest number in list : 192


0
0
0
1
2
2
2
2
3
3
4
4
5
5
5
9
9
10
11
11
12
13
13
13
13
14
15
16
16
16
18
18
18
19
19
20
21
22
24
25
26
26
26
27
27
27
28
31
31
32
32
33
33
34
35
35
35
36
36
37
38
38
39
40
40
41
41
42
42
42
43
43
43
44
45
45
46
47
48
48
48
49
49
50
50
51
51
51
52
53
53
53
54
55
55
56
56
56
56
57
57
57
57
58
58
59
59
60
60
60
60
61
61
62
64
66
68
68
68
68
69
69
69
70
70
70
71
71
71
72
72
72
73
73
73
74
74
74
75
75
75
76
76
76
76
76
77
77
77
77
78
78
80
80
80
81
82
82
82
83
84
85
85
85
85
86
87
87
88
88
89
90
91
91
91
91
91
92
92
93
93
94
94
94
94
95
95
97
97
97
99
99
99
99
99
100
100
100


Number of 58's deleted : 2
0
0
0
1
2
2
2
2
3
3
4
4
5
5
5
9
9
10
11
11
12
13
13
13
13
14
15
16
16
16
18
18
18
19
19
20
21
22
24
25
26
26
26
27
27
27
28
31
31
32
32
33
33
34
35
35
35
36
36
37
38
38
39
40
40
41
41
42
42
42
43
43
43
44
45
45
46
47
48
48
48
49
49
50
50
51
51
51
52
53
53
53
54
55
55
56
56
56
56
57
57
57
57
59
59
60
60
60
60
61
61
62
64
66
68
68
68
68
69
69
69
70
70
70
71
71
71
72
72
72
73
73
73
74
74
74
75
75
75
76
76
76
76
76
77
77
77
77
78
78
80
80
80
81
82
82
82
83
84
85
85
85
85
86
87
87
88
88
89
90
91
91
91
91
91
92
92
93
93
94
94
94
94
95
95
97
97
97
99
99
99
99
99
100
100
100


Number of even numbers in list : 97


0
0
0
2
2
2
2
4
4
10
12
14
16
16
16
18
18
18
20
22
24
26
26
26
28
32
32
34
36
36
38
38
40
40
42
42
42
44
46
48
48
48
50
50
52
54
56
56
56
56
60
60
60
60
62
64
66
68
68
68
68
70
70
70
72
72
72
74
74
74
76
76
76
76
76
78
78
80
80
80
82
82
82
84
86
88
88
90
92
92
94
94
94
94
100
100
100


List has been cleared


23
 */
