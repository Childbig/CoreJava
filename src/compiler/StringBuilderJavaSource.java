package compiler;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/6/25
 *  Last updated:  2018/6/25
 *  Compilation:   javac StringBuilderJavaSource.java
 *  Description: 
 *
 ******************************************************************************/


public class StringBuilderJavaSource extends SimpleJavaFileObject {
    private StringBuilder code;

    public StringBuilderJavaSource(String name) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        code = new StringBuilder();
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return code;
    }

    public void append(String str) {
        code.append(str);
        code.append('\n');
    }
}
