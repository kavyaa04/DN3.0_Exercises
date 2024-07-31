import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice("AAPL", 150.00);
        stockMarket.setStockPrice("GOOGL", 2800.00);
    }

    interface Stock {
        void registerObserver(Observer observer);
        void deregisterObserver(Observer observer);
        void notifyObservers();
    }

    static class StockMarket implements Stock {
        private List<Observer> observers = new ArrayList<>();
        private String stockName;
        private double stockPrice;

        public void setStockPrice(String stockName, double stockPrice) {
            this.stockName = stockName;
            this.stockPrice = stockPrice;
            notifyObservers();
        }

        public void registerObserver(Observer observer) {
            observers.add(observer);
        }

        public void deregisterObserver(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(stockName, stockPrice);
            }
        }
    }

    interface Observer {
        void update(String stockName, double stockPrice);
    }

    static class MobileApp implements Observer {
        public void update(String stockName, double stockPrice) {
            System.out.println("MobileApp: Stock " + stockName + " is now $" + stockPrice);
        }
    }

    static class WebApp implements Observer {
        public void update(String stockName, double stockPrice) {
            System.out.println("WebApp: Stock " + stockName + " is now $" + stockPrice);
        }
    }
}

