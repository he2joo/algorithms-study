package programmers.ayaan.week4;

public class 키패드누르기_ayaan {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,8,2,1,4,5,9,5};
        String hand = "right";

        String result = solution(arr, hand);
        System.out.println(result);
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";

        int left = 3;
        int right = 3;
        for(int number : numbers){
            if(number == 0){
                int left_distance = (left == 0) ? 4 : (left % 3 + 1);
                int right_distance = (right == 0) ? 4 : (right % 3 + 1);
                if(left_distance < right_distance){
                    answer += "L";
                } else if (left_distance > right_distance){
                    answer += "R";
                } else {
                    answer += hand.substring(0,1).toUpperCase();
                }
            } else if(number % 3 == 1){
                answer += "L";
                if(number <= 3){
                    left = 0;
                } else if(number > 3 && number <= 6){
                    left = 1;
                } else {
                    left = 2;
                }
            } else if(number % 3 == 0){
                answer += "R";
                if(number <= 3){
                    right = 0;
                } else if(number > 3 && number <= 6){
                    right = 1;
                } else {
                    right = 2;
                }
            } else {
                int line = number / 3;
                int left_distance = left - line + 1;
                int right_distance = right - line + 1;
                if(left_distance < right_distance){
                    answer += "L";
                } else if (left_distance > right_distance){
                    answer += "R";
                } else {
                    answer += hand.substring(0,1).toUpperCase();
                }
            }

        }

        return answer;
    }
}
