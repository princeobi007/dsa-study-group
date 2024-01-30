package com.tree;


import java.util.*;

public class Trees {

    StringNode root = new StringNode("a");
    StringNode b = new StringNode("b");
    StringNode c = new StringNode("c");
    StringNode d = new StringNode("d");
    StringNode e = new StringNode("e");
    StringNode f = new StringNode("f");

    private void initialiseTree(){
        root.setLeft(b);
        root.setRight(c);
        b.setLeft(d);
        b.setRight(e);
        c.setRight(f);
    }

    public static void main(String[] args) {
        Trees trees = new Trees();
        trees.initialiseTree();

        final var arr = iterativeDepthFirstSearch(trees.root);

        for(String s: arr){
            System.out.println(s);
        }

        System.out.println("==============");

        final var rarr = recursiveDepthFirstValue(trees.root);

        for(String s: rarr){
            System.out.println(s);
        }

        System.out.println("=========================================");
        System.out.println("     BFS");
        System.out.println("==========================================");


        final var bArr = iterativeBreadthFirstSearch(trees.root);

        for (String s: bArr){
            System.out.println(s);
        }

        System.out.println("==============");

        System.out.println("j is in tree: "+iterativeDepthFirstSearch(trees.root,"j"));
        System.out.println("c is in tree: "+iterativeDepthFirstSearch(trees.root,"c"));

        System.out.println("j is in tree: "+recursiveDepthFirstValue(trees.root,"j"));
        System.out.println("c is in tree: "+recursiveDepthFirstValue(trees.root,"c"));

    }

    private static String[] iterativeDepthFirstSearch(StringNode root){
        if(root == null){
            return new String[]{};
        }

        Deque<StringNode> stringNodeStack = new ArrayDeque<>();
        stringNodeStack.push(root);

        List<String> result = new ArrayList<>();
        while(!stringNodeStack.isEmpty()){
            StringNode currentStringNode = stringNodeStack.pop();

            result.add(currentStringNode.value);

            if(currentStringNode.getRight() != null){
                stringNodeStack.push(currentStringNode.getRight());
            }

            if(currentStringNode.getLeft()  != null){
                stringNodeStack.push(currentStringNode.getLeft());
            }
        }
        return result.toArray(new String[0]);
    }

    private static boolean iterativeDepthFirstSearch(StringNode root, String element){
        if(root == null){
            return false;
        }

        Deque<StringNode> stringNodeStack = new ArrayDeque<>();
        stringNodeStack.push(root);

        boolean elementFound = false;

        while(!stringNodeStack.isEmpty()){
            StringNode currentStringNode = stringNodeStack.pop();

            if(currentStringNode.value.equalsIgnoreCase(element)){
                elementFound = true;
                break;
            }

            if(currentStringNode.getRight() != null){
                stringNodeStack.push(currentStringNode.getRight());
            }

            if(currentStringNode.getLeft()  != null){
                stringNodeStack.push(currentStringNode.getLeft());
            }
        }
        return elementFound;
    }

    private static String[] iterativeBreadthFirstSearch(StringNode root){
        if(root == null){
            return new String[] {};
        }

        Queue<StringNode> stringNodeQueue = new LinkedList<>();
        stringNodeQueue.add(root);
        List<String> result = new ArrayList<>();

        while (!stringNodeQueue.isEmpty()){
            StringNode currentStringNode = stringNodeQueue.remove();

            result.add(currentStringNode.value);

            if(currentStringNode.getLeft() != null){
                stringNodeQueue.add(currentStringNode.getLeft());
            }

            if(currentStringNode.getRight() != null){
                stringNodeQueue.add(currentStringNode.getRight());
            }
        }

        return result.toArray(new String[0]);


    }

    private static String [] recursiveDepthFirstValue(StringNode root){
        if(root == null){
            return new String[]{};
        }

        final var leftValues = recursiveDepthFirstValue(root.left);
        final var rightValues = recursiveDepthFirstValue(root.right);

        List<String> stringList = new ArrayList<>();

        stringList.add(root.value);
        stringList.addAll(Arrays.stream(leftValues).toList());
        stringList.addAll(Arrays.stream(rightValues).toList());

        return stringList.toArray(new String[0]);

    }

    private static boolean recursiveDepthFirstValue(StringNode root, String element){
        if(root == null){
            return false;
        }

        if(root.value.equalsIgnoreCase(element)){
            return true;
        }

        final var leftValues = recursiveDepthFirstValue(root.left,element);
        final var rightValues = recursiveDepthFirstValue(root.right,element);

        return leftValues || rightValues;

    }

}


