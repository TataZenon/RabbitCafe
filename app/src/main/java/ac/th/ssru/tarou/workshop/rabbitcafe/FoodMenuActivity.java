package ac.th.ssru.tarou.workshop.rabbitcafe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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

    public static ArrayList<FoodModel> food = new ArrayList<>(6);

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



        name1.setText(food.get(0).getName());
        name2.setText(food.get(1).getName());
        name3.setText(food.get(2).getName());
        name4.setText(food.get(3).getName());
        name5.setText(food.get(4).getName());
        name6.setText(food.get(5).getName());

        price1.setText(food.get(0).getPrice());
        price2.setText(food.get(1).getPrice());
        price3.setText(food.get(2).getPrice());
        price4.setText(food.get(3).getPrice());
        price5.setText(food.get(4).getPrice());
        price6.setText(food.get(5).getPrice());

        Glide.with(img1).load(food.get(0).getImg()).into(img1);
        Glide.with(img2).load(food.get(1).getImg()).into(img2);
        Glide.with(img3).load(food.get(2).getImg()).into(img3);
        Glide.with(img4).load(food.get(3).getImg()).into(img4);
        Glide.with(img5).load(food.get(4).getImg()).into(img5);
        Glide.with(img6).load(food.get(5).getImg()).into(img6);
    }

    public static void addFoodModel(FoodModel model) {
        food.add(model);
    }
}
