public class FinancialForecasting {

   
    public static double calculateFutureValue(double initialValue, double growthRate, int periods) {

        if (periods == 0) {
            return initialValue;
        }
        
        return calculateFutureValue(initialValue * (1 + growthRate / 100), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000;  
        double growthRate = 5;       
        int periods = 10;            

        double futureValue = calculateFutureValue(initialValue, growthRate, periods);
        System.out.println("Future Value: " + futureValue);
    }
}

