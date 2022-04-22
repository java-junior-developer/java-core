package ru.itmo.lessons.lesson22.decorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncryptedInputStream extends FilterInputStream {
    private String key;
    public EncryptedInputStream(InputStream in, String key) {
        super(in);
        this.key = key;
    }

    @Override
    public int read(byte[] b) throws IOException {
        // 1. super.read(b); прочитать данные в массив b
        // 2. дешифровать данные, которые находятся в массиве b
        // 3. вернуть количество прочитанных байт
        return 0;
    }
}
