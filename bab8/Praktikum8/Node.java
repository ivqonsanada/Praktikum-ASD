/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Praktikum8;

/**
 *
 * @author rockwell
 */
public class Node {

    Object data;
    Node next,prev;

    Node(Object object) {
        this(object, null);
    }

    Node(Object object, Node node) {
        data = object;
        next = node;
    }

    Object getObject() {
        return data;
    }

    Node getNext() {
        return next;
    }
    Node getPrev(){
        return prev;
    }
}
