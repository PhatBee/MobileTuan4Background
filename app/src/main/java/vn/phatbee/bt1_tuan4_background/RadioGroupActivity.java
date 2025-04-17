package vn.phatbee.bt1_tuan4_background;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_group);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //RadioGroup
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
        ConstraintLayout bg = (ConstraintLayout) findViewById(R.id.main);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(v -> {
            finish();
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton) {
                    bg.setBackgroundResource(R.drawable.background_intro);
                } else if (checkedId == R.id.radioButton2) {
                    bg.setBackgroundResource(R.drawable.ic_launcher_background);
                }
            }
        });
    }
}