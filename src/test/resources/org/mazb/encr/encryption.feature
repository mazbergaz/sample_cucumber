Feature: text encryption using AES algorithm

Scenario: Encrypting text using AES encryption algorithm
Given the encryption algorithmm is "AES"
And we set the encryptor key "DEFAULT_ENCRYPTOR_KEY_1234"
When we give text to encrypt "BAHLUL ENTE"
Then the encryption result should be "/0YQIBztk6sqIRiw/Bh3Mw=="
And the decryption should bring "/0YQIBztk6sqIRiw/Bh3Mw==" back to "BAHLUL ENTE"