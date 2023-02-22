package leetcode.ayaan.week4;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;

        int result = searchInsert(nums, target);
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        // 시간복잡도 O(nlogn)으로 구현한다. -> 이진탐색
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(left <= right){
            mid = (left + right) / 2;
            if(target < nums[mid]){
                right = mid - 1;
            } else if(target > nums[mid]){
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
