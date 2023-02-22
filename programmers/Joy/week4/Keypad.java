package programmers.Joy.week4;

public class Keypad {
    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        int right = 12;
        int left = 10;
        StringBuilder sb = new StringBuilder();
        for (int n : numbers){
            n = (n==0)? 11:n;
            int rest = n-1;
            switch (rest % 3){
                case 0 : // n이 1,4,7
                    sb.append("L");
                    left = n;
                    break;
                case 1 : // n이 2,5,8,0
                    // 점의 좌표 구하기
                    int[] npoint = {rest/3,rest%3};
                    int[] rpoint = {(right-1)/3,(right-1)%3};
                    int[] lpoint = {(left-1)/3,(left-1)%3};

                    // 두 점사이의 거리 구하기
                    double rdis = Math.sqrt(Math.pow(npoint[0]-rpoint[0],2)+Math.pow(npoint[1]-rpoint[1],2));
                    double ldis = Math.sqrt(Math.pow(npoint[0]-lpoint[0],2)+Math.pow(npoint[1]-lpoint[1],2));;

                    if (rdis > ldis){ //왼손이 더 가까울 때
                        sb.append("L");
                        left = n;
                    } else if (rdis < ldis) { //오른손이 더 가까울 때
                        sb.append("R");
                        right = n;
                    }else { //위치 같을 때
                        if (hand.equals("right")){
                            sb.append("R");
                            right = n;
                        }else {
                            sb.append("L");
                            left = n;
                        }
                    }
                    break;
                case 2 : // n이 3,6,9
                    sb.append("R");
                    right = n;
                    break;
            }
        }
        String result = sb.toString();
        System.out.println(result);
    }
}