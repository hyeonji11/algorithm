package ArrayAndString;

public class StringCompression {
    public int compress(char[] chars) {
        int index = 0;
        char value = chars[0];
        int count = 1;

        for(int i=1; i<chars.length; i++) {
            if(value == chars[i]) {
                count++;
            } else {
                chars[index] = value;

                index = intToChar(index, count, chars);

                count = 1;
                index++;
                value = chars[i];
            }
        }

        chars[index] = value;
        index = intToChar(index, count, chars);

        return index;
    }

    public int intToChar(int index, int count, char[] chars) {
        if(count != 1) {
            int divisor = (int) Math.pow(10, (int) Math.log10(count));

            while(divisor > 0) {
                int digit = count / divisor;

                chars[++index] = (char)(digit+'0');

                count %= divisor;
                divisor /= 10;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        System.out.println(sc.compress(new char[]{'a','a','b','b','c','c','c'}));
    }
}
