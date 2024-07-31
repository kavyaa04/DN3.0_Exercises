public class ProxyPatternExample {

    public static void main(String[] args) {
        Image image = new ProxyImage("http://example.com/largeimage.jpg");

        image.display(); // Image will be loaded and displayed
        image.display(); // Image will be retrieved from cache
    }

    interface Image {
        void display();
    }

    static class RealImage implements Image {
        private String url;

        RealImage(String url) {
            this.url = url;
            loadFromServer();
        }

        private void loadFromServer() {
            System.out.println("Loading image from " + url);
        }

        public void display() {
            System.out.println("Displaying image from " + url);
        }
    }

    static class ProxyImage implements Image {
        private RealImage realImage;
        private String url;

        ProxyImage(String url) {
            this.url = url;
        }

        public void display() {
            if (realImage == null) {
                realImage = new RealImage(url);
            }
            realImage.display();
        }
    }
}

