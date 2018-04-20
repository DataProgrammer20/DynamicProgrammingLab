/*
 * Author: Allen Simpson
 * Date: April 13
 * Overview: Lab 7
 */

public class inLab7{
    public static void main(String[] args) {
        int[] arr = calulateReturn(new int[] {1,5,10,25},42);
        int c=0;
        for (int v:arr) {
            c++;
            System.out.println(c+": "+v);
        }
    }
    public static int[] calulateReturn (int[] coinTypes, int expectedChange){
        if (coinTypes.length<1){System.out.println("ERROR coinTypes smaller than 1!"); return new int[] {-1};}
        /*
        int[][] returnedCoins = new int[expectedChange][2];
        returnedCoins[0]=new int[] {0,1};
        returnedCoins[1]=new int[] {1,1};
        */
        int[] returnedCoins = {};

        /* Dynamic Implementation
        for (int c =0; c<returnedCoins.length;c++){
            for(int v:coinTypes){
                if (!(returnedCoins.length>v) && returnedCoins[c-v][0]>v){
                    returnedCoins[c][0]= returnedCoins[c-v][0]+1; 
                }
            }
        }
        */
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
        }
        return returnedCoins;
    }
}
