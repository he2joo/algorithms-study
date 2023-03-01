package programmers.fia.week5;

public class 크레인_Fia {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < board.length; i++) {
            int line = moves[i] - 1;
            for (int j = 0; j < board.length; j++) {
                if (board[line][j] > 0) {
                    builder.append(board[line][j]);
                    board[line][j] = 0;
                    break;
                }
            }

            if (builder.toString().length() > 1){
                String s = builder.toString().replaceAll("(.)\\1+", "");
                answer += (builder.toString().length() - s.length()) / 2;
                builder = new StringBuilder();
                builder.append(s);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        크레인_Fia fia = new 크레인_Fia();
        fia.solution(board, moves);
    }
}
