/*package whatever //do not write package name here */
//https://practice.geeksforgeeks.org/problems/longest-valid-parentheses/0
import java.util.*;
import java.lang.*;
import java.io.*;

class LongestValidParantheses{
	public static void main (String[] args) throws IOException{
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		while (t-->0){
		    String str=br.readLine().trim();
		    char[] c=str.toCharArray();
		    int cnt=0;
		    Stack<Integer> s=new Stack<>();
			//starting index of stack
		    s.push(-1);
		    for (int i=0 ; i<c.length ; i++){
		        if (c[i]=='(') s.push(i);
		        else {  
				// if the stack is not empty then we pop out the element from the stack.
		                if (!s.isEmpty()) s.pop();
				//push the unwanted lelemnt in the stack if the stack is empty like                                                      )()()))().
				//at position 6 stak is empty and unwanted element also                                                                  012345678.
		                if (s.isEmpty()) s.push(i);
		                else if (!s.isEmpty())
		                    cnt=Math.max(cnt,i-s.peek());
		        }
		    }
		    //remove the garbage value of stack
		    s.clear();
		    System.out.println(cnt);
		}
	}
}
