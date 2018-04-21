/*
 * Author: Allen Simpson
 * Date: 4/20/2018
 * Overview: This program utilizes dynamic programming to solve the
 * change-making problem. The class DynamicChangeMaking.java contains
 * the method calculateReturn that finds the least-most number of coins to return as change.
 */
public class DynamicChangeMaking {
    public static void main(String[] args) {
        int array[] = {1,5,10,25};
        System.out.println ("\n-95-\n");
        int[] rs = calculateReturn(array, 95);    
        for (int r:rs){System.out.println (r);}
        System.out.println ("\n-42-\n");
        rs = calculateReturn(array, 42);    
        for (int r:rs){System.out.println (r);}
        System.out.println ("\n-103-\n");
        rs = calculateReturn(array, 103); 
        for (int r:rs){System.out.println (r);}
        System.out.println ("\n-123-\n");   
        rs = calculateReturn(array, 123); 
        for (int r:rs){System.out.println (r);}
        /////////////////////////////////////////////Tomorrow 1:00 Sharp
        //////////////////*BUG*//////////////////////Errors when you are missing factors of the targetChange value 
        /*
        System.out.println ("\n-47 (new array)-\n");
        array = new int[] {2,5,10,25};
        rs = calculateReturn(array, 47);    
        for (int r:rs){System.out.println (r);}
        */
    }

    public static int[] calculateReturn (int[] coinTypes, int targetChange) {
        if (coinTypes.length == 0) {throw new IllegalArgumentException("Array of size zero is not allowed");}
        if (targetChange < 0) {throw new IllegalArgumentException("Value cannot be negative");}
        if (targetChange == 0) {return new int[]{0};}
        int[] coinNum = new int[targetChange + 1];
        int[] lastCoinUsed = new int[targetChange + 1];
        
        //Setting terminal case where number of coins = 0
        coinNum[0] = 0;
        lastCoinUsed[0] = 0;
        // Population of the pair of Data Arrays
        for (int changeValue = 1; changeValue < coinNum.length; changeValue++) {                            //Interate over the data arrays
            coinNum[changeValue] = Integer.MAX_VALUE;                                                       //Setting the coinNum changeValue to an upper-limit coinValue
            for(int coinValue : coinTypes) {                                                                //Check different coin Types
                int changeRemaining=changeValue-coinValue;                                                  //Caculate the remaining change
                if (changeRemaining >= 0 &&                                                                 //*VALIDATION CHECK*//Change remaining must be positive,otherwise the value is not representable by a coin of that value (EX. 12 cannot be represented by a quarter)
                    coinNum[changeRemaining] + 1 < coinNum[changeValue]) {                                  //   *LOGIC CHECK*  //Check that the value pointed to by the remaining change is better than the current value
                    coinNum[changeValue]=coinNum[changeRemaining]+1;                                        //Assign coinNum changeValue to valid number given adding coin 'value'
                    lastCoinUsed[changeValue]  = coinValue;                                                 
                }
            }
        }
        // Parsing the pair of Data Arrays and populating the final return array
        int[] returnedCoins = new int[coinNum[targetChange]];                                                    //Get number of coins in final answer
        int i = 0;
        while(lastCoinUsed[targetChange] > 0) {
            returnedCoins[i] = lastCoinUsed[targetChange];
            i++;
            targetChange -= lastCoinUsed[targetChange];
        }
        return returnedCoins;
    }
}
//given that coinTypes = {1,5,10,25}
//[ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15]
//  0  1  2  3  4  1  2  3  4  5  1  2  3  4  5  2
//  1  1  1  1  1  5  1  1  1  1 10  1  1  1  1  5