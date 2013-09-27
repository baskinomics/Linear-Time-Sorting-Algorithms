/**
 *
 */
public class LinearTimeSort {

    private static final int BASE_10 = 10;
    /**
     *
     */
    public static int[] countingSort(int[] a, int k) {
        int[] b = new int[a.length];
        // Declare auxiliary array
        int[] c = new int[k + 1];
        // Zero out auxiliary array
        for (int i = 0; i <= k; i++) {
            c[i] = 0;
        }
        // 
        for (int i = 0; i < a.length; i++) {
            c[a[i]] = c[a[i]] + 1;
        }
        //
        for (int i = 1; i <= k; i++) {
            c[i] = c[i] + c[i - 1];
        }
        //
        for (int i = a.length - 1; i >= 0; i--) {
            b[c[a[i]] - 1] = a[i];
            c[a[i]] = c[a[i]] - 1;
        }
        return b;
    }

    public static int[] radixSort(int[] a, int k) {
        // d = 2-bit integers
        int d = 2;
        // w = x-bit integers
        int w;

        int kBitSize = Integer.toBinaryString(k).length();
        //
        if (kBitSize % 2 != 0)
            w = kBitSize + 1;
        else
            w = kBitSize;
        //
        int[] b = null;
        //
        for (int p = 0; p < w/d; p++) {
            //
            int c[] = new int[1<<d];
            // the next three for loops implement counting-sort
            b = new int[a.length];
            //
            for (int i = 0; i < a.length; i++) 
                c[(a[i] >> d*p)&((1<<d)-1)]++;
            //
            for (int i = 1; i < 1<<d; i++)
                c[i] += c[i-1];
            //
            for (int i = a.length-1; i >= 0; i--)
                b[--c[(a[i] >> d*p)&((1<<d)-1)]] = a[i];
            //
            a = b;
        }
        //
        return b;
    }

    public static int[] bucketSort(int[] a, int maxVal){
        int[] b = new int[a.length];

        int[] bucket=new int[maxVal+1];

        for (int i=0; i<bucket.length; i++){
            bucket[i]=0;
        }

        for (int i=0; i<a.length; i++){
            bucket[a[i]]++;
        }

        int outPos=0;
        for (int i=0; i<bucket.length; i++){
            for (int j=0; j<bucket[i]; j++){
                b[outPos++]=i;
            }
        }
        return b;
    }

    public static int getMax(int[] a) {
        //
        int max = 0;
        //
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }
}