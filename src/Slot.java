import java.util.HashMap;
import java.util.Map;

public class Slot {
    public static void main(String[] args) {
//        [0, 1, 2 ,3 ,4]
//        [5, 6, 7, 8, 9]
//        [10,11,12,13,14]

        int max = 10;
        int min = 1;
        int range = max - min + 1;
        int summ = 0;
        int countone = 0;
        int downcountone = 1;
        int countwo = 0;
        int upcountwo = 1;
        int downcountwo = 1;
        int counthree = 0;
        int upcounthree = 1;
        int bet = 3;

        HashMap map = new HashMap();
        for (int i = 0; i < 15; i++) {
            int random = (int) (Math.random() * range);

            map.put(i, random);
//            map.put(i, 9);
        }
        for (int i = 0; i < 15; i++) {
            System.out.print(map.get(i) + " ");

            if ((i + 1) % 5 == 0) {
                System.out.println("");
            }
        }


        for (int i = 0; i < 15; i++) { // straight line check
            if (i < 5) {
                if (map.get(0) == map.get(i)) {
                    countone++;
                }
                if (map.get(0) != map.get(i)) {
                    i = 5;
                }
            }

            if (i >= 5 && i < 10) {
                if(map.get(5).equals(map.get(i))){
                    countwo++;
                }
                if (map.get(5) != map.get(i)) {
                    i = 10;
                }
            }

            if (i >= 10) {
                if(map.get(10).equals(map.get(i))){
                    counthree++;
                }
                if (map.get(0) != map.get(i)) {
                    i = 14;
                }
            }
        }

        for (int i = 0; i < 4 ; i++) { // \___/ first line

            if (map.get(0).equals(map.get(6+i)) && i < 3){
                downcountone++;
            }
            else break;

            if(downcountone == 4 && map.get(0).equals(map.get(4))){
                downcountone++;
            }
        }

        for (int i = 0; i < 4; i++) { // /---\ second line
            if (map.get(5).equals(map.get(1+i)) && i < 3){
                upcountwo++;
            }
            else break;

            if(upcountwo == 4 && map.get(5).equals(map.get(9))){
                upcountwo++;
            }
        }

        for (int i = 0; i < 4; i++) { // \___/ second line
            if (map.get(5).equals(map.get(11+i)) && i < 3){
                downcountwo++;
            }
            else break;

            if(downcountwo == 4 && map.get(5).equals(map.get(9))){
                downcountwo++;
            }
        }

        for (int i = 0; i < 4; i++) { // /---\ third line
            if (map.get(10).equals(map.get(6+i)) && i < 3){
                upcounthree++;
            }
            else break;

            if(upcounthree == 4 && map.get(10).equals(map.get(14))){
                upcounthree++;
            }
        }


        if(countone >= 3){ // -----
            summ = summ + ((int)map.get(0) * countone);
        }
        if(downcountone >= 3){ // \___/
            summ = summ + ((int)map.get(0) * downcountone);
        }
        if(countwo >= 3){ // -----
            summ = summ + ((int)map.get(5) * countwo);
        }
        if(upcountwo >= 3){ // /---\
            summ = summ + ((int)map.get(5) * upcountwo);
        }
        if(downcountwo >= 3){ // \___/
            summ = summ + ((int)map.get(5) * downcountwo);
        }
        if(counthree >= 3){ // ------
            summ = summ + ((int)map.get(10) * counthree);
        }
        if(upcounthree >= 3){ // /---\
            summ = summ + ((int)map.get(10) * upcounthree);
        }

        summ = summ * bet; // Your bet multiplier

        if (summ > 0) { // If you win
            System.out.println("Your bet : " + bet + "$");
            System.out.println("Congratulation!");
            System.out.println("You win : " + summ + "$");
        }
        else { // If you lose
            System.out.println("Your bet : " + bet + "$");
            System.out.println("Try again");
        }
    }
}