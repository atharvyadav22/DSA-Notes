package PatternPrinting;

public class TrianglePatterns {

    public void binaryNumberTriangle(){

        //Tip - plot coordinates and sum it (it is observed for even numbers its 1)
        int n = 4;

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= i ; j++) {

                int sum = i+j;

                if(sum % 2 == 0) System.out.print("1");
                else System.out.print("0");
            }
            System.out.println();
        }
    }

    public void palindromicPyramid(){

        /*
       row     part1        part2       part3
       1       4spaces      1           palindrome
       2       3spaces      2           palindrome
       3       2spaces      3           palindrome
       4       1spaces      4           palindrome
       5       0spaces      5           palindrome

       Observation - spaces = n-i
                     palindrome 2 se shuru hota hai 3rd loop 2 se chalu hoga
         */

        int n =5;

        for (int i = 1; i <=n; i++){

            //Spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print("  ");
            }

            //1st half
            for (int j =i; j >=1; j--){
                System.out.print(j + " ");
            }

            //2nd half
            for (int j =2; j <=i; j++){
                System.out.print(j + " ");
            }

            System.out.println();
        }
    }
}
