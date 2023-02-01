package leetcode.ayaan.week1;

public class L289 {
    public static void main(String[] args){
        int[][] board = {{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};

        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 다음 상태 배열
        int[][] next = new int[m][n];

        // 8개의 이웃 세포를 구하기 위한 방향벡터
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                int live = 0;   // live 이웃 세포의 개수
                for(int k=0; k<8; k++){
                    int neighbor_x = i + dx[k];
                    int neighbor_y = j + dy[k];
                    // m x n의 범위를 벗어나는지 체크
                    if(neighbor_x >= 0 && neighbor_x < m && neighbor_y >= 0 && neighbor_y < n){
                        if(board[neighbor_x][neighbor_y] == 1){
                            live++;
                        }
                    }
                }

                int cell = board[i][j];
                if(cell == 1){
                    if(live < 2 || live > 3){
                        next[i][j] = 0;
                    } else {
                        next[i][j] = 1;
                    }
                } else {
                    if(live == 3){
                        next[i][j] = 1;
                    } else {
                        next[i][j] = 0;
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                board[i][j] = next[i][j];
            }
        }
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
