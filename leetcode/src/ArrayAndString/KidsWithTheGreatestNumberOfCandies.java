package ArrayAndString;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValue = 0;

        List<Boolean> result = new ArrayList<Boolean>();

        for(int value : candies) {
            maxValue = Math.max(maxValue, value);
        }

        for(int i=0; i<candies.length; i++) {
            if(candies[i] + extraCandies >= maxValue)
                result.add(true);
            else
                result.add(false);
        }

        return result;
    }
}
