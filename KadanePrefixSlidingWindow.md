
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

## 1⃣ **Kadane's Algorithm**  
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
// Output: Max Mood Streak = 6
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
`Max Mood Streak = 6`

---

## 2⃣ **Prefix Sum**  
**Use When**: You need the sum between any two days.

### **Code with Initial and Final Array States**:
```java
// Input array: [4, -2, 1, 3, -5, 6, -1]
int[] prefixSum = new int[moods.length];
prefixSum[0] = moods[0];

for (int i = 1; i < moods.length; i++) {
    prefixSum[i] = prefixSum[i - 1] + moods[i];
    System.out.println("Prefix Sum [" + i + "] = " + prefixSum[i]);
}

// Calculating max sum using prefix sum
int maxSum = Integer.MIN_VALUE;
for (int start = 0; start < moods.length; start++) {
    for (int end = start; end < moods.length; end++) {
        int sum = start == 0 ? prefixSum[end] : prefixSum[end] - prefixSum[start - 1];
        maxSum = Math.max(maxSum, sum);
    }
}
System.out.println("Max Sum = " + maxSum);
```

### **Visual Walkthrough**:
| Step | Prefix Sum Array |
|------|------------------|
| 1    | [4]              |
| 2    | [4, 2]           |
| 3    | [4, 2, 3]        |
| 4    | [4, 2, 3, 6]     |
| 5    | [4, 2, 3, 6, 1]  |
| 6    | [4, 2, 3, 6, 1, 7] |
| 7    | [4, 2, 3, 6, 1, 7, 6] |

### **Final Array State**:  
`Prefix Sum Array = [4, 2, 3, 6, 1, 7, 6]`  
`Max Sum = 7`

---

## 3⃣ **Sliding Window**  
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
