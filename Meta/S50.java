package Meta;

public class S50 {

    // https://leetcode-cn.com/problems/powx-n/solution/50-powx-n-kuai-su-mi-qing-xi-tu-jie-by-jyd/
    public double myPow(double x, int n) {

        // 指数小于零，转换为负幂
        if (n < 0) {
            // 拆一个1/x 防止负数的负数 大于 max int
            return myPow(1/x, -n - 1) * 1/x;
        }

        double res = 1.0;

        // 不断除2 取平方
        while (n > 0) {
            // 确定二进制当前位是否为1
            if (n % 2 == 1) {
                res *= x;
            }
            // 二进制算法，对底数不断平方
            x *= x;
            n /= 2;
        }
        return res;
    }
}
