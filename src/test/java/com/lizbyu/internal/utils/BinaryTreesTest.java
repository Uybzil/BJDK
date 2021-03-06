package com.lizbyu.internal.utils;

import com.lizbyu.internal.tree.binary.BinaryTree;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BinaryTreesTest {
    private BinaryTrees<Integer> binaryTrees;
    private final List<Integer> list;

    public BinaryTreesTest(List<Integer> list) {
        this.list = list;
    }

    @Parameterized.Parameters(name = "{index} : {0}")
    public static Collection<Object[]> preparedData() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1, 2, 3, 4, 5)},
                {Arrays.asList(3, null, 3, 4, 5)},
                {Arrays.asList(15, 2, 3, null, 5)},
                {Arrays.asList(1, 22, null, 34, 5)}
        });
    }

    @Before
    public void setUp() {
        binaryTrees = new BinaryTrees<>();
    }

    @Test
    public void isSameTree() {
        BinaryTree<Integer, BinaryTree.Node<Integer>> tree0 = binaryTrees.create(list);
        BinaryTree<Integer, BinaryTree.Node<Integer>> tree1 = binaryTrees.create(list);
        assertTrue(binaryTrees.isSameTree(tree0.getRoot(), tree1.getRoot()));
    }
}