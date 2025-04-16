/**
 * @Description: 简单的二分查找
 * @Author: wjh
 * @Date: 2025/4/16 上午10:58
 */
public class SimpleBinarySearch {

    public static int BinarySearch(int[] nums, int k) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int middle = (low + high) / 2;


            if (nums[middle] == k) {
                return middle;
            } else if (nums[middle] < k) {

                low = middle + 1;
            } else {

                high = middle - 1;
            }
        }
        return -1;
    }
}


// 3个注意点

//1. 循环退出条件  注意是 low<=high，而不是 low<high。
//2. mid 的取值 实际上，mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。改进的方法是将 mid 的计算方式写成 low+(high-low)/2。进一步，如果要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。因为相比除法运算来说，计算机处理位运算要快得多。
//3. low 和 high 的更新  low=mid+1，high=mid-1。注意这里的 +1 和 -1，如果直接写成 low=mid 或者high=mid，就可能会发生死循环。比如，当 high=3，low=3 时，如果 a[3] 不等于value，就会导致一直循环不退出。