package Meta;

public class S1344 {

    // 易错！
    public double angleClock(int hour, int minutes) {
        double h = hour, m = minutes; // 原始数据不用把 12 改成 0，角度是相对的，12点 - 260度 = 0点
        double span = 360;
        
        double degM = span * m / 60;
        double degH = span * (h + m/60) / 12;
        
        double deg = degM - degH;
        if (deg < 0) {
            deg = -deg;
        }
        if (deg > 180) {
            deg = span - deg; // 注意这里不是减180 是360 - deg 因为相当于 全饼 - 大饼 = 小饼！！！
        }
        
        return deg;
    }
}
