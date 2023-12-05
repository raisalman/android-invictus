package net.invictusmanagement.invictuslifestyle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import net.invictusmanagement.invictuslifestyle.fragments.GuestKeyFragment;
import net.invictusmanagement.invictuslifestyle.fragments.QuickKeyFragment;

public class GenerateDigitalKeyActivity extends AppCompatActivity {


    Spinner spinner;
    FrameLayout fragment_container;
    private RadioGroup radioGroup;
    private RadioButton rbGuestKey;
    private RadioButton rbQuickKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_digital_key);


        radioGroup = findViewById(R.id.radioGroup);
        rbGuestKey = findViewById(R.id.rbGuestKey);
        rbQuickKey = findViewById(R.id.rbQuickKey);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_action_back);
        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setResult(1);
//                finish();
                onBackPressed();
            }
        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        spinner=findViewById(R.id.spnKeyType);
        fragment_container=findViewById(R.id.fragment_container);

//        String[] items = {"Guest Key", "Quick Key"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
//
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        spinner.setAdapter(adapter);


        // Set a listener for the RadioGroup
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Handle the radio button selection change
                switch (checkedId) {
                    case R.id.rbGuestKey:
                        replaceFragment(new GuestKeyFragment());
                        break;
                    case R.id.rbQuickKey:
                        replaceFragment(new QuickKeyFragment());
                        break;
                }
            }
        });

//        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
//                Fragment selectedFragment;
//                if (pos==1){
//                   selectedFragment= new QuickKeyFragment();
//                }else{
//                    selectedFragment= new GuestKeyFragment();
//                }
//                replaceFragment(selectedFragment);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}