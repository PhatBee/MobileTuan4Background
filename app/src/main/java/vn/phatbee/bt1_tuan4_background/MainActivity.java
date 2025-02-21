package vn.phatbee.bt1_tuan4_background;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int[] backgroundImages = {
            R.drawable.cat_1, R.drawable.cat_2, R.drawable.cat_3, R.drawable.cat_4,
            R.drawable.cat_5, R.drawable.logo, R.drawable.pizza, R.drawable.pop_1,
            R.drawable.pop_2, R.drawable.pop_3
    };


    ImageView backgroundImageView;
    Switch wallpaperSwitch;
    int currentIndex;
    int lastIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

//        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.ConstrainLayout1);
//        bg.setBackgroundColor(Color.BLUE);
//        bg.setBackgroundResource(R.drawable.background_intro);
        taoHinhNgauNhien();

        chuyenBackground();

    }

    private void chuyenBackground()
    {

        backgroundImageView = findViewById(R.id.imageButton1);
        wallpaperSwitch = findViewById(R.id.wallpaperSwitch);
        wallpaperSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                lastIndex = currentIndex;
                currentIndex = (currentIndex + 1) % backgroundImages.length;
                backgroundImageView.setImageResource(backgroundImages[currentIndex]);
            } else {
                currentIndex = lastIndex;
                backgroundImageView.setImageResource(backgroundImages[lastIndex]);
            }
        });
    }

    private void taoHinhNgauNhien()
    {
        ImageView BackgroundImage = findViewById(R.id.imageButton1);
        // Random Background
        Random random = new Random();
        int randomIndex = random.nextInt(backgroundImages.length);
        BackgroundImage.setImageResource(backgroundImages[randomIndex]);
        currentIndex = randomIndex;
    }
}