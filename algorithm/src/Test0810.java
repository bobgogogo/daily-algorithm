import java.util.ArrayList;
import java.util.List;

public class Test0810 {
    public int countBinarySubstrings(String s) {
        if (s.isEmpty()) {
            return 1;
        }
        char n = '2';
        int i = 0;
        List<Integer> counts = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (c!=n) {
                counts.add(i);
                n = c;
                i = 0;
            }
            i++;
        }
        counts.add(i);

        int times = 0;
        for (int k=1; k<counts.size()-1;k++) {
            times += Math.min(counts.get(k),counts.get(k+1));
        }

        return times;
    }

    public static void main(String[] args) {
        String s = "001111011";
        Test0810 test0810 = new Test0810();
        int i = test0810.countBinarySubstrings(s);
        System.out.println("i = " + i);

    }
}
