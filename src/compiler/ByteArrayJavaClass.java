package compiler;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/6/25
 *  Last updated:  2018/6/25
 *  Compilation:   javac ByteArrayJavaClass.java
 *  Description: 
 *
 ******************************************************************************/


public class ByteArrayJavaClass extends SimpleJavaFileObject {
    private ByteArrayOutputStream stream;

    public ByteArrayJavaClass(String name) {
        super(URI.create("bytes:///" + name), Kind.CLASS);
        stream = new ByteArrayOutputStream();
    }

    public OutputStream openOutputStream() throws IOException {
        return  stream;
    }

    public byte[] getBytes() {
        return stream.toByteArray();
    }
}
