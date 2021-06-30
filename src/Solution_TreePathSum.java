import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution_TreePathSum {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode root, int targetSum){
        if(root == null){
            return;
        }path.offer(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0){
            res.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }



}
