package com.example.sih_v2.Profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.MainActivity;
import com.example.sih_v2.R;
import com.example.sih_v2.Settings.SettingsActivity;

import org.jetbrains.annotations.NotNull;

import io.paperdb.Paper;
import nl.joery.animatedbottombar.AnimatedBottomBar;

public class ProfileActivity extends AppCompatActivity {

    LinearLayout personalinfo, experience, review;
    TextView personalinfobtn;

    TextView profile,sih,verify,dev,rate,contact,edit;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile = findViewById(R.id.profile);
        sih = findViewById(R.id.sih);
        dev = findViewById(R.id.dev);
        rate = findViewById(R.id.rate);
        contact = findViewById(R.id.contact);
        verify = findViewById(R.id.verify);
        edit = findViewById(R.id.edit);

        personalinfo = findViewById(R.id.personalinfo);
        personalinfobtn = findViewById(R.id.personalinfobtn);


        AnimatedBottomBar animatedBottomBar = findViewById(R.id.animatedBottomBar);
        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.Home:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0,0);
                        break;
                    case R.id.Profile:
                        break;
                    case R.id.settings:
                        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                        overridePendingTransition(0,0);
                        break;
                }
            }
        });





        /*making personal info visible*/

        personalinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                personalinfo.setVisibility(View.VISIBLE);
                //review.setVisibility(View.GONE);
                personalinfobtn.setTextColor(getResources().getColor(R.color.blue));
            }
        });



        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView(Paper.book().read("language"));

    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        profile.setText(resources.getString(R.string.profile));
        sih.setText(resources.getString(R.string.sih_v2));
        dev.setText(resources.getString(R.string.android_developer));
        rate.setText(resources.getString(R.string.rate_us));
        verify.setText(resources.getString(R.string.verification_done));
        edit.setText(resources.getString(R.string.edit));
        personalinfobtn.setText(resources.getString(R.string.user_info));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.language_en)
        {
            Paper.book().write("language","en");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_hi)
        {
            Paper.book().write("language","hi");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_ta)
        {
            Paper.book().write("language","ta");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_mr)
        {
            Paper.book().write("language","mr");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_bn)
        {
            Paper.book().write("language","bn");
            updateView(Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_pa)
        {
            Paper.book().write("language","pa");
            updateView(Paper.book().read("language"));
        }

        return true;
    }

}