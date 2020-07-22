//https://www.hackerearth.com/practice/data-structures/stacks/basics-of-stacks/practice-problems/algorithm/super-reduced-strings-303701dd/submissions/
import java.util.*;
public class SuperReducedString{
    public static void main(String[] args){
        Scanner sc=new Scanner (System.in);
        Stack<Character> st=new Stack<>();
        String s=sc.next();
        for (char c:s.toCharArray()){
            if (!st.isEmpty() && c==st.peek()) st.pop();
            else st.push(c);
        }
        if (st.isEmpty()){
            System.out.println("Empty String");
            return;
        }
        String str="";
        while (!st.isEmpty()){
            str=st.pop()+str;
        }
        System.out.println(str);
    }
}