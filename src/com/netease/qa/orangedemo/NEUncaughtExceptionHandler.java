package com.netease.qa.orangedemo;

import java.lang.Thread.UncaughtExceptionHandler;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

public class NEUncaughtExceptionHandler implements UncaughtExceptionHandler {

	private static final String LOG_TAG = NEUncaughtExceptionHandler.class.getSimpleName();
	private static NEUncaughtExceptionHandler INSTANCE;
	
	private static Context context;
	
	 /** 获取NEUncaughtExceptionHandler实例 ,单例模式 */
    public static NEUncaughtExceptionHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NEUncaughtExceptionHandler();
        }
        return INSTANCE;
    }
    
    public static void init(Context mContext) {
        Log.i("BaseActivity","init()");
        context = mContext;
        // 设置该类为线程默认UncatchException的处理器。
        Thread.setDefaultUncaughtExceptionHandler(getInstance());
    }
    
	public void uncaughtException(Thread arg0, Throwable arg1) {
		Log.w(LOG_TAG, "*** uncaughtException and startActivity***");
		arg1.printStackTrace();
		Toast.makeText(context.getApplicationContext(), "崩溃异常捕获", Toast.LENGTH_LONG).show();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}

}
