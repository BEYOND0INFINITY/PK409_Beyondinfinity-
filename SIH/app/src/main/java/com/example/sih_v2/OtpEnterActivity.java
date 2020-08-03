package com.example.sih_v2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sih_v2.Helper.LocaleHelper;

import io.paperdb.Paper;

public class OtpEnterActivity extends AppCompatActivity {

    TextView Register;
    EditText otp;
    Button submit;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_enter);

        Register = findViewById(R.id.topText);
        otp = findViewById(R.id.name);
        submit = findViewById(R.id.submit);

        overridePendingTransition(0,0);
        View relativeLayout=findViewById(R.id.login_container);

        Animation animation= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        relativeLayout.startAnimation(animation);

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtpEnterActivity.this, MainActivity.class));
            }
        });
        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView((String)Paper.book().read("language"));
    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        Register.setText(resources.getString(R.string.register));
        otp.setText(resources.getString(R.string.otp));
        submit.setText(resources.getString(R.string.submit));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.language_en)
        {
            Paper.book().write("language","en");
            updateView((String)Paper.book().read("language"));
        }
        else if (item.getItemId() == R.id.language_hi)
        {
            Paper.book().write("language","hi");
            updateView((String)Paper.book().read("language"));
        }

        return true;
    }
}
