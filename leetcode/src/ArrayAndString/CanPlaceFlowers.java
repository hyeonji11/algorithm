package ArrayAndString;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for(int i=0; i<flowerbed.length; i++) {
            boolean isLeftEmpty = (i == 0) || (flowerbed[i-1] == 0);
            boolean isRightEmpty = (i+1 == flowerbed.length) || (flowerbed[i+1] == 0);

            if(flowerbed[i] == 0 && isLeftEmpty && isRightEmpty) {
                n--;
                flowerbed[i] = 1;
                if(n <= 0) break;
            }

        }

        if(n <= 0) return true;
        return false;

    }
}
