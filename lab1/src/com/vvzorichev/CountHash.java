package com.vvzorichev;
 
import org.apache.commons.codec.digest.DigestUtils;
 
import java.io.FileInputStream;
import java.io.IOException;
 
public class CountHash {
 
    private String FileName;
 
    public CountHash(String str) {
        this.FileName = str;
    }
 
    public String CountMd5() throws IOException {
        return DigestUtils.md5Hex(new FileInputStream(FileName));
    }
 
    public String CountSha256() throws IOException {       
        return DigestUtils.sha256Hex(new FileInputStream(FileName));
    }
}
