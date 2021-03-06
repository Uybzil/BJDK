package com.lizbyu.internal.utils;

import com.lizbyu.internal.tree.binary.BinaryTree;
import com.lizbyu.internal.tree.TreeNodeHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeFactoryTest {
    public static final String TAG = "BinaryTreeFactoryTest";
    private BinaryTrees<Integer> binaryTreeFactory;

    @Before
    public void setUp() {
        binaryTreeFactory = new BinaryTrees<>();
    }

    @Test
    public void create() {
        BinaryTree<Integer, BinaryTree.Node<Integer>> integerNodeBinaryTree
                = binaryTreeFactory.create(Arrays.asList(1, 2, 3));
        LogUtils.d(TAG, "level traversal ");
        integerNodeBinaryTree.levelTraversal(new TreeNodeHandler<>());
        LogUtils.d(TAG, "pre order traversal ");
        integerNodeBinaryTree.preorderTraversal(new TreeNodeHandler<>());
        LogUtils.d(TAG, "inorder traversal ");
        integerNodeBinaryTree.inorderTraversal(new TreeNodeHandler<>());
        LogUtils.d(TAG, "post order traversal ");
        integerNodeBinaryTree.postorderTraversal(new TreeNodeHandler<>());
    }
}