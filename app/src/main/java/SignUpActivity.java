
package com.example.chatcs460.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.lab4.R;
import com.example.lab4.databinding.ActivitySignUpBinding;

import java.io.ByteArrayInputStream;
public class SignUpActivity extends AppCompatActivity{
    private ActivitySignUpBinding binding;

    private String encodeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this);
        // setContentView(R.layout.activity_sign_up);
        // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
        //    Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        //   v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        //   return insets;
        // });


        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }

    private void setListeners() {
        binding.textSignIn.setOnClickListener(v -> onBackPressed());

        binding.buttonSignUp.setOnClickListener(view -> {
            if(isValidSignUpDetails()){
                SignUp();
            }
        });
    }

    private void showToast(String message){
        Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
    }

    private void SignUp(){
        //Check Loading

        //Post to Firebase
    }

    private String encodeImage(Bitmap bitmap){
        int previewWidth = 150;
        int previewHeight = bitmap.getHeight()*previewWidth / bitmap.getWidth();

        Bitmap previewBitmap = Bitmap.createScaledBitmap(bitmap,previewWidth,previewHeight,false);

        ByteArrayInputStream


        return null;
    }


    private Boolean isValidSignUpDetails() {
        if (binding.inputName.getText().toString().isEmpty()) {
            showToast("Please Enter Your Name");
            return false;
        } else if (binding.inputEmail.getText().toString().isEmpty()) {
            showToast("Please Enter Your Email");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.getText().toString()).matches()) {
            showToast("Please Enter vail Email");
            return false;
        } else if (binding.inputPassword.getText().toString().isEmpty()) {
            showToast("Please Enter Your Password");
            return false;

        }else if (binding.inputConfirmPassword.getText().toString().isEmpty()) {
            showToast("Please Confirm Your Password");
            return false;

        }else if (!binding.inputPassword.getText().toString().equals(binding.inputConfirmPassword.getText().toString())) {
            showToast("Password & Confirm Password must be the same");
            return false;

        }
        else{
            return true;
        }
    }

}
