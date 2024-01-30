package com.tree;

public class IntegerNode {

    int value;
    IntegerNode left;
    IntegerNode right;

    public IntegerNode(int value){
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public IntegerNode getLeft() {
        return left;
    }

    public void setLeft(IntegerNode left) {
        this.left = left;
    }

    public IntegerNode getRight() {
        return right;
    }

    public void setRight(IntegerNode right) {
        this.right = right;
    }
}
