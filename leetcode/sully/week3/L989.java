package leetcode.sully.week3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
//        for (int i = num.length; i >= 0; i++) {
//            numToInt += num[i] * Math.pow();
//        }

        List<Integer> answer = new ArrayList<>();

        // num 배열을 String 변환
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i);
        }

//        // num String + k -> 결과값을 다시 String 변환
//        String tmp = String.valueOf(Integer.parseInt(sb.toString()) + k);

//        for (int i = 0; i < tmp.length(); i++) {
//            answer.add(Integer.parseInt(String.valueOf(tmp.charAt(i))));
//        }

        // [9,9,9,9,9,9,9,9,9,9] -> 9999999999
        // 이 String 값을 그대로 Integer.parseInt()로 바꾸려 하면(그니까 int형으로 바꾸려 하면) 범위 초과가 됨
        // 그럼 String 형태로 하나하나씩 저장을 해야 하는데 -> 1을 어떻게 더하냐 이 말이지

        BigInteger bigInteger = new BigInteger(sb.toString());
        bigInteger.add(BigInteger.valueOf(k));
        System.out.println(bigInteger);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));

        // 이게 문제가 됨 -> 그럼 이걸 어떻게 int형으로 바꿔야 할까?
//        System.out.println(Integer.parseInt("9999999999"));
    }
}
