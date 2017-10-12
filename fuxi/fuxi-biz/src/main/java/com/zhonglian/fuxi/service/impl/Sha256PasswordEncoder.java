/**
 * Copyright (c) 2017, 满兜 . All rights reserved. Use is subject to license terms.
 */
package com.zhonglian.fuxi.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 密码加密服务
 * 
 * @author zyf
 *
 */
public class Sha256PasswordEncoder {
	

	/** 密码加密密钥 */
	public final static String PASSWORD_SECRET = "ebe5ce";

	public String encode(CharSequence rawPassword) {
		return DigestUtils.sha256Hex(PASSWORD_SECRET + rawPassword.toString());
	}

	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return StringUtils.equals(encodedPassword, encode(rawPassword));
	}

}
