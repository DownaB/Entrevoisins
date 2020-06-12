package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

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





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug_neighbour);

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

            }
        });

    }




}
