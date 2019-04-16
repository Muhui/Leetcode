/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	List<Integer> res;
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        
        res = new ArrayList<>();

        findBelowTarget(target, K, 0);
        findAboveTarget(root, target, K);

        return res;

    }

    private int findAboveTarget(TreeNode root, TreeNode target, int K) {
    	if(root == null) return Integer.MIN_VALUE;
    	if(root == target) return 0;

    	int left = findAboveTarget(root.left, target, K);
    	int right = findAboveTarget(root.right, target, K);

    	if(left == K - 1 || right == K - 1) {
    		res.add(root.val);
    	}

    	int retVal = Integer.MIN_VALUE;
    	if(left != Integer.MIN_VALUE || right != Integer.MIN_VALUE) {
    		if(left >= 0) {
    			retVal = left + 1;
    			findBelowTarget(root.right, K, left + 2);	
    		}

    		if(right >= 0) {
    			retVal = right + 1;	
    			findBelowTarget(root.left, K, right + 2);
    		}
    	}

    	return retVal;

    }

    private void findBelowTarget(TreeNode curr, int K, int currDist) {
    	if(curr == null) return;

    	if(currDist == K) {
    		res.add(curr.val);
    	}
    	findBelowTarget(curr.left, K, currDist + 1);
    	findBelowTarget(curr.right, K, currDist + 1);
    }
}