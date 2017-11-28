/*
	Ko kodenya aku tuker daftar jadi signin
*/ 
package org.labseni.idiotkyu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;


public class Daftar extends AppCompatActivity implements View.OnClickListener{
   	private Button buttonSignIn;
	private EditText editTextEmail;
	private EditText editTextPassword;
	private TextView textViewSignup;
	private ProgressDialog progressDialog;
	private FirebaseAuth firebaseAuth;

    	@Override
    	protected void onCreate(Bundle savedInstanceState) 
	{
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.activity_daftar);
		
		firebaseAuth= FirebaseAuth.getInstance();
		
		if(firebaseAuth.getCurrentUser()!=null)
		{
			//profile activity
			finish();
			startActivity(new Intent(getApplicationContext(), MENUUTAMA.class));

		}

		editTextEmail =(EditText) findViewByID(R.id.editTextEmail);
		editTextPassword =(EditText) findViewByID(R.id.editTextPassword);
		buttonSignin =(Button) findViewByID(R.id.buttonSignin);
		textViewSignup =(TextView) findViewByID(R.id.textViewSignup);
		
		progressDialog= new ProgressDialog(this);

		buttonSignIn.setOnClickListener(this);
		textViewSignup.setOnClickListener(this);

    	}

	private void userLogin()
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
			Toast.makeText(this, "Silfupley, password", Toast.LENGTH_SHORT).show()
			//stopping execution furher
			return;
		}
		//if valid 
		progressDialog.setMessage("Lagi registering bro...");
		progressDialog.show();
		firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>(){
		@Override
		public void onComplete(@NonNull Task<AuthResult> task)
		{
			progressDialog.dismiss();
			if(task.isSuccessful()){
				//start the profile activity
				finish();
				startActivity(new Intent(getApplicationContext(), MENUUTAMA.class));
			}
		}
		

});
	}
	@Override
	public void onClick(View view)
	{
		if(view==buttonSignIn){
		userLogin();
		}
		if (view==textViewSignup)
		{	
			finish();
			startActivity(new Intent(this, login.class));
		}
	}
}
