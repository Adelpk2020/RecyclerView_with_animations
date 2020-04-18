package com.example.fzaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    DataAdapter dataAdapter;
    List<DataModel> mData;
    FloatingActionButton fabswitcher;
    boolean isDark=false;
    ConstraintLayout rootLayout;
    EditText searchInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // let's make this activity on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //hide action Bar
        getSupportActionBar().hide();
        //init view
        fabswitcher=findViewById(R.id.fab_switcher);
        rootLayout=findViewById(R.id.root_layout);
        recyclerView = findViewById(R.id.data_rv);
        searchInput=findViewById(R.id.searchview);
        mData = new ArrayList<>();

        // load theme state

        isDark = getThemeStatePref();
        if(isDark) {
            // dark theme is on
           searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.black));

        }
        else
        {
            // light theme is on
           searchInput.setBackgroundResource(R.drawable.search_input_style);
            rootLayout.setBackgroundColor(getResources().getColor(R.color.white));

        }

        //fill list with data

        mData.add(new DataModel("OnePlus 6T Camera Review:", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.user));
        mData.add(new DataModel("I love Programming And Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,", "6 july 1994", R.drawable.circul6));
        mData.add(new DataModel("My first trip to Thailand story ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.uservoyager));
        mData.add(new DataModel("After Facebook Messenger, Viber now gets...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "6 july 1994", R.drawable.useillust));
        mData.add(new DataModel("Isometric Design Grid Concept", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "6 july 1994", R.drawable.circul6));
        mData.add(new DataModel("Android R Design Concept 4K", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "6 july 1994", R.drawable.user));
        mData.add(new DataModel("OnePlus 6T Camera Review:", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.user));
        mData.add(new DataModel("I love Programming And Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,", "6 july 1994", R.drawable.circul6));
        mData.add(new DataModel("My first trip to Thailand story ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.uservoyager));
        mData.add(new DataModel("After Facebook Messenger, Viber now gets...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "6 july 1994", R.drawable.useillust));
        mData.add(new DataModel("Isometric Design Grid Concept", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "6 july 1994", R.drawable.circul6));
        mData.add(new DataModel("Android R Design Concept 4K", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "6 july 1994", R.drawable.user));
        mData.add(new DataModel("OnePlus 6T Camera Review:", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.user));
        mData.add(new DataModel("I love Programming And Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,", "6 july 1994", R.drawable.circul6));
        mData.add(new DataModel("My first trip to Thailand story ", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", "6 july 1994", R.drawable.uservoyager));
        mData.add(new DataModel("After Facebook Messenger, Viber now gets...", "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,", "6 july 1994", R.drawable.useillust));
        mData.add(new DataModel("Isometric Design Grid Concept", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit", "6 july 1994", R.drawable.circul6));
        mData.add(new DataModel("Android R Design Concept 4K", "lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit lorem ipsum dolor sit ", "6 july 1994", R.drawable.user));

        dataAdapter=new DataAdapter(this,mData,isDark);
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        fabswitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDark=!isDark;
                if(isDark)
                {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.black));
                    searchInput.setBackgroundResource(R.drawable.search_input_dark_style);
                }
                else
                {
                    rootLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    searchInput.setBackgroundResource(R.drawable.search_input_style);
                }
                dataAdapter=new DataAdapter(getApplicationContext(),mData,isDark);
                recyclerView.setAdapter(dataAdapter);
                saveThemeStatePre(isDark);
            }
        });

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                dataAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void saveThemeStatePre(boolean isDark) {
        SharedPreferences preferences=getApplicationContext().getSharedPreferences("my pref",MODE_PRIVATE);
        SharedPreferences.Editor editor=preferences.edit();
        editor.putBoolean("isDark",isDark);
        editor.commit();
    }
    private boolean getThemeStatePref() {
        SharedPreferences preferences=getApplicationContext().getSharedPreferences("my pref",MODE_PRIVATE);
        boolean isDark=preferences.getBoolean("isDark",false);
        return isDark;
    }
}
