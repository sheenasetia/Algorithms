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

    static int height(Node root)
    {
        if(root==null)
        return 0;
        return 1+(int)Math.max(height(root.left),height(root.right));
    }
    static int getDiameter(Node root)
    {
        if(root==null)
        return 0;
        return 1+height(root.left)+height(root.right);

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
  
        System.out.println(getDiameter(root));
    }
}
