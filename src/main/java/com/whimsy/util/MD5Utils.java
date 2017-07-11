package com.whimsy.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author CQY13 MD5加密工具类
 */
public class MD5Utils {

    /**
     * 获取MD5加密
     * 
     * @param pwd
     *            需要加密的字符串
     * @return String字符串 加密后的字符串
     */
    public static String getPwd(String pwd) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");

            // 调用加密对象的方法，加密的动作已经完成
            byte[] bs = digest.digest(pwd.getBytes());
            // 接下来，我们要对加密后的结果，进行优化，按照mysql的优化思路走
            // mysql的优化思路：
            // 第一步，将数据全部转换成正数：
            String hexString = "";
            for (byte b : bs) {
                // 第一步，将数据全部转换成正数：
                // 解释：为什么采用b&255
                /*
                 * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                 * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                 * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                 * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                 * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                 */
                int temp = b & 255;
                // 第二步，将所有的数据转换成16进制的形式
                // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                // 因此，需要对temp进行判断
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个“0”
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
    private final static String[] HEXDIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d","e", "f" };  
    
    public final static String getMD5(String str){  
        if (str != null) {  
            try {  
                // 创建具有指定算法名称的信息摘要  
                MessageDigest md = MessageDigest.getInstance("MD5");  
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算  
                byte[] results = md.digest(str.getBytes()); // 将得到的字节数组变成字符串返回  
                StringBuffer resultSb = new StringBuffer();  
                String a = "";  
                for (int i = 0; i < results.length; i++) {  
                    int n = results[i];  
                    if (n < 0)  
                        n = 256 + n;  
                    int d1 = n / 16;  
                    int d2 = n % 16;  
                    a = HEXDIGITS[d1] + HEXDIGITS[d2];  
                    resultSb.append(a);  
                }  
                return resultSb.toString();  
            } catch (Exception ex) {  
                ex.printStackTrace();  
            }  
        }  
        return null;  
    }  
    /**
     * @param args
     */
    public static void main(String[] args) {
        String pwd = MD5Utils.getPwd("abc");
        System.out.println(pwd);
    }

}
