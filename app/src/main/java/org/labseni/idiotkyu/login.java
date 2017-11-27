package org.labseni.idiotkyu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity implements View.OnClickListener{
	private Button buttonRegister;
	private EditText editTextEmail;
	private EditText editTextPassword;
	private TextView textViewSignup;
	private ProgressDialog progressDialog;
	private FirebaseAuth firebaseAuth;
     	
   	@Override
    	protected void onCreate(Bundle savedInstanceState) {
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.activity_login);
		
		firebaseAuth= FirebaseAuth.getInstance();
 
		progressDialog= new ProgressDialog(this);
        	buttonRegister = (Button) findViewById(R.id.t_daftar);
		editTextEmail = (EditText) findViewById(R.id.editTextEmail);
		editTextPassword = (EditText) findViewById(R.id.editTextPassword);
		textViewSignin = (TextView) findViewById(R.id.textViewSignin)
	
		buttonRegister.setOnClickListener(this);
		textViewSignin.setOnClickListener(this);
	}
	public void registerUser()
	{
		String email=editTextEmail.getText().toString().trim();
		String password=edittextPassword.getText().toString().trim();
		if(TextUtils.isEmpty(email))
		{
			//email is emty
			Toast.makeText(this, "Silfupley, email", Toast.LENGTH_SHORT).show();
			//stop function
			return; 
		}
		if(TextUtils.isEmpty(password))
		{
			//password is empty
			Toast.makeText(this, "Silfupley, password", Toast.LENGTH_SHORT).show()
			//stopping execution furher
			return;
		}
		//if valid 
		progressDialog.setMessage("Lagi registering bro...");
		progressDialog.show();
		firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
	@Override
	public void onComplete(@NonNull Task<AuthResult> task)
	{
		if(task.isSuccessful())

		{
			//ini dia kalau telah di register dan akan login dalam kode ini
			Toast.makeText(MainActivity.this,"teregister berhasil", Toast.LENGTH_SHORT).show();

		}
		else
		{
			Toast.makeText(MainActivity.this,"teregister gagal, coba gosok lagi", Toast.LENGTH_SHORT).show();
		}
	}

	});
		
		
	}
	@Override
	public void onClick(View view)
	{
		if(view==buttonRegister)
		{
			registerUser();
		}
		if (view==textViewSignin)
		{
			//open login activity
		}
	}

/*
	//ini yang dulu
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
	*/
}
