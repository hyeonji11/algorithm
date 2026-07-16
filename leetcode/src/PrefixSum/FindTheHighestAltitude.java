package PrefixSum;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length+1];
        int max = 0;

        for(int i=0; i < gain.length; i++) {
            altitude[i+1] = altitude[i] + gain[i];
            max = Math.max(altitude[i+1], max);
        }

        return max;
    }
}
