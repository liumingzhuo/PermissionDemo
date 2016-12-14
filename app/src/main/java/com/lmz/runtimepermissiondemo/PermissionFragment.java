package com.lmz.runtimepermissiondemo;

import android.Manifest;
import android.view.View;
import android.widget.Toast;

/**
 * 作者：LMZ on 2016/12/14 0014 15:08
 */
public class PermissionFragment extends BaseFragment {
    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initView(View rootView) {
        rootView.findViewById(R.id.permissionBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                permissionRequest("赶快同意", new String[]{Manifest.permission.CALL_PHONE}, 102, new IPermissionResultListener() {
                    @Override
                    public void onPermissionSuccess() {
                        Toast.makeText(getActivity(), "申请了权限", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionFaild() {
                        Toast.makeText(getActivity(), "拒绝 了权限", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {

    }

}
