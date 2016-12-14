package com.lmz.runtimepermissiondemo;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.open_galley).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionRequest("没有权限您不能使用相机，请把相机权限赐给我吧!(如果设置不再提示,您可以在设置中打开权限)"
                        , new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                        101, new IPermissionResultListener() {
                            @Override
                            public void onPermissionSuccess() {
                                Toast.makeText(MainActivity.this, "申请了权限", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onPermissionFaild() {
                                Toast.makeText(MainActivity.this, "拒绝了权限", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
       // mFrameLayout = (FrameLayout) findViewById(R.id.layout);
        getSupportFragmentManager().beginTransaction().add(R.id.layout, new PermissionFragment())
                .commit();

    }
}
