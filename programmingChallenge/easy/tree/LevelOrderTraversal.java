package programmingChallenge.easy.tree;

import programmingChallenge.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-level-order-traversal/
public class LevelOrderTraversal {

    // basically using BFS in traversal order
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int level = queue.size();
            List<Integer> wrapper = new ArrayList();
            for(int i = 0; i < level; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                wrapper.add(queue.poll().val);
            }
            list.add(wrapper);
        }

        return list;
    }

    // DFS recursion
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList();
        if(root == null) return list;
        levelOrderHelper(list, root, 0);
        return list;
    }

    void levelOrderHelper(List<List<Integer>> list, TreeNode node, int level){
        if(node == null) return;

        if(level >= list.size() ){
            List<Integer> wrapper = new ArrayList();
            wrapper.add(node.val);
            list.add(wrapper);
        }else{
            list.get(level).add(node.val);
        }

        levelOrderHelper(list, node.left, level+1);
        levelOrderHelper(list, node.right, level+1);
    }
}
