package programmers.fia.week2;

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            String line = String.format("%" + n + "s", Integer.toBinaryString(arr1[i] | arr2[i]));
            line = line.replace("1", "#");
            result[i] = line.replace("0", " ");
        }
        return result;
    }
}
