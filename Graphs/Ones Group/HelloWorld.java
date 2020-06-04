import java.util.*;

class Solution{
    
    int count=0;
    
	public ArrayList<Integer> onesGroup(int[][] grid, int m, int n,int queries[])
	{
		HashMap<Integer,Integer> hm=new HashMap<>();
		ArrayList<Integer> al=new ArrayList<>();
		int c=0;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(grid[i][j]==1)
				{
					count=0;
				    c=bfs(grid,i,j);
				    
				    if(hm.containsKey(c))
				        hm.replace(c,hm.get(c)+1);
				    else
				        hm.put(c,1);
				}
			}
		}
		
		for(int i=0;i<queries.length;i++)
		{
		    if(hm.containsKey(queries[i]))
		        al.add(hm.get(queries[i]));
		    else
		        al.add(0);
		}
		
		return al;
	}

	private int bfs(int[][] grid, int i, int j) {
		
		if(i<0 || i >= grid.length || j<0 || j >= grid[i].length || grid[i][j]==0)
			return count;
		
		if(grid[i][j]==1)
		{
		    grid[i][j]=0;
		    count+=1;
		}
		
		bfs(grid,i-1,j); //check up
		bfs(grid,i+1,j); //check down
		bfs(grid,i,j-1); //check left
		bfs(grid,i,j+1); //check right
		
		return count;
	}
	
}

public class HelloWorld{

	public static void main(String[] args) {
		
		int m,n;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter num of rows in the grid : ");
		m=sc.nextInt();
		System.out.print("Enter num of cols in the grid : ");
		n=sc.nextInt();
		int grid[][]=new int[m][n];
		System.out.print("Enter grid elements : ");
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				grid[i][j]=sc.nextInt();
			}
		}
		
		System.out.print("Enter num of queries : ");
		int noOfQ = sc.nextInt();
		int queries[]=new int[noOfQ];
		for(int i=0;i<noOfQ;i++)
		{
		    queries[i]=sc.nextInt();
		}
		sc.close();
		Solution obj= new Solution();
		
	    ArrayList<Integer> al = new ArrayList<>();
	    al=obj.onesGroup(grid,m,n,queries);
	    
	    System.out.println("Result : ");
	    
	    for(int i=0;i<al.size();i++)
	    {
	        System.out.println(al.get(i));
	    }
	}

}
