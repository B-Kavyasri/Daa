import java.util.Scanner;
public class BinarySearch{
    public static int BinarySearch(int a[],int n,int key){
        int lb=0;
        int ub=n-1;
        while(lb<=ub){
            int mid=(lb+ub)/2;
            if(a[mid]==key){
                return mid;
            }
            else if(a[mid]>key){
                ub=mid-1;
            }
            else{
                lb=mid+1;
            }
        }
        return -1;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        
        System.out.println("enter no.of elements:");
        int n=sc.nextInt();
        int a[]=new int[n];
        System.out.println("enter the search element:");
        int key=sc.nextInt();
        System.out.println("enter the elements:");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        int index=BinarySearch(a,n,key);
            if(index==-1){
                System.out.println("Element not found");
            }
            else{
                System.out.println("Element "+key+" is found at index position:"+index);
            }
    }
}