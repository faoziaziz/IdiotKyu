package org.labseni.idiotkyu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cekjadwal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cekjadwal);

        Button btn4 = (Button) findViewById(R.id.t_jadwal);

        btn4.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick (View v)
            {
                Intent i1 = new Intent(getApplication(), tambahjadwal.class);
                startActivity(i1);


            }

        });
    }
}
