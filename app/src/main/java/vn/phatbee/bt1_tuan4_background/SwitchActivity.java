package vn.phatbee.bt1_tuan4_background;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SwitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_switch);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Switch sw = (Switch) findViewById(R.id.switch1);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) { //isChecked = true
                    Toast.makeText(SwitchActivity.this, "Wifi đang bật", Toast.LENGTH_LONG).show(); }
                else{
                        Toast.makeText(SwitchActivity.this, "Wifi đang tắt", Toast.LENGTH_LONG).show();
                    }
                }
        });

        btnNext.setOnClickListener(v -> {
            Intent intent = new Intent(SwitchActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }
}