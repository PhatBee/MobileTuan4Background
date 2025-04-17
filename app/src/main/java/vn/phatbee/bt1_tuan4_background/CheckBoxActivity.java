package vn.phatbee.bt1_tuan4_background;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_check_box);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        CheckBox ck1 = (CheckBox) findViewById(R.id.checkBox);
        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.main);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bg.setBackgroundResource(R.drawable.background_intro);
                } else {
                    bg.setBackgroundResource(R.drawable.ic_launcher_background);
                }
            }
        });

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(CheckBoxActivity.this, BackgroundActivity.class);
            startActivity(intent);
        });
    }
}