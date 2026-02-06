package Level1;

public class VideoPlayer {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int totalVideoLen = timeToSeconds(video_len);
        int current = timeToSeconds(pos);
        int opStart = timeToSeconds(op_start);
        int opEnd = timeToSeconds(op_end);

        for(int i = 0; i < commands.length; i++) {
            if(current >= opStart && current < opEnd) {
                current = opEnd;
            }

            if(commands[i].equals("next")) {
                if(current+10 >= totalVideoLen) {
                    current = totalVideoLen;
                } else {
                    current += 10;
                }
            } else {
                if(current-10 <= 0) {
                    current = 0;
                } else {
                    current -= 10;
                }
            }
        }

        if(current >= opStart && current < opEnd) {
            current = opEnd;
        }

        return secondToTime(current);
    }

    public int timeToSeconds(String time) {
        String[] times = time.split(":");
        int minute = Integer.parseInt(times[0]);
        int second = Integer.parseInt(times[1]);

        return minute * 60 + second;
    }

    public String secondToTime(int time) {
        int minute = time / 60;
        int second = time % 60;

        return String.format("%02d:%02d", minute, second);
    }
}
