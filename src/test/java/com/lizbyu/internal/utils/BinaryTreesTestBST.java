package com.lizbyu.internal.utils;

import com.lizbyu.internal.tree.binary.BinarySearchTree;
import com.lizbyu.internal.tree.binary.BinaryTree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreesTestBST {
    private final List<Integer> nodeList;
    private final boolean isBST;

    public BinaryTreesTestBST(List<Integer> nodeList, boolean isBST) {
        this.nodeList = nodeList;
        this.isBST = isBST;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> prepareData() {
        return Arrays.asList(new Object[][]{
                {Collections.singletonList(1), true},
                {Arrays.asList(1, 2, 3, 4, 5, 6), false},
                {Arrays.asList(4, 2, 6, 1, null, null, 7), true},
                {Arrays.asList(10, 5, 15, null, null, 6, 20), false}
        });
    }

    @Test
    public void isBST() {
        BinaryTrees<Integer> binaryTrees = new BinaryTrees<>();
        BinarySearchTree bst = new BinarySearchTree(binaryTrees.create(nodeList).getRoot());
        assertEquals(binaryTrees.isBST(bst), isBST);
    }
}