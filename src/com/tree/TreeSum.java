package com.tree;

import java.util.*;

public class TreeSum {
    IntegerNode rootNode = new IntegerNode(3);
    IntegerNode elevenNode = new IntegerNode(11);
    IntegerNode fourNode = new IntegerNode(4);
    IntegerNode fourLNode = new IntegerNode(4);
    IntegerNode twoNode = new IntegerNode(2);
    IntegerNode oneNode = new IntegerNode(1);

    public TreeSum(){
        initialiseTree();
    }

    private void initialiseTree(){
        rootNode.setLeft(elevenNode);
        rootNode.setRight(fourNode);
        elevenNode.setLeft(fourLNode);
        elevenNode.setRight(twoNode);
        fourNode.setRight(oneNode);
    }

    private int recursiveDfvSum(IntegerNode node){
        if(node == null){
            return 0;
        }
        return node.value + recursiveDfvSum(node.left) + recursiveDfvSum(node.right);
    }

    private int iterativeBfvSum(IntegerNode node){
        if (node == null){
            return 0;
        }

        Queue<IntegerNode> integerNodeQueue = new LinkedList<>();
        integerNodeQueue.add(node);

        int sum = 0;

        while (!integerNodeQueue.isEmpty()){
            IntegerNode currentIntegerNode = integerNodeQueue.remove();

            sum += currentIntegerNode.value;

            if(currentIntegerNode.getLeft() != null){
                integerNodeQueue.add(currentIntegerNode.getLeft());
            }

            if(currentIntegerNode.getRight() != null){
                integerNodeQueue.add(currentIntegerNode.getRight());
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeSum treeSum = new TreeSum();
        System.out.println("DFV: "+treeSum.recursiveDfvSum(treeSum.rootNode));
        System.out.println("BFV: "+treeSum.iterativeBfvSum(treeSum.rootNode));
    }
}
