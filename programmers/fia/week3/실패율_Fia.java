package programmers.fia.week3;

import java.util.*;

public class 실패율_Fia {
    public List<Integer> solution(int N, int[] stages) {
        Map<Integer, Long> fails = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for (int stage : stages) {
            if (fails.containsKey(stage)) {
                continue;
            }
            long pass = Arrays.stream(stages).filter(s -> s >= stage).count();
            long in = Arrays.stream(stages).filter(s -> s == stage).count();
            long fail = in / pass;
            fails.put(stage, fail);
        }
        List<Long> valueList = new ArrayList<>(fails.values());
        valueList.sort(Long::compareTo);
        for (Integer key : fails.keySet()) {
            answer.add(key);
        }
        return answer;
    }

    public static void main(String[] args) {
        실패율_Fia 실패율 = new 실패율_Fia();
        int[] test = {2, 1, 2, 6, 2, 4, 3, 3};
        실패율.solution(5, test);
    }
}
