package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseUser;

public class LogoutActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = LoginActivity.class.getSimpleName();
    Button btnRevoke, btnLogout;
    private FirebaseAuth mAuth;

    private GoogleApiClient mGoogleApiClient;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_out:
                Intent intent = new Intent(this, LogoutActivity.class);
                startActivity(intent);
                break;
            case R.id.protect:
                Intent intent2 = new Intent(this, ProtectActivity.class);
                startActivity(intent2);
                break;
            case R.id.alram:
                Intent intent3 = new Intent(this, AlramActivity.class);
                startActivity(intent3);
                break;
            case R.id.information:
                Intent intent4 = new Intent(this, InformationActivity.class);
                startActivity(intent4);
                break;
            case R.id.faq:
                Intent intent5 = new Intent(this, FAQActivity.class);
                startActivity(intent5);
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);

//        showProgressDialog();

        // GoogleSignInOptions 개체 구성
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        // Build a GoogleApiClient with access to the Google Sign-In API and the options specified by gso.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//                        DebugLog.logD(TAG, "Login fail");
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        // initialize auth
        mAuth = FirebaseAuth.getInstance();

        signOut();


        btnLogout = (Button)findViewById(R.id.btn_logout);
//        btnRevoke = (Button)findViewById(R.id.btn_revoke);

        mAuth = FirebaseAuth.getInstance();

        btnLogout.setOnClickListener(this);
//        btnRevoke.setOnClickListener(this);

//        Button heartButton = (Button) findViewById(R.id.heart_button);
//        heartButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Button sleepButton = (Button) findViewById(R.id.sleep_button);
//        sleepButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SleepActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        Button gpsButton = (Button) findViewById(R.id.gps_button);
//        gpsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), GPSActivity.class);
//                startActivity(intent);
//            }
//        });

    }

    private void signOut() {

        mGoogleApiClient.connect();
        mGoogleApiClient.registerConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {

            @Override
            public void onConnected(@Nullable Bundle bundle) {

                mAuth.signOut();
                if (mGoogleApiClient.isConnected()) {

                    Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {

//                    mAuth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {

                        @Override
                        public void onResult(@NonNull Status status) {

                            if (status.isSuccess()) {

//                                DebugLog.logD(TAG, "User Logged out");
//                                setResult(ResultCode.SIGN_OUT_SUCCESS);

                            } else {

//                                setResult(ResultCode.SIGN_OUT_FAIL);
                            }

//                            hideProgressDialog();
                            finishAffinity();
                        }
                    });
                }
            }

            @Override
            public void onConnectionSuspended(int i) {

//                DebugLog.logD(TAG, "Google API Client Connection Suspended");

//                setResult(ResultCode.SIGN_OUT_FAIL);
//                hideProgressDialog();

                finish();
            }
        });
    }


//        mAuth.getInstance().signOut();

    private void revokeAccess() {
        mAuth.getCurrentUser().delete();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_logout:
                signOut();
                finishAffinity();
                break;
//            case R.id.btn_revoke:
//                revokeAccess();
//                finishAffinity();
//                break;
        }
    }





}
