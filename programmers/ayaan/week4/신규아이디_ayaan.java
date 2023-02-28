package programmers.ayaan.week4;

public class 신규아이디_ayaan {
    public static void main(String[] args) {
        String id = "z-+.^.";
        String result = solution(id);
        System.out.println(result);
    }

    public static String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        answer = answer.replaceAll("\\.{2,}", ".");
        answer = answer.replaceAll("^\\.|\\.$", "");

        if(answer.isEmpty()){
            answer = "a";
        } else if(answer.length() > 15){
            answer = answer.substring(0, 15).replaceAll("\\.$", "");
        }

        while(answer.length() < 3){
            answer += answer.charAt(answer.length()-1);
        }

        return answer;
    }
}
