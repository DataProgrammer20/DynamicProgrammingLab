/*
 * Author: Allen Simpson
 * Date: April 13
 * Overview: Lab 7
 */

public class inLab7{
    
    public static void main(String[] args) {
        int[][] arr = calculateReturn(new int[] {1,5,10,25},15);
        int[] finalArr = new int[arr[arr.length - 1][0]];
        int farrindex = finalArr.length-1;
        int coinNum = arr[arr.length - 1][1];
        for (int i = arr.length; i>0;){
            finalArr[farrindex]=arr[i][1];
            farrindex--;
            i=i-arr[i][1];
        }
        for (int c: finalArr){
            System.out.println(c);
        }
    }
    
    public static int[][] calculateReturn (int[] coinTypes, int expectedChange) {
        if (coinTypes.length < 1) {throw new IllegalArgumentException("Array of size zero is not allowed");}
        int[][] returnedCoins = new int[expectedChange][2];
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
        /*

        [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15]
    [0]   0  1  2  3  4  1  2  3  4  5  1  2  3  4  5  2  //number of coins
    [1]   1  1  1  1  1  5  1  1  1  1 10  1  1  1  1  5  //last coin type used

        int[] returnedCoins = {};
        int workingChange=expectedChange;
        int addedCoin;
        int remainderChange;
        int[] tempArr;
        int[] workingCoinTypes = new int[coinTypes.length];
        for (int i =0; i<coinTypes.length;i++)
            workingCoinTypes[i]=coinTypes[coinTypes.length-1-i];
        for (int v:workingCoinTypes){
            addedCoin=workingChange/v;
            remainderChange = workingChange%v;
            workingChange= remainderChange;
            tempArr=returnedCoins;
            returnedCoins = new int[returnedCoins.length+addedCoin];
            for (int i=0;i<tempArr.length;i++){
                returnedCoins[i]=tempArr[i];
            }
            for (int j=tempArr.length;j<returnedCoins.length;j++){
                returnedCoins[j]=v;
            }
        }*/
        return returnedCoins;
    }
}