package enricopdg.database;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import enricopdg.objects.Book;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class FirebaseService {
    private static Firestore db;
    private static final String collection = "books";
    public static void init() {
        try {
            FileInputStream serviceAccount =
                    new FileInputStream("/home/enrico/projects/java/Demo/chaves/chave-desafio.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://desafio-asenjo-a89cb-default-rtdb.firebaseio.com")
                    .build();
            FirebaseApp.initializeApp(options);

            db = FirestoreClient.getFirestore();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void insertBook(Book book) {
        try {
            ApiFuture<WriteResult> future = db.collection(collection).document(book.getTitle()).set(book);
            System.out.println("Update time: " + future.get().getUpdateTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void searchBook(Book book) {
        try {
            CollectionReference books = db.collection(collection);

            Query query = books.whereEqualTo("title", book.getTitle());

            ApiFuture<QuerySnapshot> querySnapshot = query.get();

            for (DocumentSnapshot document : querySnapshot.get().getDocuments() ) {
                System.out.println(document.getData());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteBook(Book book) {
        try {
            ApiFuture<WriteResult> writeResult = db.collection(collection).document(book.getTitle()).delete();
            System.out.println("Update time: " + writeResult.get().getUpdateTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateBook(Book book) {
        try {
            DocumentReference docRef = db.collection(collection).document(book.getTitle());
            Map<String, Object> data = new HashMap<>();
            data.put("author", book.getAuthor());
            data.put("publisher", book.getPublisher());
            data.put("year", book.getYear());
            data.put("location", book.getLocation());

            ApiFuture<WriteResult> writeResult = docRef.update(data);
            System.out.println("Update time: " + writeResult.get().getUpdateTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
