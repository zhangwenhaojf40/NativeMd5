package com.hao.so;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.hao.happy.NativeUtil;

public class MainActivity extends AppCompatActivity {
    Button btnSignMd5Native;
    Button btnSignMd5Java;
    Button btnMd5Java;
    Button btnMd5Native;
    Button btnMd5Result;
    Button btnMd5Check;

    TextView tvSignMd5Native;
    TextView tvSignMd5Java;
    TextView tvMd5Java;
    TextView tvMd5Native;
    TextView tvMd5Result;
    TextView tvCheckResult;

    static {
        System.loadLibrary("native-lib");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //签名-native
        btnSignMd5Native = findViewById(R.id.btn_sign_md5_native);
        //签名-java
        btnSignMd5Java = findViewById(R.id.btn_sign_md5_java);
        //md5加密-java
        btnMd5Java = findViewById(R.id.btn_md5_java_jia_mi);
        btnMd5Result = findViewById(R.id.btn_md5_result);
        //md5加密-native
        btnMd5Native = findViewById(R.id.btn_md5_native_jia_mi);
        tvSignMd5Native = findViewById(R.id.tv_sign_md5_native);
        tvSignMd5Java = findViewById(R.id.tv_sign_md5_java);
        tvMd5Java = findViewById(R.id.tv_md5_java);
        tvMd5Native = findViewById(R.id.tv_md5_Nava);
        tvMd5Result = findViewById(R.id.tv_md5_result);
        btnMd5Check = findViewById(R.id.btn_check_result);
        tvCheckResult = findViewById(R.id.tv_md5_check_result);


        btnSignMd5Native.setOnClickListener(v -> {//获取md5签名-Native
            System.out.println("zhang"+NativeUtil.getSign(this));
            tvSignMd5Native.setText(NativeUtil.getSign(this));
        });
        btnSignMd5Java.setOnClickListener(v -> {//获取md5签名-Java
            String javaSignature = SignatureUtil.getSignatureStr(getApplicationContext());
            tvSignMd5Java.setText(javaSignature);
        });
        btnMd5Java.setOnClickListener(v -> {//获取md5签名-Native
            tvMd5Java.setText(MD5Utils.getMD5("zhang321"));

        });
        btnMd5Native.setOnClickListener(v -> {//获取md5签名-Native
            String result = NativeUtil.md5("zhang", "321").replace(":", "").toLowerCase();
            tvMd5Native.setText(result);

        });
        btnMd5Check.setOnClickListener(v->{//验证签名是否一致
            String result = NativeUtil.checkSign(this);
            tvCheckResult.setText(result);
        });

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}