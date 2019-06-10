package com.zhongyp.advanced.rsa;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;
/**
 * RSA非对称加密算法。用法：1 公钥加密，私钥解密；2 私钥签名，公钥验证签名。
 */
public class RSAUtils {
    /** 指定加密算法为RSA */
    public static final String ALGORITHM = "RSA";
    /** 签名算法 */
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";
    /** 指定key的大小*/
    public static final int KEYSIZE = 1024;
    /** 加密时支持的最大字节数为【证书位数/8 -11】，1024位的证书加密时最大支持117个字节，2048位的证书加密时最大支持245个字节*/
    public static final int MAX_ENCRYPT_SIZE = KEYSIZE / 8 - 11 - 1;
    /** 解密是支持的最大字节数为【证书位数/8】，1024位的证书解密时最大支持128个字节，2048位的证书解密时最大支持256个字节*/
    public static final int MAX_DECRYPT_SIZE = KEYSIZE / 8;
    /** 指定公钥存放文件 */
    public static final String PUBLIC_KEY_FILE = "PublicKey";
    /** 指定私钥存放文件 */
    public static final String PRIVATE_KEY_FILE = "PrivateKey";
    /** 字符串编码 */
    public static final String CHARSET = "UTF-8";

    public static void main(String[] args) throws Exception {
        generateKeyPair();
        test1("1");
        String source = "一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九";//刚刚好117个字符
        test1(source);//证书位数为1024时，加密超过117个字符就会报异常：javax.crypto.IllegalBlockSizeException: Data must not be longer than 117 bytes
        test2(source + "我可以超过117个字符");
        test3(source.getBytes(CHARSET));
    }

