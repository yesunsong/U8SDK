package com.u8.sdk;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;

import com.u8.sdk.component.pay.U8Pay;
import com.u8.sdk.component.user.U8User;

public class U8SDK {

	public static final int TYPE_LOGIN = 1;
	public static final int TYPE_PAY = 2;

	private static U8SDK instance = null;

	private Activity context;
	private Handler mainThreadHandler;

	private SDKConfigData developInfo;

	private IU8SDKListener listener;
	private IActivityListener activityCallback;

	private U8SDK() {
		mainThreadHandler = new Handler(Looper.getMainLooper());
	}

	public static U8SDK getInstance() {
		if (instance == null) {
			instance = new U8SDK();
		}
		return instance;
	}

	public void init(Activity context) {
		this.context = context;
		ComponentFactory.getInstance().init(context);
		developInfo = ComponentFactory.getInstance().getSDKConfigData();

		U8User.getInstance().init();
		U8Pay.getInstance().init();
	}

	public void runOnMainThread(Runnable runnable) {
		if (mainThreadHandler != null) {
			mainThreadHandler.post(runnable);
			return;
		}
		if (context != null) {
			context.runOnUiThread(runnable);
		}
	}

	public Activity getContext() {
		return context;
	}

	public SDKConfigData getSDKParams() {
		return developInfo;
	}

	public int getCurrChannel() {
		if (this.developInfo == null
				|| !this.developInfo.contains("U8_Channel")) {
			return -1;
		}
		return this.developInfo.getInt("U8_Channel");
	}

	public void setSDKListener(IU8SDKListener listener) {
		this.listener = listener;
	}

	public void setActivityCallback(IActivityListener callback) {
		this.activityCallback = callback;
	}
}
