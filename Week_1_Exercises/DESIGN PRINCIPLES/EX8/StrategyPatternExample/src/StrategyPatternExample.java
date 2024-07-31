public class StrategyPatternExample {

    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "12/23");
        PaymentStrategy payPalPayment = new PayPalPayment("user@example.com");

        paymentContext.setPaymentStrategy(creditCardPayment);
        paymentContext.executePayment(100.00);

        paymentContext.setPaymentStrategy(payPalPayment);
        paymentContext.executePayment(200.00);
    }

    interface PaymentStrategy {
        void pay(double amount);
    }

    static class CreditCardPayment implements PaymentStrategy {
        private String cardNumber;
        private String expiryDate;

        CreditCardPayment(String cardNumber, String expiryDate) {
            this.cardNumber = cardNumber;
            this.expiryDate = expiryDate;
        }

        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
        }
    }

    static class PayPalPayment implements PaymentStrategy {
        private String email;

        PayPalPayment(String email) {
            this.email = email;
        }

        public void pay(double amount) {
            System.out.println("Paid $" + amount + " using PayPal: " + email);
        }
    }

    static class PaymentContext {
        private PaymentStrategy paymentStrategy;

        public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
        }

        public void executePayment(double amount) {
            paymentStrategy.pay(amount);
        }
    }
}

