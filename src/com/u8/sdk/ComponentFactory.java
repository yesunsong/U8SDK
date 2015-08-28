package com.u8.sdk;

import android.app.Activity;

public class ComponentFactory {
	private static ComponentFactory componentFactory = null;

	private ComponentFactory() {

	}

	public static ComponentFactory getInstance() {
		if (componentFactory == null) {
			componentFactory = new ComponentFactory();
		}
		return componentFactory;
	}
	
	public void init(Activity context){
		
	}

	public SDKConfigData getSDKConfigData() {
		return null;
	}
}
