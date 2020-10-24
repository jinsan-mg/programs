package sample;

import java.util.Scanner;

public class createPalindromeInd {
    public static char[] output;

    public static void main (String a[]) {
        int[] input = new int[4];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            input[i] = Integer.parseInt(scanner.next());
        }
        int totalLength = input[0];
        int charCount = input[1];
        int numCount = input[2];
        int specialChar = input[3];
        int specialCharFlag = 0;
        int charFlag = 0;
        int numFlag = 0;
        int allEven = 0;

        int[] Flags = checkForValidInput(totalLength,charCount,numCount,specialChar);
        allEven = Flags[0];
        charFlag = Flags[1];
        numFlag = Flags[2];
        specialCharFlag = Flags[3];

        output = new char[totalLength];
        int mid = totalLength/2;
        formString(totalLength,charCount,numCount,specialChar);
        if (charFlag==1){
            output[mid] = getAsciiValue(97);
        }
        if (numFlag==1){
            output[mid] = getAsciiValue(48);
        }
        if (specialCharFlag==1){
            output[mid] = getAsciiValue(33);
        }
        if(Flags[4] == 1){
            System.out.println(String.valueOf(output));
        }

        if (checkPalindrome(String.valueOf(output))){
            System.out.println("It is a Palindrome");
        }
        else System.out.println("It is NOT a Palindrome");
    }

    public static boolean checkPalindrome(String output){
        StringBuilder stringBuilder = new StringBuilder(output);
        if (stringBuilder.reverse().toString().equals(output)){
            return true;
        }
        else return false;
    }


    public static char getAsciiValue(int ascii){
        return (char)ascii;
    }

    public static boolean checkEven(int input){
        if (input % 2 == 0)
            return true;
        else return false;
    }
    public static int[] checkForValidInput(int totCount,int chCount,int nuCount,int spCount){
        int[] flags = {0,0,0,0,0};
        int validFlag = 0;
        if (chCount + nuCount + spCount == totCount) {
            if (checkEven(chCount) && checkEven(nuCount) && checkEven(spCount)) {
                validFlag = 1;
                flags[0] = 1;
            }
            if (!checkEven(chCount)) {
                if (checkEven(nuCount) && checkEven(spCount)) {
                    validFlag = 1;
                    flags[1] = 1;
                }
            }
            if (!checkEven(nuCount)) {
                if (checkEven(spCount) && checkEven(chCount)) {
                    validFlag = 1;
                    flags[2] = 1;
                }
            }
            if (!checkEven(spCount)) {
                if (checkEven(nuCount) && checkEven(chCount)) {
                    validFlag = 1;
                    flags[3] = 1;
                }
            }
            flags[4] = validFlag;
            if(validFlag == 0){
                System.out.println("Invalid Input");
            }
        }
        else
            System.out.println("Invalid Input");
        return flags;
    }

    public static void formString(int totalLength, int charCount,int numCount, int specialChar){
        int i, j, k = 0;
        for (i=0;i<charCount/2;i++){
            output[i] = getAsciiValue(i + 97);
            output[totalLength - 1 - i] = getAsciiValue(i + 97);
        }
        for (j = i; j < i + numCount/2; j++) {
            output[j] = getAsciiValue(j-i + 48);
            output[totalLength - 1 - j] = getAsciiValue(j-i + 48);
        }
        for (k = j; k < j + specialChar / 2; k++) {
            output[k] = getAsciiValue(k-j + 33);
            output[totalLength - 1 - k] = getAsciiValue(k-j + 33);
        }
    }
}