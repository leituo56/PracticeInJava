//Two elements of a binary search tree (BST) are swapped by mistake.
//
//Recover the tree without changing its structure.
//
//Note:
//A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
package org.leituo.leetcode.treeM;

/**
 * Created by leituo56 on 1/16/15.
 */
public class RecoverBinarySearchTree {
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        traverse(root);
        if(first!=null && second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    private void traverse(TreeNode root){
        if(root==null)
            return;
        traverse(root.left);
        if(prev !=null && root.val < prev.val){
            if(first == null){
                first = prev;
            }
            second = root;
        }
        prev = root;
        traverse(root.right);
    }
}
