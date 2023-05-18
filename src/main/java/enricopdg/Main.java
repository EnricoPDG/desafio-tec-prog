package enricopdg;

import enricopdg.database.FirebaseService;
import enricopdg.objects.Book;

public class Main {
    public static void main(String[] args) {
        FirebaseService.init();
        Book l1 = new Book();
        l1.setTitle("Aprendendo Firebase");
        l1.setAuthor("Enrico");
        l1.setPublisher("Tech");
        l1.setYear("2023");
        l1.setLocation("A2");

        FirebaseService.insertBook(l1);
        FirebaseService.searchBook(l1);
        FirebaseService.updateBook(l1);
        FirebaseService.deleteBook(l1);

    }
}