package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.w3c.dom.Text;

import java.io.Serializable;

public class PlugNeighbourActivity extends AppCompatActivity implements Serializable {

private ImageView mAvatar;
private FloatingActionButton mFavorite;
private TextView mName;
private TextView mIdName;
private TextView mCountry;
private TextView mPhoneNumber;
private TextView mInternetLink;
private TextView mAboutMe;
private Neighbour neighbour;
private String avatar;
private NeighbourApiService mApiService;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug_neighbour);
        setSupportActionBar(findViewById(R.id.toolbar2));
        setupActionBar();


        mAvatar = findViewById(R.id.avatar);
        mFavorite = findViewById(R.id.favorite);
        mName =  findViewById(R.id.nameNeighbour);
        mIdName = findViewById(R.id.name);
        mCountry = findViewById(R.id.country);
        mPhoneNumber = findViewById(R.id.phoneNumber);
        mInternetLink = findViewById(R.id.internetLink);
        mAboutMe = findViewById(R.id.aboutMe);

        Intent intent = getIntent();
        neighbour = (Neighbour) getIntent().getSerializableExtra("neighbour");
        mName.setText(neighbour.getName());
        mIdName.setText(neighbour.getName());
        mCountry.setText(neighbour.getAddress());
        mPhoneNumber.setText(neighbour.getPhoneNumber());
        mAboutMe.setText(neighbour.getAboutMe());
        Glide.with(this).load(neighbour.getAvatarUrl()).into(mAvatar);
        mInternetLink.setText(getResources().getString(R.string.facebook)+neighbour.getName());

        mFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            mApiService = DI.getNeighbourApiService();
            mApiService.addFavoriteNeighbours(neighbour);
            mFavorite.setImageResource(android.R.drawable.star_big_off  );
                Toast.makeText(PlugNeighbourActivity.this,"Ajouté aux favoris", Toast.LENGTH_SHORT).show();


            }
        });

    }

    private void setupActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
               onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
