package Level1;

public class CheckPersonalityType {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int[] res = new int[4];
        String[][] types = {{"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"}};

        for(int i=0; i<survey.length; i++) {
            int val = choices[i] - 4;
            switch (survey[i]) {
                case "RT": case "TR": {
                    if(survey[i].equals("TR")) {
                        val *= -1;
                    }
                    res[0] += val;
                    break;
                }
                case "CF": case "FC": {
                    if(survey[i].equals("FC")) {
                        val *= -1;
                    }
                    res[1] += val;
                    break;
                }
                case "JM": case "MJ": {
                    if(survey[i].equals("MJ")) {
                        val *= -1;
                    }
                    res[2] += val;
                    break;
                }
                case "AN": case "NA": {
                    if(survey[i].equals("NA")) {
                        val *= -1;
                    }
                    res[3] += val;
                    break;
                }
            }
        }

        for(int i=0; i<res.length; i++) {
            if(res[i] <= 0) {
                answer.append(types[i][0]);
            } else {
                answer.append(types[i][1]);
            }
        }

        return answer.toString();
    }
    public static void main(String[] args) {

    }
}
