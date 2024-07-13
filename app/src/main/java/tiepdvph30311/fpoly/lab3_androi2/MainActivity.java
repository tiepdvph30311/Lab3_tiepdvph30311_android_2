package tiepdvph30311.fpoly.lab3_androi2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn1,btn2,btn3,btn4;
    Context context=MainActivity.this;
    @SuppressLint("MissingInflatedId")
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
        btn1=findViewById(R.id.id_btn1);
        btn2=findViewById(R.id.id_btn2);
        btn3=findViewById(R.id.id_btn3);
        btn4=findViewById(R.id.id_btn4);
        // thông báo
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle("Thông báo !");
                builder.setMessage("Nội dung chọn");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Đồng ý",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Không Đồng ý",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        //single choice
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arr={"Xanh","Đỏ","Vàng"};
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                // tạo các thành phần trong builder
                builder.setTitle("lựa chọn 2");
                // set single choice cho builder
                builder.setSingleChoiceItems(arr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"bạn chọn :"+arr[i],Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog= builder.create();
                dialog.show();
            }
        });
        //mutiple choice
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String[] arr={"Xanh","Đỏ","Vàng"};
//                AlertDialog.Builder builder= new AlertDialog.Builder(context);
//                // tạo các thành phần trong builder
//                builder.setTitle("lựa chọn 2");
//                // set single choice cho builder
//                builder.setMultiChoiceItems(arr, null, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                        Toast.makeText(getApplicationContext(),"bạn chọn :"+arr[i],Toast.LENGTH_LONG).show();
//                    }
//                });
//                AlertDialog dialog= builder.create();
//                dialog.show();
//            }
//        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] arr = {"Xanh", "Đỏ", "Vàng"};
                boolean[] checkedItems = new boolean[arr.length]; // Trạng thái của các mục đã chọn
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Lựa chọn 2");
                builder.setMultiChoiceItems(arr, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                        if (isChecked) {
                            for (int i = 0; i < checkedItems.length; i++) {
                                if (i != which) {
                                    checkedItems[i] = false;
                                    ((AlertDialog) dialogInterface).getListView().setItemChecked(i, false);
                                }
                            }
                            Toast.makeText(getApplicationContext(), "Bạn chọn: " + arr[which], Toast.LENGTH_LONG).show();
                        }
                    }
                });
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Xử lý sự kiện khi nhấn nút OK nếu cần
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(context);

                LayoutInflater inflater=getLayoutInflater();
                View view1=inflater.inflate(R.layout.dialogdemo3,null);
                builder.setView(view1);
                //ánh xạ
                final EditText edu=view1.findViewById(R.id.id_edu);
                final EditText edp=view1.findViewById(R.id.id_edp);
                // thêm các thành phần khác
                builder.setTitle("Bạn Muốn");
                builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Thoát đăng nhập",Toast.LENGTH_LONG).show();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });

    }
}