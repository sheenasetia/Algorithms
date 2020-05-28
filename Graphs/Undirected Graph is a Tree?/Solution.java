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
            for(int i=0;i<v;i++){
                g.add(new ArrayList<>());
            }
        }

        void addEdge(int v,int e)
        {
            g.get(v).add(e);
            g.get(e).add(v);
        }

        boolean checkCycle(int i,boolean visited[],int parent)
        {
            visited[i]=true;
            for(int j=0;j<g.get(i).size();j++)
            {
                int n=g.get(i).get(j);
                if(!visited[n])
                {
                    if(checkCycle(n, visited,i))
                    return true;
                }

                else if(n!=parent)
                return true;
            }
            return false;
        }

        boolean checkIfTree()
        {
            boolean visited[]=new boolean[V];
            
            if(checkCycle(0,visited,-1)==true)
            return false;

            for(int i=0;i<V;i++)
            {
                if(visited[i]==false)
                return false;
            }
            return true;
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

            System.out.println(obj.checkIfTree());
        }


    }
}
