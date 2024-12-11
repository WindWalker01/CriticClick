package org.example.dsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


// Modulo Division Method
// with seperate chaining collision resolution
public class HashMapngGroup1<K, V> {

    public static class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }


    private int size = 7;
    private Node[] dataMap;

    public HashMapngGroup1() {
        dataMap = new Node[size];
    }


    // The hash function
    private int hash(K key){
        return key == null ? 0 : Math.abs(key.hashCode() % size);
    }

    // adds a key value pair in the map
    public void set(K key, V value){
        int index = hash(key);
        Node<K, V> newNode = new Node<>(key, value);

        if (dataMap[index] == null){
            dataMap[index] = newNode;
        }else{
            Node<K, V> temp = dataMap[index];
            while (temp.next != null){
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // returns the value by a specific key in the map
    // if there is a collision this function will return the last value in the linked list
    public V get(K key){
        int index = hash(key);
        Node<K, V> temp = dataMap[index];

        while (temp != null){
            if (temp.key.equals(key) && temp.next == null){
                return temp.value;
            }

            temp = temp.next;
        }

        return null;
    }

    // for debugging purposes only
    // print all the keys and values in the map
    public void printTable() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println("   {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

    // return all the keys in the given map
    public ArrayList keys(){
        ArrayList<K> list = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null){
                list.add((K)temp.key);
                temp = temp.next;
            }
        }
        return list;
    }

    // returns all the values in the given map
    public ArrayList values(){
        ArrayList<V> list = new ArrayList<>();
        for (int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while (temp != null){
                list.add((V)temp.value);
                temp = temp.next;
            }
        }
        return list;
    }

    // returns a set of key value pairs for easy looping through the map
    public Set<Node<K, V>> entrySet(){
        Set<Node<K, V>> set = new HashSet<>();

        // loops through every key value pair and adds it to the set
        for (Node<K, V> temp : dataMap){
            Node<K, V> current = temp;
            while (current != null) {
                set.add(current);
                current = current.next;
            }
        }

        return set;
    }


}
