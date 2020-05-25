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
private TextView mAboutMe;
private FloatingActionButton mFavorite;
private TextView mName;
private TextView mPresentation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plug_neighbour);

        mAvatar = findViewById(R.id.avatar);
        mFavorite = findViewById(R.id.favorite);
        mName =  findViewById(R.id.nameNeighbour);
        mAboutMe = findViewById(R.id.aboutMe);
        mPresentation = findViewById(R.id.presentation);
    }

    public ImageView getAvatar() {
        return mAvatar;
    }

    public void setAvatar(ImageView avatar) {
        mAvatar = avatar;
    }

    public TextView getAboutMe() {
        return mAboutMe;
    }

    public void setAboutMe(TextView aboutMe) {
        mAboutMe = aboutMe;
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

    public TextView getPresentation() {
        return mPresentation;
    }

    public void setPresentation(TextView presentation) {
        mPresentation = presentation;
    }
}
