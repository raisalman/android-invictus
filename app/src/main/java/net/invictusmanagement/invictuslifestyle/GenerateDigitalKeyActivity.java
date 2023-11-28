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
import android.widget.LinearLayout;
import android.widget.Spinner;

import net.invictusmanagement.invictuslifestyle.fragments.GuestKeyFragment;
import net.invictusmanagement.invictuslifestyle.fragments.QuickKeyFragment;

public class GenerateDigitalKeyActivity extends AppCompatActivity {


    Spinner spinner;
    FrameLayout fragment_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_generate_digital_key);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_action_back);
//        /*getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onBackPressed();
//            }````
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner=findViewById(R.id.spnKeyType);
        fragment_container=findViewById(R.id.fragment_container);

        String[] items = {"Generate Guest Key", "Generate Quick Key"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                Fragment selectedFragment;
                if (pos==1){
                   selectedFragment= new QuickKeyFragment();
                }else{
                    selectedFragment= new GuestKeyFragment();
                }
                replaceFragment(selectedFragment);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); // Optional: Add the transaction to the back stack
        transaction.commit();
    }
}