package leetcode.sully.week1;

class L2535 {
    public static int differenceOfSum(int[] nums) {
        int digitSum = 0;
        int elementSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // digit
            digitSum += nums[i];

            // element
            if (nums[i] / 10 > 0) {
                int tmp = nums[i];
                while (tmp != 0) {
                    elementSum += tmp % 10;
                    tmp /= 10;
                }
                continue;
            }
            elementSum += nums[i];
        }

        return Math.abs(elementSum - digitSum);
    }
}