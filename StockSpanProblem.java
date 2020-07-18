import java.util.*;
import java.io.*;
//Based on index value
public class StockSpanProblem{
	public static void main(String[] ars) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine().trim());
		while (t-->0){
			int n=Integer.parseInt(br.readLine().trim());
			String[] str=br.readLine().split(" ");
			int ar[]=new int[n];
			for (int i=0;i<n;i++)
				ar[i]=(Integer.parseInt(str[i]));
			Stack<Integer> s=new Stack<>();
			int res[]=new int[n];
			res[0]=1;
			s.push(0);
			for (int i=1;i<n;i++){
				//while you don't find element smaller than previous element, keep poping
				//we are doing this as lower element which occur at previous indexes should be added to 
				//span of bigger price day
				while (!s.isEmpty() && ar[i]<=ar[s.peek()]) s.pop();
				//this handles two cases
				//1) when there is no element in the stack: simply i+1 as no all previous elements will be smaller thats why they were  popped out
				//2) if not empty, keep popping in above step till you reach something bigger that can not 
				//be added to span of current observed element
				res[i]=(s.isEmpty()) ? i+1 : i-s.peek();
				//afterwards push element 
				s.push(i);
			}
			for (int i=0;i<n;i++)
				System.out.print(res[i]+" ");
			System.out.println();
		}
	}
}