    private static void test1(String source) throws Exception {
        String cryptograph = encrypt(source);// 生成的密文
        String target = decrypt(cryptograph);// 解密密文
        System.out.println("加密前【" + source + "】\n加密后【" + cryptograph + "】\n解密后【" + target + "】\n");
    }
    private static void test2(String source) throws Exception {
        source = "cfrCIV9XdWislxNDRnNe3IRwC1D0JZom2OYBKqT4nNrzJmC3Rrw0gARkRxxz4H92yO0mkHGteDz7hnGKg1D7K1/8lCs/68w8cyTu5G2y461ggCEDGFduclOk+NsAPptqAxVWWOXPE1lA8hfamLKsHBfOc1nxHBfFq+TCRYPgWShTqSt6mevC0y5MrTVCIOxH60iOfClOr85mLNRZj1IZq0060opUfgXy7+h3pAQJs7ZcVJWyrI4sszrqoxBdqgIC9lDW5UDaNOU3j5LWxDElQmrIH4jSbGWgEif4BYLkgEUAjexoqtjrXBPlnu4sSuiI/lZthWswovIJBgZZPKzIew==";
        byte[] cryptograph = source.getBytes();// 生成的密文
        String cryptographStr = Base64.getEncoder().encodeToString(cryptograph);//这里不能用new String()来还原字符串
        byte[] target = decrypt(cryptograph);// 解密密文
        System.out.println("加密前【" + source + "】\n加密后【" + cryptographStr + "】\n解密后【" + new String(target, CHARSET) + "】\n");
    }
    private static void test3(byte[] datas) throws Exception {
        byte[] signature = sign(datas);
        System.out.println("原始数据"+Arrays.toString(datas));
        System.out.println("签名数据"+Arrays.toString(signature));
        System.out.println("签名是否正确：" + verify(datas, signature));
    }
    //******************************************************************************************
    //                                                                              生成密钥
    //******************************************************************************************
    /**
     * 生成并持久化密钥对
     */
    public static void generateKeyPair() throws Exception {
        /** RSA算法要求有一个可信任的随机数源 */
        SecureRandom sr = new SecureRandom();
        /** 为RSA算法创建一个KeyPairGenerator对象 */
        KeyPairGenerator kpg = KeyPairGenerator.getInstance(ALGORITHM);
        /** 利用上面的随机数据源初始化这个KeyPairGenerator对象 */
        kpg.initialize(KEYSIZE, sr);
        /** 生成密匙对 */
        KeyPair kp = kpg.generateKeyPair();
        /** 得到公钥 */
        Key publicKey = kp.getPublic();
        /** 得到私钥 */
        Key privateKey = kp.getPrivate();
        /** 用对象流将生成的密钥写入文件 */
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(PUBLIC_KEY_FILE));
        ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(PRIVATE_KEY_FILE));
        oos1.writeObject(publicKey);
        oos2.writeObject(privateKey);
        /** 清空缓存，关闭文件输出流 */
        oos1.close();
        oos2.close();
    }
    /**
     * 获取公钥
     */
    public static Key getPublicKey() throws Exception {
        /** 将文件中的公钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PUBLIC_KEY_FILE));
        Key key = (Key) ois.readObject();//直接从持久化对象中获取KEY
        ois.close();
        return key;
    }
    /**
     * 获取私钥
     */
    public static Key getPrivateKey() throws Exception {
        /** 将文件中的私钥对象读出 */
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(PRIVATE_KEY_FILE));
        Key key = (Key) ois.readObject();
        ois.close();
        return key;
    }
    //******************************************************************************************
    //                                                                              加解密
    //******************************************************************************************
    /**
     * 加密
     */
    public static String encrypt(String source) throws Exception {
        /** 得到Cipher对象来实现对源数据的RSA加密 */
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey());//加密模式
        /** 执行加密操作*/
        byte[] b1 = cipher.doFinal(source.getBytes(CHARSET));
        return Base64.getEncoder().encodeToString(b1);
    }
    /**
     * 解密
     */
    public static String decrypt(String cryptograph) throws Exception {
        /** 得到Cipher对象对已用公钥加密的数据进行RSA解密 */
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, getPrivateKey());//解密模式
        byte[] b1 = Base64.getDecoder().decode(cryptograph);
        /** 执行解密操作 */
        byte[] b = cipher.doFinal(b1);
        return new String(b, CHARSET);
    }
    //******************************************************************************************
    //                                                                              分段加解密
    //******************************************************************************************
    /**
     * 分段加密
     */
    public static byte[] encrypt(byte[] data) throws Exception {
        Cipher cipher = Cipher.getInstance(getPublicKey().getAlgorithm());
        cipher.init(Cipher.ENCRYPT_MODE, getPublicKey());
        int inputLen = data.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        for (int i = 0; inputLen - offSet > 0; offSet = i * MAX_ENCRYPT_SIZE) {
            byte[] cache;
            if (inputLen - offSet > MAX_ENCRYPT_SIZE) cache = cipher.doFinal(data, offSet, MAX_ENCRYPT_SIZE);
            else cache = cipher.doFinal(data, offSet, inputLen - offSet);
            out.write(cache, 0, cache.length);
            ++i;
        }
        byte[] encryptedData = out.toByteArray();
        out.close();
        return encryptedData;
    }
    /**
     * 分段解密
     */
    public static byte[] decrypt(byte[] encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(getPrivateKey().getAlgorithm());
        cipher.init(Cipher.DECRYPT_MODE, getPrivateKey());
        int inputLen = encryptedData.length;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int offSet = 0;
        for (int i = 0; inputLen - offSet > 0; offSet = i * MAX_DECRYPT_SIZE) {
            byte[] cache;
            if (inputLen - offSet > MAX_DECRYPT_SIZE) cache = cipher.doFinal(encryptedData, offSet, MAX_DECRYPT_SIZE);
            else cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
            out.write(cache, 0, cache.length);
            ++i;
        }
        byte[] decryptedData = out.toByteArray();
        out.close();
        return decryptedData;
    }
    //******************************************************************************************
    //                                                                              签名
    //******************************************************************************************
    /**
     * 用私钥对信息生成数字签名
     */
    public static byte[] sign(byte[] data) throws Exception {
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initSign((PrivateKey) getPrivateKey());
        signature.update(data);
        return signature.sign();
    }
    /**
     * 用公钥校验数字签名
     * @param data 已加密数据
     * @param sign 数字签名
     */
    public static boolean verify(byte[] data, byte[] sign) throws Exception {
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        signature.initVerify((PublicKey) getPublicKey());
        signature.update(data);
        return signature.verify(sign);
    }
}
