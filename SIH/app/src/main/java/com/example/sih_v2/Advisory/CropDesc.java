package com.example.sih_v2.Advisory;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sih_v2.Helper.LocaleHelper;
import com.example.sih_v2.R;

import io.paperdb.Paper;

public class CropDesc extends AppCompatActivity {
    //,
    TextView Crop, Type, Variety;
    String cropNew, typeNew, varietyNew, desc;

    TextView crop_descr,type,crop,variety,Maturity;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_desc);

        crop_descr = (TextView)findViewById(R.id.topText);
        type = (TextView)findViewById(R.id.textView);
        crop = (TextView)findViewById(R.id.textView1);
        variety = (TextView)findViewById(R.id.textView2);
        Maturity = (TextView)findViewById(R.id.textView3);

        Crop = (TextView)findViewById(R.id.text);
        Type = (TextView)findViewById(R.id.crop);
        Variety = (TextView)findViewById(R.id.var);
        Intent intent = getIntent();
        String str = intent.getStringExtra("crop");
        String str1 = intent.getStringExtra("type");
        String str2 = intent.getStringExtra("variety");
        Crop.setText(str);
        Type.setText(str1);
        Variety.setText(str2);
        TextView maturity = (TextView) findViewById(R.id.mat);

        cropNew = Crop.toString();
        typeNew = Type.toString();
        varietyNew = Variety.toString();

        if (typeNew.equals("Cereal")){
            if (cropNew.equals("Finger Millet")){
                //maturity = (TextView)findViewById(R.id.mat);
                //maturity.setText("Late 125-130");
                desc = "Late 125-130";
                maturity.setText(desc.toString());
            }

            else if(cropNew.equals("Maize")){
                if (varietyNew.equals("Hishell (MCH-42) (Hybrid)") || varietyNew.equals("HM-12 (HKH 313) Hybrid") || varietyNew.equals("KMH 3712 (Hybrid)") || varietyNew.equals("KMH-218 Plus (Hybrid)") || varietyNew.equals("KMH-25K60 (Hybrid)") || varietyNew.equals("KMH-3426 (Hybrid)") || varietyNew.equals("NMH-803 (Hybrid)")){
                    //maturity = (TextView)findViewById(R.id.mat);
                    maturity.setText(getResources().getString(R.string.mat1));
                    //desc = "c";
                    //maturity.setText(desc);
                }
                else if (varietyNew == "NMH-731 (Hybrid)" || varietyNew == "SMH-3904"){
                    //maturity = (TextView)findViewById(R.id.mat);
                    maturity.setText(getResources().getString(R.string.mat2));
                    //desc = "";
                    //maturity.setText(desc);
                }
                else if (varietyNew == "Vivek Maize hybrid  (FH 3483)"){
                    //maturity = (TextView)findViewById(R.id.mat);
                    maturity.setText("Kharif/ Late  >96 days");
                   // desc = "";
                    //maturity.setText(desc);
                }
            }
        }

        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language","en");
        updateView(Paper.book().read("language"));

    }

    private void updateView(String lang) {
        Context context = LocaleHelper.setLocale(this,lang);
        Resources resources = context.getResources();

        crop_descr.setText(resources.getString(R.string.crop_discription));
        type.setText(resources.getString(R.string.type));
        crop.setText(resources.getString(R.string.crop));
        variety.setText(resources.getString(R.string.variety));
        Maturity.setText(resources.getString(R.string.maturity));
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