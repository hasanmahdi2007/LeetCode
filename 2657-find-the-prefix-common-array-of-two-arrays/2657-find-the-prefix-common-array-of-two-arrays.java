class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] c = new int[A.length];
        int[] holder = new int[A.length+1];
        for(int i = 0; i < A.length; i++){
            if(i != 0) c[i] = c[i-1];
            int a = A[i];
            int b = B[i];
            if(holder[a] == 1) c[i]++;
            else holder[a] = 1;
            if(holder[b] == 1) c[i]++;
            else holder[b] = 1;
        }
        return c;
    }
}