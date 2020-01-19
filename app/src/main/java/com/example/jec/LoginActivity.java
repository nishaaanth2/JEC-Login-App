package com.example.jec;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextView logintxt;
    private String rememe_regno,rememe_pass;
    private TextInputEditText edtregno,edtpass;
    private Button btnlng;
    private CheckBox cbrem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final SharedPreferences preferences=getSharedPreferences("rememe",0);
        rememe_regno=preferences.getString("rememeregno","");
        rememe_pass=preferences.getString("rememepass","");
        edtregno=(TextInputEditText)findViewById(R.id.mainreg);
        edtpass=(TextInputEditText)findViewById(R.id.mainpass);
        edtregno.setText(rememe_regno);
        edtpass.setText(rememe_pass);
        logintxt=(TextView)findViewById(R.id.mainlogintext);
        btnlng=(Button)findViewById(R.id.mainbtnlogin);
        cbrem=(CheckBox)findViewById(R.id.mainremberme);

        btnlng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String regname=String.valueOf(edtregno.getText());
                String regpass=String.valueOf(edtpass.getText());
                if (cbrem.isChecked())
                {
                    SharedPreferences preferences1=getSharedPreferences("rememe",0);
                    SharedPreferences.Editor editor=preferences1.edit();
                    editor.putString("rememeregno",regname);
                    editor.putString("rememepass",regpass);
                    editor.apply();
                    Toast.makeText(LoginActivity.this,regname+regpass, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}