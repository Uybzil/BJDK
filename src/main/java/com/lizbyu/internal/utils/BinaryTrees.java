package com.lizbyu.internal.utils;

import com.lizbyu.internal.tree.binary.BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTrees<V> {

    public BinaryTree<V, BinaryTree.Node<V>> create(List<V> valueSequence) {
        return new BinaryTree<>(createRootNode(valueSequence, 0));
    }

    private BinaryTree.Node<V> createRootNode(List<V> valueSequence, int index) {
        if (index >= valueSequence.size() || valueSequence.get(index) == null) {
            return null;
        }

        BinaryTree.Node<V> node = new BinaryTree.Node<>(valueSequence.get(index));
        node.setLeft(createRootNode(valueSequence, 2 * index + 1));
        node.setRight(createRootNode(valueSequence, 2 * index + 2));
        return node;
    }

    /**
     * Note : You may assume that duplicates do not exist in the tree.
     */
    public BinaryTree<V, BinaryTree.Node<V>> createFromPI(V[] preorder, V[]inorder) {
        return new BinaryTree<>(createRootNodeFromPI(preorder, inorder));
    }

    private BinaryTree.Node<V> createRootNodeFromPI(V[] preorder, V[]inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        V rootVal = preorder[0];
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        // pre : rootval -- [left] -- [right]
        // in : [left] -- rootval -- [right]
        BinaryTree.Node<V> node = new BinaryTree.Node<>(rootVal);

        V[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIndex + 1);
        V[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        node.setLeft(createRootNodeFromPI(leftPreorder, leftInorder));

        V[] rightPreorder = Arrays.copyOfRange(preorder, rootIndex + 1, preorder.length);
        V[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        node.setRight(createRootNodeFromPI(rightPreorder, rightInorder));

        return node;
    }

    /**
     * Note : You may assume that duplicates do not exist in the tree.
     */
    public BinaryTree<V, BinaryTree.Node<V>> createFromIP(V[] inorder, V[] postorder) {
        return new BinaryTree<>(createRootNodeFromIP(inorder, postorder));
    }

    private BinaryTree.Node<V> createRootNodeFromIP(V[] inorder, V[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }

        V rootVal = postorder[postorder.length - 1];
        int rootIndex = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }

        BinaryTree.Node<V> root = new BinaryTree.Node<>(rootVal);

        V[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        V[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootIndex);
        root.setLeft(createRootNodeFromIP(leftInorder, leftPostorder));

        V[] rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        V[] rightPostorder = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);
        root.setRight(createRootNodeFromIP(rightInorder, rightPostorder));

        return root;
    }

    public boolean isSameTree(BinaryTree<V, BinaryTree.Node<V>> p, BinaryTree<V, BinaryTree.Node<V>> q) {
        return isSameTree(p.getRoot(), q.getRoot());
    }

    public boolean isSameTree(BinaryTree.Node<V> p, BinaryTree.Node<V> q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        } else if (p.getVal() != q.getVal()) {
            return false;
        }

        if (p.getLeft() == null && p.getRight() == null && q.getLeft() == null
        && q.getRight() == null) {
            return true;
        }

        return isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());
    }

    public boolean isBST(BinaryTree<Integer, BinaryTree.Node<Integer>> tree) {
        List<Integer> nodeValList = new ArrayList<>();
        inOrderTraveral(tree.getRoot(), nodeValList);

        for (int i = 0; i < nodeValList.size() - 1; i++) {
            if (nodeValList.get(i) >= nodeValList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inOrderTraveral(BinaryTree.Node<Integer> root, List<Integer> nodeValList) {
        if (root == null) {
            return;
        }

        inOrderTraveral(root.getLeft(), nodeValList);
        nodeValList.add(root.getVal());
        inOrderTraveral(root.getRight(), nodeValList);
    }

    // note : error implement
    // error case : [10,5,15,null,null,6,20]
    @SuppressWarnings("unused")
    private boolean isBST(BinaryTree.Node<Integer> node) {
        if (node == null) {
            return true;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }

        if (node.getLeft() == null) {
            if (node.getVal() > node.getRight().getVal()) {
                return false;
            } else {
                return isBST(node.getRight());
            }
        } else if (node.getRight() == null) {
            if (node.getVal() < node.getLeft().getVal()) {
                return false;
            } else {
                return isBST(node.getLeft());
            }
        } else {
            if (node.getVal() > node.getRight().getVal() || node.getVal() < node.getLeft().getVal()) {
                return false;
            } else {
                return isBST(node.getLeft()) && isBST(node.getRight());
            }
        }
    }

    public boolean hasPathSum(BinaryTree.Node<Integer> node, int num) {
        return hasPathSum(node, num, 0);
    }

    private boolean hasPathSum(BinaryTree.Node<Integer> node, int sum, int currentSum) {
        if (node == null) {
            return false;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return sum == currentSum + node.getVal();
        }

        return hasPathSum(node.getLeft(), sum, currentSum + node.getVal())
                || hasPathSum(node.getRight(), sum, currentSum + node.getVal());
    }

}
