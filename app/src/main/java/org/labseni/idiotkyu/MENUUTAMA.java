package org.labseni.idiotkyu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MENUUTAMA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuutam);

        Button btn2 = (Button) findViewById(R.id.t_cek);

        btn2.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick (View v)
            {
                Intent i1 = new Intent(getApplication(), cekkosan.class);
                startActivity(i1);


            }

        });

        Button btn3 = (Button) findViewById(R.id.c_jadwal);

        btn3.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick (View v)
            {
                Intent i1 = new Intent(getApplication(), cekjadwal.class);
                startActivity(i1);


            }

        });

    }
}
