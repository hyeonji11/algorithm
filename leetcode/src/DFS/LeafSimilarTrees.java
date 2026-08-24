package DFS;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) return true;

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        dfs(list, root1);
        dfs(list2, root2);

        if(list.size() != list2.size())
            return false;

        for(int i=0; i<list.size(); i++) {

            if(!list.get(i).equals(list2.get(i))) return false;
        }

        return true;

    }

    public void dfs(List<Integer> list, TreeNode cur) {
        if(cur.left == null && cur.right == null) {
            list.add(cur.val);
            return;
        }

        if(cur.left != null)
            dfs(list, cur.left);
        if(cur.right != null)
            dfs(list, cur.right);
    }
}
