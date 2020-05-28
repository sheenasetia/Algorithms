import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static class graph
    {
        int V;
        ArrayList<ArrayList<Integer>> g=new ArrayList<>();
        graph(int v){
            V=v;
            for(int i=0;i<=v;i++){
                g.add(new ArrayList<>());
            }
        }

        void addEdge(int v,int e)
        {
            g.get(v).add(e);
            g.get(e).add(v);
        }

        int getAvg()
        {
            int c=0;
            for(int i=1;i<=V;i++)
            {
                c+=g.get(i).size();
            }

            return (c/V);
        }
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int v=sc.nextInt();
            int e=sc.nextInt();
            graph obj=new graph(v);
            for(int j=0;j<e;j++)
            {
                obj.addEdge(sc.nextInt(),sc.nextInt());
            }

            System.out.println(obj.getAvg());
        }


    }
}
