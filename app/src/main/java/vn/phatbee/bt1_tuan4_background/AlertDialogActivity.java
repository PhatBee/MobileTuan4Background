package vn.phatbee.bt1_tuan4_background;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AlertDialogActivity extends AppCompatActivity {

    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btnLogout = findViewById(R.id.btnLogout2    );

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XacNhanXoa(0); // Vị trí 0, bạn có thể truyền vị trí item trong ListView nếu muốn
            }
        });
    }

    private void XacNhanXoa(final int vitri) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Thông báo");
        alert.setMessage("Bạn có muốn đăng xuất không?");

        alert.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogActivity.this, "Đã đăng xuất", Toast.LENGTH_SHORT).show();
                // Thực hiện hành động đăng xuất, ví dụ:
                finish(); // thoát khỏi Activity hiện tại
            }
        });

        alert.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(AlertDialogActivity.this, "Hủy thao tác", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        alert.show();
    }
}
