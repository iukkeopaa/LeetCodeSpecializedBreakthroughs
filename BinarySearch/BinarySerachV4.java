/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/4/16 上午11:23
 */
public class BinarySerachV4 {

     public int bsearch7(int[] a, int n, int value) {
         int low = 0;
         int high = n - 1;
         while (low <= high) {
             int mid = low + ((high - low) >> 1);
             if (a[mid] > value) {
                 high = mid - 1;
                 } else {
                 if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                 else low = mid + 1;
                 }
             }
         return -1;
     }
}
