package programmers.ayaan.week4;

import java.util.HashMap;
import java.util.Map;

public class 키패드누르기_ayaan {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";

        String result = solution(arr, hand);
        System.out.println(result);
    }

    public static String solution(int[] numbers, String hand) {
        Map<Integer, int[]> keyMap = new HashMap<>();
        keyMap.put(1, new int[]{0, 0});
        keyMap.put(2, new int[]{0, 1});
        keyMap.put(3, new int[]{0, 2});
        keyMap.put(4, new int[]{1, 0});
        keyMap.put(5, new int[]{1, 1});
        keyMap.put(6, new int[]{1, 2});
        keyMap.put(7, new int[]{2, 0});
        keyMap.put(8, new int[]{2, 1});
        keyMap.put(9, new int[]{2, 2});
        keyMap.put(10, new int[]{3, 0});
        keyMap.put(0, new int[]{3, 1});
        keyMap.put(12, new int[]{3, 2});

        int left = 10;
        int right = 12;

        StringBuilder result = new StringBuilder();

        for(int num : numbers){
            if(num % 3 == 1){
                result.append("L");
                left = num;
            } else if(num != 0 && num % 3 == 0){
                result.append("R");
                right = num;
            } else {
                int[] left_point = keyMap.get(left);
                int[] right_point = keyMap.get(right);
                int[] num_point = keyMap.get(num);

                int left_distance = Math.abs(num_point[0] - left_point[0]) + Math.abs(num_point[1] - left_point[1]);
                int right_distance = Math.abs(num_point[0] - right_point[0]) + Math.abs(num_point[1] - right_point[1]);

                if(left_distance < right_distance){
                    result.append("L");
                    left = num;
                } else if(left_distance > right_distance){
                    result.append("R");
                    right = num;
                } else {
                    if(hand.equals("left")){
                        result.append("L");
                        left = num;
                    } else {
                        result.append("R");
                        right = num;
                    }
                }
            }
        }

        return result.toString();
    }
}
