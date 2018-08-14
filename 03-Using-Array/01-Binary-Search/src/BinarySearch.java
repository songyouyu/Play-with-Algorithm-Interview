/**
 * 二分查找法
 * @author youyusong
 * @date 2018/8/14
 */
public class BinarySearch {

    /**
     * 使用二分查找法在数组 arr 中查找元素 target
     * @param arr
     * @param target
     * @return
     */
    public int binarySearch(Comparable[] arr, Comparable target) {

        int n = arr.length;
        int l = 0;
        int r = n - 1;

        // 在数组 arr[l...r] 中查找元素 target
        // 即使 l == r, arr[l...r] 依然有效
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == arr[mid]) {
                return mid;
            }
            if (target.compareTo(arr[mid]) < 0) {
                // target在[l...mid-1]中; [mid...r]一定没有target
                r = mid - 1;
            } else {
                // target在[mid+1...r]中; [l...mid]一定没有target
                l = mid + 1;
            }
        }

        return -1;
    }

}
