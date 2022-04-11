package hcmute.edu.vn.leafnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    TextView saveNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        addControl();
        setSaveNote();
    }

    private void addControl() {
        saveNote = (TextView) findViewById(R.id.txtSaveNote);
    }

    public void setSaveNote(){
        saveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NoteActivity.this, "Đã lưu ghi chú", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}