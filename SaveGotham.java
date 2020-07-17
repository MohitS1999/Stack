/*package whatever //do not write package name here */
//https://practice.geeksforgeeks.org/problems/save-gotham/0
import java.util.*;
import java.lang.*;
import java.io.*;

class SaveGotham{
	public static void main (String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		while (t-->0){
		    int n=Integer.parseInt(br.readLine().trim());
		    int ar[]=new int[n];
		    String[]  str=br.readLine().split(" ");
		    for (int i=0;i<n;i++)
		        ar[i]=Integer.parseInt(str[i]);
		    Stack<Integer> s=new Stack<>();
		    int sum=0;
		    for (int i=n-1;i>=0;i--){
		        while (!s.isEmpty() && ar[i]>=s.peek()) s.pop();
		        sum+=(s.isEmpty()) ? 0 : s.peek();
		        s.push(ar[i]);
		    }
		    System.out.println(sum);
		}
	}
}