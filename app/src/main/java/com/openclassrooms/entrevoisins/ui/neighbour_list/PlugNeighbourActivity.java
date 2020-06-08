package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;

import org.w3c.dom.Text;

public class PlugNeighbourActivity extends AppCompatActivity {

private ImageView mAvatar;
private FloatingActionButton mFavorite;
private TextView mName;
private TextView mIdName;
private TextView mCountry;
private TextView mPhoneNumber;
private TextView mInternetLink;
private TextView mAbout;
private TextView mAboutMe;




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
        mAbout = findViewById(R.id.about);
        mAboutMe = findViewById(R.id.aboutMe);

    }

    public ImageView getAvatar() {
        return mAvatar;
    }

    public void setAvatar(ImageView avatar) {
        mAvatar = avatar;
    }


    public FloatingActionButton getFavorite() {
        return mFavorite;
    }

    public void setFavorite(FloatingActionButton favorite) {
        mFavorite = favorite;
    }

    public TextView getName() {
        return mName;
    }

    public void setName(TextView name) {
        mName = name;
    }

    public TextView getIdName() {
        return mIdName;
    }

    public void setIdName(TextView idName) {
        mIdName = idName;
    }

    public TextView getCountry() {
        return mCountry;
    }

    public void setCountry(TextView country) {
        mCountry = country;
    }

    public TextView getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(TextView phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public TextView getInternetLink() {
        return mInternetLink;
    }

    public void setInternetLink(TextView internetLink) {
        mInternetLink = internetLink;
    }

    public TextView getAbout() {
        return mAbout;
    }

    public void setAbout(TextView about) {
        mAbout = about;
    }

    public TextView getAboutMe() {
        return mAboutMe;
    }

    public void setAboutMe(TextView aboutMe) {
        mAboutMe = aboutMe;
    }
}
