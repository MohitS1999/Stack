/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class NearestGreaterToRight{
	public static void main (String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		while (t-->0){
		    int n=Integer.parseInt(br.readLine().trim());
		    String str[]=br.readLine().split(" ");
		    long ar[]=new long[n];
		    for (int i=0;i<n;i++)
		        ar[i]=Long.parseLong(str[i]);
		    List<Long> list=new ArrayList<>();
		    Stack<Long> s=new Stack<>();
		    for (int i=n-1;i>=0;i--){
		        while (!s.isEmpty() && ar[i]>=s.peek()) s.pop();
		        if (s.isEmpty()) list.add((long)-1);
		        else list.add(s.peek());
		        s.push(ar[i]);
		    }
		    for (int i=n-1;i>=0;i--) System.out.print(list.get(i)+" ");
		    System.out.println();
		}
	}
}