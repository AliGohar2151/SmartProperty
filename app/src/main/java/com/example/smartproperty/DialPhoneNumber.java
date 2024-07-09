package com.example.smartproperty;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class DialPhoneNumber {

    private final Context context;

    public DialPhoneNumber(Context context) {
        this.context = context;
    }

    public void dialNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        String phoneNumber = "12345678";
        intent.setData(Uri.parse("tel:" + phoneNumber));
        context.startActivity(intent);
    }
}
