import java.util.List;

public class LC_199_BinaryTreeRightSideView {
    public static void main(String[] args) {

    }

    private static void recurse(TreeNode root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (list.size() == level) {
            list.add(root.val);
        }
        recurse(root.right, list, level+1);
        recurse(root.left, list, level+1);
    }


    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
    }

}
