package leetcode.fia.week4;

import java.util.ArrayList;
import java.util.Collections;

public class LeetCode35 {
    public int searchInsert1(int[] nums, int target) { // 라이브러리 사용 시
        ArrayList<Integer> numList = new ArrayList<>();
        for (int number : nums) {
            numList.add(number);
        }
        if (!numList.contains(target)) {
            numList.add(target);
            Collections.sort(numList);
        }
        return numList.indexOf(target);
    }

    public void searchInsert2(int[] nums, int target) { // log n : 반씩 나눠서 검사하기
        int start = 0;
        int end = nums.length - 1;
        int half = start + ((end - start) / 2);
        int value = nums[half];
        if (value < target) {
            start = half;
        } else {
            end = half;
        }
        half = start + ((end - start) / 2);
    }
}
