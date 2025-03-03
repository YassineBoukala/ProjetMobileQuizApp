package com.example.quizapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText edit_email,edit_password;
    Button btn_signin;
    TextView txt_register;
    CheckBox show_hide_password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_email=findViewById(R.id.edit_email_login);
        edit_password=findViewById(R.id.edit_password_login);
        btn_signin=findViewById(R.id.btn_signin_login);
        txt_register=findViewById(R.id.txt_register_login);
        show_hide_password=findViewById(R.id.show_hide_password);

        mAuth = FirebaseAuth.getInstance();
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(edit_email.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this,"Email field is empty",Toast.LENGTH_LONG).show();

                }else if(TextUtils.isEmpty(edit_password.getText().toString()))
                {
                    Toast.makeText(LoginActivity.this,"Password field is empty",Toast.LENGTH_LONG).show();
                }else
                {
                    String email=edit_email.getText().toString();
                    String pswd=edit_password.getText().toString();

                    /*for (User user : Config.users)
                    {
                        if(user.getEmail().equals(email) && user.getPswd().equals(pswd))
                        {
                            Toast.makeText(LoginActivity.this,"You're logged in",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(LoginActivity.this,QuizActivity.class);
                            startActivity(intent);
                            return;
                        }
                    }*/
                   mAuth.signInWithEmailAndPassword(email,pswd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               Toast.makeText(LoginActivity.this,"You're logged in",Toast.LENGTH_LONG).show();
                               Intent intent=new Intent(LoginActivity.this,QuizActivity.class);
                               startActivity(intent);
                           } else {
                               Toast.makeText(LoginActivity.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                           }
                       }
                   });


                }
            }
        });


show_hide_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton button, boolean isChecked) {
        if (isChecked) {
            show_hide_password.setText("Hide password");
            edit_password.setInputType(InputType.TYPE_CLASS_TEXT);
            edit_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        else {
            show_hide_password.setText("Show password");
            edit_password.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_PASSWORD);
            edit_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
});

        txt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });

    }

}


