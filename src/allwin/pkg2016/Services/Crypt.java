/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allwin.pkg2016.Services;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;





/**
 *
 * @author Mahmoud
 */

public class Crypt {

    public static String decrypt(String encryptedInput) {
        try {
              return StringUtils.newStringUtf8(Base64.decodeBase64(encryptedInput));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String encrypt(String str) {
        try {
             return Base64.encodeBase64String(StringUtils.getBytesUtf8(str));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
