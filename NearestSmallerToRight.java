import java.util.*;
import java.io.*;

public class NearestSmallerToRight{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while (t-->0){
			int n=Integer.parseInt(br.readLine());
			String[] str=br.readLine().split(" ");
			int ar[]=new int[n];
			for (int i=0;i<n;i++)
				ar[i]=Integer.parseInt(str[i]);
			Stack<Integer> st=new Stack<>();
			List<Integer> list=new ArrayList<>();
			for (int i=n-1;i>=0;i--){
				while (!st.isEmpty() && ar[i]<=st.peek()) st.pop();	
				if (st.isEmpty()) list.add(-1);
				else list.add(st.peek());
				st.push(ar[i]);
			}
			for (int i=n-1;i>=0;i--)
				System.out.print(list.get(i)+" ");
			System.out.println();
		}
	}
}