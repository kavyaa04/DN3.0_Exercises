public class AdapterPatternExample {

    public static void main(String[] args) {
        PaymentProcessor paypalAdapter = new PaypalAdapter(new PaypalPaymentGateway());
        PaymentProcessor stripeAdapter = new StripeAdapter(new StripePaymentGateway());

        paypalAdapter.processPayment(100.00);
        stripeAdapter.processPayment(200.00);
    }

    // Step 2: Define Target Interface
    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Step 3: Implement Adaptee Classes
    static class PaypalPaymentGateway {
        void makePayment(double amount) {
            System.out.println("Processing payment through Paypal: $" + amount);
        }
    }

    static class StripePaymentGateway {
        void charge(double amount) {
            System.out.println("Processing payment through Stripe: $" + amount);
        }
    }

    // Step 4: Implement the Adapter Class
    static class PaypalAdapter implements PaymentProcessor {
        private PaypalPaymentGateway paypal;

        PaypalAdapter(PaypalPaymentGateway paypal) {
            this.paypal = paypal;
        }

        public void processPayment(double amount) {
            paypal.makePayment(amount);
        }
    }

    static class StripeAdapter implements PaymentProcessor {
        private StripePaymentGateway stripe;

        StripeAdapter(StripePaymentGateway stripe) {
            this.stripe = stripe;
        }

        public void processPayment(double amount) {
            stripe.charge(amount);
        }
    }
}
