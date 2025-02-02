package PatternPrinting;

public class SquarePatterns {

    public void alphabetSquareSimilar(){

        //ASCII for 'A' is 65
        int n = 4;

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print( (char) (j + 64) + " " );
            }

            System.out.println();
        }

    }

    public void hallowSquare(){

        //Tip - make a square and plot its coordinates
        int n = 4;

        for (int i = 1; i <=4; i++){
            for (int j = 1; j <=4; j++){
                if(i == 1 || i == n || j ==1 || j == n){
                    System.out.print("* ");
                }
                else System.out.print("  ");
            }

            System.out.println();
        }

    }




}
