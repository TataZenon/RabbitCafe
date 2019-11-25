package ac.th.ssru.tarou.workshop.rabbitcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class MainActivity extends AppCompatActivity {

    private Button buttonfood;
    private Button buttonrabbit;
    private Button buttonrule;


    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*readFood();*/


        buttonfood = (Button) findViewById(R.id.btnFoodMenu);
        buttonrule = (Button) findViewById(R.id.btnRule);
        buttonrabbit = (Button) findViewById(R.id.btnBunMenu);

        buttonfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodMenu();
            }
        });
        buttonrule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRuleMenuMenu();
            }
        });
        buttonrabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openrabbitMenu();
            }
        });

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setTimestampsInSnapshotsEnabled(true)
                .build();
        firestore.setFirestoreSettings(settings);


    }

    /*private void readFood() {
        DocumentReference food = db.collection("food").document("1001");
                food.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()){
                            DocumentSnapshot doc = task.getResult();
                            StringBuilder data = new StringBuilder("");
                            data.append("Name: ").append(doc.getString("name"));
                            data.append("\nPrice: ") .append(doc.getString("price"));
                            data.append("\nimage: ") .append(doc.getString("img"));
                            txtDisplay.setText(data.toString());
                        }
                    }
                });
    }*/

    public void openFoodMenu(){
        Intent intent = new Intent(this, FoodMenuActivity.class);
        startActivity(intent);
    }

    public void openRuleMenuMenu(){
        Intent intent = new Intent(this,RuleMenu.class);
        startActivity(intent);
    }

    public void openrabbitMenu(){
        Intent intent = new Intent(this,RabbitMenu.class);
        startActivity(intent);
    }



}
