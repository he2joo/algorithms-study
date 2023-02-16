package leetcode.fia.week3;

import java.util.*;

public class Add989 {
    public List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder builder = new StringBuilder();
        for (int number : num) {
            builder.append(number);
        }
        String number = builder.toString();
        Double d = Double.parseDouble(number);
        int result = (int) (d + k);
        List<Integer> answer = new ArrayList<>();
        int n = result % 10;
        while (result > 0) {
            answer.add(n);
            result = result / 10;
            n = result % 10;
        }
        Collections.reverse(answer);
        return answer;
    }
}
