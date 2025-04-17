package vn.phatbee.bt1_tuan4_background;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class BackgroundLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_background_layout);


        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.constraintLayout1);
        Button btnNext = (Button) findViewById(R.id.btnNext);
//        bg.setBackgroundColor(Color.BLUE);
//        bg.setBackgroundResource(R.drawable.top_background2);

        // Random background
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(R.drawable.top_background1);
        arrayList.add(R.drawable.top_background2);
        arrayList.add(R.drawable.ic_launcher_background);
        arrayList.add(R.drawable.ic_launcher_foreground);
        Random random = new Random();
        int vitri = random.nextInt(arrayList.size());
        bg.setBackgroundResource(arrayList.get(vitri));

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(BackgroundLayoutActivity.this, SwitchActivity.class);
            startActivity(intent);
        });
    }
}