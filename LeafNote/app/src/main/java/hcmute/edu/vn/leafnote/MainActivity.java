package hcmute.edu.vn.leafnote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import hcmute.edu.vn.leafnote.fragment.HomeFragment;
import hcmute.edu.vn.leafnote.fragment.NoteFragment;
import hcmute.edu.vn.leafnote.fragment.TaskFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Open Search
    TextView search;

    //Open sub note
    TextView subNote;

    //Chọn ảnh
    ImageView imageView;
    int imagevalue;

    //Bắt đầu toolbar Menu
    Toolbar toolbar;

    //Bắt đầu khai báo Menu
    private DrawerLayout menuDrawerLayout;

    //Phân biệt fragment
    private static final int FRAGMENT_HOME = 0;
    private static final int FRAGMENT_NOTE = 1;
    private static final int FRAGMENT_TASK = 2;
    private static final int FRAGMENT_NOTEBOOK = 3;
    private static final int FRAGMENT_CARD = 4;
    private static final int FRAGMENT_SHARE = 5;
    private static final int FRAGMENT_BIN = 6;

    private int currentFragment = FRAGMENT_HOME;

    //Bắt đầu khai báo Button Bottom Sheet
    Button openBottomSheet;

    //Khai báo các thành phần khác giao diện chính
    TextView titleHeader, setDay;
    LinearLayout customHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        addControl();
        setRealTime();
        setDay();

        //Open search
        setOpenSearch();

        //Menu
        openMenu();

        //Bottom Sheet
        openBottomSheet();

        //Open new note
        //setOpenSubNote();


        //Nhận ảnh
        // initialise the layout
        imageView = findViewById(R.id.backGroundHeader);
        // check if any value sent from previous activity
        Bundle bundle = getIntent().getExtras();
        // if bundle is not null then get the image value
        if (bundle != null) {
            imagevalue = bundle.getInt("image");
        }
        imageView.setImageResource(imagevalue);


        //Control Header
        customHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent custom = new Intent(MainActivity.this, CustomActivity.class);
                startActivity(custom);
            }
        });
    }

    private void addControl() {
        //Start Header
        customHeader = (LinearLayout) findViewById(R.id.CustomHeader);
        titleHeader = (TextView) findViewById(R.id.txtTitleHeader);
        setDay = (TextView) findViewById(R.id.txtSetDay);

        //Open search
        search = (TextView) findViewById(R.id.openSearch);

        //Start Menu
        menuDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        //Start NavBottom
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //Start Bottom Sheet
        openBottomSheet = (Button) findViewById(R.id.openBottomSheet);

        //Sub note
        //subNote = (TextView) findViewById(R.id.txtSubNewNote);
    }

    //Open Sub Note
    public void setOpenSubNote() {
        subNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newNote = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(newNote);
            }
        });
    }

    //Open Search
    public void setOpenSearch() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openSearch = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(openSearch);
            }
        });
    }

    //Cài đặt cho menu
    public void openMenu() {
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this, menuDrawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        menuDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        replaceFragment(new NoteFragment());
        navigationView.getMenu().findItem(R.id.nav_menu_home).setChecked(true);
    }

    //Cài đặt click item cho menu
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_menu_home) {
            if(currentFragment != FRAGMENT_HOME){
                replaceFragment(new HomeFragment());
                currentFragment = FRAGMENT_HOME;
            }
        } else if (id == R.id.nav_menu_note){
            if(currentFragment != FRAGMENT_NOTE){
                replaceFragment(new NoteFragment());
                currentFragment = FRAGMENT_NOTE;
            }
        } else if (id == R.id.nav_menu_task){
            if(currentFragment != FRAGMENT_TASK){
                replaceFragment(new TaskFragment());
                currentFragment = FRAGMENT_TASK;
            }
        }

        menuDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(menuDrawerLayout.isDrawerOpen(GravityCompat.START)){
            menuDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //Thay thế fragment khi click
    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, fragment);
        transaction.commit();
    }

    //Cài đặt Bottom Sheet
    public void openBottomSheet() {
        openBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "TAG");
            }
        });
    }


    //Cài đặt ngày Header
    public void setRealTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("H");
        int hour = Integer.parseInt(sdf.format(c.getTime()));
        if (hour < 10 && hour >= 0) {
            titleHeader.setText("Xin chào buổi sáng");
        } else if (hour >= 10 && hour <= 18) {
            titleHeader.setText("Chúc buổi trưa vui vẻ");
        } else if (hour > 18 && hour <= 23) {
            titleHeader.setText("Buổi tối tốt lành");
        }
    }

    public void setDay() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat day = new SimpleDateFormat("d");
        SimpleDateFormat month = new SimpleDateFormat("M");
        SimpleDateFormat year = new SimpleDateFormat("y");
        int Day = Integer.parseInt(day.format(c.getTime()));
        int Month = Integer.parseInt(month.format(c.getTime()));
        int Year = Integer.parseInt(year.format(c.getTime()));
        setDay.setText("Ngày " + Day + " tháng " + Month + " năm " + Year);
    }
}