public class Test {
    public static void main(String args[]){
        int []arr1 =new int[]{1, 4, 5, 7};
        int []arr2=new int[]{10, 20, 30, 40};
        int x=32;
        printClosestTwoPointer(arr1,arr2,x);

    }


    public static void printClosestTwoPointer(int []arr1,int []arr2, int x){
        int n1=arr1.length;
        int n2=arr2.length;

        int diff=Integer.MAX_VALUE;

        int index1=0;
        int index2=0;
        int itr1=0;
        int itr2=n2-1;


        while (itr1<n1 && itr2>=0){
            int v1=arr1[itr1];
            int v2=arr2[itr2];

            int diff2= (v1+v2)-x;

            if(diff2>=0 && diff2<diff){
                index1=itr1;
                index2=itr2;
            }

            if(diff2<0){
                //increase v1
                itr1++;
            }
            else if(diff2==0){
                index1=itr1;
                index2=itr2;
                break;
                //break;
                //answer reached

            }
            else if(diff2>0){
                itr2--;
                //decerease v2

            }

        }
        System.out.println(arr1[index1]+" : "+arr2[index2]);


    }

    public static void printClosest(int []arr1,int []arr2, int x){
        int n1=arr1.length;
        int n2=arr2.length;
        int index1=0;
        int index2=0;

        int value=Integer.MAX_VALUE;

        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                int v1=arr1[i];
                int v2=arr2[j];
                int val=Math.abs(v1+v2-x);

                if(val<value){
                    index1=i;
                    index2=j;
                    value=val;
                }

            }
        }


//        int value=Integer.MAX_VALUE;
//        int index1=0;
//        int index2=0;
//
//        int itr1=0;
//        int itr2=0;
//
//
//        while (itr1<n1 && itr2<n2){
//
//            int v1=arr1[itr1];
//            int v2=arr2[itr2];
//
//            int val=Math.abs(v1+v2-x);
//            if(val<value){
//                value=val;
//                index1=itr1;
//                index2=itr2;
//            }
//
//
//            if(v1<v2 && itr1+1<n1){
//                itr1++;
//            }
//            else if(v1<v2 && itr2+1<n2){
//                itr2++;
//            }
//            else if(v1>v2 && itr2+1<n2){
//                itr2++;
//            }
//            else if(v1>v2 && itr1+1<n1){
//                itr1++;
//            }
//            else if(v1==v2 && itr2+1<n2){
//                itr2++;
//            }
//            else{
//                itr1++;
//            }
//
//        }
        System.out.println(arr1[index1]+" : "+arr2[index2]);

    }


}
