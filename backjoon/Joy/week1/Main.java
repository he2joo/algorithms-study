import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[] result = new int[testCase]; //결과 저장 배열

        for (int i=0;i<testCase;i++){
            int n = sc.nextInt();
            int[] list = new int[n];
            int headOfInterview = 0; //인터뷰 1등의 서류 등수.
            for (int j=0;j<n;j++){
                int document = sc.nextInt();
                int interview = sc.nextInt();
                if (interview==1) {
                    headOfInterview = document;
                }
                list[document-1] = interview;
            }
            int pass = 1;
            int min = list[0];
            for (int j=1;j< headOfInterview;j++){
                if (list[j]<list[j-1]){
                    if (list[j]<min){
                        pass++;
                        min = list[j];
                    }
                }
            }
            result[i] = pass;
        }
        for (int i : result){
            System.out.println(i);
        }
    }
}
