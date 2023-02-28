package programmers.fia.week5;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사_Fia {
    public String solution(String[] survey, int[] choices) {
        Map<Integer, Integer> points = new HashMap<>();
        points.put(1, 3);
        points.put(2, 2);
        points.put(3, 1);
        points.put(4, 0);
        points.put(5, 1);
        points.put(6, 2);
        points.put(7, 3);

        Map<Character, Integer> types = new HashMap<>();
        types.put('R', 0);
        types.put('T', 0);
        types.put('C', 0);
        types.put('F', 0);
        types.put('J', 0);
        types.put('M', 0);
        types.put('A', 0);
        types.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {
                Character type = survey[i].charAt(0);
                types.put(type, types.get(type) + points.get(choices[i]));
            } else if (choices[i] > 4) {
                Character type = survey[i].charAt(1);
                types.put(type, types.get(type) + points.get(choices[i]));
            }
        }

        StringBuilder builder = new StringBuilder();
        if (types.get('R') >= types.get('T')) {
            builder.append("R");
        } else {
            builder.append("T");
        }
        if (types.get('C') >= types.get('F')) {
            builder.append("C");
        } else {
            builder.append("F");
        }
        if (types.get('J') >= types.get('M')) {
            builder.append("J");
        } else {
            builder.append("M");
        }
        if (types.get('A') >= types.get('N')) {
            builder.append("A");
        } else {
            builder.append("N");
        }

        return builder.toString();
    }
}
