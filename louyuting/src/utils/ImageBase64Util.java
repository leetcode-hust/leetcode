package utils;

import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;


/**
 * function: 图片传输需要的操作
 * @author LL
 * @since 2016-7-19
 * 
 */
@SuppressWarnings("unused")
public class ImageBase64Util {

	public static final String DECODE_FAIL="decode fail";
    /**
     * 从path这个地址获取一张图片然后转为base64码
     * @param imgName  图片的名字 如：123.gif（是带后缀的）
     * @param path     123.gif图片存放的路径
     * @return  图片的base64码的字符串
     */
    public static String getImageFromServer(String imgName,String path)throws Exception{
        BASE64Encoder encoder = new BASE64Encoder();
        File f = new File(path+imgName);
        if(!f.exists()){
            f.createNewFile();
        }
        BufferedImage bi = ImageIO.read(f);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, "jpg", baos);
        byte[] bytes = baos.toByteArray();
        return encoder.encodeBuffer(bytes).trim();
    }

    /**
     * 将一个base64转换成图片保存在  path  文件夹下   名为imgName.gif
     * @param base64String
     * @param path  是一个文件夹路径
     * @param imgName 图片名字(没有后缀)
     * @throws Exception
     */
    public static String savePictoServer(String base64String,String path,String imgName)throws Exception{
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] bytes1 = decoder.decodeBuffer(base64String);
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
        BufferedImage bi1 =ImageIO.read(bais);

        String realPath = path;
        File dir=new File(realPath);
        if(!dir.exists()){
            dir.mkdir();
        }
        String fileName=path+imgName+".jpg";
        File w2 = new File(fileName);//可以是jpg,png,gif格式
        ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
        return fileName;
    }
    
    /**
     * 将图片经过base64压缩之后的字符串解压成图片(这里的base64字符串包是通过web端上传的，包含前面的图片类型信息，比如:dataStructure:image/jpeg;base64,)
     * @param base64 base64编码之后的字符串
     * @param path 图片的保存路径(目录)
     * @param imgName 图片的保存名字,这里的名字不加文件扩展名
     * @return 最后图片保存的名字，如果图片名字为""，表示保存失败
     */
	public static String decodeBase64ToImage(String base64, String path, String imgName) {
		//先判断图片包含图片的头信息不？
	    if(base64.startsWith("dataStructure:image/jpeg")) {
	        imgName = imgName+".jpeg";
	    }else if(base64.startsWith("dataStructure:image/jpg")){
	        imgName = imgName+".jpg";
	    }else if(base64.startsWith("dataStructure:image/png")){
	        imgName = imgName+".png";
	    }else if(base64.startsWith("dataStructure:image/gif")) {
	        imgName = imgName+".gif";
	    }else if(base64.startsWith("dataStructure:image/jpe")) {
	        imgName = imgName+".jpe";
	    }else if(base64.startsWith("dataStructure:image/bmp")) {
	        imgName = imgName+".bmp";
	    }else if(base64.startsWith("dataStructure:image/pcx")) {
	        imgName = imgName+".pcx";
	    }else{
	    	//其余的默认你保存为jpg
	    	imgName = imgName+".jpg";
	    }
	    //获取图片信息的第一个字符的索引值
	    int inx  = base64.indexOf("base64,");
	    String nbase64=null;
	    if(inx == -1){
	    	//说明不存在base64, 这段字符，获取端部的字符串
	    	nbase64 = base64.substring(inx+1);
	    }
	    else{
	    	//截取图片信息的字符串
	    	nbase64 = base64.substring(inx+7);
	    }
	    //解码
	    BASE64Decoder decoder = new BASE64Decoder();
	    try {
	    	File f = new File(path);
			if(!f.exists())
				f.mkdirs();
			
	    	if(!path.endsWith("/"))
	    		path = path+"/";
	    	
	        FileOutputStream write = new FileOutputStream(new File(path + imgName));
	        byte[] decoderBytes = decoder.decodeBuffer(nbase64);
	        write.write(decoderBytes);
	        write.close();
	        return imgName;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return "decodeFail";
	}
	
//============================================================================================================//
	@Test
	public void test2(){
		String base64=null;
		try {
			base64 = getImageFromServer("my2.jpg", "f:");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(base64);
		
		String name = decodeBase64ToImage(base64, "f:", "my3");
		System.out.println(name);
	}
}




















