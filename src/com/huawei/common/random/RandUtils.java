package com.huawei.common.random;

import org.apache.commons.lang.math.RandomUtils;

import java.util.Random;

public class RandUtils {

	/**************************************返回随机�?********************************/
	
	/** 
	* 	产生指定的范围的随机整数�?
	* 
	* @param num 数字 
	* @return int 随机�?
	*/ 
	public static int generateRandomInteger(int num){

		return RandomUtils.nextInt(num);
	}
	
	/** 
	* 	按均�?��布产生整�?
	* 
	* 
	* @return int 随机�?
	*/ 
	public static int generateRandomInteger(){
		
		return RandomUtils.nextInt();
	}

	/** 
	* 	按均�?��布产生长整数
	* 
	* 
	* @return long 随机�?
	*/ 
	public static long generateRandomLong(){
		 Random ran = new Random();
		return ran.nextLong();
	}
	
	/** 
	* 	按均�?��布产生大于等�?，小�?的float数[0, 1)
	* 
	* 
	* @return float 随机�?
	*/ 
	public static float generateRandomFloat(){
		 Random ran = new Random();
		return ran.nextFloat();
	}
	
	/** 
	* 	按均�?��布产生[0, 1)范围的double�?
	* 
	* 
	* @return double 随机�?
	*/ 
	public static double generateRandomDouble(){
		 Random ran = new Random();
		return ran.nextDouble();
	}
	
	/** 
	* 	按均�?��布产生高斯数 
	* 
	* 
	* @return double 随机�?
	*/ 
	public static double generateRandomGaussian(){
		 Random ran = new Random();
		return ran.nextGaussian();
	}
	
	/** 
	* 使用java.lang.Math的random方法生成随机�?
	* 
	* 
	* @return double 随机�?
	*/ 
	public static double generateRandom(){
		
		return Math.random();
	}
	
	/**************************************返回字符*********************************/
	
	/** 
	* 返回�?��定长的随机字符串(只包含大小写字母、数�? 
	* 
	* @param length 随机字符串长�?
	* @return String 随机字符�?
	*/ 
	public static String generateRandomString(int length) {
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < length; i++) { 
	sb.append(allChar.charAt(generateRandomInteger(allChar.length()))); 
	} 
	return sb.toString(); 
	} 

	/** 
	* 返回�?��定长的随机纯字母字符�?只包含大小写字母) 
	* 
	* @param length 随机字符串长�?
	* @return  String 随机字符�?
	*/ 
	public static String generateMixString(int length) {
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < length; i++) { 
	sb.append(letterChar.charAt(generateRandomInteger(letterChar.length()))); 
	} 
	return sb.toString(); 
	} 

	
	/** 
	* 返回�?��定长的随机纯数字字符�?
	* 
	* @param length 随机字符串长�?
	* @return String 随机字符�?
	*/ 
	public static String generateMixNumber(int length) {
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < length; i++) { 
	sb.append(numberChar.charAt(generateRandomInteger(numberChar.length()))); 
	} 
	return sb.toString(); 
	} 
	
	/** 
	* 返回�?��定长的随机纯大写字母字符�?只包含大小写字母) 
	* 
	* @param length 随机字符串长�?
	* @return String 随机字符�?
	*/ 
	public static String generateLowerString(int length) {
	return generateMixString(length).toLowerCase(); 
	} 

	/** 
	* 返回�?��定长的随机纯小写字母字符�?只包含大小写字母) 
	* 
	* @param length 随机字符串长�?
	* @return String 随机字符�?
	*/ 
	public static String generateUpperString(int length) {
	return generateMixString(length).toUpperCase(); 
	} 

	/** 
	* 生成�?��定长的纯0字符�?
	* 
	* @param length 字符串长�?
	* @return String �?字符�?
	*/ 
	public static String generateZeroString(int length) {
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < length; i++) { 
	sb.append('0'); 
	} 
	return sb.toString(); 
	} 

	/** 
	* 根据数字生成�?��定长的字符串，长度不够前面补0 
	* 
	* @param num 数字 
	* @param fixdlenth 字符串长�?
	* @return String 定长的字符串 
	*/ 
	public static String toFixdLengthString(long num, int fixdlenth) {
	StringBuffer sb = new StringBuffer();
	String strNum = String.valueOf(num);
	if (fixdlenth - strNum.length() >= 0) { 
	sb.append(generateZeroString(fixdlenth - strNum.length())); 
	} else { 
	throw new RuntimeException();
	} 
	sb.append(strNum); 
	return sb.toString(); 
	} 

	/** 
	* 根据数字生成�?��定长的字符串，长度不够前面补0 
	* 
	* @param num 数字 
	* @param fixdlenth 字符串长�?
	* @return String 定长的字符串 
	*/ 
	public static String toFixdLengthString(int num, int fixdlenth) {
	StringBuffer sb = new StringBuffer();
	String strNum = String.valueOf(num);
	if (fixdlenth - strNum.length() >= 0) { 
	sb.append(generateZeroString(fixdlenth - strNum.length())); 
	} else { 
	throw new RuntimeException();
	} 
	sb.append(strNum); 
	return sb.toString(); 
	} 

	
	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numberChar = "0123456789";
}
