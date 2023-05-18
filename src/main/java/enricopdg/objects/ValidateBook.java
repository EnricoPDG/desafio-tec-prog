package enricopdg.objects;

public class ValidateBook {
    public static void validateBook(Book book) throws Exception {
        if (book.getTitle().equals("")) {
            throw new Exception("Livro sem titulo, preenchimento obrigatório");
        }

        if (book.getAuthor().equals("")) {
            throw new Exception("Livro sem autor, preenchimento obrigatório");
        }

        if (book.getPublisher().equals("")) {
            throw new Exception("Livro sem editora, preenchimento obrigatório");
        }

        if (book.getYear().equals("")) {
            throw new Exception("Livro sem ano, preenchimento obrigatório");
        }

        if (book.getLocation().equals("")) {
            throw new Exception("Livro sem localização, preenchimento obrigatório");
        }

        try {
            Integer.parseInt(book.getYear());
        } catch (Exception e) {
            throw e;
        }
    }
}
