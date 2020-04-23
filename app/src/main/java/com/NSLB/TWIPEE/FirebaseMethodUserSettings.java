package com.NSLB.TWIPEE;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.NSLB.TWIPEE.Interface.SignInListener;
import com.NSLB.TWIPEE.ItemModel.UserInfoModel;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import static android.content.ContentValues.TAG;

public class FirebaseMethodUserSettings extends FirebaseMethods {
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private SignInListener signInListener = null;
    private GoogleApiClient mgoogleApiClient;
    boolean check = false;


    public int CheckAuth(){
        DatabaseAccess();
        if(mAuth.getCurrentUser() != null){
            onAuthSuccess(mAuth.getCurrentUser());
            return 1;
        }else
        return 0;
    }

    public void signIn(String Email, String Password) {
        Log.d(TAG, "signIn");
        /*if (!validateForm()) {
            return;
        }*/

        final String fEmail = Email;
        final String fPassword = Password;

        mAuth.signInWithEmailAndPassword(fEmail, fPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    onAuthSuccess(task.getResult().getUser());
                    signInListener.SignSuccess();
                }else {
                    signInListener.SignFail();
                }
            }
        });
    }

    public void signOut() {
        DatabaseAccess();
        mgoogleApiClient = ((Login_main)Login_main.mContext).mGoogleApiClient;
        mgoogleApiClient.connect();
        mgoogleApiClient.registerConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {

            @Override
            public void onConnected(@Nullable Bundle bundle) {

                mAuth.signOut();
                if (mgoogleApiClient.isConnected()) {

                    Auth.GoogleSignInApi.signOut(mgoogleApiClient).setResultCallback(new ResultCallback<Status>() {

                        @Override
                        public void onResult(@NonNull Status status) {

                            if (status.isSuccess()) {
                                //Toast.makeText(MainActivity.this, "로그아웃 성공.", Toast.LENGTH_SHORT).show();
                            } else {

                            }
                        }
                    });
                }
            }

            @Override
            public void onConnectionSuspended(int i) {
                //finish();
            }
        });
    }

    public void categorysave(String show_category){
        DatabaseAccess();
        mDatabase.child(getUid()).child("category").setValue(show_category);
    }

    public void firebaseAuthWithGoogle(GoogleSignInAccount acct, Activity activity){
        DatabaseAccess();
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(),null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.v("알림", "ONCOMPLETE");
                        if (!task.isSuccessful()) {
                            Log.v("알림", "!task.isSuccessful()");
                            Toast.makeText(Login_main.mContext, "인증에 실패하였습니다.", Toast.LENGTH_SHORT).show();
                        }else {
                            Log.v("알림", "task.isSuccessful()");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(Login_main.mContext, "FireBase 아이디 생성이 완료 되었습니다", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    public void signUp(String Email, String Password) {
        Log.d(TAG, "signUp");
        /*if (!validateForm()) {
            return;
        }*/

        final String fEmail = Email;
        final String fPassword = Password;

        mAuth.createUserWithEmailAndPassword(fEmail, fPassword);
    }

    public void onSignInListener(SignInListener listener){
        this.signInListener = listener;
    }

    private void onAuthSuccess(FirebaseUser user){
        String username = usernameFromEmail(user.getEmail());

        writeNewUser(user.getUid(), username, user.getEmail());
    }

    private void writeNewUser(String userId, String name, String email) {
        UserInfoModel user = new UserInfoModel(name,email);
        mDatabase.child("users").child(userId).setValue(user);
    }



    private String usernameFromEmail(String email) {
        if (email.contains("@")) {
            return email.split("@")[0];
        } else {
            return email;
        }
    }

    @Override
    public void DatabaseAccess() {
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void UploadData(String userId, String username, String title, String body) {

    }

}
