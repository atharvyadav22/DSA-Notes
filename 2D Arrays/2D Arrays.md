
# 2D Array Operations

## Concept
A 2D array is an array of arrays, which is used to represent a grid-like structure. Operations like multiplication, transpose, and rotation are commonly applied to 2D arrays.

---

## Theory For Interview
- **Multiplication**: Matrix multiplication involves multiplying two matrices where the number of columns in the first matrix must be equal to the number of rows in the second matrix.
- **Transpose**: The transpose of a matrix is obtained by swapping its rows and columns.
- **Rotation**: Rotating a 2D matrix by 90 degrees involves shifting elements within the array to form a rotated version.

---

## Initial Diagram: Matrix Multiplication Example
Example of two matrices to multiply:
```
Matrix A:
[1, 2]
[3, 4]

Matrix B:
[5, 6]
[7, 8]
```

---

## Final Diagram: After Matrix Multiplication
Result of multiplying Matrix A and Matrix B:
```
Result Matrix C:
[(1*5 + 2*7), (1*6 + 2*8)]
[(3*5 + 4*7), (3*6 + 4*8)]

C = 
[19, 22]
[43, 50]
```

---

## Code With Comments Explaining Why and What

### Matrix Multiplication Code:

```java
public class MatrixMultiplication {
    public static void multiply(int[][] A, int[][] B, int[][] C) {
        int m = A.length;    // Rows in A
        int n = A[0].length; // Columns in A
        int p = B[0].length; // Columns in B

        // Initialize result matrix C with zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < p; j++) {
                C[i][j] = 0;  // Initialize C[i][j] to 0
                for (int k = 0; k < n; k++) {
                    C[i][j] += A[i][k] * B[k][j];  // Perform matrix multiplication
                }
            }
        }
    }
}
```

### Matrix Transpose Code:

```java
public class MatrixTranspose {
    public static void transpose(int[][] matrix) {
        int m = matrix.length;    // Rows
        int n = matrix[0].length; // Columns

        // Transpose logic
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                // Swap elements (i, j) and (j, i)
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
```

### Matrix Rotation Code (90 degrees clockwise):

```java
public class MatrixRotation {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;  // Assuming square matrix

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // Swap elements
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Reverse each row using two-pointer approach
        for (int i = 0; i < n; i++) {

            int start = 0, end = n - 1;

            while (start < end) {
                // Swap elements
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }

    }
}
```

---

## Visual Representation of the Process
### Matrix Multiplication Visual
```
Matrix A:
[ 1, 2 ]
[ 3, 4 ]

Matrix B:
[ 5, 6 ]
[ 7, 8 ]

Step by step multiplication:
C[0][0] = 1*5 + 2*7 = 19
C[0][1] = 1*6 + 2*8 = 22
C[1][0] = 3*5 + 4*7 = 43
C[1][1] = 3*6 + 4*8 = 50

Resulting Matrix C:
[19, 22]
[43, 50]
```

### Matrix Transpose Visual
```
Original Matrix:
[ 1, 2, 3 ]
[ 4, 5, 6 ]
[ 7, 8, 9 ]

Transposed Matrix:
[ 1, 4, 7 ]
[ 2, 5, 8 ]
[ 3, 6, 9 ]
```

### Matrix Rotation Visual (90 degrees clockwise)
```
Original Matrix:
[ 1, 2, 3 ]
[ 4, 5, 6 ]
[ 7, 8, 9 ]

After Transposition:
[ 1, 4, 7 ]
[ 2, 5, 8 ]
[ 3, 6, 9 ]

After Row Reversal:
[ 7, 4, 1 ]
[ 8, 5, 2 ]
[ 9, 6, 3 ]
```

---

## Time and Space Complexity
- **Matrix Multiplication**: 
  - Time Complexity: O(m * n * p), where m is the number of rows in A, n is the number of columns in A, and p is the number of columns in B.
  - Space Complexity: O(m * p), as a new matrix C of size m * p is created.
  
- **Matrix Transpose**:
  - Time Complexity: O(m * n), where m is the number of rows and n is the number of columns.
  - Space Complexity: O(1), as the operation can be done in-place.

- **Matrix Rotation**:
  - Time Complexity: O(n^2), where n is the size of the matrix (assuming a square matrix).
  - Space Complexity: O(1), as the operation can be done in-place.

---