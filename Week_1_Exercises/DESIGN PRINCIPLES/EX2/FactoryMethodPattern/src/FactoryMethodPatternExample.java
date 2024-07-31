public class FactoryMethodPatternExample {

    public static void main(String[] args) {
        DocumentFactory wordFactory = new WordDocumentFactory();
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        DocumentFactory excelFactory = new ExcelDocumentFactory();

        Document wordDoc = wordFactory.createDocument();
        Document pdfDoc = pdfFactory.createDocument();
        Document excelDoc = excelFactory.createDocument();

        wordDoc.display();
        pdfDoc.display();
        excelDoc.display();
    }

    // Step 2: Define Document Interface
    interface Document {
        void display();
    }

    // Step 3: Concrete Document Classes
    static class WordDocument implements Document {
        public void display() {
            System.out.println("Displaying Word Document");
        }
    }

    static class PdfDocument implements Document {
        public void display() {
            System.out.println("Displaying PDF Document");
        }
    }

    static class ExcelDocument implements Document {
        public void display() {
            System.out.println("Displaying Excel Document");
        }
    }

    // Step 4: Define DocumentFactory
    abstract static class DocumentFactory {
        public abstract Document createDocument();
    }

    // Step 4: Concrete Factories
    static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }
}
