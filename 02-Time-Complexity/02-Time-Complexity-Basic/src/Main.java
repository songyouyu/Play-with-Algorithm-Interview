/**
 * 时间复杂度
 * @author youyusong
 * @date 2018/8/11
 */
public class Main {

    public static void main(String[] args) {
        for (int x = 1; x <= 9; x++) {

            int n = (int) Math.pow(10, x);

            long startTime = System.currentTimeMillis();

            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += i;
            }

            long endTime = System.currentTimeMillis();

            System.out.println("sum = " + sum);
            System.out.println("10^" + x + " : " + (endTime - startTime) + " ms");
            System.out.println("");
        }
    }

    /*
    如果想在 1S 内解决问题：
    O(n^2)的算法可以处理大约 10 ^ 4 级别的数据
    O(n)的算法可以处理大约 10 ^ 8 级别的数据
    O(nlogn)的算法可以处理大约 10 ^ 7 级别的数据
     */

}
