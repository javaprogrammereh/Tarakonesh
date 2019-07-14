package com.example.tarakonesh;

/*support telgram id =@javaprogrammer_eh
 * 24/03/1398
 * creted by elmira hossein zadeh*/

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

public class login extends AppCompatActivity {

    Button btnLogin;
    EditText edtUserName,edtPassword;
    userApp user = new userApp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        edtUserName = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);

        final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(this);
        user = sharedPreferencesManager.get_shared_preferences();
        user.setFirst_time_run(true);
        sharedPreferencesManager.set_false_first_time(user);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtUserName.getText().toString();
                String password = edtPassword.getText().toString();
                if (!userName.equals("") && !password.equals("")) {
                    Database.addLoginData(userName, password, getApplicationContext());
                    startActivity(new Intent(login.this, MainActivity.class));
                    login.this.finish();

                    final SharedPreferencesManager sharedPreferencesManager = new SharedPreferencesManager(login.this);
                    user = sharedPreferencesManager.get_shared_preferences();
                    user.setFirst_time_run(false);
                    sharedPreferencesManager.set_false_first_time(user);
                    Toast.makeText(login.this, "ثبت اطلاعات کاربری", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(login.this,  edtPassword.getText(), Toast.LENGTH_SHORT).show();
//                    Toast.makeText(login.this, edtPassword.getRawText(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(login.this, "لطفا اطلاعات را کامل کنید!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        login.this.finish();

    }
}
