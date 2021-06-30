import java.util.ArrayList;

public class ModeOfTree2 {
    int preVal = 0, curTimes = 0, maxTimes = 0;

    ArrayList<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root){
        traverse(root);
        int size = list.size();
        int[] res = new int[list.size()];
        for(int i = 0; i< size; i++){
            res[i]= list.get(i);
        }
        return res;
    }

    public void traverse(TreeNode root){
        if(root != null){
            traverse(root.left);
            if(preVal == root.val){
                curTimes++;
            }else{
                preVal = root.val;
                curTimes = 1;
            }

            if(curTimes ==maxTimes){
                list.add(root.val);
            } else if( curTimes> maxTimes){
                list.clear();
                list.add(root.val);
                maxTimes = curTimes;
            }
            traverse(root.right);
        }
    }
}
