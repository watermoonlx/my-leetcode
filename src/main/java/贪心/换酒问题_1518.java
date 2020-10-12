package 贪心;

public class 换酒问题_1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles == 0 || numExchange == 0) {
            return 0;
        }
        int total = 0;
        int leftEmptyBottles = 0;
        do {
            total += numBottles;
            int newBottles = (numBottles + leftEmptyBottles) / numExchange;
            leftEmptyBottles = (numBottles + leftEmptyBottles) % numExchange;
            numBottles = newBottles;
        } while (numBottles > 0);

        return total;
    }
}
