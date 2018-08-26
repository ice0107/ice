package com.huawei.common.io;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.CountingOutputStream;
import com.huawei.common.utils.DetectionUtils;

import java.io.*;
import java.net.URL;

/**
* IO有关的操�?
* @author eagler006 email:eagler006@hotmail.com
* @version  1.1
*
*/
public class IOUtil {


	/*******************************流操�?*************************/
	/**
	* 
	* 将输入流输出到输出流
	* @param ins 输入�?
	* @param outs 输出�?OutputStream或�?Writer
	* @throws IOException
	*/
	public static void in2OutStream(InputStream ins, Object outs) throws IOException {
		if(outs instanceof OutputStream)
			IOUtils.copy(ins,(OutputStream)outs);
		if(outs instanceof Writer)
			IOUtils.copy(ins,(Writer)outs);
	}
	
	

	/**
	* 关闭�?
	* @param streams Reader、Writer、InputStream、OutputStream
	* 
	*/
	public static void closeAll(Object streams){
		if(streams instanceof Reader)
			IOUtils.closeQuietly((Reader) streams);
		if(streams instanceof Writer)
			IOUtils.closeQuietly((Writer) streams);
		if(streams instanceof InputStream)
			IOUtils.closeQuietly((InputStream) streams);
		if(streams instanceof OutputStream)
			IOUtils.closeQuietly((OutputStream) streams);
	}
	
	/**
	* 
	* 将输入流转化为自定义编码字符串，默认为utf-8
	* @param ins 输入�?
	* @param encoding 字符编码，当值为blank时，为utf-8
	* @return String 返回字符�?
	* @throws IOException
	*/
	public static String In2String(InputStream ins, String encoding) throws IOException {
		if(DetectionUtils.isBlank(encoding))
			encoding="UTF-8";
		return IOUtils.toString(ins,encoding);   
	}
	/**
	* 
	* 将网页转化为输入�?
	* @param surl 网址
	* @return InputStream 输入�?
	* @throws IOException
	*/
	public static InputStream Url2InStream(String surl) throws IOException {
		URL url = new URL(surl);
        return url.openStream();   

	}
	
	/**
	 * 从控制台读取�?��字符�?
	 * @return String 读取的字符串
	 * @throws IOException
	 */
	public static String readStringFromSystemIn() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return br.readLine();
		} finally {
			if (br != null)
				br.close();
		}
	}
	


	

	/*******************************构建流操�?*************************/

	/**
	 * 当ObjectInputStream对象调用
	 * readObject();�?会从ByteArrayInputStream流中反序列化出的对象
	 * @param bi
	 * @return ObjectInputStream 对象输入�?
	 * @throws IOException
	 */

	public static ObjectInputStream buildObjectInputStream(ByteArrayInputStream bi) throws IOException {
		return new ObjectInputStream(bi);
	}

	/**
	 * 当ObjectOutputStream对象调用
	 * writeObject(o);�?o对象会序列化到ByteArrayOutputStream流中�?
	 * @param bos 字节数组�?
	 * @return ObjectOutputStream 对象输出�?
	 * @throws IOException
	 */

	public static ObjectOutputStream buildObjectOutputStream(ByteArrayOutputStream bos) throws IOException {
		return new ObjectOutputStream(bos);
	}

	
	/**
	 * 将字符串转化为打�?��缓存的Reader
	 * @param str 字符�?
	 * @return BufferedReader 对象输出�?
	 * 
	 */
	
	public static BufferedReader buildBufferedReader(String str) {

		return new BufferedReader(new StringReader(str));

	}
	/**
	 * 建字节流
	 * @param str 字符�?
	 * @return ByteArrayInputStream 字节数组�?
	 * 
	 */
	
	public static ByteArrayInputStream buildByteArrayInputStream(String str) {

		return new ByteArrayInputStream(str.getBytes());

	}
	/**
	 * 建字节流
	 * @param bt 字节数组
	 * @return ByteArrayInputStream 字节数组�?
	 * 
	 */
	public static ByteArrayInputStream buildByteArrayInputStream(byte[] bt) {

		return new ByteArrayInputStream(bt);

	}
	/**
	 * 获取字数
	 * @param countStream 用于计算字节的输出流
	 * @return  in 字数
	 * 
	 */
	public static int getStreamCount(CountingOutputStream countStream){
		
		return countStream.getCount( );   

	}

}