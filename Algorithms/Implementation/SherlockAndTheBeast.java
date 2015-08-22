/*
Problem Statement

Sherlock Holmes is getting paranoid about Professor Moriarty, his arch-enemy. All his efforts to subdue Moriarty have been in vain. These days Sherlock is working on a problem with Dr. Watson. Watson mentioned that the CIA has been facing weird problems with their supercomputer, 'The Beast', recently.

This afternoon, Sherlock received a note from Moriarty, saying that he has infected 'The Beast' with a virus. Moreover, the note had the number N printed on it. After doing some calculations, Sherlock figured out that the key to remove the virus is the largest Decent Number having N digits.

A Decent Number has the following properties:

3, 5, or both as its digits. No other digit is allowed.
Number of times 3 appears is divisible by 5.
Number of times 5 appears is divisible by 3.
Meanwhile, the counter to the destruction of 'The Beast' is running very fast. Can you save 'The Beast', and find the key before Sherlock?

Input Format
The 1st line will contain an integer T, the number of test cases. This is followed by T lines, each containing an integer N. i.e. the number of digits in the number. 

Output Format
Largest Decent Number having N digits. If no such number exists, tell Sherlock that he is wrong and print −1.

Constraints
1≤T≤20
1≤N≤100000


Sample Input

4
1
3
5
11
Sample Output

-1
555
33333
55555533333
Explanation
For N=1, there is no such number.
For N=3, 555 is the only possible number.
For N=5, 33333 is the only possible number.
For N=11, 55555533333 and all permutations of these digits are valid numbers; among them, the given number is the largest one.
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SherlockAndTheBeast {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t>0){
            int n = sc.nextInt();
            StringBuilder x=new StringBuilder(n);
            if(n == 3 ){
                x.append("555");
                
            }
            else if(n == 5){
                x.append("33333");
            }
            else if(n == 10){
                x.append("3333333333");
            }
            else{
            int temp5 =0;
            int temp3 =0;
            int i;
            
            
            
            for( i= n; i>0; i--){
                temp5 = i%3;
                temp3 = (n-i)%5;
                //System.out.println(i + " temp5%3 " + temp5%3 + " temp3%5 " + temp3%5);
                //System.out.println("temp5 + temp3 " + (temp5 + temp3));
                if((temp5 + temp3) == 0 ){
                    //System.out.println("if" + i);
                    break;
                }
                
            }
            if(i != 0){
                temp5 = i;
                temp3 = n-i;
                 
                for(int k =0; k<temp5; k+=3){
                   x.append("555");
                }
                for(int k =0; k<temp3; k+=5){
                    x.append("33333");
                }
            }
            else{
               x.append("-1");
            } 
            }
            System.out.println(x);
            t--;
        }
    }
}