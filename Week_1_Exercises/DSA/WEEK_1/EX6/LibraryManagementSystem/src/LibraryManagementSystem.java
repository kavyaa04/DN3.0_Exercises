class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

public class LibraryManagementSystem {

    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = title.compareToIgnoreCase(books[mid].getTitle());

            if (comparison == 0) {
                return books[mid];
            }
            if (comparison > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "To Kill a Mockingbird", "Harper Lee"),
            new Book(2, "1984", "George Orwell"),
            new Book(3, "Pride and Prejudice", "Jane Austen"),
            new Book(4, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        Book foundBook = linearSearch(books, "1984");
        System.out.println(foundBook != null ? "Found: " + foundBook.getTitle() : "Book not found");

        // Assuming books array is sorted by title
        foundBook = binarySearch(books, "Pride and Prejudice");
        System.out.println(foundBook != null ? "Found: " + foundBook.getTitle() : "Book not found");
    }
}
