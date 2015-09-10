package cc.cail.bugms.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PwdUtil {
	static String getSign(String pass){
        return  new SimpleHash("md5",pass,null,2).toHex();
    }
    
    public static void main(String[] args) {
        System.out.println(getSign("admin"));
    }
}
