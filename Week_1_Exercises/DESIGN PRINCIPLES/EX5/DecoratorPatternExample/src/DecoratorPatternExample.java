public class DecoratorPatternExample {

    public static void main(String[] args) {
        Notifier emailNotifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        slackNotifier.send();
    }

    interface Notifier {
        void send();
    }

    static class EmailNotifier implements Notifier {
        public void send() {
            System.out.println("Sending email notification");
        }
    }

    abstract static class NotifierDecorator implements Notifier {
        protected Notifier notifier;

        NotifierDecorator(Notifier notifier) {
            this.notifier = notifier;
        }

        public void send() {
            notifier.send();
        }
    }

    static class SMSNotifierDecorator extends NotifierDecorator {
        SMSNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send() {
            super.send();
            System.out.println("Sending SMS notification");
        }
    }

    static class SlackNotifierDecorator extends NotifierDecorator {
        SlackNotifierDecorator(Notifier notifier) {
            super(notifier);
        }

        public void send() {
            super.send();
            System.out.println("Sending Slack notification");
        }
    }
}

