package com.example.shopisthan_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.CircleIndicator;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    CircleIndicator tabIndicator;
    Button btnskip;
    ImageButton  btnNext;
    int position = 0;
    Button btnGetStarted;
    Animation btnAnim ;
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;

    TextView signin,close;

    FirebaseAuth firebaseAuth;
    TextInputLayout firstName, lastName,email,password;
    Button signUP;
    SignInButton btn;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

//        if (restorePrefData()){
//            Intent mainActivity =new Intent(getApplicationContext(),MainActivity.class);
//            startActivity(mainActivity);
//            finish();
//        }

        tabIndicator = findViewById(R.id.tab_indicator);
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_getstarted);
        btnskip = findViewById(R.id.btn_next2);
        screenPager =findViewById(R.id.screen_viewpager);



        firebaseAuth = FirebaseAuth.getInstance();

        btnAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.button_animation);

        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Shopisthan", "Explore New Store,\nFollow Your Favorite\nStore.","Order, Share or Stay updated of your\nfavorite store products",R.drawable.images));
        mList.add(new ScreenItem("Shopisthan", "Sell Product\nAnywhere, Home,\nStore Or Multilocation.","sell, share or stay focused on best\ncustomer service for your community.\nmove to manufacturing instead of\nretailing",R.drawable.download));
        mList.add(new ScreenItem("Shopisthan", "Enjoy Window\nShopping Or Build\nYour Own Community By Selling Best Product","",R.drawable.shopbolte));


        introViewPagerAdapter = new IntroViewPagerAdapter(this,mList);
        screenPager.setAdapter(introViewPagerAdapter);

        tabIndicator.setViewPager(screenPager);

        btnskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this,loginActivity.class);
                startActivity(intent);
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()){
                    position++;
                    screenPager.setCurrentItem(position);
                }
                if (position == mList.size()-1){
                    loadLastScreen();
                }
            }
        });




        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewContactDialog();

            }
        });

//        savePrefsData();
//        finish();

    }

    private void createNewContactDialog() {
        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.sign_up,null);

        signin = contactPopupView.findViewById(R.id.signup);
        close = contactPopupView.findViewById(R.id.close);

        firstName = contactPopupView.findViewById(R.id.firstname);
        lastName =contactPopupView.findViewById(R.id.shopdescription);
        email =  contactPopupView.findViewById(R.id.GSTno);
        password = contactPopupView.findViewById(R.id.shopType);
        signUP = contactPopupView.findViewById(R.id.gopopup);
        progressBar = contactPopupView.findViewById(R.id.progress_circular);

        btn = contactPopupView.findViewById(R.id.googleSign);



        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Signin();
            }
        });

        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();







        signUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String Email = email.getEditText().toString().trim();
                String Password = password.getEditText().toString().trim();
                String FirstName = firstName.getEditText().toString().trim();
                String LastName = lastName.getEditText().toString().trim();


                if (TextUtils.isEmpty(FirstName))
                {
                    firstName.setError("Enter the first name");
                }
                else if (TextUtils.isEmpty(LastName))
                {
                    email.setError("Enter the last name");
                }

                else if (TextUtils.isEmpty(Email))
                {
                    email.setError("Enter the email");
                }
                else if (TextUtils.isEmpty(Password))
                {
                    password.setError("Password is Required");
                }
                else if (Password.length()<6)
                {
                    password.setError("Password must be more than 6 characters");
                }

                else
                {
                    signUP.setVisibility(View.INVISIBLE);
                    progressBar.setVisibility(View.VISIBLE);
                    firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(IntroActivity.this, "registered successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(IntroActivity.this,HomeActivity.class));
                            }
                            else
                            {
                                signUP.setVisibility(View.VISIBLE);
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(IntroActivity.this, "Error ! "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }




            }
        });








    }

    private void Signin() {
        dialogBuilder= new AlertDialog.Builder(this);
        final View contactPopupView = getLayoutInflater().inflate(R.layout.sing_in,null);



        dialogBuilder.setView(contactPopupView);
        dialog = dialogBuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();


    }

//    private boolean restorePrefData() {
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);
//        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened",false);
//        return isIntroActivityOpenedBefore;
//    }
//
//    private void savePrefsData() {
//        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs",MODE_PRIVATE);;
//        SharedPreferences.Editor editor = pref.edit();
//        editor.putBoolean("isIntroOpened",true);
//        editor.commit();
//    }

    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
        btnskip.setVisibility(View.INVISIBLE);

        btnGetStarted.setAnimation(btnAnim);
    }
}