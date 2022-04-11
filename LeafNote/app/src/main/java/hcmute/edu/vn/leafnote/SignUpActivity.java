package hcmute.edu.vn.leafnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }


    public void signupGoogle(View view) {
    }

    public void signupFacebook(View view) {
    }

    public void linkLogin(View view) {
        Intent linkLogin = new Intent(this, LoginActivity.class);
        startActivity(linkLogin);
    }

    public void signUpSuccess(View view) {
        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
        Intent linkLogin = new Intent(this, LoginActivity.class);
        startActivity(linkLogin);
    }
}