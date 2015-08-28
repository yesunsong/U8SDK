package com.u8.sdk.component.pay;

public class U8Pay {
	private static U8Pay u8Pay = null;

	private U8Pay() {
	}

	public static U8Pay getInstance() {
		if (u8Pay == null) {
			u8Pay = new U8Pay();
		}
		return u8Pay;
	}

	public void init() {
		
	}
}
