package com.example.myapplications;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.ExternalWalletListener;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Razorpay extends Activity {
    private static final String TAG = Razorpay.class.getSimpleName();
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_razorpay);


    }
}
