package ac.th.ssru.tarou.workshop.rabbitcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button buttonfood;
    private Button buttonrabbit;
    private Button buttonrule;

    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseFirestore.getInstance();

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

        readFood();
    }

    private void readFood() {
        db.collection("food")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult() != null) {
                                List<FoodModel> downloadInfoList = task.getResult().toObjects(FoodModel.class);
                                for (FoodModel downloadInfo : downloadInfoList) {
                                    FoodModel model = new FoodModel(downloadInfo.name, downloadInfo.price, downloadInfo.img);
                                    FoodMenuActivity.addFoodModel(model);
                                }
                            }
                        }
                    }
                });
    }

    public void openFoodMenu(){
        if(FoodMenuActivity.food.size() == 6){
            Intent intent = new Intent(this, FoodMenuActivity.class);
            startActivity(intent);
        }
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
