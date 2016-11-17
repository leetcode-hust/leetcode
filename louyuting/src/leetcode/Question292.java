package leetcode;

/**
 * Created by louyuting on 16/11/15.
 * 292-Nim Game
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you
 * take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first
 * turn to remove the stones.
   Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
   win the game given the number of stones in the heap.

 For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you remove,
 the last stone will always be removed by your friend.

 If there are 5 stones in the heap, could you figure out a way to remove the stones such that you will always be the winner?
 */

import utils.InputUtil;
import utils.LogUtil;

/**
 * 分析: 我是最先开始移动石头的,如果n是4的倍数,那么无论我最开始移动1-3个,到我的时候是4的倍数,我必输;
 * 如果n不是4的倍数,我移动之后都可以保证到对方手里时是4的倍数,我必赢.
 */
public class Question292 {


    public static boolean canWinNim(int n) {
        /*if(n%4 == 0){
            return false;
        }else {
            return true;
        }*/
        //return n%4==0? false:true;
        return n%4!=0;
    }


    public static void main(String[] args) {

        int n = InputUtil.inputInt(null);

        if(canWinNim(n)){
            LogUtil.log_debug("true");
        }else{
            LogUtil.log_debug("false");
        }
    }
}
