package socket;

import java.io.IOException;
import java.net.InetAddress;

/******************************************************************************
 *  Author:        Zhang Xuan
 *  Written:       2018/6/8
 *  Last updated:  2018/6/8
 *  Compilation:   javac InetAddressTest.java
 *  Description: 
 *
 ******************************************************************************/


public class InetAddressTest {
    public static void main(String[] args) throws IOException{
        if ("google.com".length() > 0) {
            String host = "google.com";
            InetAddress[] addresses = InetAddress.getAllByName(host);

            for (InetAddress a : addresses) {
                System.out.println(a);
            }
        } else {
            InetAddress localHostAddress = InetAddress.getLocalHost();
            System.out.println(localHostAddress);
        }
    }
}
