package com.lizbyu.util;

import com.lizbyu.tree.BinaryTree;
import com.lizbyu.tree.TreeNodeHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BinaryTreeFactoryTest {
    public static final String TAG = "BinaryTreeFactoryTest";
    private BinaryTreeUtils<Integer> binaryTreeFactory;

    @Before
    public void setUp() throws Exception {
        binaryTreeFactory = new BinaryTreeUtils<>();
    }

    @Test
    public void create() {
        BinaryTree<Integer, BinaryTree.Node<Integer>> integerNodeBinaryTree
                = binaryTreeFactory.create(Arrays.asList(1, 2, 3));
        LogUtils.d(TAG, "level traversal ");
        integerNodeBinaryTree.levelTraversal(new TreeNodeHandler());
        LogUtils.d(TAG, "pre order traversal ");
        integerNodeBinaryTree.preorderTraversal(new TreeNodeHandler());
        LogUtils.d(TAG, "inorder traversal ");
        integerNodeBinaryTree.inorderTraversal(new TreeNodeHandler());
        LogUtils.d(TAG, "post order traversal ");
        integerNodeBinaryTree.postorderTraversal(new TreeNodeHandler());
    }
}