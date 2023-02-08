package programmers.ayaan.week2;

public class SecretMap_ayaan {

    public static void main(String[] args){
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] result = solution(n, arr1, arr2);
        System.out.println(result);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i=0; i<n; i++){
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);

            if(str1.length() < n){
                String newStr = str1;
                for(int k=0; k<n-str1.length(); k++){
                    newStr = "0" + newStr;
                }
                str1 = newStr;
            }
            if(str2.length() < n){
                String newStr = str2;
                for(int k=0; k<n-str2.length(); k++){
                    newStr = "0" + newStr;
                }
                str2 = newStr;
            }

            StringBuilder result = new StringBuilder();
            for(int j=0; j<n; j++){
                if((str1.charAt(j)-48 | str2.charAt(j)-48) == 1){
                    result.append("#");
                } else {
                    result.append(" ");
                }
            }
            answer[i] = result.toString();
        }

        return answer;
    }
}
