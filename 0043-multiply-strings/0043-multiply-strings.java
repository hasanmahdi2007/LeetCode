class Solution {
    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] product = new int[n + m];
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';    
                int currentSum = digit1 * digit2 + product[i + j + 1];
                product[i + j + 1] = currentSum % 10;
                product[i + j] += currentSum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int val : product) {
            if (sb.length() == 0 && val == 0) {
                continue;
            }
            sb.append(val);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}