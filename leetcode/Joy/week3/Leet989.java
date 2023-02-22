package leetcode.Joy.week3;

import java.math.BigInteger;
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
        BigInteger n = new BigInteger(str+k);
        String str2 = n+"";
        BigInteger[] answer = new BigInteger[str2.length()];

        for (int i=str2.length()-1;i>=0;i--){
            answer[i] = n.remainder(BigInteger.TEN);
            n = n.divide(BigInteger.TEN);
        }
        List<BigInteger> list = Arrays.asList(answer);
        System.out.println(list);
    }
}
