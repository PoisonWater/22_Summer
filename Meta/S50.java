package Meta;

class S50R2 {
    // R2 用Recursion！！！
    public double myPow(double x, int n) {
        // handle n<0 n==0
        if (x == 0) { return 0; }
        if (n == 0) { return 1; }
        
        if (n < 0) {
            return (1 / x) * myPow(1 / x, -n-1);
        }
        
        if (n % 2 == 0) {
            return myPow(x * x, n/2);
        } else {
            return x * myPow(x * x, n/2);
        }
    }
}

public class S50 {

    // Revisit : Recursion 更直观 OlogN OlogN
    public double myPow1(double x, int n) {
        // x == 0;
        if (x == 0) { return 0; }
        // n < 0;
        if ( n < 0 ) {
            return getPow(1/x, -n - 1) * 1 / x;
        }
        return getPow(x, n);
    }
    
    private double getPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        
        double ret = getPow(x, n / 2);
        
        if (n % 2 == 1) {
            return x * ret * ret;
        } 
        
        return ret * ret;
        
    }

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
