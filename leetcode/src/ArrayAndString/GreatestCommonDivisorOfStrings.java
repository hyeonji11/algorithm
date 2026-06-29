package ArrayAndString;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        int str1Len = str1.length();
        int str2Len = str2.length();
        int gcd = 1;

        if(str1Len < str2Len)
            gcd = getGCD(str2Len, str1Len);
        else
            gcd = getGCD(str1Len, str2Len);

        StringBuilder sb1 = new StringBuilder("");

        for(int i = gcd; i >= 1; i--) {
            if(gcd % i == 0) {
                sb1.append(str1.substring(0, i));
                int val1 = str1Len / i;
                int val2 = str2Len / i;

                if(sb1.toString().repeat(val1).equals(str1) && sb1.toString().repeat(val2).equals(str2)) {
                    return sb1.toString();
                }
                sb1.setLength(0);
            }
        }

        return "";
    }

    public int getGCD(int a, int b) {
        if(b == 0)
            return a;
        return getGCD(b, a % b);
    }
}
