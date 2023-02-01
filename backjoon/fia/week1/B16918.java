// https://www.acmicpc.net/problem/16918
// 시뮬레이션

package backjoon.fia.week1;

import java.util.Scanner;

public class B16918 {
    public static void main(String[] args) {
        B16918 bomberMan = new B16918();

        Scanner scanner = new Scanner(System.in);
        int ROW = scanner.nextInt();
        int COLUMN = scanner.nextInt();
        int SECOND = scanner.nextInt();

        int DOT = 46;
        int BOMB = 79;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // 초기 설정
        int[][] ground = new int[ROW][COLUMN]; // 위치 (. - O)
        int[][] bombTime = new int[ROW][COLUMN]; // 해당 위치에 있는 폭탄이 터질 시간
        for (int i = 0; i < ROW; i++) {
            String line = scanner.next();
            for (int j = 0; j < COLUMN; j++) {
                ground[i][j] = line.charAt(j);
                if (ground[i][j] == BOMB) {
                    bombTime[i][j] = 3;
                }
            }
        }

        if (SECOND == 1) {
            bomberMan.stringify(ground);
            return;
        }

        for (int i = 2; i <= SECOND; i++) {
            // 짝수인 경우 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다
            if (i % 2 == 0) {
                for (int r = 0; r < ROW; r++) {
                    for (int c = 0; c < COLUMN; c++) {
                        if (ground[r][c] == DOT) {
                            ground[r][c] = BOMB;
                            bombTime[r][c] = i + 3;
                        }
                    }
                }
            } else if (i % 2 == 1) {
                // 홀수인 경우 아무것도 하지 않는다
                for (int r = 0; r < ROW; r++) { // 타이머 3 폭탄은 폭발한다
                    for (int c = 0; c < COLUMN; c++) {
                        if (bombTime[r][c] == i) {
                            ground[r][c] = DOT;
                            bombTime[r][c] = -1;
                            for (int j = 0; j < 4; j++) { // 근처 4개의 폭탄은 소멸한다
                                int nearRow = r + dy[j];
                                int nearColumn = c + dx[j];
                                if (nearRow >= 0 && nearColumn >= 0 && nearRow < ROW && nearColumn < COLUMN && bombTime[nearRow][nearColumn] != i) {
                                    ground[nearRow][nearColumn] = DOT;
                                    bombTime[nearRow][nearColumn] = -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        bomberMan.stringify(ground);
    }

    public void stringify(int[][] ground) {
        for (int[] column : ground) {
            for (int k : column) {
                System.out.print(k == 46 ? "." : "O");
            }
            System.out.println();
        }
    }
}
