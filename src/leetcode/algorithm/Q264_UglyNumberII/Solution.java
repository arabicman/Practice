package leetcode.algorithm.Q264_UglyNumberII;

public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return 1;      //1 is 1st ugly number

        int arr[]=new int [n];
        arr[0]=1;

        int p2=0;
        int p3=0;
        int p5=0;

        for(int i=1;i<n;i++){
            arr[i]=Math.min(arr[p2]*2,Math.min(arr[p3]*3,arr[p5]*5));

            if(arr[i]==arr[p2]*2) p2++;
            if(arr[i]==arr[p3]*3) p3++;
            if(arr[i]==arr[p5]*5) p5++;
        }
        return arr[n-1];
    }
}
