package com.cn.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @className DateUtil.java
 * @description
 * @author lxs
 * @version 1.0
 * @since 1.0
 * @date 2019年9月7日
 */
public class DateUtil {
	public static Timestamp now() {
		Date date = new Date();
		SimpleDateFormat sFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return Timestamp.valueOf(sFormat.format(date));
	}
}
