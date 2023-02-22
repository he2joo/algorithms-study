package programmers.fia.week3;

import java.util.ArrayList;
import java.util.List;

public class DartGame {
    public int solution(String dartResult) {
        int answer = 0;

        List<Integer> index = new ArrayList<>();
        for (int i = 2; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) <= 57 && dartResult.charAt(i) >= 47) {
                index.add(i);
            }
        }

        List<String> splitNumber = new ArrayList<>();
        splitNumber.add(dartResult.substring(0, index.get(0)));
        splitNumber.add(dartResult.substring(index.get(0), index.get(1)));
        splitNumber.add(dartResult.substring(index.get(1)));

        List<Integer> results = new ArrayList<>();
        boolean option = false;
        for (int i = 0; i < 3; i++) {
            String point = splitNumber.get(i);
            int result = point(point.charAt(0), point.charAt(1));
            if (point.length() < 3) {
                if (option) {
                    result = addOption(results.get(i - 1));
                }
                results.add(result);
                continue;
            }
            char options = point.charAt(2);
            result = option(result, point.charAt(2));
            if (option) {
                result = addOption(results.get(i - 1));
            }
            results.add(result);
            if (options == 42 && i > 0) {
                option = true;
            } else {
                option = false;
            }
        }
        answer = results.get(0) + results.get(1) + results.get(2);
        return answer;
    }

    public int point(int number, int type) {
        if (type == 83) {
            return (number - '0');
        } else if (type == 68) {
            return (number - '0') * (number - '0');
        } else {
            return (number - '0') * (number - '0') * (number - '0');
        }
    }

    public int option(int number, int type) {
        if (type == 42) {
            return number - '0' * 2;
        } else {
            return -(number - '0');
        }
    }

    public int addOption(int number) {
        return (number - '0') * 2;
    }
}
