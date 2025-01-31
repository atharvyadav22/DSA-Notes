
# Mood Streaks Explained: Kadane's, Prefix Sum, and Sliding Window

## **Introduction**
We’ll analyze the mood streak problem using three approaches:
1. **Kadane's Algorithm**: Finds the best overall streak (any length).
2. **Prefix Sum**: Calculates the sum between any two specific days.
3. **Sliding Window**: Finds the best streak for a fixed length.

---

## Example Problem
Given the mood points for the week:  
`moods = [4, -2, 1, 3, -5, 6, -1]`

We want to solve:
1. **Max mood streak overall.**  
2. **Max mood streak for exactly 3 days.**

---

## **Kadane's Algorithm**  
**Use When**: You want the best overall streak, regardless of length.

### **Code with Initial and Final Array States**:
```java
// Input array: [4, -2, 1, 3, -5, 6, -1]
int maxMood = Integer.MIN_VALUE;
int currentMood = 0;

for (int mood : moods) {
    currentMood += mood;
    maxMood = Math.max(maxMood, currentMood);

    // Visual: Show how currentMood and maxMood update
    System.out.println("Mood: " + mood + ", Current Mood: " + currentMood + ", Max Mood: " + maxMood);

    if (currentMood < 0) {
        currentMood = 0;  // Reset if mood goes negative
    }
}
// Output: Max Mood Streak = 7
```

### **Visual Walkthrough**:
| Step | Mood | Current Mood | Max Mood |
|------|------|--------------|----------|
| 1    | 4    | 4            | 4        |
| 2    | -2   | 2            | 4        |
| 3    | 1    | 3            | 4        |
| 4    | 3    | 6            | 6        |
| 5    | -5   | 1            | 6        |
| 6    | 6    | 7            | 7        |
| 7    | -1   | 6            | 7        |

### **Final Array State**:  
`Max Mood Streak = 7`

---

## **Prefix Sum**  
**Use When**: You need the sum between any two days.

### **Code with Initial and Final Array States**:

```java
public class PrefixSumInPlace {
    public static void main(String[] args) {
        // Initial Array
        int[] array = {4, -2, 5, 1, -3, 7};

        // Calculate prefix sum in-place
        for (int i = 1; i < array.length; i++) {
            array[i] += array[i - 1];  // Add the previous prefix to the current element
        }

        // Print the final modified array
        System.out.println("Final Prefix Array: " + java.util.Arrays.toString(array));
    }
}
```
### **Final Array State**:  
`Prefix Sum Array = [4, 2, 3, 6, 1, 7, 6]`  

---

## **Sliding Window**  
**Use When**: You want the best streak for a fixed length.

### **Code with Initial and Final Array States**:
```java
// Input array: [4, -2, 1, 3, -5, 6, -1]
int k = 3;
int windowSum = 0;

// Initial window
for (int i = 0; i < k; i++) {
    windowSum += moods[i];
}
System.out.println("Initial Window Sum = " + windowSum);

int maxSum = windowSum;

// Slide the window
for (int i = k; i < moods.length; i++) {
    windowSum += moods[i] - moods[i - k];
    maxSum = Math.max(maxSum, windowSum);
    System.out.println("Window Sum after sliding: " + windowSum);
}

// Output: Max Sum for 3-day streak = 4
```

### **Visual Walkthrough**:
| Step | Window Position | Window Sum | Max Sum |
|------|-----------------|------------|---------|
| 1    | [4, -2, 1]      | 3          | 3       |
| 2    | [-2, 1, 3]      | 2          | 3       |
| 3    | [1, 3, -5]      | -1         | 3       |
| 4    | [3, -5, 6]      | 4          | 4       |
| 5    | [-5, 6, -1]     | 0          | 4       |

### **Final Array State**:  
`Max Sum for 3-day streak = 4`

---

## Summary Table
| **Approach**        | **Use Case**                                       | **Result**                | **Time Complexity** | **Space Complexity** |
|---------------------|----------------------------------------------------|---------------------------|---------------------|---------------------|
| **Kadane's**        | Best overall streak (any length)                   | `[4, -2, 1, 3]` → **6**   | O(n)                | O(1)                |
| **Prefix Sum**      | Sum between any two specific days                  | Subarray `[1, 3, -5]` → **-1** | O(n^2)              | O(n)                |
| **Sliding Window**  | Best fixed-length streak                           | 3-day streak → **4**      | O(n)                | O(1)                |

---

## **When to Use What?**
- **Kadane's Algorithm**: Use for finding the maximum subarray sum in a single pass.
- **Prefix Sum**: Use when you need to calculate sums between any two indices multiple times.
- **Sliding Window**: Use when looking for the best subarray sum of a fixed size.

---

## **Final Thoughts**  
Mastering these three approaches will give you the tools to tackle most subarray-related problems in interviews!
