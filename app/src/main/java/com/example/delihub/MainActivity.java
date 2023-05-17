package com.example.delihub;

import static com.example.delihub.R.layout.activity_main;
import static com.example.delihub.R.layout.profilelogin;
import static com.example.delihub.R.layout.profilelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerCategories;
    RecyclerView recyclerItems;

    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);



        recyclerCategories = findViewById(R.id.recycler_categories);
        recyclerItems = findViewById(R.id.recycler_deli);


        imageButton = (ImageButton) findViewById(R.id.imgbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {openprofilelogin();
            }

        });

        setCategories();
        setDeliItem(0);


    }
    public void openprofilelogin(){
        Intent intent = new Intent(this,ProfileLogin.class);
        startActivity(intent);
    }



    private void setCategories(){
        List<DeliCategories> data = new ArrayList<>();

        DeliCategories deliCategories = new DeliCategories("EasyCoach",R.drawable.easycoach);
        DeliCategories deliCategories2 = new DeliCategories("UberEats",R.drawable.eats);
        DeliCategories deliCategories3= new DeliCategories("Glovo",R.drawable.glovo);
        DeliCategories deliCategories4= new DeliCategories("Posta",R.drawable.posta);
        DeliCategories deliCategories5= new DeliCategories("Tahmeed",R.drawable.tahmeed);
        DeliCategories deliCategories6= new DeliCategories("Uber",R.drawable.uber);

        data.add(deliCategories);
        data.add(deliCategories2);
        data.add(deliCategories3);
        data.add(deliCategories4);
        data.add(deliCategories5);
        data.add(deliCategories6);


        DelicatAdapter deli_adapter = new DelicatAdapter(data, MainActivity.this, new DelicatAdapter.OnCategoryClick() {
            @Override
            public void onClick(int pos) {
                setDeliItem(pos);
            }
        });

        recyclerCategories.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.HORIZONTAL,false));
        recyclerCategories.setAdapter(deli_adapter);
        deli_adapter.notifyDataSetChanged();
    }

    private void setDeliItem(int pos ){
        List<Deli_Item> deliItems = new ArrayList<>();
        switch (pos){
            case 0:
                Deli_Item deli_item = new Deli_Item("EasyCoach Nairobi",4.0f,300,R.drawable.easycoach);
                Deli_Item deli_item2 = new Deli_Item("EasyCoach Mombasa",4.5f,400,R.drawable.easycoach);
                Deli_Item deli_item3 = new Deli_Item("EasyCoach Kisumu",4.0f,350,R.drawable.easycoach);
                Deli_Item deli_item4 = new Deli_Item("EasyCoach Kisumu",4.0f,350,R.drawable.easycoach);

                deliItems.add(deli_item);
                deliItems.add(deli_item2);
                deliItems.add(deli_item3);
                deliItems.add(deli_item4);

                break;
            case 1:
                Deli_Item deli_item7 = new Deli_Item("Eats Nairobi",4.0f,300,R.drawable.eats);
                Deli_Item deli_item8 = new Deli_Item("Eats Mombasa",4.5f,400,R.drawable.eats);
                Deli_Item deli_item9 = new Deli_Item("Eats Kisumu",4.0f,350,R.drawable.eats);
                Deli_Item deli_item10 = new Deli_Item("Eats Embu ",4.5f,200,R.drawable.eats);


                deliItems.add(deli_item7);
                deliItems.add(deli_item8);
                deliItems.add(deli_item9);
                deliItems.add(deli_item10);

                break;
            case 5:
                Deli_Item deli_item13 = new Deli_Item("Uber Nairobi",4.0f,300,R.drawable.uber);
                Deli_Item deli_item14 = new Deli_Item("Uber Mombasa",4.5f,400,R.drawable.uber);
                Deli_Item deli_item15 = new Deli_Item("Uber Kisumu",4.0f,350,R.drawable.uber);
                Deli_Item deli_item16 = new Deli_Item("Uber Embu ",4.5f,200,R.drawable.uber);


                deliItems.add(deli_item13);
                deliItems.add(deli_item14);
                deliItems.add(deli_item15);
                deliItems.add(deli_item16);

                break;
            case 2:
                Deli_Item deli_item19 = new Deli_Item("Glovo Nairobi",4.0f,300,R.drawable.glovo);
                Deli_Item deli_item20 = new Deli_Item("Glovo Mombasa",4.5f,400,R.drawable.glovo);
                Deli_Item deli_item21 = new Deli_Item("Glovo Kisumu",4.0f,350,R.drawable.glovo);
                Deli_Item deli_item22 = new Deli_Item("Glovo Embu ",4.5f,200,R.drawable.glovo);


                deliItems.add(deli_item20);
                deliItems.add(deli_item21);
                deliItems.add(deli_item19);
                deliItems.add(deli_item22);

                break;
            case 3:
                Deli_Item deli_item25 = new Deli_Item("Posta Nairobi",4.0f,300,R.drawable.posta);
                Deli_Item deli_item26 = new Deli_Item("Posta Mombasa",4.5f,400,R.drawable.posta);
                Deli_Item deli_item27 = new Deli_Item("Posta Kisumu",4.0f,350,R.drawable.posta);
                Deli_Item deli_item28 = new Deli_Item("Posta Embu ",4.5f,200,R.drawable.posta);


                deliItems.add(deli_item25);
                deliItems.add(deli_item26);
                deliItems.add(deli_item27);
                deliItems.add(deli_item28);

                break;
            case 4:
                Deli_Item deli_item31 = new Deli_Item("Tahmeed Nairobi",4.0f,300,R.drawable.tahmeed);
                Deli_Item deli_item32 = new Deli_Item("Tahmeed Mombasa",4.5f,400,R.drawable.tahmeed);
                Deli_Item deli_item33 = new Deli_Item("Tahmeed Kisumu",4.0f,350,R.drawable.tahmeed);
                Deli_Item deli_item34 = new Deli_Item("Tahmeed Embu ",4.5f,200,R.drawable.tahmeed);


                deliItems.add(deli_item31);
                deliItems.add(deli_item32);
                deliItems.add(deli_item33);
                deliItems.add(deli_item34);

                break;
        }

        DeliAdapter deliAdapter = new DeliAdapter(deliItems);
        recyclerItems.setLayoutManager(new LinearLayoutManager(MainActivity.this,RecyclerView.HORIZONTAL,false));

        recyclerItems.setAdapter(deliAdapter);
        deliAdapter.notifyDataSetChanged();

    }
}

