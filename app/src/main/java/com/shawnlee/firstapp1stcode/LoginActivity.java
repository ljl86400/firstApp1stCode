package com.shawnlee.firstapp1stcode;


import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;




public class LoginActivity extends BaseActivity implements OnClickListener{
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountEdit = (EditText) findViewById(R.id.account_edit_text);
        passwordEdit = (EditText) findViewById(R.id.password_edit_text);
        login = (Button) findViewById(R.id.log_in_button);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.log_in_button:
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin") && password.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this,FirstActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(this,"账号或密码错误",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}

