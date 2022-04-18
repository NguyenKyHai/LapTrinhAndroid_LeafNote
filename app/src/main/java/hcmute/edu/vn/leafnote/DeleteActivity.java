package hcmute.edu.vn.leafnote;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DeleteActivity extends AppCompatActivity {

    TextView seenDeleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        addControl();
        closeSeenDeleted();
    }

    //Đóng thùng rác
    private void closeSeenDeleted() {
        seenDeleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void addControl() {
        seenDeleted = (TextView) findViewById(R.id.txtSeenDeleted);
    }
}