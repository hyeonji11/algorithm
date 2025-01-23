package Level2;

import java.util.*;

public class TaskProgress {
    public class Task {
        String name;
        int start;
        int playTime;

        public Task(String name, int start, int playTime) {
            this.name = name;
            this.start = start;
            this.playTime = playTime;
        }
    }
    public String[] solution(String[][] plans) {
        Stack<Task> stack = new Stack<>();
        ArrayList<Task> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i=0; i<plans.length; i++) {
            String[] time = plans[i][1].split(":");
            list.add(new Task(plans[i][0], Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]), Integer.parseInt(plans[i][2])));
        }

        Collections.sort(list, Comparator.comparingInt(o -> o.start));

        for(int i=0; i<list.size()-1; i++) {
            Task cur = list.get(i);
            Task next = list.get(i+1);

            int gap = next.start - cur.start;
            stack.push(cur);

            while(!stack.isEmpty()) {
                Task last = stack.pop();
                if(gap < last.playTime) {
                    last.playTime -= gap;
                    stack.push(last);
                    break;
                }
                result.add(last.name);
                gap -= last.playTime;
            }
        }
        stack.push(list.get(list.size()-1));

        while(!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        return result.toArray(new String[0]);
    }
    public static void main(String[] args) {
        TaskProgress tp = new TaskProgress();
        tp.solution(new String[][] {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
    }
}
