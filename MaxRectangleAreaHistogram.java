import java.util.*;
import java.io.*;
public class MaxRectangleAreaHistogram{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while (t-->0){
			int n=Integer.parseInt(br.readLine().trim());
			String[] str=br.readLine().split( " ");
			int ar[]=new int[n];
			for (int i=0;i<n;i++)
				ar[i]=Integer.parseInt(str[i]);
			int max=Histogram(ar,n);
			System.out.println(max);
		}
		
	}
	public static int Histogram(int[] ar,int n){
		int res[]=new int[n];
		Stack<Integer> s=new Stack<>();
		res[0]=1;
		s.push(0);
		for (int i=1;i<n;i++){
			while (!s.isEmpty() && ar[i]<=ar[s.peek()]) s.pop();
			res[i]=(s.isEmpty()) ? i+1 :i-s.peek();
			s.push(i);
		}
		// for (int i=0;i<n;i++)
				// System.out.print(res[i]+" ");
		System.out.println();
		s.clear();
		s.push(n-1);
		res[n-1]=res[n-1]+1;
		for (int i=n-2;i>=0;i--){
			while (!s.isEmpty() && ar[i]<=ar[s.peek()]) s.pop();
			res[i]+=s.isEmpty() ? n-i : s.peek()-i;
			s.push(i);
		}
		int max=0;
		for (int i=0;i<n;i++){
			//System.out.println(res[i]+"   "+ar[i]);
			if (max<ar[i]*(res[i]-1))
				max=ar[i]*(res[i]-1);
		}return max;
	}
}
//Brute Force Method
/*package whatever //do not write package name here */

// import java.util.*;
// import java.lang.*;
// import java.io.*;

// class GFG {
	// public static void main (String[] args) throws IOException {
		// BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		// int t=Integer.parseInt(br.readLine());
		// while (t-->0){
		    // int n=Integer.parseInt(br.readLine());
		    // String[] str=br.readLine().split(" ");
		    // int ar[]=new int[n];
		    // for (int i=0;i<n;i++){
		        // ar[i]=Integer.parseInt(str[i]);
		    // }
		    // int max=0;
		    // for (int i=0;i<n;i++){
		        // int prev=i-1;
		        // int next=i+1;
		        // int cnt=1;
		        // while (prev>=0 && ar[i]<=ar[prev]){
		            // prev--;
		            // cnt++;
		        // }
		        // while (next<n && ar[i]<=ar[next]){
		            // next++;
		            // cnt++;
		        // }
		        System.out.println(max+" "+cnt);
		        // if (max<ar[i]*cnt) max=ar[i]*cnt;
		        
		    // }
		    // System.out.println(max);
		// }
	// }
// }