package leetcode.dp;

/**
 * @author louyuting
 * @create 2017-05-20-下午2:44
 *
 * 如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？
 *
 * 状态是 d(i) 表示凑够i元最少需要的硬币数量
 *
 * 状态转移方程是： d(i)=min{ d(i-v[j])+1 }  其中i-v[j] >=0，vj表示第j个硬币的面值;
 */
public class CoinQuestion {


}
