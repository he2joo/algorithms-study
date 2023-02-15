package programmers.Joy.week3;

import java.util.Arrays;

public class fail {
    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        int ja;
        int mo = stages.length;
        int[] answer = new int[N];
        double[] percent = new double[N];

        for (int i=1;i<=N;i++){
            int k = i;
            ja = (int)Arrays.stream(stages).filter(j->j==k).count();
            percent[i-1] = (double)ja/mo;
            mo -= ja;
            answer[i-1] = i;
        }

        for (int i=0;i<N;i++){
            for (int j=0;j<N-1-i;j++){
                if (percent[j]<percent[j+1]){
                    double tmp1 = percent[j];
                    percent[j] = percent[j+1];
                    percent[j+1] = tmp1;

                    int tmp2 = answer[j];
                    answer[j] = answer[j+1];
                    answer[j+1] = tmp2;

                }
            }
        }
        System.out.println(Arrays.toString(answer));
    }
}
