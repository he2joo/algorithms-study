package programmers.sully.week3;

class 실패율 {
    // (스테이지 도달했으나, 클리어 x) / (스테이지 도달한 플레이어 수)
    // N: 전체 스테이지 개수
    // stage: 사용자가 "멈춰있는" 스테이지 번호 배열 -> 각 배열은 사용자가 현재 도전 중인 스테이지 번호

    // 만약, 실패율 같은 스테이지 존재 -> 작은 번호의 스테이지가 먼저 오도록 (정렬할 때 예외처리 해줄 것.)
    // 스테이지에 도달한 유저가 없는 경우 -> 실패율 0으로 예외처리

    // 실패율이 높은 것부터 내림차순으로 스테이지 번호 담긴 배열 return
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        // 일단 실패율부터 구하자
        // i가 증가할 때마다 분자의 수만큼 분모를 빼준다 -> 그럼 List 사용할까? -> ㄴㄴ

        // 그니까 stage 배열의 값을 작은 수부터 (완전 탐색?) 그 수가 몇개인지를 찾으면 되는 문제임
        // 그 후 예외처리는 따로 해주면 되는 거고

        // 분모는 stages의 길이로 초기화
        int denominator = stages.length;

//        int min = stages[0];
        for (int i = 0; i < N; i++) {
            // 분자는 N값이 증가할 때마다 0으로 초기화
            int numerator = 0;

            // stages 배열을 작은 값부터 찾아나가야 하는데 최소값을 구하는 게 맞나?
            // 최소값을 구하면 뭐해 그 다음 값부터는 못 구하는데
            // stages 배열에는 1 이상 N + 1 이하의 자연수가 담겨있다. -> 이 조건이 있었네
            for (int j = 0; j < stages.length; j++) {

            }

            // N이 증가할 때마다 분모는 분자값을 빼준 값이 됨
            denominator -= numerator;

//            for (int j = 0; j < stages.length; j++) {
//                if (min > stages[i]) {
//                    min = stages[i];
//                }
//            }
        }
        return answer;
    }
}
