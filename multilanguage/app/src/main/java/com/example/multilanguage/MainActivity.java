package com.example.multilanguage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
        setContentView(R.layout.activity_main);

        Button btn_Change = (Button)findViewById(R.id.button_Changelanguage);
        btn_Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showChangeLanguageDialog();
            }
        });
    }
    private void showChangeLanguageDialog()
    {
        final String[] listitems ={"English", "Vietnamese","French"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Change Language");
        builder.setSingleChoiceItems(listitems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        setLocale("en");
                        recreate();
                        break;
                    case 1:
                        setLocale("vi");
                        recreate();
                        break;
                    case 2:
                        setLocale("fr");
                        recreate();
                        break;
                        default:dialogInterface.dismiss();
                }
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void setLocale(String lang)
    {
        Locale locale1 = new Locale(lang);
        Locale.setDefault(locale1);
        Configuration configuration = new Configuration();
        configuration.locale = locale1;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Setting",MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
    }
    public void loadLocale()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("Setting", Activity.MODE_PRIVATE);
        String lang = sharedPreferences.getString("My_lang","");
        setLocale(lang);

    }
}
