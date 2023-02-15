package programmers.ayaan.week3;

public class 다트게임_ayaan {
    public static void main(String[] args) {
        String dart = "1S2D*3T";
        int result = solution(dart);
        System.out.println(result);
    }

    public static int solution(String dartResult){
        int answer = 0;

        int preScore = 0;
        int score = 0;
        for(int i=0; i<dartResult.length(); i++){
            char ch = dartResult.charAt(i);

            if(ch == 'S' || ch == 'D' || ch == 'T'){
                switch (ch){
                    case 'D':
                        score *= score;
                        break;
                    case 'T':
                        score = score * score * score;
                        break;
                }
            } else if (ch == '*' || ch == '#') {
                switch (ch){
                    case '*':
                        score *= 2;
                        preScore *= 2;
                        break;
                    case '#':
                        score *= -1;
                        break;
                }
            } else {
                if(i != 0){
                    preScore = score;
                }
                score = Integer.parseInt(Character.toString(ch));
                continue;
            }

            answer += score;
            answer += preScore;
        }

        return answer;
    }

    public static int solution2(String dartResult){
        int answer = 0;

        int[] scores = new int[3];
        for(int i=0; i<3; i++){
            int count = 0;
            for(int j=0; j<3; j++){
                switch (j){
                    case 0:
                        char first = dartResult.charAt(i+count);
                        scores[j] = Integer.parseInt(Character.toString(first));
                        count++;
                        break;
                    case 1:
                        char second = dartResult.charAt(i+count);
                        int bonus = scores[j];
                        switch(second){
                            case 'D':
                                scores[j] = bonus * bonus;
                                break;
                            case 'T':
                                scores[j] = bonus * bonus * bonus;
                                break;
                        }
                        count++;
                        break;
                    case 2:

                        count++;
                        break;
                }
            }
        }

        return answer;
    }
}
