package com.example.myapplication12;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bn = (Button) findViewById(R.id.bn);
        bn.setOnClickListener(new MyClickListener());
        Button button = (Button) findViewById(R.id.buttonTest);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View v=inflater.inflate(R.layout.login_dialog,null);


                builder.setView(v)
                        .setTitle("Login").setPositiveButton("登录", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            // login

                            EditText userId = (EditText) v.findViewById(R.id.editTextUserId);
                            EditText pwd = (EditText) v.findViewById(R.id.editTextPwd);


                            String u=userId.getText().toString();
                            String p=pwd.getText().toString();
                            if(u.equals("ABC")&&p.equals("123")){
                                Toast.makeText(MainActivity.this, "用户登录成功", Toast.LENGTH_LONG).show();
                            }else{
                                Toast.makeText(MainActivity.this, "用户登录失败", Toast.LENGTH_LONG).show();
                            }
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                                Toast.makeText(MainActivity.this, "用户取消登录", Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });
    }


    class MyClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v){
            TextView txt1 = (TextView) findViewById(R.id.txt);
            txt1.setText("Hello World！！！");
        }
    }

}
