package programmers.Joy.week2;

import java.util.Scanner;

public class SecretMapJoy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

//      1. 입력받은 문자열을 정수로 변환하여 int 배열에 넣는다.
        str1 = str1.replaceAll("]"," ");
        str1 = str1.replaceAll("["," ");
        str2 = str1.replaceAll("]"," ");
        str2 = str1.replaceAll("["," ");
        String[] strArr1 = str1.split(" ");
        String[] strArr2 = str2.split(" ");

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

//      2. 배열 값 이진수로 변환하여 문자열 2차원배열에 넣는다
        for (int i=0;i<n;i++){
            strArr1[i] = ""+Integer.toBinaryString(arr1[i]);
            strArr2[i] = ""+Integer.toBinaryString(arr2[i]);
        }
//      3. 문자열 비교
        String[] result = new String[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                char ch1 = strArr1[i].charAt(j);
                char ch2 = strArr2[i].charAt(j);
                int t = (int)(ch1)+(int)(ch2);
                if (t==0){
                    result[i] += " ";
                }else {
                    result[i] += "#";
                }
            }
        }
//      4. 출력
        System.out.println(result);
    }
}
