package programmingChallenge.medium.tree;

import programmingChallenge.utils.TreeNode;

import java.util.Stack;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack();
        Stack<TreeNode> stackQ = new Stack();

        stackP.push(p);
        stackQ.push(q);

        while(!stackP.isEmpty() && !stackQ.isEmpty()){
            TreeNode nodeP = stackP.pop();
            TreeNode nodeQ = stackQ.pop();


            if(nodeP == null || nodeQ == null){
                if(nodeP == nodeQ) continue;
                else return false;
            }
            if(nodeP.val != nodeQ.val) return false;

            stackP.push(nodeP.right);
            stackQ.push(nodeQ.right);
            stackP.push(nodeP.left);
            stackQ.push(nodeQ.left);
        }

        return stackP.isEmpty() && stackQ.isEmpty();
    }
}
