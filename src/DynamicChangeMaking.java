/*
 * Author: Allen Simpson
 * Date: 4/20/2018
 * Overview: This program utilizes dynamic programming to solve the
 * change-making problem. The class DynamicChangeMaking.java contains
 * the method calculateReturn that finds the least-most number of coins to return as change.
 */
public class DynamicChangeMaking {
    public static int[] calculateReturn (int[] coinTypes, int expectedChange) {
        if (coinTypes.length == 0) {throw new IllegalArgumentException("Array of size zero is not allowed");}
        if (expectedChange < 0) {throw new IllegalArgumentException("Value cannot be negative");}
        if (expectedChange == 0) {return new int[]{0};}
        int[][] returnedCoins = new int[expectedChange + 1][2];
        returnedCoins[0] = new int[] {0,1};
        returnedCoins[1] = new int[] {1,1};
        int newCoin = 1;
        // Dynamic Implementation
        for (int c = 1; c < returnedCoins.length; c++) {
            returnedCoins[c][0]=expectedChange;
            for(int v : coinTypes) {
                if (!((c-v) < 0) && returnedCoins[c-v][0] + 1 < returnedCoins[c][0]) {
                    returnedCoins[c][0]=returnedCoins[c-v][0]+1;
                    newCoin = v;
                }
            }
            returnedCoins[c][1] = newCoin;
        }
        int[] finalArr = new int[returnedCoins[returnedCoins.length - 1][0]];
        int farrindex = finalArr.length-1;
        for (int i = returnedCoins.length-1; i>0;) {
            finalArr[farrindex]=returnedCoins[i][1];
            farrindex--;
            i = i - returnedCoins[i][1];
        }
        return finalArr;
    }
}