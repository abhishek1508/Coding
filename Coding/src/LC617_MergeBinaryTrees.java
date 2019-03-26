public class LC617_MergeBinaryTrees {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        //t1.left =  new TreeNode(2);
        t1.right =  new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        t2.left =  new TreeNode(4);
        t2.right =  new TreeNode(5);
        TreeNode result = mergeTrees(t1, t2);
        System.out.println(result);
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left == null ? null : t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
