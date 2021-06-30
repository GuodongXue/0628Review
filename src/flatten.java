import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.List;

public class flatten {
    public void flatten (TreeNode root){
        List<TreeNode> list = new LinkedList<>();
        preOrder(root, list);
        int size = list.size();
        for(int i = 1; i<size; i++ ){
            TreeNode prev = list.get(i-1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }
    public void preOrder(TreeNode root, List<TreeNode> list){
        if(root!= null){
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }

}
