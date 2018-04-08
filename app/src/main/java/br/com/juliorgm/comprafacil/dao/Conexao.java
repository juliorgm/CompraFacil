package br.com.juliorgm.comprafacil.dao;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Conexao {
    private static FirebaseAuth mAuth;
    private static FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;

    private Conexao() { }

    public static FirebaseAuth getFirebaseAuth(){
        if (mAuth == null) {
            inicializarFirebase();
        }
        return mAuth;
    }

    private static void inicializarFirebase() {
        mAuth = FirebaseAuth.getInstance();

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user= mAuth.getCurrentUser();
                if (user!=null) firebaseUser = user;
            }
        };
        mAuth.addAuthStateListener(authStateListener);
    }

    public static FirebaseUser getFirebaseUser(){
        return firebaseUser;
    }

    public static void logOut(){
        mAuth.signOut();
    }
}
