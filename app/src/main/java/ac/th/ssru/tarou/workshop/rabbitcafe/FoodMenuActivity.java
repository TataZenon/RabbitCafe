package ac.th.ssru.tarou.workshop.rabbitcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class FoodMenuActivity extends AppCompatActivity {
    public TextView name1,name2,name3,name4,name5,name6;
    public android.widget.TextView price1,price2,price3,price4,price5,price6;
    public ImageView img1,img2,img3,img4,img5,img6;

    FirebaseFirestore db;
    ArrayList<FoodModel> food = new ArrayList<>(6);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);

        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        name3 = (TextView) findViewById(R.id.name3);
        name4 = (TextView) findViewById(R.id.name4);
        name5 = (TextView) findViewById(R.id.name5);
        name6 = (TextView) findViewById(R.id.name6);

        price1 = (TextView) findViewById(R.id.price1);
        price2 = (TextView) findViewById(R.id.price2);
        price3 = (TextView) findViewById(R.id.price3);
        price4 = (TextView) findViewById(R.id.price4);
        price5 = (TextView) findViewById(R.id.price5);
        price6 = (TextView) findViewById(R.id.price6);

        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);

        db = FirebaseFirestore.getInstance();
//        db.collection("food").orderBy("id").startAt(1).endAt(6).get()
//                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
//                        if(task.isSuccessful()){
//                            QuerySnapshot document = task.getResult();
//                            for(int i=0; i<6; i++){
//                                if(document.getDocuments().get(i).exists()){
//                                    String na = document.getDocuments().get(i).get("name").toString();
//                                    String pr = document.getDocuments().get(i).get("price").toString();
//                                    String im = document.getDocuments().get(i).get("img").toString();
//                                    System.out.println(na);
//                                    addItem(na, pr, im);
//                                }
//                            }
//                        }
//                    }
//                });

        db.collection("food")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            if (task.getResult() != null) {
                                List<FoodModel> downloadInfoList = task.getResult().toObjects(FoodModel.class);
                                for (FoodModel downloadInfo : downloadInfoList) {
                                    FoodModel model = new FoodModel(downloadInfo.name, downloadInfo.price, downloadInfo.image);
                                    addFoodModel(model);
                                }
                            }
                        }
                    }
                });

//        name1.setText(food.get(0).getName());
//        name1.setText(food.get(1).getName());
//        name1.setText(food.get(2).getName());
//        name1.setText(food.get(3).getName());
//        name1.setText(food.get(4).getName());
//        name1.setText(food.get(5).getName());
//
//        price1.setText(food.get(0).getPrice());
//        price1.setText(food.get(1).getPrice());
//        price1.setText(food.get(2).getPrice());
//        price1.setText(food.get(3).getPrice());
//        price1.setText(food.get(4).getPrice());
//        price1.setText(food.get(5).getPrice());
    }

    private void addFoodModel(FoodModel model) {
        food.add(model);
        System.out.println(food.get(0).getName());
    }
}
