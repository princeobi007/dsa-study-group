package com.tree;

public class StringNode {
    String value;
    StringNode left;
    StringNode right;

    public StringNode(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StringNode getLeft() {
        return left;
    }

    public void setLeft(StringNode left) {
        this.left = left;
    }

    public StringNode getRight() {
        return right;
    }

    public void setRight(StringNode right) {
        this.right = right;
    }
}
