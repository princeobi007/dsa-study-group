package com.tree;

public class TreeMinValue {

    IntegerNode rootNode = new IntegerNode(5);
    IntegerNode elevenNode = new IntegerNode(11);
    IntegerNode fourNode = new IntegerNode(4);
    IntegerNode fifteenNode = new IntegerNode(15);
    IntegerNode threeNode = new IntegerNode(3);
    IntegerNode twelveNode = new IntegerNode(12);

    Integer min = Integer.MAX_VALUE;

    private void initialiseTree(){
        rootNode.setLeft(elevenNode);
        rootNode.setRight(threeNode);
        elevenNode.setLeft(fourNode);
        elevenNode.setRight(fifteenNode);
        threeNode.setRight(twelveNode);
    }

    public TreeMinValue(){
        initialiseTree();
    }

    private int recursiveDfvMinValue(IntegerNode node){
        if(node == null){
            return Integer.MAX_VALUE;
        }

        int leftMin = Math.min(recursiveDfvMinValue(node.left),min);
        int rightMin = Math.min(recursiveDfvMinValue(node.right), min);

        int minLeftOrRight = Math.min(leftMin,rightMin);

        return Math.min(node.value, minLeftOrRight);
    }

    public static void main(String[] args) {
       final var tree = new TreeMinValue();
        System.out.println("Min of tree is: "+ tree.recursiveDfvMinValue(tree.rootNode));
    }

}
