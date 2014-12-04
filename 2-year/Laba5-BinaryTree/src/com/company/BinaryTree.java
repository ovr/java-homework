package com.company;

import com.sun.istack.internal.Nullable;

/**
 * Created by ovr on 04.12.14.
 */
public class BinaryTree {
    public static class Node {
        private Object item;
        private Node left = null;
        private Node right = null;

        public Node(Object item) {
            this.item = item;
        }

        public Node(Object item, Node left, Node right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }

        public Node(Object item, Node left) {
            this.item = item;
            this.left = left;
        }

        public Node left() {
            return this.left;
        }

        public Node right() {
            return this.right;
        }
    }

    protected Node root = null;

    public Node getRoot() {
        return root;
    }

    public BinaryTree() {
        this.root = new Node("root");
    }

    public void addNodeToLeft(Node sourceNode) {
        sourceNode.left = new Node("left");
    }

    public void addNodeToRight(Node sourceNode) {
        sourceNode.right = new Node("right");
    }

    public int height() {
        return height(this.root);
    }

    @Nullable
    public int height(Node node) {
        if (node == null) {
            return 0;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
