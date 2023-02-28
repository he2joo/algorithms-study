class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        size = len(nums)
        left = 0
        right = size - 1

        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                if mid > 0 and target > nums[mid - 1]:
                    return mid
                if mid == 0:
                    return 0
                right = mid - 1
            else:  # nums[mid] < target
                if mid + 1 < size and target < nums[mid + 1]:
                    return mid + 1
                if mid == size-1:
                    return size
                left = mid + 1