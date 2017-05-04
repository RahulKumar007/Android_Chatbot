package bot.android.com.proto2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    EditText txtUsername, txtPassword;
    Button btnLogin;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        session = new SessionManager(getApplicationContext());

        txtUsername = (EditText) findViewById(R.id.Username);
        txtPassword = (EditText) findViewById(R.id.Password);
        btnLogin = (Button) findViewById(R.id.Loginbutton);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if (username.trim().length() > 0
                        && password.trim().length() > 0) {
                    if ((username.equals("rahul9056@gmail.com")||username.equals("khushaalchoudhary@gmail.com")) && password.equals("root123")) {
                        session.createLoginSession(username);
                        Intent i = new Intent(LogIn.this,MainActivity.class);
                        startActivity(i);

                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong Password or Email", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Password and Email", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

