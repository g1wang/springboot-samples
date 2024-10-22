package com.example.demostarter.java;

/**
 * 命令转义
 * <p>
 * 规则如下<br>
 * 0x5e -> 0x1e0x5d<br>
 * 0x7e -> 0x1e0x7d<br>
 * 0x1e -> 0x1e0x00<br>
 * 
 * @author mingqi.wang
 * @since 2018年1月22日
 */
public class Escape {
  /**
   * 开始标志
   */
  public final static String START_FLAG="5E";
  /**
   * 开始转义
   */
  public final static String START_FLAG_ESCAPE="1E 5D";
  /**
   * 结束标志
   */
  public final static String END_FLAG="7E";
  /**
   * 结束转义
   */
  public final static String END_FLAG_ESCAPE="1E 7D";
  /**
   * 转义字符
   */
  public final static String ESCAPE="1E";
  /**
   * 转义字符替换
   */
  public final static String ESCAPE_FLAG="1E 00";
  /**
   * 转义
   * @param b
   * @return
   */
  public static byte[] escape(byte[] b){
      String s=bytesToHexString(b);
      s=addSpace(s);
      s=s.replace(ESCAPE+" ", ESCAPE_FLAG+" ").replace(START_FLAG+" ", START_FLAG_ESCAPE+" ").replace(END_FLAG+" ", END_FLAG_ESCAPE+" ");
      s=s.trim().replace(" ", "");
      byte[] c=hexStringToBytes(s);
      return c;
  }
  
  public static String addSpace(String s){
	  String r="";
	  for(int i=0;i<s.length();i++){
		  r+=s.charAt(i);
		  if(i%2==1)
			  r+=" ";
	  }
	  return r;
  }

  /**
   * 逆转义
   * @param b
   * @return
   */
  public static byte[] unescape(byte[] b){
      String s=bytesToHexString(b);
      s=addSpace(s);
      s=s.replace(START_FLAG_ESCAPE+" ", START_FLAG+" ").replace(END_FLAG_ESCAPE+" ", END_FLAG+" ").replace(ESCAPE_FLAG+" ", ESCAPE+" ");
      s=s.trim().replace(" ", "");
      byte[] c=hexStringToBytes(s);
      return c;
  }
  
  public static String byte1ToHexString(int v) {
    String hex = Integer.toHexString(0xFF & v);
    while (hex.length() < 2) {
      hex="0"+hex;
    }
    return hex.toUpperCase();
  }
  
  public static String byte2ToHexString(int v) {
    String hex = Integer.toHexString(0xFFFF & v);
    while (hex.length() < 4) {
      hex="0"+hex;
    }
    return hex.toUpperCase();
  }

  public static String bytesToHexString(byte[] bArray) {
    //String hex=Hex.encodeHexString(bArray,false);
    //return hex;
    StringBuffer sb = new StringBuffer(bArray.length);
    String sTemp;
    for (int i = 0; i < bArray.length; i++) {
     sTemp = Integer.toHexString(0xFF & bArray[i]);
     if (sTemp.length() < 2)
      sb.append(0);
     sb.append(sTemp.toUpperCase());
    }
    return sb.toString();
  }
  
  public static String bytesToHexStringReverse(byte[] bArray) {
	    //String hex=Hex.encodeHexString(bArray,false);
	    //return hex;
	    StringBuffer sb = new StringBuffer(bArray.length);
	    String sTemp;
	    for (int i = bArray.length-1; i >=0; i--) {
	     sTemp = Integer.toHexString(0xFF & bArray[i]);
	     if (sTemp.length() < 2)
	      sb.append(0);
	     sb.append(sTemp.toUpperCase());
	    }
	    return sb.toString();
	  }
  
  public static String IntegerToHexStringReverse(int number){
	  String numberStr=Integer.toHexString(number);
		while(numberStr.length()<4)numberStr="0"+numberStr;
		String reverse=numberStr.substring(2,4)+numberStr.substring(0,2);
	return reverse;
  }

  public static byte[] hexStringToBytes(String hexString){
//    byte[] bs=null;
//    try {
//      bs = Hex.decodeHex(hexString);
//    } catch (DecoderException e) {
//      throw new RuntimeException(e);
//    }
//    return bs;
    hexString = hexString.toUpperCase();
    int length = hexString.length() / 2;
    char[] hexChars = hexString.toCharArray();
    byte[] d = new byte[length];
    for (int i = 0; i < length; i++) {
        int pos = i * 2;
        d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));
        
    }
    return d;
  }
  
  public static int hexToInt(String hex) {
    Integer v=Integer.parseInt(hex, 16);
    return v;
  }
  
  public static char hexToChar(String hex) {
    int v=hexToInt(hex);
    return (char)v;
  }
  
  public static int hexToByte(String hex) {
    Integer v=Integer.parseInt(hex, 16);
    return v.byteValue();
  }
  
  
  /**
   * 获取字节某一位置BIT值
   * @param b   byte
   * @param pos 位置：从0-1
   * @return    [0,1]
   */
  public static byte byteBitValue(byte b,int pos) {  
    return (byte)((b >> pos) & 0x1); 
  } 
  
  public static int bytesToInt(byte[] src) {
      byte[] bytes= {0x0,0x0,0x0,0x0};
      for(int i=0; i<src.length; i++) {
        bytes[i]=src[i];
      }
      int value;
      value = (int) ((bytes[0] & 0xFF) | ((bytes[1] & 0xFF) << 8) | ((bytes[2] & 0xFF) << 16) | ((bytes[3] & 0xFF) << 24));
      return value;
  }
  
  private static byte charToByte(char c) {
    return (byte) "0123456789ABCDEF".indexOf(c);
  }
  
  public static void main(String[] args) {
	String s="38 39 38 36 30 32 42 37 31 33 31 37 30 30 30 39 38 32 31 37 00  ";
	byte[] bs=hexStringToBytes(s.replace(" ", ""));
	String ss=new String(bs);
	System.out.println(ss);
}
  
//  public static void main(String[] args) throws DecoderException {
//    char ii=0x0A;
//    String hex=byte2ToHexString(ii);
//    byte[] bytes=hexStringToBytes(hex);
//    int i=Integer.parseInt(hex,16);
//    System.out.println(i);
//    byte[] contentBytes= Hex.decodeHex("fe");
//    System.out.println(contentBytes);
//  }
}
