package com.company;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addNodeToLeft(tree.getRoot());
        tree.addNodeToRight(tree.getRoot());

        tree.addNodeToLeft(tree.getRoot().left());
        tree.addNodeToRight(tree.getRoot().right());

        tree.addNodeToRight(tree.getRoot().left());
        tree.addNodeToLeft(tree.getRoot().right());

        tree.addNodeToRight(tree.getRoot().right().right());

        System.out.println("Height " + tree.height());

        tree.addNodeToRight(tree.getRoot().right().right().right());
        tree.addNodeToRight(tree.getRoot().right().right().right().right());
        tree.addNodeToRight(tree.getRoot().right().right().right().right().right());
        tree.addNodeToRight(tree.getRoot().right().right().right().right().right().right());
        tree.addNodeToRight(tree.getRoot().right().right().right().right().right().right().right());

        System.out.println("Height " + tree.height());
    }
}
