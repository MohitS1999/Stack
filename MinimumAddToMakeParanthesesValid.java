//https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/minimum-add-to-make-parentheses-valid-9cba6259/
import java.util.*;
import java.util.Stack;
class MinimumAddToMakeParanthesesValid{
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int cnt=0;
        Stack<Integer> st=new Stack<>();
        for (char c:s.toCharArray()){
            if (c=='('){
                st.push(1);
				}
            else if ((!st.isEmpty()) && c==')' && st.peek()==1)
                st.pop();
            else if ((st.isEmpty()) && c==')')
                cnt++;
        }
        System.out.println(cnt+st.size());
    }
}
