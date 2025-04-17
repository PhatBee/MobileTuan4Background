package vn.phatbee.bt1_tuan4_background;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProgressBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_progress_bar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView img2 = (ImageView) findViewById(R.id.img2);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(ProgressBarActivity.this, SignupActivity.class);
            startActivity(intent);
        });

        //progrebar
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar2);
//        img2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int current = progressBar.getProgress();
//                progressBar.setProgress(current + 10);
//            }
//        });
//
//        img2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int current = progressBar.getProgress();
////chạy đều đều >100 quay về 0
//                if (current>= progressBar.getMax()){
//                    current=0;
//                }
//                progressBar.setProgress(current + 10); //thiết lập progress
//            }
//        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//tự đếm progress
                CountDownTimer countDownTimer = new CountDownTimer(10000,1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        int current = progressBar.getProgress();
//chạy đều đều >100 quay về 0
                        if (current>= progressBar.getMax()){
                            current=0;
                        }
                        progressBar.setProgress(current + 10); //thiết lập progress
                    }
                    @Override
                    public void onFinish() {
                        Toast.makeText(ProgressBarActivity.this,"Hết giờ", Toast.LENGTH_LONG).show();
                    }
                };
                countDownTimer.start();
            }
        });
    }




}