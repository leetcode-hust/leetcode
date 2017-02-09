package leetcode;

import leetcode.common.TreeNode;

import java.util.*;

public class Question103 {
    /**
     * 二叉树的层次遍历
     * 使用队列实现
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列里面存放结点
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int flag=1;
        //如果为空树就直接返回
        if(root == null){
            return result;
        }

        queue.offer(root);//根节点先入队
        //只要队列非空就一直循环;
        while (!queue.isEmpty()){
            int levelNum = queue.size();//获取当前层的节点数.
            flag++;

            //从右到左遍历时才使用
            Stack<Integer> stack = new Stack<>();

            List<Integer> subList = new ArrayList<>();
            //遍历当前层结点
            for(int i=0; i<levelNum; i++){
                //队首出队并将value加入子list
                TreeNode node = queue.poll();
                //偶数行就用栈存储
                if(flag %2 == 1) {
                    stack.push(node.val);
                }else{
                    subList.add(node.val);
                }

                //将非空左右子树加入queue
                if(node.left != null){//如果队首的左结点不为空就把左结点入队
                    queue.offer(node.left);
                }
                if(node.right != null){//如果队首的右结点不为空就把右结点入队
                    queue.offer(node.right);
                }
            }
            //偶数行就从栈中取数据.
            if(flag %2 == 1) {
                while (!stack.isEmpty()){
                    subList.add(stack.pop());
                }
                result.add(subList);
            }else {
                result.add(subList);//添加一层
            }
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = Question103.levelOrder(root);

        for(List<Integer> is : res){
            for(Integer i : is){
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }

}
