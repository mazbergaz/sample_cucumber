package org.mazb.encr;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang.StringUtils;
import org.mazb.encr.AesEncryptor;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class EncryptionStepDefinition {
	
	private AesEncryptor encryptor = new AesEncryptor();
	
	@Given("^the encryption algorithmm is \"([^\"]*)\"$")
	public void encryptionAlgorithm(String algo){
		encryptor.setAlgorithmName(algo);
	}
	
	@Given("^we set the encryptor key \"([^\"]*)\"$")
	public void encryptorKey(String encryptorKey){
		encryptor.setEncryptorKey(encryptorKey);
	}
	
	@When("^we give text to encrypt \"([^\"]*)\"$")
	public void setText(String text){
		encryptor.setText(text);
	}
	
	@Then("^the encryption result should be \"([^\"]*)\"$")
	public void getResult(String result) throws Exception{
		assertTrue(StringUtils.equals(encryptor.encrypt(), result));
	}
	
	@Then("^the decryption should bring \"([^\"]*)\" back to \"([^\"]*)\"$")
	public void getDecryptionResult(String encrypted, String original) throws Exception{
		encryptor.setText(encrypted);
		assertTrue(StringUtils.equals(encryptor.decrypt(), original));
	}
	
}
