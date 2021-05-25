package com.oauth2.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.charset.Charset;
import java.security.KeyPair;

public class KeyToolUtil {

    public static void main(String[] args) {
        exportPublicKey("oauth2.keystore", "123456", "oauth2");
    }

    /**
     * 生成公钥，写入本地文件
     */
    public static void exportPublicKey(String keyStorePath, String storePassword, String alias) {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(keyStorePath), storePassword.toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(alias);

        // 设置编码，防止乱码
        // 注意第一行和最后一样样板行要字母大写
        try(OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("public.crt"), Charset.forName("utf-8").newEncoder())) {
            outputStreamWriter.write("-----BEGIN PUBLIC KEY-----\n");
            outputStreamWriter.write(new BASE64Encoder().encode(keyPair.getPublic().getEncoded()));
            outputStreamWriter.write("\n-----END PUBLIC KEY-----");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
