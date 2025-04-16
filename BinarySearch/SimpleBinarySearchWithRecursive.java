/**
 * @Description: 简单的二分查找
 * @Author: wjh
 * @Date: 2025/4/16 上午10:58
 */

public class SimpleBinarySearchWithRecursive{

    public static int BinarySearch(int[] nums, int k) {
        return binarySearchRecursive(nums, k, 0, nums.length - 1);
    }

    private static int binarySearchRecursive(int[] nums, int k, int low, int high) {
        if (low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (nums[middle] == k) {
            return middle;
        } else if (nums[middle] < k) {
            return binarySearchRecursive(nums, k, middle + 1, high);
        } else {
            return binarySearchRecursive(nums, k, low, middle - 1);
        }
    }
}  