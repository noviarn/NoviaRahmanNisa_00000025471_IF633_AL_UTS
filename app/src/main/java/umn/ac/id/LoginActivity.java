package umn.ac.id;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText enterUsername, enterPW;
    Button submitLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        enterUsername = findViewById(R.id.enter_username);
        enterPW = findViewById(R.id.enter_pw);
        submitLogin = findViewById(R.id.submit_lg);

        submitLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (enterUsername.getText().toString().equals("uasmobile") &&
                enterPW.getText().toString().equals("uasmobilegenap")){
                    Intent intent = new Intent(LoginActivity.this, MusicListActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),
                            "Invalid username/password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}