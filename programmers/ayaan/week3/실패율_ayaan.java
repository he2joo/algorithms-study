package programmers.ayaan.week3;

import java.util.Arrays;
import java.util.Comparator;

public class 실패율_ayaan {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2,1,2,6,2,4,3,3};
        int[] result = solution(N, stages);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // stage에 있는 플레이어의 수를 배열에 담는다.
        int[] stagePlayerCount = new int[N+2];
        for(int stage : stages){
            stagePlayerCount[stage]++;
        }

        int clearPlayer = stages.length;
        int notClearPlayer = 0;

        double[][] result = new double[N][2];

        for(int i=1; i<=N; i++){
            // stage를 아직 클리어 하지 않는 플레이어 수 = stage에 있는 플레이어의 수
            notClearPlayer = stagePlayerCount[i];

            // result[0] = index
            result[i-1][0] = i;
            // result[1] = 실패율
            if(clearPlayer == 0){
                result[i-1][1] = 0;
            } else {
                result[i-1][1] = (double)notClearPlayer/clearPlayer;
            }

            clearPlayer -= notClearPlayer;
        }

        Arrays.sort(result, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return Double.compare(o2[1], o1[1]);
            }
        });

        for(int i=0; i<result.length; i++){
            answer[i] = (int)result[i][0];
        }

        return answer;
    }
}
