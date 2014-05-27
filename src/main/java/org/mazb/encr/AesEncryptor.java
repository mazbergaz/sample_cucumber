package org.mazb.encr;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AesEncryptor {
	
	private static final String ENCODING = "UTF-8";
	private static final String HASH = "SHA-1";
	
	private String algorithmName;
	private String encryptorKey;
	private String text;
	
	public AesEncryptor(){
		
	}
	
	public AesEncryptor(String text, String encryptorKey){
		this.algorithmName = "AES";
		this.text = text;
		this.encryptorKey = encryptorKey;
	}
	
	public String encrypt() throws Exception{
		return encrypt(text, encryptorKey);
	}
	
	public String decrypt() throws Exception{
		return decrypt(text, encryptorKey);
	}

	private String encrypt(String textToEncrypt, String encryptorKey) throws Exception {
		SecretKeySpec keySpec = getKey(encryptorKey);
		Cipher cipher = Cipher.getInstance(algorithmName);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		byte[] encryptedTextBytes = cipher.doFinal(textToEncrypt.getBytes(ENCODING));
		
		//wrong result
		return new Base64().encodeAsString(encryptedTextBytes) + "_";
		
		//correct result
		//return new Base64().encodeAsString(encryptedTextBytes);
	}

	private String decrypt(String textToDecrypt, String encryptorKey) throws Exception {
		SecretKeySpec keySpec = getKey(encryptorKey);
		Cipher cipher = Cipher.getInstance(algorithmName);
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		byte[] encryptedTextBytes = Base64.decodeBase64(textToDecrypt);
		byte[] decryptedTextBytes = cipher.doFinal(encryptedTextBytes);
		return new String(decryptedTextBytes);
	}
	
	private SecretKeySpec getKey(String myKey){
		SecretKeySpec secretKey = null;
        try {
        	byte[] key = myKey.getBytes(ENCODING);
            key = make16(key);
            secretKey = new SecretKeySpec(key, algorithmName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return secretKey;
    }
	
	private byte[] make16(byte[] key){
		byte[] result = null;
		try {
			MessageDigest sha = MessageDigest.getInstance(HASH);
	        key = sha.digest(key);
	        result = Arrays.copyOf(key, 16); // use only first 128 bit
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void setAlgorithmName(String algorithmName){
		this.algorithmName = algorithmName;
	}
	
	public void setEncryptorKey(String encryptorKey){
		this.encryptorKey = encryptorKey;
	}
	
	public void setText(String text){
		this.text = text;
	}

}
