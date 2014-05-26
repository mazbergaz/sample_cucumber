package org.mazb.encr;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class EncryptionTest {
	
	private AesEncryptor encryptor = new AesEncryptor();
	
	@Given("^the encryption algorithmm is \"AES\"$")
	public void encryptionAlgorithm(){
		encryptor.setAlgorithmName("AES");
	}
	
	@Given("^we set the encryptor key \"DEFAULT_ENCRYPTOR_KEY_1234\"$")
	public void encryptorKey(){
		encryptor.setEncryptorKey("DEFAULT_ENCRYPTOR_KEY_1234");
	}
	
	@When("^we give text \"BAHLUL ENTE\"$")
	public void setText(){
		encryptor.setTextToEncrypt("BAHLUL ENTE");
	}
	
	@Then("^the result should be \"/0YQIBztk6sqIRiw/Bh3Mw==\"$")
	public void getResult() throws Exception{
		assertTrue(StringUtils.equals(encryptor.encrypt(), "/0YQIBztk6sqIRiw/Bh3Mw=="));
	}
	
	@Given("^the decryption algorithmm is \"AES\"$")
	public void decryptionAlgorithm(){
		encryptor.setAlgorithmName("AES");
	}
	
	@Given("^we set the decryptor key \"DEFAULT_ENCRYPTOR_KEY_1234\"$")
	public void decryptorKey(){
		encryptor.setEncryptorKey("DEFAULT_ENCRYPTOR_KEY_1234");
	}
	
	@When("^we give text \"/0YQIBztk6sqIRiw/Bh3Mw==\"$")
	public void setTextToDecrypt(){
		encryptor.setTextToEncrypt("/0YQIBztk6sqIRiw/Bh3Mw==");
	}
	
	@Then("^the result should be \"BAHLUL ENTE\"$")
	public void getDecryptResult() throws Exception{
		assertTrue(StringUtils.equals(encryptor.decrypt(), "BAHLUL ENTE"));
	}
	
}
