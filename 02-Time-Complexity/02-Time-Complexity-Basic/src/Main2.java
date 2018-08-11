/**
 * 空间复杂度
 * @author youyusong
 * @date 2018/8/11
 */
public class Main2 {

    private static int sum1(int n){

        int ret = 0;
        for( int i = 0 ; i <= n ; i ++ ) {
            ret += i;
        }
        return ret;
    }

    private static int sum2(int n){

        if( n == 0 ) {
            return 0;
        }

        return n + sum2(n-1);
    }

    public static void main(String[] args) {

        System.out.println(sum1(10000));
        System.out.println(sum2(10000));
    }

}
