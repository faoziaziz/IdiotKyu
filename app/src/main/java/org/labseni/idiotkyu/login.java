package org.labseni.idiotkyu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
 		if(firebaseAuth.getCurrentUser()!=null)
		{
			//profile activity
			finish();
			startActivity(new Intent(getApplicationContext(), MENUUTAMA.class));

		}
		progressDialog= new ProgressDialog(this);

		editTextEmail = (EditText) findViewById(R.id.editTextEmail);
		editTextPassword = (EditText) findViewById(R.id.editTextPassword);
		textViewSignup = (TextView) findViewById(R.id.textViewSignup);
	
		buttonRegister.setOnClickListener(this);
		textViewSignup.setOnClickListener(this);
	}
	public void registerUser()
	{
		String email=editTextEmail.getText().toString().trim();
		String password=editTextPassword.getText().toString().trim();
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
			Toast.makeText(this, "Silfupley, password", Toast.LENGTH_SHORT).show();
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

			finish();
			startActivity(new Intent(getApplicationContext(), MENUUTAMA.class));

		}
		else
		{
			Toast.makeText(login.this,"teregister gagal, coba gosok lagi", Toast.LENGTH_SHORT).show();
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
		if (view==textViewSignup)
		{
			//open login activity
			finish();
			startActivity(new Intent(this, Daftar.class));
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
