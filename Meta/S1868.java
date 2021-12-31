package Meta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class S1868 {

    // 直接在数组上记录traversal, 修改原始数据！！ TODO: Revisit!!
    public List<List<Integer>> findRLEArray1(int[][] encoded1, int[][] encoded2) {
        int p1 = 0, p2=0;
        List<List<Integer>> res = new ArrayList<>();
		
        while(p1 < encoded1.length) {
            int len = Math.min(encoded1[p1][1], encoded2[p2][1]);
            int mult = encoded1[p1][0] * encoded2[p2][0];
            
            if(res.size() > 0 && res.get(res.size()-1).get(0) == mult) //to handle cases like [[1,3],[2,3]] * [[6,3],[3,3]] --> [[6,6]]
                res.get(res.size()-1).set(1, res.get(res.size()-1).get(1)+len); //update previous mult in res instead of adding a new one
            else
                res.add(Arrays.asList(mult, len));
            
			encoded1[p1][1] -= len;
            encoded2[p2][1] -= len;
            if(encoded1[p1][1] == 0) p1++;
            if(encoded2[p2][1] == 0) p2++;
        }
        return res;
}
    
    // 太慢 可以直接在原数组上操作 详见上种方法 乘一个删一个 一次可以加一堆
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        
        int p1 = 0, p2 = 0; // pointer for encoded arr
        int off1 = 0, off2 = 0; // previous sum of jumped offsets
        int p = 0; // pointer for global mult
        
        List<List<Integer>> ret = new ArrayList<>();
        
        while (p1 < encoded1.length || p2 < encoded2.length) {
            
            // update ret list
            int m = encoded1[p1][0] * encoded2[p2][0]; // numbers at ptr
            
            if (ret.isEmpty() || ret.get(ret.size() - 1).get(0) != m) { // add new list in ret
                List<Integer> tmp = new ArrayList<>();
                tmp.add(m);
                tmp.add(0);
                ret.add(tmp);
            }
            List<Integer> last = ret.get(ret.size() - 1);
            last.set(1, last.get(1) + 1);
            
            // next iteration
            p++; // update global pointer
            if (p >= off1 + encoded1[p1][1]) {
                off1 += encoded1[p1][1];
                p1++;
            }
            if (p >= off2 + encoded2[p2][1]) {
                off2 += encoded2[p2][1];
                p2++;
            }
            
        }
        
        return ret;
        
    }

    // 这个能过 模拟改变原数组len 但很慢
    public List<List<Integer>> findRLEArray0(int[][] encoded1, int[][] encoded2) {
        
        int p1 = 0, p2 = 0; // pointer for encoded arr
        int off1 = 0, off2 = 0; // previous sum of jumped offsets
        int p = 0; // pointer for global mult
        
        List<List<Integer>> ret = new ArrayList<>();
        
        while (p1 < encoded1.length || p2 < encoded2.length) {
            
            // update ret list
            int m = encoded1[p1][0] * encoded2[p2][0]; // numbers at ptr
            int len = 0;
            
            while (p < off1 + encoded1[p1][1] && p < off2 + encoded2[p2][1]) {
                // next iteration
                p++; // update global pointer
                len++;
            }
            
            if (ret.isEmpty() || ret.get(ret.size() - 1).get(0) != m) { // add new list in ret
                List<Integer> tmp = new ArrayList<>();
                tmp.add(m);
                tmp.add(0);
                ret.add(tmp);
            }
            
            List<Integer> last = ret.get(ret.size() - 1);
            last.set(1, last.get(1) + len);
            
            if (p >= off1 + encoded1[p1][1]) {
                off1 += encoded1[p1][1];
                p1++;
            }
            if (p >= off2 + encoded2[p2][1]) {
                off2 += encoded2[p2][1];
                p2++;
            }
            
        }
        
        return ret;
        
    }

}
