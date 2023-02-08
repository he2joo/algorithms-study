package programmers.ayaan.week2;

import java.util.HashMap;

public class 숫자_문자열과_영단어 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        int result = solution(s);
        System.out.println(result);
    }

    public static int solution(String s) {
        HashMap<String, Integer> alphabet = new HashMap<>();
        alphabet.put("zero", 0);
        alphabet.put("one", 1);
        alphabet.put("two", 2);
        alphabet.put("three", 3);
        alphabet.put("four", 4);
        alphabet.put("five", 5);
        alphabet.put("six", 6);
        alphabet.put("seven", 7);
        alphabet.put("eight", 8);
        alphabet.put("nine", 9);

        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) <= '9'){
                sb.append(s.charAt(i));
                continue;
            }

            temp.append(s.charAt(i));
            if(alphabet.containsKey(temp.toString())){
                sb.append(alphabet.get(temp.toString()));
                temp = new StringBuilder();
            }
        }

        return Integer.parseInt(sb.toString());
    }
}
