package programmers.fia.week2;

import java.util.Map;

public class 숫자_문자열과_영단어 {
    public int solution1(String s) {
        String temp = s;
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] integers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < numbers.length; i++) {
            temp = temp.replace(numbers[i], integers[i]);
        }
        return Integer.valueOf(temp);
    }

    public int solution2(String s) {
        String temp = s;
        Map<String, String> numbers = Map.of("zero", "0",
                "one", "1",
                "two", "2",
                "three", "3",
                "four", "4",
                "five", "5",
                "six", "6",
                "seven", "7",
                "eight", "8",
                "nine", "9");
        for (String key : numbers.keySet()) {
            temp = temp.replace(key, numbers.get(key));
        }
        return Integer.valueOf(temp);
    }
}
