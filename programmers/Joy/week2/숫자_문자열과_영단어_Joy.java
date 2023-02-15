package programmers.Joy.week2;

import java.util.HashMap;

public class 숫자_문자열과_영단어_Joy {
    public int solution(String s) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("zero",0);
        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);
        map.put("five",5);
        map.put("six",6);
        map.put("seven",7);
        map.put("eight",8);
        map.put("nine",9);

        String result = "";
        while (!s.equals("")){
            int i = 0;
            String num = s.charAt(i)+"";
            if (map.containsKey(num)){
                result += map.get(num)+"";
                i++;
            }else {

            }
        }
        int r = 0;
        return r;
    }

    public static void main(String[] args) {
        String s = "2three45sixseven";
        s = s.replaceAll("[0123456789]","*");
        String[] strArr = s.split("");
        for (int i = 0; i < strArr.length; i++) {
            String s1 = strArr[i];

        }
        System.out.println(s);
        System.out.println(strArr.length);
    }
}

