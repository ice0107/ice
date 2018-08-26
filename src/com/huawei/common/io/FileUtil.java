package com.huawei.common.io;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.*;
import org.springframework.web.multipart.MultipartFile;
import com.huawei.common.utils.DetectionUtils;

import static com.huawei.common.ConstUtil.FILE_LOCAL_ADDRESS;
import static com.huawei.common.ConstUtil.FILE_SERVER_ADDRESS;

import java.io.*;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
* 文件操作工具�?
* @author eagler006 email:eagler006@hotmail.com
* @version  1.1
*
*/
public class FileUtil {

	/**
	 * @author Ice
	 * @param file
	 * @return
     */
	public static String saveFile2Server(MultipartFile file){
		if (file == null) return null;
		Date date = new Date();
		String dirName = new SimpleDateFormat("yyyyMMdd").format(date) + "/";
		String filePath = FILE_LOCAL_ADDRESS + dirName;
		String returnPath = FILE_SERVER_ADDRESS + dirName;
		try{
			File dir = new File(filePath);
			if (!dir.exists() && !dir.isDirectory()){
				dir.mkdir();
			}
			String fileName = Long.toString(System.currentTimeMillis());
			filePath += fileName;
			returnPath += fileName;
			file.transferTo(new File(filePath));
		} catch (Exception e){
			e.printStackTrace();
			returnPath = null;
		}
		return returnPath;
	}

	/**
	* <p>将字符串写入指定文件</p>
	* @param res 源字符串
	* @param distFile 目标文件
	* @param encoding 字符编码
	* @throws IOException
	* 
	*/
	public static void string2File(String res, File distFile, String encoding)
			throws IOException {

		if (DetectionUtils.isBlank(encoding))
			encoding = "utf-8";
		FileUtils.writeStringToFile(distFile, res, encoding);

	}

	/**
	 * <p>文本文件转换为指定编码的字符�?/p>
	 * 
	 * @param file
	 *            文本文件
	 * @param encoding
	 *            编码类型 没有编码方式,传入NULL既可,将使用默认的编码方式 utf-8
	 * @return String 转换后的字符�?
	 * @throws IOException
	 */
	public static String file2String(File file, String encoding)
			throws IOException {
		if (DetectionUtils.isBlank(encoding))
			encoding = "utf-8";
		return FileUtils.readFileToString(file, encoding);
	}
	/**
	 * <p>文本文件转换为指定编码的byte数组</p>
	 * 
	 * @param file
	 *            文本文件
	 * @param encoding
	 *            编码类型 没有编码方式,传入NULL既可,将使用默认的编码方式 utf-8
	 * @return byte[] 转换后的字节数组
	 * @throws IOException
	 */
	public static byte[] file2bytes(File file, String encoding)
			throws IOException {
		if (DetectionUtils.isBlank(encoding))
			encoding = "utf-8";

		return FileUtils.readFileToByteArray(file);

	}

	/**
	* <p>逐行读取文本内容</p>
	* @param file 文本文件
	* @param encoding 编码类型 没有编码方式,传入NULL既可,将使用默认的编码方式 utf-8
	* @return LineIterator 
	* @throws IOException
	* 
	*/
	public static LineIterator readLines(File file, String encoding)
			throws IOException {
		if (DetectionUtils.isBlank(encoding))
			encoding = "utf-8";

		return FileUtils.lineIterator(file, encoding);

	}

	/* ========对文件操�?复制,删除,移动) ======== */

	/**
	 * <p>复制文件,复制前后文件完全�?���?/p>
	 * 
	 * @param resFile
	 *            源文件路�?
	 * @param distFolder
	 *            目标文件�?
	 * @throws 当操作发生异常时抛出
	 */
	public static void copyFile2Folder(File resFile, File distFolder)
			throws IOException {

		FileUtils.copyFileToDirectory(resFile, distFolder);
	}
	
	/**
	 * <p>复制目录,复制前后文件完全�?���?/p>
	 * 
	 * @param resFile
	 *            源文件路�?
	 * @param distFolder
	 *            目标文件�?
	 * @throws 当操作发生异常时抛出
	 */
	public static void copyFolder2Folder(File resFolder, File distFolder)
			throws IOException {
		
		FileUtils.copyDirectoryToDirectory(resFolder, distFolder);
	}
	
