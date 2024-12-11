package org.example.dsa;

public class MovieMap<K, V> {

    private class Node<K, V>{
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

    public MovieMap() {
        dataMap = new Node[size];
    }

    private int hash(K key){
        return key == null ? 0 : Math.abs(key.hashCode() % size);
    }

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

    public V get(K key){
        int index = hash(key);
        Node<K, V> temp = dataMap[index];

        while (temp != null){
            if (temp.key.equals(key)){
                return temp.value;
            }

            temp = temp.next;
        }

        return null;
    }

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


}
