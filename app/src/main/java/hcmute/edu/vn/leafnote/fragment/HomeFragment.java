package hcmute.edu.vn.leafnote.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hcmute.edu.vn.leafnote.R;

public class HomeFragment extends Fragment {

    TextView subNote;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //subNote = (TextView) findViewById(R.id.txtSubNewNote);

    }

    //Open Sub Note
//    public void setOpenSubNote() {
//        subNote.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent newNote = new Intent(HomeFragment.this, NoteActivity.class);
//                startActivity(newNote);
//            }
//        });
//    }
}
