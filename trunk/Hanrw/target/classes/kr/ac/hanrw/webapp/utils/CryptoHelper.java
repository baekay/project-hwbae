package kr.ac.hanrw.webapp.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CryptoHelper {
	static final String key="iwanttobuyrx1";

	public static Key getKey() throws Exception {
		return (key.length() == 24) ? getKey2(key) : getKey1(key);
	}

	public static Key getKey1(String keyValue) throws Exception {
		DESKeySpec desKeySpec = new DESKeySpec(keyValue.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		Key key = keyFactory.generateSecret(desKeySpec);
		return key;
	}

	public static Key getKey2(String keyValue) throws Exception {
		DESedeKeySpec desKeySpec = new DESedeKeySpec(keyValue.getBytes());
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
		Key key = keyFactory.generateSecret(desKeySpec);
		return key;
	}

	public static String encrypt(String ID) throws Exception {
		if (ID == null || ID.length() == 0)
			return "";

		String instance = (key.length() == 24) ? "DESede/ECB/PKCS5Padding"
				: "DES/ECB/PKCS5Padding";
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(instance);
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE,getKey());
		String amalgam = ID;

		byte[] inputBytes1 = amalgam.getBytes("UTF8");
		byte[] outputBytes1 = cipher.doFinal(inputBytes1);
//		Base64 encoder = new Base64();
		
//		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
//		String outputStr1 = encoder.encode(outputBytes1);
		String outputStr1 = Base64.encodeBase64String(outputBytes1);
		return outputStr1;
	}

	public static String decrypt(String codedID) throws Exception {
		if (codedID == null || codedID.length() == 0)
			return "";

		String instance = (key.length() == 24) ? "DESede/ECB/PKCS5Padding"
				: "DES/ECB/PKCS5Padding";
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(instance);
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE,getKey());
		
//		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		
//		byte[] inputBytes1 = decoder.decodeBuffer(codedID);
		byte[] inputBytes1 = Base64.decodeBase64(codedID);
		byte[] outputBytes2 = cipher.doFinal(inputBytes1);

		String strResult = new String(outputBytes2, "UTF8");
		return strResult;
	}

    public static String sha1(String plainTxt) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
        return messageDigest.digest(plainTxt.getBytes()).toString();
    }

}
