import java.util.*;
import java.io.*;
public class MaxRectangle{
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while (t-->0){
			String s1[]=br.readLine().split(" ");
			int row=Integer.parseInt(s1[0]);
			int col=Integer.parseInt(s1[1]);
			int m[][]=new int[row][col];
			for (int i=0;i<row;i++){
				String[] str=br.readLine().split(" ");
				for (int j=0;j<col;j++){
					m[i][j]=Integer.parseInt(str[j]);
				}
			}
			System.out.println(maxArea(m,row,col));
		}
	}
	//Max Area
	public static int maxArea(int a[][], int m, int n) {
        int maxRec=0;
        int ar[]=new int[n];
        Arrays.fill(ar,0);
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                ar[j]=(a[i][j]==0) ? 0 : ar[j]+1;
            }
            int max=Histogram(ar,n);
            if (maxRec<max)
                maxRec=max;
        }
        return maxRec;
    }
	//gives the hisyogram
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
			if (max<ar[i]*(res[i]-1))
				max=ar[i]*(res[i]-1);
		}return max;
	}
}
