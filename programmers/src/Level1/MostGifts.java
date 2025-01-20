package Level1;

import java.util.Arrays;
import java.util.HashMap;

public class MostGifts {
    public int solution(String[] friends, String[] gifts) {

        HashMap<String, int[]> giftMap = new HashMap<>();
        HashMap<String, Integer> indexMap = new HashMap<>();
        int[] resultArr = new int[friends.length]; //받는선물

        for(int i=0; i<friends.length; i++) {
            indexMap.put(friends[i], i);
            giftMap.put(friends[i], new int[friends.length]);
        }

        for(int i=0; i<gifts.length; i++) {
            String[] strArr = gifts[i].split(" ");
            int[] arr = giftMap.get(strArr[0]);
            arr[indexMap.get(strArr[1])]++;
        }

        for(int i=0; i<friends.length; i++) {
            for(int j=i+1; j<friends.length; j++) {
                int aGive = giftMap.get(friends[i])[indexMap.get(friends[j])];
                int bGive = giftMap.get(friends[j])[indexMap.get(friends[i])];

                if(aGive > bGive) {
                    resultArr[indexMap.get(friends[i])]++;
                } else if(aGive < bGive) {
                    resultArr[indexMap.get(friends[j])]++;
                } else {
                    int aGiftIndex = Arrays.stream(giftMap.get(friends[i])).sum();
                    int bGiftIndex = Arrays.stream(giftMap.get(friends[j])).sum();

                    for(int k=0; k<friends.length; k++) {
                        aGiftIndex -= giftMap.get(friends[k])[indexMap.get(friends[i])];
                        bGiftIndex -= giftMap.get(friends[k])[indexMap.get(friends[j])];
                    }
                    if(aGiftIndex < bGiftIndex) {
                        resultArr[indexMap.get(friends[j])]++;
                    } else if(aGiftIndex > bGiftIndex) {
                        resultArr[indexMap.get(friends[i])]++;
                    }
                }
            }
        }

        return Arrays.stream(resultArr).max().getAsInt();
    }
    public static void main(String[] args) {

    }
}
