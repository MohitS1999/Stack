import java.util.*;
import java.io.*;
public class NearestSmallerToLeft{
	public static void main(String[] ars) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		while (t-->0){
			int n=Integer.parseInt(br.readLine().trim());
			int ar[]=new int[n];
			String str[]=br.readLine().split(" ");
			for (int i=0;i<n;i++)
				ar[i]=Integer.parseInt(str[i]);
			List<Integer> list=new ArrayList<>();
			Stack<Integer> st=new Stack<>();
			for (int i=0;i<n;i++){
				
				while (!st.isEmpty() && ar[i]<=st.peek()) st.pop();
				if (st.isEmpty()) list.add(-1);
				else list.add(st.peek());
				st.push(ar[i]);
				
			}
			for (int i=0;i<n;i++) 
				System.out.print(list.get(i)+" ");
			
			System.out.println();
		}
	}
}
