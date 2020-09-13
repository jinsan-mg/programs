# programs
coding problems and solutions
# 1. createPalindrome
a program to create a palindrome string based on the user input.
eg: word length - 4, number of chars - 2, number of digits - 2, number of special chars - 0
output: a00a;
The program also checks for invalid use cases and prints the same.
#methods used:
# a. convertToInt
This method will convert the commandline string inputs to integer array. Also set the invalid flag to 1 if invalid inputs are passed.
Takes string array as input and returns integer array
# b. checkForInvalidPalindromeInput
Method used to validate the inputs. Check the boundary conditions for the inputs, invalid combinations of inputs and returns the flag accordingly
# c. buildPalindrome
method which creates the required output. Accept the integer array as input and returns the palindrome string.
The methods divides the x,y and z length to half to build the first half of the palindrome and combine all of them to create the first half.
It also check if the any of x,y and z is odd and create the character to add in middle.
Combines the first half, middle string and reverse of first half to return the final output.
# d. createStream
The method create the stream of character based on the ascci value range and the length required.