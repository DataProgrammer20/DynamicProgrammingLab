/*
 * Author: Allen Simpson
 * Date: April 13
 * Overview: Lab 7
 */
public class inLab7{
    public static int[] calculateReturn (int[] coinTypes, int expectedChange) {
        if (coinTypes.length == 0) {throw new IllegalArgumentException("Array of size zero is not allowed");}
        if (expectedChange < 0) {throw new IllegalArgumentException("Value cannot be negative");}
        if (expectedChange == 0) {return new int[]{0};}
        int[][] returnedCoins = new int[expectedChange + 1][2];
        returnedCoins[0] = new int[] {0,1};
        returnedCoins[1] = new int[] {1,1};
        int newCoin = 1;
        //Dynamic Implementation
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
        int[][] arr = returnedCoins;
        int[] finalArr = new int[arr[arr.length - 1][0]];
        int farrindex = finalArr.length-1;
        for (int i = arr.length-1; i>0;) {
            finalArr[farrindex]=arr[i][1];
            farrindex--;
            i = i - arr[i][1];
        }
        return finalArr;
    }
}