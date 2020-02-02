package com.lizbyu.lang;

/**
 * basic element node used in ADT
 * @param <V> val type
 */
public class Node<V> {
    private V val;

    public Node(V val) {
        this.val = val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public V getVal() {
        return val;
    }
}