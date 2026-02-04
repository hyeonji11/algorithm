package Level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class BestAlbum {
    public class Song {
        int[] ids;
        int sum;
        public Song(int[] ids, int sum) {
            this.ids = ids;
            this.sum = sum;
        }

        public void plusSum(int value) {
            this.sum += value;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Song> map = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            if(map.containsKey(genres[i])) {
                Song song = map.get(genres[i]);
                song.plusSum(plays[i]);
                if(plays[song.ids[0]] < plays[i]) {
                    song.ids[1] = song.ids[0];
                    song.ids[0] = i;
                } else if(song.ids[1] == -1 || plays[song.ids[1]] < plays[i]) {
                    song.ids[1] = i;
                }
            } else {
                map.put(genres[i], new Song(new int[] {i, -1}, plays[i]));
            }
        }

        return map.values().stream()
                .sorted(Comparator.comparingInt((Song s) -> s.sum).reversed())
                .flatMapToInt(song -> Arrays.stream(song.ids))
                .filter(id -> id != -1)
                .toArray();
    }
}
