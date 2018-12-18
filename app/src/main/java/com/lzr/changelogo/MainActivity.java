package com.lzr.changelogo;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ComponentName mDefault;
    private ComponentName mAily;
    private ComponentName mLyds;
    private PackageManager mPm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDefault = new ComponentName(getBaseContext(),
                "com.lzr.changelogo.norLuncherActivity");
        mAily = new ComponentName(
                getBaseContext(),
                "com.lzr.changelogo.ailyLuncherActivity");
        mLyds = new ComponentName(
                getBaseContext(),
                "com.lzr.changelogo.lydsLuncherActivity");
        mPm = getApplicationContext().getPackageManager();

    }

    /**
     * 变回默认
     *
     * @param view
     */
    public void nor(View view) {
        disableComponent(mAily);
        disableComponent(mLyds);
        enableComponent(mDefault);
        Log.e("lzr", "正常路径=" + mDefault.getClassName());
    }

    /**
     * 变成爱录音
     *
     * @param view
     */
    public void aily(View view) {
        disableComponent(mDefault);
        disableComponent(mLyds);
        enableComponent(mAily);
    }

    /**
     * 变成录音大师
     *
     * @param view
     */
    public void lyds(View view) {
        disableComponent(mDefault);
        disableComponent(mAily);
        enableComponent(mLyds);
    }

    /**
     * 显示变更图标
     *
     * @param componentName
     */
    private void enableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    /**
     * 隐藏变更图标
     *
     * @param componentName
     */
    private void disableComponent(ComponentName componentName) {
        mPm.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }


}
