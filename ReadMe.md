# ADT Specification, Representation, and Implementation

## Abstract Data Type (ADT) Specification
The `HashMapngGroup1<K, V>` class represents a hash map, which is a collection of key-value pairs where each key is unique. The primary operations supported by this hash map include:

1. **Insert (Set)**: Add a key-value pair to the map. If a key already exists, it appends the new value at the collision point (in this case, as part of a linked list).
2. **Retrieve (Get)**: Retrieve the value associated with a specific key.
3. **Utility Operations**:
    - `keys()`: Retrieve a list of all keys.
    - `values()`: Retrieve a list of all values.
    - `entrySet()`: Retrieve all key-value pairs as a set.
    - `printTable()`: Debugging utility to print the internal structure of the map.

### Functional Specification
- **Domain**:
    - `Key (K)`: Any object that can generate a valid hash code (e.g., `String`, `Integer`, etc.).
    - `Value (V)`: Any object.
- **Operations**:
    - `set(K key, V value)`: Adds or updates the value for a key.
    - `get(K key)`: Retrieves the value for the key, or `null` if the key is not present.
    - `keys()`: Returns a list of all keys in the map.
    - `values()`: Returns a list of all values in the map.
    - `entrySet()`: Returns a `Set` of all key-value pairs.
    - `printTable()`: Prints the internal hash table representation.

---

## Representation
### Data Structure Representation
The `HashMapngGroup1` is implemented using **separate chaining** for collision resolution. The core components include:

1. **Hash Table Array**:
    - A fixed-size array (`dataMap`) is used as the primary storage. The size of the array is set to 7 by default.

2. **Nodes**:
    - Each entry in the array is a linked list of `Node<K, V>` objects. Each node contains:
        - `key`: The key of the key-value pair.
        - `value`: The value of the key-value pair.
        - `next`: A pointer to the next node in the chain (used in case of collisions).

3. **Hash Function**:
    - `hash(K key)`: Computes the index for a given key using `key.hashCode() % size`.
    - Ensures that keys are evenly distributed across the array indices.

---

## Implementation
### 1. **Hash Function**
The `hash()` method ensures that each key maps to an index within the bounds of the `dataMap` array. It accounts for null keys and negative hash codes:
```java
private int hash(K key){
    return key == null ? 0 : Math.abs(key.hashCode() % size);
}
```

### 2. **Set Operation**
Adds a new key-value pair to the map. If a collision occurs, it appends the new pair at the end of the linked list at the computed index:
```java
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
```

### 3. **Get Operation**
Retrieves the value associated with a key by traversing the linked list at the computed index:
```java
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
```

### 4. **Keys and Values Retrieval**
- `keys()`: Iterates over all linked lists in the hash table and collects all keys:
```java
public ArrayList<K> keys(){
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
```

- `values()`: Similar to `keys()` but collects all values:
```java
public ArrayList<V> values(){
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
```

### 5. **Entry Set**
Creates a `Set` of all key-value pairs by iterating through all linked lists:
```java
public Set<Node<K, V>> entrySet(){
    Set<Node<K, V>> set = new HashSet<>();

    for (Node<K, V> temp : dataMap){
        Node<K, V> current = temp;
        while (current != null) {
            set.add(current);
            current = current.next;
        }
    }

    return set;
}
```

---

## Summary
This implementation of a hash map is a basic demonstration of the **Modulo Division Method** for hashing and **separate chaining** for collision resolution. While functional, it lacks features like dynamic resizing, handling of duplicate keys, or advanced hashing strategies. However, it successfully adheres to the fundamental principles of the hash map ADT and provides an excellent learning base for custom hash map implementations.

