package programmers.ayaan.week3;

import java.util.Arrays;
import java.util.Collections;

public class 실패율_ayaan {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        int[] result = solution(N, stages);
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = {};

        StringBuilder sb = new StringBuilder();
        for(int i : stages){
            sb.append(i);
        }
        String stageStr = sb.toString();
        int clearPlayer = stages.length;
        int notClearPlayer = 0;

        Double[] arr = new Double[N];

        for(int i=1; i<=N; i++){
            char num = Integer.toString(i).charAt(0);
            notClearPlayer = (int)stageStr.chars().filter(c -> c == num).count();

            if(clearPlayer == 0){
                arr[i-1] = (double)0;
            } else {
                arr[i-1] = (double)notClearPlayer / (double)clearPlayer;
            }

            clearPlayer -= notClearPlayer;
            stageStr.replaceAll(Character.toString(num), "");
        }

        Arrays.sort(arr, Collections.reverseOrder());
        System.out.println(arr);

        return answer;
    }
}
