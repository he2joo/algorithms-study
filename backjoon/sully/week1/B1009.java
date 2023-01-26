package backjoon.sully.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B1009 {
    // 컴퓨터는 총 10대 (1번 ~ 10번)
    // 데이터 개수 -> a^b 형태
    // 최대 4번까지 거듭제곱
    // 10번째 컴퓨터에는 조건에 따라 10을 출력
    static void solution(List<List<Integer>> input) {
        for (List<Integer> list : input) {
            int tmpOutput = 1;
            int a = list.get(0);
            int b = list.get(1) % 4;
            if (b == 0) { // 원래의 b와 4의 나머지가 0이면 4를 넣어준다.
                b = 4;
            }
            for (int j = 0; j < b; j++) {
                tmpOutput = (tmpOutput * a) % 10;
            }
            if (tmpOutput == 0) { // 10번째 컴퓨터
                tmpOutput = 10;
            }
            System.out.println(tmpOutput);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<List<Integer>> input = new ArrayList<>(); // List<>형 2차원 배열
        for (int i = 0; i < t; i++) {
            List<Integer> tmp = new ArrayList<>(); // input 2차원 배열에 저장할 임시 1차원 배열
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            tmp.add(Integer.parseInt(st.nextToken())); // a
            tmp.add(Integer.parseInt(st.nextToken())); // b
            input.add(tmp);
        }
        solution(input);
        br.close();
    }
}