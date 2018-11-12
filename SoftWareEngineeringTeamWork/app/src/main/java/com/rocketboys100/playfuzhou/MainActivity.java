package com.rocketboys100.playfuzhou;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private ImageView iv;
    private TextView tv;
    private TextView tv2;

    public static final int RequestCode_Login = 0;

    private void initUI() {
        btn = findViewById(R.id.btn);
        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.tv);
        tv2 = findViewById(R.id.tv2);
        btn.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getSupportActionBar().hide();
        initUI();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == this.RequestCode_Login
                && resultCode == Login.RequestCode_Login)
        {
            String userName = data.getStringExtra("userName");
            String userOpenID = data.getStringExtra("userOpenID");
            String userHeadPath = data.getStringExtra("userHeadPath");
            Bitmap userHead = BitmapFactory.decodeFile(userHeadPath);
////////////////////////////////////////////////////////////////
            // change this
            iv.setImageBitmap(userHead);
            tv.setText(userName);
            tv2.setText(userOpenID);
            ////////////////////////////////////////////////////////////////
        }

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"click" , Toast.LENGTH_SHORT).show();
        if(v.getId() == R.id.btn){
            Intent intent = new Intent(this, Login.class);
            startActivityForResult(intent,RequestCode_Login);
        }
    }
}
