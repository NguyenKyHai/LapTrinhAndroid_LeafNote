package hcmute.edu.vn.leafnote;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import hcmute.edu.vn.leafnote.dao.UserDao;
import hcmute.edu.vn.leafnote.database.DBConnection;
import hcmute.edu.vn.leafnote.entity.Users;

public class SignUpActivity extends AppCompatActivity {

    EditText edtUsername, edtPassword, edtName, edtEmail, edtConfirm;
    Button btnDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        AnhXa();

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser();
            }
        });

    }

    private void AnhXa() {
        edtUsername = (EditText) findViewById(R.id.edtSignUpUserName);
        edtPassword = (EditText) findViewById(R.id.edtSignUpPassword);
        edtName = (EditText) findViewById(R.id.edtSignUpName);
        edtEmail = (EditText) findViewById(R.id.edtSignUpEmail);
        edtConfirm = (EditText) findViewById(R.id.edtConfirmSignUpPassword);
        btnDangKy = (Button) findViewById(R.id.btnSignUp);
    }

    private void addUser(){
        String username = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String confirm = edtConfirm.getText().toString().trim();
        String name = edtName.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();

        Users users = new Users(username, password, name, email);
        DBConnection db = Room.databaseBuilder(getApplicationContext(), DBConnection.class, "leafnote.db")
                .allowMainThreadQueries()
                .build();
        UserDao userDao = db.userDao();
        userDao.insert(users);
        Toast.makeText(this, users.toString(), Toast.LENGTH_LONG).show();
    }

    public void signupGoogle(View view) {
    }

    public void signupFacebook(View view) {
    }

    public void linkLogin(View view) {
        Intent linkLogin = new Intent(this, LoginActivity.class);
        startActivity(linkLogin);
    }

//    public void signUpSuccess(View view) {
//        Toast.makeText(this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
//        Intent linkLogin = new Intent(this, LoginActivity.class);
//        startActivity(linkLogin);
//    }
}