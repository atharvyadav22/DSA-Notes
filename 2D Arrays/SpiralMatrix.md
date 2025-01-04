
# **Spiral Matrix Traversal & Generation**

## **Concept**
- **Spiral Matrix Traversal**: Visit all elements of a matrix in a spiral order starting from the top-left corner.
- **Spiral Matrix Generation**: Given an integer `n`, generate an `n x n` matrix filled with elements from 1 to \( n^2 \) in spiral order.

---

## **Theory for Interview**
- Spiral traversal involves iterating over layers of the matrix from the outermost to the innermost, adjusting traversal direction (right, down, left, up) at each boundary.
- Spiral generation builds the matrix layer by layer, filling elements sequentially while adjusting boundaries dynamically.

---

## **Initial Diagram**  

### For Spiral Traversal
**Matrix**:
```
1  2  3  
4  5  6  
7  8  9  
```
**Traversal Order**:  
Start from the top-left → go right → go down → go left → go up (repeat until all elements are visited).

---

## **Final Diagram**

### For Spiral Traversal
**Result**: `[1, 2, 3, 6, 9, 8, 7, 4, 5]`

### For Spiral Generation (`n = 3`)
**Generated Matrix**:
```
1  2  3  
8  9  4  
7  6  5  
```

---

## **Code with Comments Explaining Why and What**

### Spiral Traversal
```java
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    if (matrix == null || matrix.length == 0) return result;

    int top = 0, bottom = matrix.length - 1;
    int left = 0, right = matrix[0].length - 1;

    while (top <= bottom && left <= right) {
        // Traverse from left to right
        for (int i = left; i <= right; i++) result.add(matrix[top][i]);
        top++; // Move the top boundary down

        // Traverse from top to bottom
        for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
        right--; // Move the right boundary left

        if (top <= bottom) {
            // Traverse from right to left
            for (int i = right; i >= left; i--) result.add(matrix[bottom][i]);
            bottom--; // Move the bottom boundary up
        }

        if (left <= right) {
            // Traverse from bottom to top
            for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
            left++; // Move the left boundary right
        }
    }
    return result;
}
```

---

### Spiral Generation
```java
public int[][] generateMatrix(int n) {
    int[][] matrix = new int[n][n];
    int top = 0, bottom = n - 1;
    int left = 0, right = n - 1;
    int num = 1;

    while (top <= bottom && left <= right) {
        // Fill from left to right
        for (int i = left; i <= right; i++) matrix[top][i] = num++;
        top++; // Move the top boundary down

        // Fill from top to bottom
        for (int i = top; i <= bottom; i++) matrix[i][right] = num++;
        right--; // Move the right boundary left

        // Fill from right to left
        if (top <= bottom) {
            for (int i = right; i >= left; i--) matrix[bottom][i] = num++;
            bottom--; // Move the bottom boundary up
        }

        // Fill from bottom to top
        if (left <= right) {
            for (int i = bottom; i >= top; i--) matrix[i][left] = num++;
            left++; // Move the left boundary right
        }
    }
    return matrix;
}
```

---

## **Visual Representation of the Process**

### Spiral Traversal
```
Start →  1 → 2 → 3  
                 ↓  
         4 → 5   6 
         ↑       ↓
         7 ← 8 ← 9 
        
  
```

### Spiral Generation (n = 3)
```
Final: [1, 2, 3]  
       [8, 9, 4]  
       [7, 6, 5]
```

---

## **Time and Space Complexity**
- **Spiral Traversal**:
  - Time Complexity: \( O(m*n) \), where \( m \) and \( n \) are matrix dimensions.
  - Space Complexity: \( O(1) \), ignoring output storage.
- **Spiral Generation**:
  - Time Complexity: \( O(n^2) \), as we visit all \( n^2 \) cells once.
  - Space Complexity: \( O(n^2) \), for storing the matrix.

--- 