package DFS;

public class CountGoodNodes {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int count = 0;

    public int goodNodes(TreeNode root) {
        int val = root.val;
        dfs(root, val);

        int answer = count;
        count = 0;

        return answer;
    }

    public void dfs(TreeNode node, int max) {
        if(max <= node.val) {
            count++;
            max = node.val;
        }

        if(node.left == null && node.right == null)
            return;

        if(node.left != null) {
            dfs(node.left, max);
        }
        if(node.right != null) {
            dfs(node.right, max);
        }
    }
}
