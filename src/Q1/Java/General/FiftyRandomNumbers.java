package Q1.Java.General;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class FiftyRandomNumbers {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Random r = new Random();

        while (set.size() < 50) {
            set.add(r.nextInt(1000));
        }

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
/*
769
899
392
651
781
654
18
19
918
23
24
409
922
414
670
545
932
425
937
428
300
943
179
569
61
957
958
318
830
961
454
456
849
725
86
90
96
225
226
995
356
228
614
617
618
113
500
372
503
379
 */