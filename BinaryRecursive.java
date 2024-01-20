import java.util.Scanner;
public class BinaryRecursive{
    public static int BinaryRecursive(int a[],int lb,int ub,int key){
        if(lb<=ub){
            int mid=(lb+ub)/2;
            if(a[mid]==key){
                return mid;
            }
            else if(a[mid]>key){
                return BinaryRecursive(a,lb,mid-1,key);
            }
            else{
                return BinaryRecursive(a,mid+1,ub,key);
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
        int lb=0;
        int ub=n-1;
        int index=BinaryRecursive(a,lb,ub,key);
            if(index==-1){
                System.out.println("Element not found");
            }
            else{
                System.out.println("Element "+key+" is found at index position:"+index);
            }
    }
}