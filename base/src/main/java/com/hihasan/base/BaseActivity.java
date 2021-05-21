package com.hihasan.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class BaseActivity extends AppCompatActivity {
    //base of all activity class
    public LoadingDialog dialogUtil;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //initialize dialog utils class for getting dialog util object
        dialogUtil = new LoadingDialog(this);

    }


    //method for network available or not checking
    public boolean isNetworkAvailable() {

        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();

    }


    //method for fragment calling

    protected void initFragment(Fragment fragment, String id, int resId) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(resId, fragment, id)
                .addToBackStack(null)
                .commit();
    }

    //method for fragment replace
    protected void replaceFragment(Fragment fragment, String id, int resId) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(resId, fragment, id)
                .addToBackStack(null)
                .commit();
    }


    //method for show error message form Api
//    public <T> void showErrorMessage(int responseCode, Response<T> response) {
//
////        if (responseCode == 422) {
//        try {
//            JSONObject jsonObject;
//            try {
//                jsonObject = new JSONObject(response.errorBody().string());
//                String errorMessage = jsonObject.getString("error");
//                Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        }
//
//    }
}
