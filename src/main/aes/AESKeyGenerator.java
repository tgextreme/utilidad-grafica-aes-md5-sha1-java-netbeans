/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.aes;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author usuario
 */
public class AESKeyGenerator {
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256); // Puedes usar 128, 192 o 256 bits.
        return keyGenerator.generateKey();
    }
}