	/**
	 * <p>复制文件</p>
	 * 
	 * @param resFilePath
	 *            源文�?
	 * @param distFilePath
	 *            目标文件
	 * @throws 当操作发生异常时抛出
	 */
	public static void copyFile2File(File resFilePath, File distFilePath)
			throws IOException {
			FileUtils.copyFile(resFilePath, distFilePath);   

	}
	/**
	 * <p>复制网址内容</p>
	 * 
	 * @param surl
	 *            源网�?
	 * @param file
	 *            目标文件
	 * @throws 当操作发生异常时抛出
	 */
	public static void copyUrl2File(String surl, File file) throws IOException {
		 URL url = new URL(surl);

		FileUtils.copyURLToFile(url,file);
	}

	/* ========递归删除目录和文�?======== */
	/**
	 *<p> 删除目录</p>
	 * 
	 * @param dir
	 *            目录
	 * @param isdeldirectory
	 *            是否删除目录文件�?
	 * @throws IOException
	 */
	public static void delDirectory(File dir, boolean isdeldirectory)
			throws IOException {
		if (isdeldirectory)
			FileUtils.deleteDirectory(dir);
		else
			FileUtils.cleanDirectory(dir);

	}

	/**
	 * <p>删除�?��文件</p>
	 * 
	 * @param file
	 *            文件
	 * @throws 当操作发生异常时抛出
	 */
	public static void deleteFile(File file) throws IOException {
		
		FileUtils.deleteQuietly(file);
	}

	/**
	 * <p>移动文件或�?目录,移动前后文件完全�?��,如果目标文件夹不存在则创建�?</p>
	 * 
	 * @param res
	 *            源文件或文件夹路�?
	 * @param dist
	 *            目标文件或文件夹路径
	 * @throws 当操作发生异常时抛出
	 */
	public static void moveFile(File res, File dist)
			throws IOException {
		if (res.isDirectory() && dist.isDirectory()) {
			copyFolder2Folder(res, dist);
			delDirectory(res,true);

		} else if (res.isFile() && dist.isDirectory()) {
			copyFile2Folder(res, dist);
			deleteFile(res);
		}else {
			
			copyFile2File(res, dist);
			deleteFile(res);
		}
	}

	/**
	 * <p>重命名文件或文件�?/p>
	 * 
	 * @param resFilePath
	 *            源文件路�?
	 * @param newFilePath
	 *            重命�?
	 * @return boolean 操作成功标识
	 * @throws IOException
	 */
	public static void renameFile(File res, File dist) throws IOException {

		moveFile( res,  dist);
	}


	/**
	 * 读取文件或�?目录的大�?
	 * 
	 * @param distFile
	 *            目标文件或�?文件�?
	 * @return 文件或�?目录的大小，如果获取失败，则返回-1
	 */
	public static long genFileSize(File distFile) {
		if (distFile.isFile()) {
			return distFile.length();
		} else if (distFile.isDirectory()) {
			return FileUtils.sizeOfDirectory(distFile);
		}
		return -1L;
	}

	/**
	 * 判断�?��文件是否存在
	 * 
	 * @param filePath
	 *            文件路径
	 * @return boolean 存在返回true，否则返回false
	 */
	public static boolean isExist(String filePath) {
		return new File(filePath).exists();
	}

	/**
	 * 本地某个目录下的文件列表（不递归�?
	 * 
	 * @param folder
	 *            ftp上的某个目录
	 * @param suffix
	 *            文件的后�?��（比�?mov.xml)
	 * @return 文件名称列表
	 */
	public static String[] listFilebySuffix(String folder, String suffix) {
		IOFileFilter fileFilter1 = new SuffixFileFilter(suffix);
		IOFileFilter fileFilter2 = new NotFileFilter(
				DirectoryFileFilter.INSTANCE);
		FilenameFilter filenameFilter = new AndFileFilter(fileFilter1,
				fileFilter2);
		return new File(folder).list(filenameFilter);
	}

	
	/**
	 * 获取文件�?��磁盘的剩余空�?
	 * 
	 * @param dirpath

	 * @return long
	 */
	@SuppressWarnings("deprecation")
	public static long getFreeSpace(String dirpath) throws IOException {
		
		return FileSystemUtils.freeSpace(dirpath);
	}
	
	
	public static byte[] bigfile2bytes(String path, long pos, int size) throws FileNotFoundException, IOException {
		
		MappedByteBuffer out = new RandomAccessFile(path, "rw").getChannel()
		.map(FileChannel.MapMode.READ_ONLY,pos, size);
		byte[] dst=new byte[size];
		out.get(dst);
		return dst;
	}

}
