package sample;

public class createPalindrom {
    static int invalid = 0;

    public static void main(String[] args) {
        //String[] inp = args;
        String[] inp = {"4", "0", "0", "4"};
        if(inp.length!=4){
            invalid=1;
        }
        int[] int_Inputs = convertToInt(inp);
        int invFlag = 0;
        if(invalid==0){
            invFlag = checkForInvalidPalindromeInput(int_Inputs);
            if(invFlag==0){
                String palindromeString = buildPalindrome(int_Inputs);
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
        String strPalindrome = "";
        int alphaLength = inp[1]/2;
        int numbLength = inp[2]/2;
        int specCharLength = inp[3]/2;
        String midString = "";
        String alphaString = createStream(97,122, alphaLength);
        String numbString = createStream(48,57, numbLength);
        String specCharString = createStream(33,47, specCharLength);
        if((inp[1]%2)!=0){
            midString = "a";
        }
        if((inp[2]%2)!=0){
            midString = "1";
        }if((inp[3]%2)!=0){
            midString = "!";
        }
        String palindromeFirstHalf = alphaString+numbString+specCharString;
        String rev_palindromeFirstHalf = new StringBuilder(palindromeFirstHalf).reverse().toString();
        strPalindrome = palindromeFirstHalf+midString+rev_palindromeFirstHalf;
        return strPalindrome;
    }
    static String createStream(int start, int end, int len){
        String charStream = "";
        int j = start;
        for(int i=0; i<len; i++){
            charStream = charStream+ Character.toString((char) j);
            j++;
            if(j>end){
                j=start;
            }
        }
        return charStream;
    }
    static void checkPalindrome(String S){
        String SR = new StringBuilder(S).reverse().toString();
        if(!(S.equals(SR))){
            System.out.println("Created the below string, but its not a valid palindrome");
        }
    }
    static int[] convertToInt(String[] inpString){
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
    static int checkForInvalidPalindromeInput(int[] inp){
        int Flag = 0;
        int wOdd = 0;
        int oddCount = 0;
        int xyz = 0;
        if(inp[0]<1 || inp[0]>20){
            Flag=1;
            return Flag;
        }
        else{
            if((inp[0] % 2)!=0){
                wOdd = 1;
            }
        }
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
        if((xyz != inp[0]) || (wOdd != oddCount)){
            Flag=1;
            return Flag;
        }
        return Flag;
    }
}