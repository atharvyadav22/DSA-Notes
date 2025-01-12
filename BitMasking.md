# 📚 **Bit Manipulation Notes with Step-by-Step Examples**  

---
## 🧩 **1. Get ith Bit**  
**Problem:** Find the value of the **ith bit** in a number `n`.  
We use the **AND (`&`)** operator to check if the bit at position `i` is `0` or `1`.

---

### 🧮 **Example: Get 3rd Bit of `n = 13` (Binary: 1101)**  
```
n = 1101  (Binary of 13)
i = 3     (Indexing starts from 0)
```

#### 🔧 **Step 1: Create a mask by left-shifting `1` by `i` positions.**  
```
Mask = 1 << i
Mask = 1 << 3 → 1000
```

#### 🔧 **Step 2: Perform AND operation (n & Mask).**  
```
n     = 1101
Mask  = 1000
--------------
n & Mask = 1000
```

#### 🔍 **Result:**  
Since the result is **non-zero**, the 3rd bit is **1**.

---

### ✅ **Java Code:**
```java
public int getIthBit(int n, int i) {
    int mask = 1 << i;
    return (n & mask) == 0 ? 0 : 1;
}
```

---

## 🧩 **2. Set ith Bit**  
**Problem:** Set the value of the **ith bit** to `1` in a number `n`.  
We use the **OR (`|`)** operator to ensure the bit at position `i` is **1**.

---

### 🧮 **Example: Set 1st Bit of `n = 13` (Binary: 1101)**  
```
n = 1101  (Binary of 13)
i = 1     (Indexing starts from 0)
```

#### 🔧 **Step 1: Create a mask by left-shifting `1` by `i` positions.**  
```
Mask = 1 << i
Mask = 1 << 1 → 0010
```

#### 🔧 **Step 2: Perform OR operation (n | Mask).**  
```
n     = 1101
Mask  = 0010
--------------
n | Mask = 1111
```

#### 🔍 **Result:**  
New number after setting the 1st bit: **15 (Binary: 1111)**.

---

### ✅ **Java Code:**
```java
public int setIthBit(int n, int i) {
    int mask = 1 << i;
    return n | mask;
}
```

---

## 🧩 **3. Clear ith Bit**  
**Problem:** Clear (set to `0`) the **ith bit** in a number `n`.  
We use the **AND (`&`)** operator with a **negated mask**.

---

### 🧮 **Example: Clear 2nd Bit of `n = 13` (Binary: 1101)**  
```
n = 1101  (Binary of 13)
i = 2     (Indexing starts from 0)
```

#### 🔧 **Step 1: Create a mask by left-shifting `1` by `i` positions.**  
```
Mask = 1 << i
Mask = 1 << 2 → 0100
```

#### 🔧 **Step 2: Negate the mask using `~`.**  
```
Mask  = 0100
~Mask = 1011
```

#### 🔧 **Step 3: Perform AND operation (n & ~Mask).**  
```
n     = 1101
~Mask = 1011
--------------
n & ~Mask = 1001
```

#### 🔍 **Result:**  
New number after clearing the 2nd bit: **9 (Binary: 1001)**.

---

### ✅ **Java Code:**
```java
public int clearIthBit(int n, int i) {
    int mask = ~(1 << i);
    return n & mask;
}
```

---

## 🧩 **4. Update ith Bit**  
**Problem:** Update the **ith bit** to a specific value (`0` or `1`).  
We first **clear** the bit and then **set** it to the new value.

---

### 🧮 **Example: Update 2nd Bit of `n = 13` (Binary: 1101) to `0`.**  
```
n = 1101  (Binary of 13)
i = 2     (Indexing starts from 0)
value = 0
```

#### 🔧 **Step 1: Clear the 2nd bit.**  
```
n     = 1101
~Mask = 1011
--------------
n & ~Mask = 1001
```

#### 🔧 **Step 2: Create a mask for the new value.**  
```
New value = 0 << 2 → 0000
```

#### 🔧 **Step 3: Perform OR operation (n | new value).**  
```
n     = 1001
NewVal = 0000
--------------
n | NewVal = 1001
```

#### 🔍 **Result:**  
New number after updating the 2nd bit to `0`: **9 (Binary: 1001)**.

---

### ✅ **Java Code:**
```java
public int updateIthBit(int n, int i, int value) {
    int mask = ~(1 << i);
    n = n & mask; // Clear the ith bit
    return n | (value << i); // Set the new bit
}
```
---

## 🧩 **5. Clear the ith Bit**  
This operation sets the **ith bit** of a number to **0**, leaving other bits unchanged.

### ✅ **Formula:**
```
Mask = ~(1 << i)
n = n & Mask
```

---

### 🔧 **Java Code:**
```java
public int clearIthBit(int n, int i) {
    int mask = ~(1 << i);  // Create a mask with 0 at ith position
    return n & mask;       // Clear the ith bit
}
```

---

### 🧮 **Example:**

```
n = 13 (Binary: 1101)
i = 2

Step 1: 1 << 2 = 0100
Step 2: ~0100 = 1011
Step 3: 1101 & 1011 = 1001

Result: 1001 (Decimal: 9)
```

---

## 🧩 **6. Clear Bits from ith to jth Position (Range)**  
This operation clears all bits between **i** and **j** (both inclusive) to **0**.

---

### ✅ **Formula:**
```
LeftMask = (~0) << (j + 1)         // Mask for clearing bits from j+1 to left
RightMask = (1 << i) - 1           // Mask for clearing bits from 0 to i-1
Mask = LeftMask | RightMask        // Combine both masks
n = n & Mask                       // Clear the range
```

---

### 🔧 **Java Code:**
```java
public int clearBitsInRange(int n, int i, int j) {
    int leftMask = (~0) << (j + 1);      // Mask for left part
    int rightMask = (1 << i) - 1;        // Mask for right part
    int mask = leftMask | rightMask;     // Combine both masks
    return n & mask;                     // Clear the bits in the range
}
```

---

### 🧮 **Example:**
```
n = 255 (Binary: 11111111)
i = 2, j = 5

Step 1: LeftMask = (~0) << (5 + 1) = 11000000
Step 2: RightMask = (1 << 2) - 1 = 00000011
Step 3: Mask = 11000000 | 00000011 = 11000011
Step 4: n & Mask = 11111111 & 11000011 = 11000011

Result: 195 (Binary: 11000011)
```

---
