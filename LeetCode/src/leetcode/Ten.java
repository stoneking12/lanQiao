package leetcode;

import jdk.nashorn.internal.runtime.FindProperty;

/**
 * @author wl
 * @Data 2020-02-17 9:19
 */
public class Ten {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[] b = {2,3,5,6,8,9,12};
        double res = findMedianSortedArrays(a,b);
        System.out.println(res);
        int  sum = 0;
        for(int i = 1; i <= 10; i++)
        {
            sum += i;
        }
        System.out.println(sum);
    }

    /**
     * 4. Ѱ�����������������λ��
     * @param A
     * @param B
     * @return
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
            //findMedianSortedArrays(B,A);
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}