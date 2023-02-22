package leetcode.ayaan.week3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayFormOfInteger_ayaan {
    public static void main(String[] args) {
        int[] num = {2,1};
        int k = 806;

        addToArrayForm2(num, k);
    }

    public static List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i : num){
            sb.append(i);
        }

        BigInteger bigNum = new BigInteger(sb.toString());
        BigInteger bigK = BigInteger.valueOf(k);
        BigInteger result = bigNum.add(bigK);
        String str = result.toString();

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
//            list.add(Character.getNumericValue(str.charAt(i)));
            list.add(str.charAt(i) - '0');
        }
        return list;
    }

    public static List<Integer> addToArrayForm2(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int len = num.length-1;

        while(len >= 0 || k > 0){
            if(len >= 0){
                k += num[len];
                len--;
            }

            result.add(k % 10);
            k /= 10;
        }

        Collections.reverse(result);
        return result;
    }
}
