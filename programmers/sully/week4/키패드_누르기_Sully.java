package programmers.sully.week4;

public class 키패드_누르기_Sully {
    // 왼손 엄지: 1, 4, 7
    // 오른손 엄지: 3, 6, 9
    // 더 가까운 엄지: 2, 5, 8, 0
    // 거리 동일: ~손 잡이

    public static String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        String leftTmp = "*";
        String rightTmp = "#";

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append("L");
                System.out.println(numbers[i] + ": answer.append(\"L\")");
                leftTmp = String.valueOf(numbers[i]);
                continue;
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append("R");
                System.out.println(numbers[i] + ": answer.append(\"R\")");
                rightTmp = String.valueOf(numbers[i]);
                continue;
            }

            // numbers[i] -> 2, 5, 8, 0 경우로만 구현 (위에 continue 있으니, if 쓸 필요 x)

            if (numbers[i] == 2) {

            } else if (numbers[i] == 5) {

            } else if (numbers[i] == 8) {

            } else if (numbers[i] == 0)

            // 거리가 동일할 때
            if (leftTmp.equals("1") && rightTmp.equals("3")
                    || leftTmp.equals("4") && rightTmp.equals("6")
                    || leftTmp.equals("7") && rightTmp.equals("9")
                    || leftTmp.equals("*") && rightTmp.equals("#")) {
                if (hand.equals("left")) { // 왼손잡이냐
                    answer.append("L");
                    System.out.println(numbers[i] + ": answer.append(\"L\")");
                } else { // hand.equals("right") // 오른손잡이냐
                    answer.append("R");
                    System.out.println(numbers[i] + ": answer.append(\"R\")");
                }
            }

            // 거리가 다를 때 -> 위치 비교 로직

        }

        return answer.toString();
    }

    // 1 2 3
    // 4 5 6
    // 7 8 9
    // * 0 #

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }
}
