package main.java.amz;

import java.util.Stack;

public class SumOf2LinkedList {
    static class Node {
        int value;
        Node next;
        Node(int val) {
            this.value = val;
        }
    }
    public static void main(String[] args) {

        int[] arr1 = {1,2,5,9};
        int[] arr2 = {2, 8, 8, 1, 7};
        Node n1 = construct(arr1);
        Node n2 = construct(arr2);
        print(n1);
        print(n2);
        print(sum(n1, n2));
    }
    private static Node construct(int[] vals) {
        Node head = new Node(vals[0]);
        Node cursor = head;
        for (int i = 1; i < vals.length; i++) {
            cursor.next = new Node(vals[i]);
            cursor =  cursor.next;
        }
        return head;
    }

    private static void print(Node n) {
        while (n != null) {
            System.out.print(n.value);
            n = n.next;
        }
        System.out.println();
    }

    private static Node sum(Node n1, Node n2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (n1 != null) {
            s1.push(n1.value);
            n1 = n1.next;
        }
        while (n2 != null) {
            s2.push(n2.value);
            n2 = n2.next;
        }
        int redundant = 0;
        Node lastNode = null;
        while (!(s2.isEmpty() && s1.isEmpty())) {
            int v1 = s1.isEmpty() ? 0 : s1.pop();
            int v2 = s2.isEmpty() ? 0 : s2.pop();
            int value;
            if (v1 + v2 + redundant>= 10) {
                value = v1 + v2 + redundant - 10;
                redundant = 1;
            } else {
                value = v1 + v2 + redundant;
                redundant = 0;
            }
            Node node = new Node(value);
            node.next = lastNode;
            lastNode = node;

        }

        return lastNode;
    }


}
