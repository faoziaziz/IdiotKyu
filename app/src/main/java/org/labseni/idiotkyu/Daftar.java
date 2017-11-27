/*
	Nama  	: Aziz Amerul Faozi
	NIM	: 18112042
		 mRootRef = new Firebase("https://idiotkyu.firebaseio.com/"); udah  h
*/
// 
package org.labseni.idiotkyu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import com.google.firebase.database.*;
import com.google.firebase.*;


public class Daftar extends AppCompatActivity {
    private EditText mValueField;
    private Button mtombol;
	
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);

        DatabaseReference myRef = databas
	DatabaseReferenc

        mValueField = (EditText) findViewById(R.id.s_nama);
        mtombol =(Button) findViewById(R.id.t_daftar);


    }
}
