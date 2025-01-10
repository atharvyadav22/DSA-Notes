## **Hashing Overview**

Hashing is a technique used to uniquely identify a specific object from a collection of objects. It uses a **hash function** to map data of arbitrary size (like strings or integers) to a fixed size. This is mainly used for data retrieval and ensuring that each data has a unique identifier.

---

## **Common Hashing Structures: HashMap & HashSet**

### **HashMap** (Stores key-value pairs)
- **Key-value** pairs allow fast lookups and insertions based on a key.
- **Methods in HashMap**:  
  A HashMap stores key-value pairs, and you can use these methods to perform various operations.

| **Method**             | **Description**                                                                 | **Example**                                                       | **Time Complexity** | **Space Complexity** |
|------------------------|---------------------------------------------------------------------------------|-------------------------------------------------------------------|---------------------|----------------------|
| `put(key, value)`       | Adds a key-value pair to the map. If the key exists, it updates the value.      | `map.put("name", "Alice");`                                        | O(1)                | O(n)                 |
| `get(key)`              | Returns the value associated with the key. If not found, returns `null`.        | `map.get("name");`  // returns "Alice"                            | O(1)                | O(n)                 |
| `containsKey(key)`      | Checks if the map contains the specified key.                                  | `map.containsKey("name");`                                         | O(1)                | O(n)                 |
| `containsValue(value)`  | Checks if the map contains the specified value.                                | `map.containsValue("Alice");`                                     | O(n)                | O(n)                 |
| `remove(key)`           | Removes the key-value pair from the map based on the key.                       | `map.remove("name");`                                             | O(1)                | O(n)                 |
| `size()`                | Returns the number of key-value pairs in the map.                              | `map.size();`                                                     | O(1)                | O(n)                 |
| `clear()`               | Removes all key-value pairs from the map.                                       | `map.clear();`                                                    | O(n)                | O(n)                 |
| `isEmpty()`             | Checks if the map is empty.                                                    | `map.isEmpty();`                                                  | O(1)                | O(n)                 |
| `keySet()`              | Returns a set view of all keys in the map.                                      | `map.keySet();`                                                   | O(n)                | O(n)                 |
| `values()`              | Returns a collection view of all values in the map.                             | `map.values();`                                                   | O(n)                | O(n)                 |

---

### **HashSet** (Stores only unique values)
- A **HashSet** is a collection of unique elements with no key-value mapping.

| **Method**             | **Description**                                                                 | **Example**                                                       | **Time Complexity** | **Space Complexity** |
|------------------------|---------------------------------------------------------------------------------|-------------------------------------------------------------------|---------------------|----------------------|
| `add(element)`          | Adds an element to the set. If the element already exists, it does nothing.     | `set.add(3);`                                                     | O(1)                | O(n)                 |
| `contains(element)`     | Checks if the set contains the specified element.                              | `set.contains(3);`                                                | O(1)                | O(n)                 |
| `remove(element)`       | Removes the specified element from the set.                                     | `set.remove(3);`                                                  | O(1)                | O(n)                 |
| `size()`                | Returns the number of elements in the set.                                      | `set.size();`                                                     | O(1)                | O(n)                 |
| `clear()`               | Removes all elements from the set.                                             | `set.clear();`                                                    | O(n)                | O(n)                 |
| `isEmpty()`             | Checks if the set is empty.                                                    | `set.isEmpty();`                                                  | O(1)                | O(n)                 |

---

### **HashMap vs HashSet**

| **Feature**            | **HashMap**                       | **HashSet**                      |
|------------------------|-----------------------------------|----------------------------------|
| **Stores**             | Key-value pairs                   | Only unique values               |
| **Main Use**           | Fast key-value pair retrieval     | Checking for uniqueness          |
| **Methods**            | `put()`, `get()`, `remove()`, etc. | `add()`, `contains()`, `remove()`|
| **Time Complexity**    | O(1) for most operations          | O(1) for most operations         |

---

## **Conversion of HashMap to Array**
Sometimes, you may want to convert the contents of a HashMap into an array. Here's how you can do it:

### **Key-Value Pair to Array:**
- Convert keys or values to arrays.

**Code:**
```java
// HashMap to Key Array
Set<String> keys = map.keySet();
String[] keyArray = keys.toArray(new String[0]);

// HashMap to Value Array
Collection<String> values = map.values();
String[] valueArray = values.toArray(new String[0]);
```

### **Time Complexity**:
- **O(n)**: Because we are converting the elements into an array.

### **Space Complexity**:
- **O(n)**: Space required to store the arrays.

---

## **Common Hashing Techniques**

- **Separate Chaining**: 
  - Uses linked lists or other data structures to store elements at the same index.
  - Resolves collisions when two keys hash to the same index.
  
- **Open Addressing**: 
  - Handles collisions by probing for the next available slot in the array.
  - Types of probing:
    - Linear Probing
    - Quadratic Probing
    - Double Hashing

---

## **Common Interview Questions on Hashing**

1. **What is the time complexity of operations in HashMap?**
   - **Answer**: Most operations (`put()`, `get()`, `remove()`) take **O(1)** time on average. However, in the worst case (due to hash collisions), the time complexity can be **O(n)**.

2. **How can you handle collisions in HashMap?**
   - **Answer**: You can handle collisions using techniques like **Separate Chaining** (linked lists at each index) or **Open Addressing** (probing for an empty slot).

3. **What is the difference between HashSet and HashMap?**
   - **Answer**: A **HashMap** stores key-value pairs, while a **HashSet** only stores unique elements without any associated key.

4. **How do you convert a HashMap to a Set or List?**
   - **Answer**: You can convert the keys or values of a HashMap into a Set or List using `keySet()` or `values()`, respectively.

---

## **Time and Space Complexity of Hashing Operations**
- **Insertion (`put()` or `add()`)**:  
  - **Time Complexity**: **O(1)** average, **O(n)** worst case  
  - **Space Complexity**: **O(n)**

- **Search (`get()` or `contains()`)**:  
  - **Time Complexity**: **O(1)** average, **O(n)** worst case  
  - **Space Complexity**: **O(n)**

- **Deletion (`remove()`)**:  
  - **Time Complexity**: **O(1)** average, **O(n)** worst case  
  - **Space Complexity**: **O(n)**

---

These notes should help you quickly understand the key methods and concepts related to **Hashing** and **HashMap/HashSet**.