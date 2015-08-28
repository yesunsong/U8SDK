package com.u8.sdk.component.user;

public class U8User {
	private static U8User u8User = null;

	private U8User() {
	}

	public static U8User getInstance() {
		if (u8User == null) {
			u8User = new U8User();
		}
		return u8User;
	}

	public void init() {
		
	}
}
