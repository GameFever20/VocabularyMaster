package utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

/**
 * Created by Aisha on 6/23/2018.
 */

public class FirebaseHandler {

    // Access a Cloud Firestore instance from your Activity
    FirebaseFirestore db;
    Context context;

    public FirebaseHandler(Context context) {
        this.context = context;
        db = FirebaseFirestore.getInstance();
    }

    public void uploadWord(Word word) {
        db.collection("words").document(word.getWordName())
                .set(word)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(context, "Uploaded", Toast.LENGTH_SHORT).show();
                        Log.d("Success", "DocumentSnapshot successfully written!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context, "Error Uploaded", Toast.LENGTH_SHORT).show();
                        Log.w("Error", "Error writing document", e);
                    }
                });

    }

    public void downloadWordByName(final String wordName) {
        DocumentReference docRef = db.collection("words").document(wordName);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Word word = documentSnapshot.toObject(Word.class);
                Toast.makeText(context, word.getWordName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void downloadWordByLevel(int level) {
        db.collection("words")
                .whereEqualTo("wordLevel", level)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Toast.makeText(context, "Level word " + document.getData(), Toast.LENGTH_SHORT).show();
                                Log.d("Success", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.d("Not Success", "Error getting documents: ", task.getException());
                        }
                    }
                });
    }
}
