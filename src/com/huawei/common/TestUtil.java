package com.huawei.common;

import org.junit.Test;
import com.huawei.common.encrypt.MD5Encrypt;


/**
* @ClassName: TestUtil
* @ClassNameExplain: 测试类
* @Description: 用于基本测试
* @author Ice
* @date 2017年4月9日 下午3:29:58
*/
public class TestUtil {
	
	@Test
	public void test(){
		String md5str = "";
		md5str = MD5Encrypt.encrypt("17863137875", "123456");
		System.out.println("第一次加密结果：" + md5str);
		System.out.println("第二次加密结果：" + MD5Encrypt.encryptAddSalt(md5str, 20170427L));
	}
	
}
