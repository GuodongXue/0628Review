import java.util.*;

public class closestValue {
    public void inorder(TreeNode root, List<Integer> list){
        if (root== null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    public int closestValue(TreeNode root, double target){
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return Collections.min(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs((o1-target))<Math.abs((o2-target))?-1:1;
            }
        });

    }
    public int closestValue2(TreeNode root, double target){
        if(root.val>target && root.left != null){
            int v = closestValue2(root.left, target);
            return Math.abs(root.val-target) <Math.abs(v - target) ? root.val: v;
        }else if (root.val<target && root.right != null){
            int v = closestValue2(root.right, target);
            return Math.abs(root.val-target) < Math.abs(v-target) ? root.val : v;
        } else {
            return root.val;
        }

    }

}
