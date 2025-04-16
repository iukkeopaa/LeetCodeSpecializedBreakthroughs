public class CircularSortedBinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]) {
                // 目标值在左半部分有序区间内
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 1, 2, 3};
        int target = 2;
        int result = search(nums, target);
        if (result != -1) {
            System.out.println("目标值 " + target + " 在数组中的索引是: " + result);
        } else {
            System.out.println("目标值 " + target + " 不在数组中。");
        }
    }
}    