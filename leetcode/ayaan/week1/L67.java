package leetcode.ayaan.week1;

public class L67 {
    public static void main(String[] args){
        String a = "11";
        String b = "1";

        String c = addBinary(a, b);
        System.out.println(c);
    }

    public static String addBinary(String a, String b) {
        int a_len = a.length();
        int b_len = b.length();

        StringBuilder result = new StringBuilder();
        int sum = 0;
        while(a_len > 0 || b_len > 0){
            if(a_len > 0){
                sum += (a.charAt(a_len-1) - '0');
                a_len--;
            }
            if(b_len > 0){
                sum += (b.charAt(b_len-1) - '0');
                b_len--;
            }
            // sum의 값은 1 or 2 or 3 이므로 2로 나눈 나머지는 0 or 1
            result.append(sum%2);
            sum /= 2;   // 3일 경우 캐리를 sum에 저장해둔다.
        }
        if(sum == 1){   // 마지막 캐리가 있는 경우
            result.append(sum);
        }
        return result.reverse().toString();
    }
}
