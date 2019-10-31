package com.soholy.dogmanager.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Map;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import com.alibaba.fastjson.JSON;
import com.hazelcast.com.eclipsesource.json.JsonObject;

public class Md5Encode {

	/**
	 * 
	 * @param username
	 *            盐值
	 * @param password
	 *            加密对象 salt 默认将username作为盐值
	 * 
	 * @return
	 */
	public static Object getCredentials(String username, String password) {
		// 加密方式
		String algorithmName = "MD5";
		// 加密的字符串
		Object source = password;
		// 盐值，用于和密码混合起来用
		Object salt = ByteSource.Util.bytes(username);
		// 加密的次数,可以进行多次的加密操作
		int hashIterations = 1;
		Object result = new SimpleHash(algorithmName, source, salt, hashIterations);
		return result;
	}

	/**
	 * 对字符串md5加密(小写+字母)
	 *
	 * @param str
	 *            传入要加密的字符串
	 * @return MD5加密后的字符串
	 */
	public static String getMD5(String str) {
		try {
			// 生成一个MD5加密计算摘要
			MessageDigest md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(str.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			return new BigInteger(1, md.digest()).toString(16);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 对字符串md5加密(大写+数字)
	 *
	 * @param str
	 *            传入要加密的字符串
	 * @return MD5加密后的字符串
	 */

	public static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		String credentials = getCredentials("ttt", "123456").toString();
		System.out.println(credentials);
		//		7edd4a7d792f85111e40e5451c4f1b2c
	}

}
