package com.paypal;

public class Main {
    static int invalid = 0;

    public static void main(String[] args) {
        //String[] inp = {"10", "6", "4", "0"};
        String[] inp = args;
        if(inp.length!=4){
            invalid=1;
        }
        int oddCount = 0;
        //convert strings agrs to integer
        int[] pals = convertInt(inp);
        //check for invalid inputs
        int invFlag = 0;
        if(invalid==0){
            invFlag = checkForInvalidPalindrom(pals);
            if(invFlag==0){
                String palindromeString = buildPalindrome(pals);
                //test the formed string
                checkPalindrome(palindromeString);
                System.out.println(palindromeString);
            }
            else {
                System.out.println("Invalid Palindrome");
            }
        }
        else {
            System.out.println("invalid input");
        }
    }
    static String buildPalindrome(int[] inp){
        String strPal = "";
        int x1 = inp[1]/2;
        int y1 = inp[2]/2;
        int z1 = inp[3]/2;
        String mid = "";
        String s1 = createStream(97,122, x1);
        String s2 = createStream(48,57, y1);
        String s3 = createStream(33,47, z1);
        if((inp[1]%2)!=0){
            mid = "a";
        }
        if((inp[2]%2)!=0){
            mid = "1";
        }if((inp[3]%2)!=0){
            mid = "!";
        }
        String s = s1+s2+s3;
        String sr = new StringBuilder(s).reverse().toString();
        strPal = s+mid+sr;
        return strPal;
    }
    static String createStream(int start, int end, int len){
        String s = "";
        int j = start;
        for(int i=0; i<len; i++){
            s = s+ Character.toString((char) j);
            j++;
            if(j>end){
                j=start;
            }
        }
        return s;
    }
    static void checkPalindrome(String S){
        String SR = new StringBuilder(S).reverse().toString();
        if(!(S.equals(SR))){
            System.out.println("Created the below string, but its not a valid palindrome");
        }
    }
    static int[] convertInt(String[] inpString){
        int[] p = new int[4];
        try {
            p[0] = Integer.parseInt(inpString[0]);
            p[1] = Integer.parseInt(inpString[1]);
            p[2] = Integer.parseInt(inpString[2]);
            p[3] = Integer.parseInt(inpString[3]);
        } catch (Exception e){
            invalid = 1;
        }
        return p;
    }
    static int checkForInvalidPalindrom(int[] inp){
        int Flag = 0;
        int wOdd = 0;
        int oddCount = 0;
        int xyz = 0;
        //checkFor w
        if(inp[0]<1 || inp[0]>20){
            Flag=1;
            return Flag;
        }
        else{
            if((inp[0] % 2)!=0){
                wOdd = 1;
            }
        }
        //check for x,y and z
        for(int i=1; i<4; i++){
            if(inp[i]<0 || inp[i]>20){
                Flag=1;
                return Flag;
            }
            else{
                if((inp[i] % 2)!=0){
                    oddCount++;
                }
                xyz = xyz + inp[i];
            }
        }
        //check for total word length and odd count
        if((xyz != inp[0]) || (wOdd != oddCount)){
            Flag=1;
            return Flag;
        }
        return Flag;
    }
}