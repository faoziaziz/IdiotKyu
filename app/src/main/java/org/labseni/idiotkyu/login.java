package org.labseni.idiotkyu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn = (Button) findViewById(R.id.t_daftar);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick (View v)
            {
                Intent i1 = new Intent(getApplication(), Daftar.class);
                startActivity(i1);
        //ini code buat nyambung

            }

        });

        Button btn1 = (Button) findViewById(R.id.tmasuk);

        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick (View v)
            {
                Intent i1 = new Intent(getApplication(), MENUUTAMA.class);
                startActivity(i1);
                //ini code buat nyambung

            }

        });

    }
}
