package hcmute.edu.vn.leafnote;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                Toast.makeText(NoteActivity.this, "Đã lưu bản ghi chú", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}