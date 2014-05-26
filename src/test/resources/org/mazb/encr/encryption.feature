Feature: text encryption using AES algorithm

Scenario: Encrypting text using AES encryption algorithm
Given the encryption algorithmm is "AES"
And we set the encryptor key "DEFAULT_ENCRYPTOR_KEY_1234"
When we give text "BAHLUL ENTE"
Then the result should be "/0YQIBztk6sqIRiw/Bh3Mw=="

Scenario: Decrypting text using AES encryption algorithm
Given the decryption algorithmm is "AES"
And we set the decryptor key "DEFAULT_ENCRYPTOR_KEY_1234"
When we give text "/0YQIBztk6sqIRiw/Bh3Mw=="
Then the result should be "BAHLUL ENTE"