package leetcode.fia.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
    public List<Integer> partitionLabels1(String s) { // HashMap 사용하지 않은 경우
        List<Integer> results = new ArrayList<>();

        char start = s.charAt(0);
        int beforeLastIndex = - 1;

        while (beforeLastIndex != s.length() - 1) {
            int lastIndexOfStart = s.lastIndexOf(start);
            int maxIndexOfWord = lastIndexOfStart;

            for (int i = 0; i < maxIndexOfWord; i++) {
                int lastIndexCheck = s.lastIndexOf(s.charAt(i));
                if (s.charAt(i) != start && maxIndexOfWord < lastIndexCheck) {
                    maxIndexOfWord = lastIndexCheck;
                }
            }
            results.add(maxIndexOfWord - beforeLastIndex);
            beforeLastIndex = maxIndexOfWord;
            if (beforeLastIndex != s.length() - 1) {
                start = s.charAt(beforeLastIndex + 1);
            }
        }
        return results; // runtime : 60 ms (Beats : 5.27 %) & memory : 40.7 MB (Beats : 92.20 %)
    }

    public List<Integer> partitionLabels2(String s) { // HashMap 사용한 경우
        Map<Character, Integer> charAndIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charAndIndex.put(s.charAt(i), i);
        }

        List<Integer> results = new ArrayList<>();
        int maxIndex = 0;
        int previousIndex = - 1;
        for (int i = 0; i < s.length(); i++) {
            char start = s.charAt(i);
            maxIndex = Math.max(maxIndex, charAndIndex.get(start));
            if (maxIndex == i) {
                results.add(maxIndex - previousIndex);
                previousIndex = maxIndex;
            }
        }
        return results; // runtime : 8 ms  (Beats : 39.2 %) & memory : 42.3 MB (Beats : 45.95 %)
    }
}
