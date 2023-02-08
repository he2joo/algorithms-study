package programmers.fia.week2;

public class 숫자_문자열과_영단어 {
    public int solution(String s) {
        String temp = s;
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] integers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for(int i = 0; i < numbers.length; i++) {
            temp = temp.replace(numbers[i], integers[i]);
        }
        return Integer.valueOf(temp);
    }
}
