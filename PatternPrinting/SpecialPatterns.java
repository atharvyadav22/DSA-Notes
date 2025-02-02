package PatternPrinting;

 public class SpecialPatterns {

    //Tip - Make Boxes first to analyze spaces and pattern
    public void butterflyPattern() {

        /*
       rows      part1      part2        part3
       1         1star      6spaces      1star
       2         2star      4spaces      2star
       3         3star      2spaces      3star
       4         4star      0spaces      4star     -First Half
       5         4star      0spaces      4star     -Second Half
       7         .          .            .
       8         .          .            .
       9         .          .            .
       10        .          .            .

       Observation - jtina rows utne stars,
                     2*(n-1) spaces
         */


        int n = 5;

        //Upper Half
        for (int i = 1; i <= n; i++) {

            //1st part
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            //2nd part
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }

            //3rd part
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        //Lower Half
        for (int i = n; i >= 1; i--) {

            //1st part
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            //2nd part
            int spaces = 2 * (n - i);
            for (int j = 1; j <= spaces; j++) {
                System.out.print("  ");
            }

            //3rd part
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }


    }

    public void solidRhombus() {

        /*
       row     part1        part2       part3
       1       4spaces      5star       0spaces
       2       3spaces      5star       1spaces
       3       2spaces      5star       2spaces
       4       1spaces      5star       3spaces
       5       0spaces      5star       4spaces

       Observation - spaces = n-i
         */

        int n = 5;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

    }

}
