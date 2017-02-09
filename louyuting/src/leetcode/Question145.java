package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Question145 {
    /**
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<Integer>();
        postHelper(root, post);
        return post;
    }

    private static void postHelper(TreeNode root, List<Integer> post) {
        if(root==null) return;

        postHelper(root.left, post);
        postHelper(root.right, post);
        post.add(root.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);

        List<Integer> resu = Question145.postorderTraversal(root);

        for (int i : resu){
            System.out.println(i);
        }
    }
}
