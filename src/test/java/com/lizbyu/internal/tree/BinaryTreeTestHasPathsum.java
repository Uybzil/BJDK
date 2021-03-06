package com.lizbyu.internal.tree;

import com.lizbyu.internal.tree.binary.BinaryTree;
import com.lizbyu.internal.utils.BinaryTrees;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreeTestHasPathsum {
    private final List<Integer> nodeList;
    private final int sum;
    private final boolean res;

    private BinaryTrees<Integer> binaryTrees;

    public BinaryTreeTestHasPathsum(List<Integer> nodeList, int sum, boolean res) {
        this.nodeList = nodeList;
        this.sum = sum;
        this.res = res;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> perpareData() {
        return Arrays.asList(new Object[][] {
                {Collections.singletonList(1), 1, true},
                {Arrays.asList(1, 2), 1, false},
                {Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1), 22, true},
                {Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1), 21, false},
                {Arrays.asList(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1), 18, true}
        });
    }

    @Before
    public void setUp() {
        binaryTrees = new BinaryTrees<>();
    }

    @Test
    public void hasPathSum() {
        BinaryTree<Integer, BinaryTree.Node<Integer>> tree = binaryTrees.create(nodeList);
        assertEquals(binaryTrees.hasPathSum(tree.getRoot(), sum), res);
    }
}