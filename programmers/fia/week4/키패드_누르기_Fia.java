package programmers.fia.week4;

import java.util.HashMap;
import java.util.Map;

public class 키패드_누르기_Fia {
    public String solution(int[] numbers, String hand) {
        Map<Integer, String> leftPad = new HashMap<>();
        Map<Integer, String> rightPad = new HashMap<>();
        Map<Integer, String> otherPad = new HashMap<>();
        String leftHand = "00";
        String rightHand = "02";

        otherPad.put(0, "01");
        leftPad.put(7, "10");
        otherPad.put(8, "11");
        rightPad.put(9, "12");
        leftPad.put(4, "20");
        otherPad.put(5, "21");
        rightPad.put(6, "22");
        leftPad.put(1, "30");
        otherPad.put(2, "31");
        rightPad.put(3, "32");

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            if (leftPad.containsKey(numbers[i])) {
                leftHand = leftPad.get(numbers[i]);
                builder.append("L");
            } else if (rightPad.containsKey(numbers[i])) {
                rightHand = rightPad.get(numbers[i]);
                builder.append("R");
            } else if (otherPad.containsKey(numbers[i])) {
                String goTo = otherPad.get(numbers[i]);
                char x = goTo.charAt(0);
                char y = goTo.charAt(1);
                int left = Math.abs(x - leftHand.charAt(0)) + Math.abs(y - leftHand.charAt(1));
                int right = Math.abs(x - rightHand.charAt(0)) + Math.abs(y - rightHand.charAt(1));
                if (left > right) {
                    rightHand = goTo;
                    builder.append("R");
                } else if (left < right) {
                    leftHand = goTo;
                    builder.append("L");
                } else {
                    if (hand.equals("left")) {
                        leftHand = goTo;
                        builder.append("L");
                    } else {
                        rightHand = goTo;
                        builder.append("R");
                    }
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";
        키패드_누르기_Fia fia = new 키패드_누르기_Fia();
        System.out.println(fia.solution(numbers, hand));
    }
}
