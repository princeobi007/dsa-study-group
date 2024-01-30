package com.tree;

public class MaxRootToLeaf {

    IntegerNode root = new IntegerNode(5);
    IntegerNode elevenNode = new IntegerNode(11);
    IntegerNode threeNode = new IntegerNode(3);
    IntegerNode fourNode = new IntegerNode(4);
    IntegerNode twoNode = new IntegerNode(2);
    IntegerNode oneNode = new IntegerNode(1);

    private void initialiseTree(){
        root.setLeft(elevenNode);
        root.setRight(threeNode);
        elevenNode.setLeft(fourNode);
        elevenNode.setRight(twoNode);
        threeNode.setRight(oneNode);
    }

    public MaxRootToLeaf(){
        initialiseTree();
    }

    private int recursiveMaxRootToTree(IntegerNode node){
        if(node == null){
            return Integer.MIN_VALUE;
        }

        if(node.left == null && node.right == null){
            return node.value;
        }

        int maxValue = Math.max(recursiveMaxRootToTree(node.left),recursiveMaxRootToTree(node.right));

        return maxValue+node.value;
    }

    public static void main(String[] args) {
        MaxRootToLeaf maxRootToLeaf = new MaxRootToLeaf();
        System.out.println("max to root: "+maxRootToLeaf.recursiveMaxRootToTree(maxRootToLeaf.root));

        System.out.printf("Factorial = %d",maxRootToLeaf.factorial(5));
    }

    private int factorial(int num){
        if(num == 0){
            return 1;
        }

        return num * factorial(num-1);
    }

}
