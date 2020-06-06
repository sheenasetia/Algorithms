import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int v)
        {
            val=v;
            left=null;
            right=null;
        }
    }

    static Node constructBST(Node root,int n)
    {
        if(root==null)
        return new Node(n);

        if(n<root.val)
        root.left=constructBST(root.left, n);
        else
        root.right=constructBST(root.right, n);

        return root;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc=new Scanner(System.in);
        Node root=null;
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            root = constructBST(root,sc.nextInt());
        }

        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);

        int c=0,count=0;
        
        //level order traversal
        while(!q.isEmpty() && !(q.size()==1 && q.peek()==null))
        {
            Node demo=q.poll();
            if(demo==null)
            {
                count+=(c-1);
                c=0;
                q.add(null);
            }
            else
            {
                c++;
                if(demo.left!=null)
                q.add(demo.left);
                if(demo.right!=null)
                q.add(demo.right);
            }
        }
        count+=(c-1);
        System.out.println(count);
    }
}
