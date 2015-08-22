/*
Problem Statement

How many different ways can you make change for an amount, given a list of coins? In this problem, your code will need to efficiently compute the answer.

Task

Write a program that, given

An amount N and types of infinite available coins M
A list of M coins - C={C1,C2,C3,..,CM}
Prints out how many different ways you can make change from the coins to STDOUT.

The problem can be formally stated:

Given a value N, if we want to make change for N cents, and we have infinite supply of each of C={C1,C2,…,CM} valued coins, how many ways can we make the change? The order of coins doesn’t matter.

Constraints

1≤Ci≤50
1≤N≤250
1≤M≤50
The list of coins will contain distinct integers.
Solving the overlapping subproblems using dynamic programming

You can solve this problem recursively, but not all the tests will passs unless you optimise your solution to eliminate the overlapping subproblems using a dynamic programming solution

Or more specifically;

If you can think of a way to store the checked solutions, then this store can be used to avoid checking the same solution again and again.
Input Format

First line will contain 2 integer N and M respectively. 
Second line contain M integer that represent list of distinct coins that are available in infinite amount.

Output Format

One integer which is the number of ways in which we can get a sum of N from the given infinite supply of M types of coins.

Sample Input

4 3
1 2 3 
Sample Output

4
Sample Input #02

10 4
2 5 3 6
Sample Output #02

5
Explanation

Example 1: For N=4 and C={1,2,3} there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}

Example 2: For N=10 and C={2,5,3,6} there are five solutions: {2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5}.

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CoinChange {

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        String line1[] = br.readLine().split(" ");
        int deno[] = new int[line1.length];
        for(int i = 0; i<line1.length; i++)
            deno[i] = Integer.parseInt(line1[i]);
        
      
        long table[] = new long[n+1];
        table[0] = 1;
        
        for(int i = 0; i<m ; i++){
            for(int j = deno[i]; j<=n ; j++)
                table[j] += table[j-deno[i]];
        }
        System.out.println(table[n]);
    }
}