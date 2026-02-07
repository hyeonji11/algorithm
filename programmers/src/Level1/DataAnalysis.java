package Level1;

import java.util.Arrays;
import java.util.Comparator;

public class DataAnalysis {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int index = convertToInt(ext);
        int sortBy =  convertToInt(sort_by);

        return Arrays.stream(data)
                .filter(item -> item[index] < val_ext)
                .sorted(Comparator.comparingInt(a -> a[sortBy]))
                .toArray(int[][]::new);
    }

    public int convertToInt(String input) {
        switch (input) {
            case "date":
                return 1;
            case "maximum":
                return 2;
            case "remain":
                return 3;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        DataAnalysis dataAnalysis = new DataAnalysis();
        dataAnalysis.solution(new int[][] {{1, 20300104, 100, 80}, {2, 20300804, 847, 37}, {3, 20300401, 10, 8}}, "date", 20300501, "remain");
    }
}
