package com.example.sih_v2.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.R;

import io.paperdb.Paper;

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

        /*making personal info visible*/
        personalinfo.setVisibility(View.VISIBLE);
        experience.setVisibility(View.GONE);
        review.setVisibility(View.GONE);


        personalinfobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                personalinfo.setVisibility(View.VISIBLE);
                experience.setVisibility(View.GONE);
                review.setVisibility(View.GONE);
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
        contact.setText(resources.getString(R.string.contact));
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