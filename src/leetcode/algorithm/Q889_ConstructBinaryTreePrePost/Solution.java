package leetcode.algorithm.Q889_ConstructBinaryTreePrePost;

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre,post, 0, pre.length-1, 0, post.length-1);

    }

    private TreeNode helper(int[] pre, int[] post, int preStart, int preEnd, int postStart, int postEnd){
        if(preStart > preEnd || postStart > postEnd){
            return null;
        }
        int val = pre[preStart];
        TreeNode root = new TreeNode(val);
        // if this is a singlr node;
        if(preStart == preEnd){
            return root;
        }

        int index = findIndex(post, pre[preStart+1], postStart, postEnd);
        int diff = index - postStart;
        root.left = helper(pre,post, preStart+1, preStart+diff+1, postStart, index);
        root.right = helper(pre,post, preStart+diff+2, preEnd, index+1, postEnd-1);
        return root;
    }

    private int findIndex(int[] post, int target, int start, int end){

        int index = start;
        for(int i = start; i <= end; i++){
            if(post[i] == target){
                index = i;
                break;
            }
        }
        return index;
    }
}

class TreeNode {
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