package leetcode.ayaan.week1;

public class L289_2 {
    public static void main(String[] args){
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};

        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int live = 0;
                for(int k=0; k<8; k++){
                    int neighbor_x = i + dx[k];
                    int neighbor_y = j + dy[k];
                    if(neighbor_x >= 0 && neighbor_x < m && neighbor_y >= 0 && neighbor_y < n){
                        // 3(11) & 1 = 1 | 2(10) & 1 = 0
                        live += board[neighbor_x][neighbor_y] & 1;
                    }
                }

                int cell = board[i][j];
                // 2진수로 변환했을 때 비트값을 이용한다.
                if(cell == 1){
                    // 1 에서 0으로 바뀌는 경우 : 01(1)
                    // 1 에서 1로 유지되는 경우 : 11(3)
                    if(live >= 2 && live <= 3){
                        board[i][j] = 3;
                    }
                } else {
                    // 0 에서 0으로 유지되는 경우 : 00(0)
                    // 0 에서 1로 바뀌는 경우 : 10(2)
                    if(live == 3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // 3 >> 1 = 1
                // 2 >> 1 = 0
                board[i][j] >>= 1;
            }
        }

        toString(board);
    }

    public static void toString(int[][] board){
        int m = board.length;
        int n = board[0].length;

        StringBuilder print = new StringBuilder();
        print.append("[");
        for(int i=0; i<m; i++){
            print.append("[");
            for(int j=0; j<n; j++){
                print.append(board[i][j]);
                if(j != (n-1)){
                    print.append(",");
                }
            }
            print.append("]");
            if(i != (m-1)){
                print.append(",");
            }
        }
        print.append("]");

        System.out.println(print);
    }
}
