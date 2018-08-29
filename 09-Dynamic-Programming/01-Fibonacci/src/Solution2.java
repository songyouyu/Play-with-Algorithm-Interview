import java.util.Arrays;

/**
 * @author youyusong
 * @date 2018/8/29
 */
public class Solution2 {

    private int num = 0;

    public int fib(int n){
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib(n, memo);
    }

    private int fib(int n, int[] memo){

        num ++;

        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        if(memo[n] == -1) {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }

        return memo[n];
    }

    public int getNum(){
        return num;
    }

    public static void main(String[] args) {

        int n = 40;

        Solution2 solution = new Solution2();
        long startTime = System.currentTimeMillis();
        int res = solution.fib(n);
        long endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + res);
        System.out.println("time : " + (endTime - startTime) + " ms");
        System.out.println("run function fib() " + solution.getNum() + " times.");
    }

}
