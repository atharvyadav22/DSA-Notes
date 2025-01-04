
# Pascal's Triangle

## **Concept**
Pascal's Triangle is a triangular array where each number is the sum of the two numbers directly above it. It is used in combinatorics, binomial expansions, and mathematical proofs.

---

## **Theory for Interview**

1. The **\(n\)-th row** of Pascal's Triangle corresponds to the coefficients of the binomial expansion \((a + b)^n\).

2. Each element at position \((i, j)\) is calculated as:

   $$
   \text{Pascal}[i][j] = \binom{i}{j} = \frac{i!}{j!(i - j)!}
   $$

   - \( i! \) represents the factorial of \(i\),
   - \( j! \) represents the factorial of \(j\),
   - \( (i - j)! \) represents the factorial of \(i - j\).

3. The **first** and **last** elements of each row are always `1`.

4. **Common Applications**:
   - Finding **combinations** \(nCk\).
   - Expanding binomials using the **Binomial Theorem**.
   - Solving **probability problems**.

5. **Shadow Trick Formula for \( nCr \)**:
   - The **shadow trick** (also called **modular inverse method**) is an optimized way of computing combinations \(nCr\) without computing factorials directly.
   - **Formula**:
     
     $$
     \binom{n}{r} = \frac{n \times (n-1) \times (n-2) \times \dots \times (n-r+1)}{r!}
     $$

   - Instead of calculating \( n! \), multiply \( r \) consecutive numbers from \( n \) down to \( n-r+1 \), and divide by \( r! \).
   
   - This method is particularly useful when **\( n \) and \( r \) are large** to prevent overflow.

   - **Example**:
     - To compute \( 10C3 \):
       $$
       \binom{10}{3} = \frac{10 \times 9 \times 8}{3!} = \frac{720}{6} = 120
       $$

---

## **Initial Diagram**  
For \(n = 5\):  

```
        1
      1   1
    1   2   1
  1   3   3   1
1   4   6   4   1
```

---

## **Final Diagram**  
Pascal's Triangle represented in a 2D list for \(n = 5\):  
```
 [1],
 [1, 1],
 [1, 2, 1],
 [1, 3, 3, 1],
 [1, 4, 6, 4, 1]
```

---

## **Code With Comments Explaining Why and What**

### Pascal's Triangle (Iterative)
```java
import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Loop through each row and calculate it using the binomial coefficient formula
        for (int i = 0; i < numRows; i++) {
            result.add(nCr(i));  // Calculate the i-th row using the nCr function
        }
        
        return result;
    }

    // Function to compute the binomial coefficients (nCr) for the r-th row
    public static List<Integer> nCr(int r) {
        List<Integer> row = new ArrayList<>();
        long coefficient = 1;  // Using long to prevent overflow for larger values of r
        
        // The first coefficient is always 1
        row.add(1);
        
        // Calculate the remaining coefficients in the r-th row
        for (int k = 1; k <= r; k++) {
            // Calculate the coefficient using the iterative formula
            coefficient = coefficient * (r - k + 1) / k;
            row.add((int) coefficient);  // Cast to int for the final result (since coefficients are integers)

        //     // Add the two elements directly above(This Take More Time To Compute So not ues but locically the process is this)
        //             row.add(triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j));
  
        
        return row;
    }
}

```

---

## **Visual Representation of the Process**

### Step-by-Step Visualization for `numRows = 5`:
1. Start with an empty list.  
2. Add the first row: `[1]`.  
3. For each subsequent row:
   - Add `1` at the beginning and end.
   - Compute intermediate values by summing the two numbers directly above.

```
Row 0: [1]
Row 1: [1, 1]
Row 2: [1, 2, 1]
Row 3: [1, 3, 3, 1]
Row 4: [1, 4, 6, 4, 1]
```

---

## **Time and Space Complexity**
- **Time Complexity**: \(O(n^2)\)  
  - Each row has at most \(i\) elements, and there are \(n\) rows.  
- **Space Complexity**: \(O(n^2)\)  
  - Space required to store the triangle.

---

