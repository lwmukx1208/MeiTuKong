package org.fireking.meitukong.supports;

import android.app.Application;

import cn.bmob.v3.Bmob;

/**
 * Created by wangg on 16/1/5.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Bmob.initialize(this, "f7a17879d2151fed9da293c5040adc1f");
    }
}
