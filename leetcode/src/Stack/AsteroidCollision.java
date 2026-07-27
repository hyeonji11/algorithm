package Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new LinkedList<Integer>();

        for(int i=0; i<asteroids.length; i++) {
            if(list.size() == 0) {
                list.add(asteroids[i]);
            } else {
                int peek = ((LinkedList<Integer>) list).getLast();
                if(asteroids[i] < 0 && peek > 0) {
                    while(peek > 0 && list.size() != 0) {
                        if(peek + asteroids[i] < 0) {
                            ((LinkedList<Integer>) list).removeLast();

                            if(list.size() == 0) {
                                list.add(asteroids[i]);
                                break;
                            }
                            peek = ((LinkedList<Integer>) list).getLast();
                            if(peek < 0) list.add(asteroids[i]);
                        }
                        else if(peek + asteroids[i] == 0) {
                            ((LinkedList<Integer>) list).removeLast();
                            break;
                        } else {
                            break;
                        }
                    }
                    continue;
                }
                list.add(asteroids[i]);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        AsteroidCollision a = new AsteroidCollision();
        int[] a1 = a.asteroidCollision(new int[]{-2, -2, 1, -2});
        System.out.println(Arrays.toString(a1));
    }
}
