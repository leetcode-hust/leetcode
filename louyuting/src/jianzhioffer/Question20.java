package jianzhioffer;

import java.util.ArrayList;

/**
 * Created by louyuting on 2017/2/22.
 *  20. 顺时针打印矩阵
 */
public class Question20 {

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if(matrix == null)
            return null;

        if(matrix.length==0){
            return res;
        }

        int row = matrix.length-1;
        int column = matrix[0].length-1;

        //只有一行
        if(row ==0 && column != 0){
            for(int i=0; i<=column; i++){
                res.add(matrix[0][i]);
            }
            return res;
        }
        //只有一列
        if(row !=0 && column == 0){
            for(int i=0; i<=row; i++){
                res.add(matrix[i][0]);
            }
            return res;
        }

        int top = row/2;

        int i=0;
        for(i=0; i <= top ; i++){
            printAyrray(matrix, row, column, i, res);
        }

        return res;
    }


    public static void printAyrray(int [][] matrix, int row, int column, int i,ArrayList<Integer> res ){
        //只有一行
        if (row%2 == 0 && i == (row/2)){
            for(int j=i; j<= column-i; j++){
                res.add(matrix[i][j]);
            }
            return;
        }

        //打印最上面一行, 从matrix[i,i] 到 matrix[i, column-i ]
        for(int j=i; j< column-i; j++){
            res.add(matrix[i][j]);
        }

        //从 matrix[i, column-i ] 到  matrix[row-i, column-i ]
        for(int j=i; j< row-i; j++){
            res.add( matrix[j][column-i] );
        }

        //从matrix[row-i, column-i] 到 matrix[row-i, i ]
        for(int j=column-i; j> i; j--){
            res.add( matrix[row-i][j]);
        }
        //从 matrix[row-i, i ] 到 matrix[i,i]
        for(int j=row-i; j> i; j--){
            res.add( matrix[j][i]);
        }
    }



    public static void main(String[] args) {

        int [][] matrix = {{1,2},{3,4},{5,6},{7,8},{9,10}};
        System.out.println(printMatrix(matrix));
    }

}
