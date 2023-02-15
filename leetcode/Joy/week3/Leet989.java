package leetcode.Joy.week3;

import java.util.Arrays;
import java.util.List;

public class Leet989 {
    public static void main(String[] args) {
        int[] num = {2,1,5};
        int k = 806;
        String str = "";
        for (int i : num){
            str += i;
        }
        int n = Integer.parseInt(str)+k;
        String str2 = n+"";
        System.out.println(n);
        Integer[] answer = new Integer[str2.length()];

        for (int i=str2.length()-1;i>=0;i--){
            answer[i] = n%10;
            n /= 10;
        }
        List<Integer> list = Arrays.asList(answer);
        System.out.println(list);
    }
}
