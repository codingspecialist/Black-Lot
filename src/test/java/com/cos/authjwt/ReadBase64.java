package com.cos.authjwt;

import java.io.File;
import java.io.FileInputStream;
import java.util.Base64;

import org.junit.jupiter.api.Test;

public class ReadBase64 {

    @Test
    public void encoding() {
        // 이미지 파일을 base64로 배열에 넣어서 인코딩
        File file = new File("C:\\green_workspace\\downloads\\dog.png");
        byte[] data = new byte[(int) file.length()];
        try (FileInputStream stream = new FileInputStream(file)) {
            stream.read(data, 0, data.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String base64data = Base64.getEncoder().encodeToString(data);

        System.out.println(base64data);

        // 디코딩
        byte[] binary = Base64.getDecoder().decode(base64data);
        // System.out.println(binary);

    }
}
