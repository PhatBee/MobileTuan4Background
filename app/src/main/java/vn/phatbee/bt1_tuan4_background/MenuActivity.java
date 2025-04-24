package vn.phatbee.bt1_tuan4_background;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnPopup = findViewById(R.id.btnShowPopup);

        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MenuActivity.this, v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_setting, popupMenu.getMenu());

                // Xử lý khi chọn menu
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int id = item.getItemId();

                        if (id == R.id.menuSetting) {
                            Toast.makeText(MenuActivity.this, "Chọn Setting", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (id == R.id.menuShare) {
                            Toast.makeText(MenuActivity.this, "Chọn Share", Toast.LENGTH_SHORT).show();
                            return true;
                        } else if (id == R.id.menuLogout) {
                            Toast.makeText(MenuActivity.this, "Chọn Logout", Toast.LENGTH_SHORT).show();
                            return true;
                        }
                        return false;
                    }
                });

                popupMenu.show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuSetting) {
            Toast.makeText(this, "Bạn chọn Setting", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menuShare) {
            Toast.makeText(this, "Bạn chọn Share", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.menuLogout) {
            Toast.makeText(this, "Bạn chọn Logout", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}