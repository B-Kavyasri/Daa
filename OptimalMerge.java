import java.util.*;
import java.util.PriorityQueue;
class OptimalMerge{
    public static int mergeCost(int[] files){
        int cost=0;
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        for(int file:files){
            minHeap.add(file);
        }
        while(minHeap.size()>1){
            int file1=minHeap.poll();
            int file2=minHeap.poll();
            int mergecost=file1+file2;
            cost+=mergecost;
            minHeap.add(mergecost);
        }
        return cost;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter no.of Files:");
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
            files[i]=sc.nextInt();
        int cost=mergeCost(files);
        System.out.println("Optimal Merge Cost : "+cost);
    }
}
        
