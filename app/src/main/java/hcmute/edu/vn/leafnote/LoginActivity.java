package hcmute.edu.vn.leafnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void loginGoogle(View view) {
        Toast.makeText(this, "Đăng nhập bằng Google", Toast.LENGTH_SHORT).show();
    }

    public void loginFacebook(View view) {
        Toast.makeText(this, "Đăng nhập bằng Facebook", Toast.LENGTH_SHORT).show();
    }

    public void linkSignUp(View view) {
        Intent linkSignUp = new Intent(this, SignUpActivity.class);
        startActivity(linkSignUp);
    }

    public void loginSuccess(View view) {
        Intent linkHome = new Intent(this, MainActivity.class);
        startActivity(linkHome);
        //Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }
}