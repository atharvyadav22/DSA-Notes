# ⊕ Operation (Exclusive OR)

## **Concept of ⊕**
- **⊕** (Exclusive OR) is a bitwise operation that returns `1` when the bits being compared are **different**, and `0` when they are **the same**.
- The **⊕ operation** is represented by the symbol `⊕` or `^` in most programming languages.

### **Properties of ⊕**
1. **Commutative**: `A ⊕ B = B ⊕ A`
2. **Associative**: `(A ⊕ B) ⊕ C = A ⊕ (B ⊕ C)`
3. **Identity**: `A ⊕ 0 = A`
4. **Self-Canceling**: `A ⊕ A = 0`
5. **Involution**: `(A ⊕ B) ⊕ B = A`

---

## **Truth Table of ⊕**

| A  | B  | A ⊕ B |
|----|----|-------|
| 0  | 0  | 0     |
| 0  | 1  | 1     |
| 1  | 0  | 1     |
| 1  | 1  | 0     |

- **1 ⊕ 1** = 0 (Same bits cancel each other)
- **1 ⊕ 0** = 1 (Different bits return 1)
- **0 ⊕ 1** = 1 (Different bits return 1)
- **0 ⊕ 0** = 0 (Same bits cancel each other)

---

## **Boolean Formula for XOR**

The ⊕ operation can also be written using the following Boolean formula:
- `A ⊕ B = A'B + AB'`
    - **A'** is the complement of **A**.
    - **B'** is the complement of **B**.
    - **A'B** and **AB'** are the two terms where **A** and **B** are different.

---

## **Step-by-Step XOR Calculation Example:**

### Example: `15 ⊕ 10`

1. **Convert to binary**:
   - 15 = `1111`
   - 10 = `1010`

2. **Perform XOR**:

**Result**: `15 ⊕ 10 = 5`

---

## **Useful XOR Tricks**

### **1. Swap Two Numbers Using XOR:**

You can swap two numbers without using a temporary variable:

```
a = a ^ b
b = a ^ b
a = a ^ b

a = a ^ b  => a = 5 ^ 7 = 2
b = a ^ b  => b = 2 ^ 7 = 5
a = a ^ b  => a = 2 ^ 5 = 7
```

# Questions Related to XOR

## 1. **Finding the Single Non-Repeating Element**
- **Hint:** XOR all elements together. The result will be the element that appears only once.

## 2. **Finding Two Non-Repeating Elements**
- **Hint:** XOR all elements together. Use the rightmost set bit to separate the two unique numbers.

## 3. **Swapping Two Numbers**
- **Hint:** Use XOR to swap values without a temporary variable. `a = a ^ b; b = a ^ b; a = a ^ b;`

## 4. **Checking if a Number is a Power of Two**
- **Hint:** If a number `n` is a power of two, `n & (n - 1)` will be `0`.

## 5. **Finding the Odd Occurring Number in an Array**
- **Hint:** XOR all elements together. The result will be the element with odd occurrences.

## 6. **XOR as a Parity Check**
- **Hint:** XOR all bits of a number. If the result is `1`, it's odd parity; `0` means even parity.

## 7. **XOR for Range Queries**
- **Hint:** Use a prefix XOR array to compute the XOR of any subarray efficiently.

## 8. **Finding Missing Number in Sequence**
- **Hint:** XOR all numbers from `1` to `n` and XOR all elements in the array. The result will be the missing number.
