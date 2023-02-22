package programmers.fia.week4;

public class 신규_아이디_추천_Fia {
    public String solution(String new_id) {
        String userId = new_id.toLowerCase()
                .replaceAll("[^a-z0-9-_.]", "")
                .replaceAll("[.]{2,}", ".")
                .replaceAll("(\\b\\.\\B)|(\\B\\.\\b)", "");

        if (userId.length() == 0) {
            userId = "a";
        }
        if (userId.length() >= 16) {
            userId = userId.substring(0, 15).replaceAll("(\\b\\.\\B)|(\\B\\.\\b)", "");;

        }
        if (userId.length() <= 2) {
            while (userId.length() == 3) {
                userId += userId.charAt(userId.length() - 1);
            }
        }
        return userId;
    }

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";

        신규_아이디_추천_Fia fia = new 신규_아이디_추천_Fia();
        fia.solution(new_id);
    }
}
