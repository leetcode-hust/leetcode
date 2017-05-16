package leetcode;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.common.TreeNode;

/**
 * @author louyuting
 * @create 2017-05-16-下午4:43
 *
 * tip：代码必须被设计成无状态的，所以不能有class 成员或则静态成员；
 *      最好是不存在递归函数，所以层次遍历是最好的。
 *      而且由于要还原二叉树，如果是先序，中序或则是后序遍历，我们必须保存中序先序，或则是中序后序遍历，才能完全还原确定一个二叉树，增大了数据量；
 *      所以我们最好的就是使用层次遍历，然后如果不存在的节点就用null 表示。
 *
 *      节点之间用 逗号 来分割。
 */
public class Question297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return null;

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //层次遍历
        int level = 0;//层次遍历的层次；
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();//每一层的节点数
            int count=0;// 第i层的下一层null 节点的个数。
            level++;
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                if(node != null){
                    queue.add(node.left);
                    queue.add(node.right);
                    if(node.left == null) {
                        count++;
                    }
                    if(node.right==null){
                        count++;
                    }
                    sb.append(node.val + ",");
                }else {
                    count++;//null节点的子节点均为空
                    count++;
                    queue.add(null);
                    queue.add(null);
                    sb.append("null" + ",");
                }
            }
            if(count == (int)Math.pow(2.0d, level)){
                //当前层全是的子节点null
                break;
            }
        }
        sb.append(level);//最后一个数据是二叉树的层次数。
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //还原节点；
        if(data == null)
            return null;
        //删除最后的一个逗号
        String[] nums = data.split(",");
        int maxLevel = Integer.valueOf(nums[nums.length-1]);//二叉树的层次数
        TreeNode root = new TreeNode( Integer.valueOf(nums[0]) );//构建根节点。

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;//层次遍历的层次；
        int i=1; //从第二个节点开始；
        while (!queue.isEmpty()){
            level++;
            int size = (int)Math.pow(2.0d, level-1); //当前 level 的节点数
            TreeNode node = queue.poll();

            for(int i1=0; i1<size;){
                if(node == null){
                    i1++;i1++;
                    continue;
                }
                else {
                    if(!nums[ (int) Math.pow(2.0d, level-1)-1 + i1 ].equals("null"))
                        node.left = new TreeNode(Integer.valueOf(nums[ (int) Math.pow(2.0d, level-1)-1 + i1 ]));
                    else
                        node.left=null;
                    i1++;
                    if(!nums[ (int) Math.pow(2.0d, level-1)-1 + i1 ].equals("null"))
                        node.right = new TreeNode(Integer.valueOf(nums[ (int) Math.pow(2.0d, level-1)-1 + i1 ]));
                    else
                        node.right=null;
                    i1++;

                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(6);
        System.out.println(new Question297().serialize(root));
    }
}
