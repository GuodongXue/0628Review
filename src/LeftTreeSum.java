public class LeftTreeSum {
    public int LeftTreeSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int res = 0;
        if(root.left != null && root.left.left == null && root.left.right == null){
            res+= root.left.val;
        }
        return LeftTreeSum(root.left)+ LeftTreeSum(root.right)+res;
    }
}
