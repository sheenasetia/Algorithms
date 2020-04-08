
import java.util.*;
public class HeapSort{

    void heapify(int arr[],int n,int i)
    {
        int largest = i;
        int l = 2*i +1;
        int r = 2*i +2;
        if(l<n && arr[l]>arr[largest])
        {
            largest = l;
        }
        if(r<n && arr[r]>arr[largest])
        {
            largest = r;
        }
        if(largest != i)
        {
            int temp = arr[largest];
            arr[largest]=arr[i];
            arr[i]=temp;
            //heapify the below disturbed nodes
            heapify(arr,n,largest);
        }
    }
    void sort(int arr[])
    {
        //built heap by heapifying in bottom-up manner
        for(int i=(arr.length)/2-1;i>=0;i--)
        {
            heapify(arr,arr.length,i);
        }
        for(int i=arr.length-1;i>0;i--)
        {
            int temp=arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr,i,0);
        }
    }
    
    static void printArray(int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }
    
    public static void main(String args[]) 
    { 
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt(); 
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
          arr[i]=sc.nextInt();
        }
        HeapSort ob = new HeapSort(); 
        ob.sort(arr); 
        System.out.println("Sorted array is"); 
        printArray(arr); 
    } 
}
