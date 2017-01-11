package exchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExchangeSimulation {

    private List<Data> exchangeRateData;
    private static final double D_MIN = 0.0d;
    private static final double D_MAX = 100.0d;

    private void run() {
        generateData();
        printData();
        processData();
    }

    private void processData() {
        Data min = null;
        Data max = null;
        double difference = 0.0d;
        for (int i = 0; i < exchangeRateData.size(); i++) {
            Data tmpMin = exchangeRateData.get(i);
            for (int j = i + 1; j < exchangeRateData.size(); j++) {
                Data tmpMax = exchangeRateData.get(j);
                if (tmpMax.getRate() > tmpMin.getRate()) {
                    double tmpDiff = tmpMax.getRate() - tmpMin.getRate();
                    if (tmpDiff > difference) {
                        difference = tmpDiff;
                        max = tmpMax;
                        min = tmpMin;
                    }
                }
            }
        }
        System.out.println(difference);
        System.out.println("BUY: " + min.toString());
        System.out.println("SELL: " + max.toString());
    }

    private void generateData() {
        exchangeRateData = new ArrayList<>();
        for (int i = 0; i < 24; i++) {
            exchangeRateData.add(new Data(i, generateDouble()));
        }
    }

    private void printData() {
        for (Data d : exchangeRateData) {
            System.out.printf("%-10.2f", d.getRate());
        }
        System.out.println();
        for (Data d : exchangeRateData) {
            System.out.printf("%-10s", d.getTime());
        }
        System.out.println();
    }

    private Double generateDouble() {
        Random random = new Random();
        return D_MIN + (D_MAX - D_MIN) * random.nextDouble();
    }

    public static void main(String[] args) {
        new ExchangeSimulation().run();
    }

}
