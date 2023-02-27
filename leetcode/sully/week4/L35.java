package leetcode.sully.week4;

public class L35 {
    public static int searchInsert(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] >= target) {
//                return i;
//            }
//        }
//
//        return nums.length;

        int lt = 0;
        int rt = nums.length - 1;
        int mid;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
//            mid = (rt - lt) / 2 + lt; // fia
            if (nums[mid] > target) {
                rt = mid - 1;
            } else if (nums[mid] < target) {
                lt = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            }
        }

        return lt;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
