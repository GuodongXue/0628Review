import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModeOfTree {
    HashMap<Integer, Integer> map = null;
    int max = 0;
    public int[] findMode(TreeNode root){
        map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        dfs(root);
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()== max){
                res.add(entry.getKey());
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i< result.length; i++){
            result[i] = res.get(i);
        }
        return result;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        map.put(root.val, map.getOrDefault(root.val, 0)+1);
        max = Math.max(map.get(root.val), max);
        dfs(root.left);
        dfs(root.right);
    }
}
