package 回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 二进制手表_401 {
    public List<String> readBinaryWatch(int num) {
        ArrayList<int[]> allPossibleLeds = new ArrayList<>();
        this.setPossibleLeds(num, new int[10], 0, allPossibleLeds);
        return this.getTimes(allPossibleLeds);
    }

    private void setPossibleLeds(int num, int[] currentLeds, int startIndex, ArrayList<int[]> allPossibleLeds) {
        if (num == 0) {
            allPossibleLeds.add(Arrays.copyOf(currentLeds, currentLeds.length));
        } else {
            for (int i = startIndex; i < 10; i++) {
                currentLeds[i] = 1;
                this.setPossibleLeds(num - 1, currentLeds, i + 1, allPossibleLeds);
                currentLeds[i] = 0;
            }
        }
    }

    private List<String> getTimes(ArrayList<int[]> allPossibleLeds) {
        ArrayList<String> times = new ArrayList<>();
        for (int[] leds : allPossibleLeds) {
            int hour = 0;
            for (int i = 9; i >= 6; i--) {
                hour = (hour << 1) + leds[i];
            }
            if (!(hour >= 0 && hour <= 11)) {
                continue;
            }
            int minute = 0;
            for (int i = 5; i >= 0; i--) {
                minute = (minute << 1) + leds[i];
            }
            if (!(minute >= 0 && minute <= 59)) {
                continue;
            }
            times.add(hour + ":" + String.format("%02d", minute));
        }

        return times;
    }

    public static void main(String[] args) {
        new 二进制手表_401().readBinaryWatch(1);
    }
}
