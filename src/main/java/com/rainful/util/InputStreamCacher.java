package com.rainful.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import com.rainful.logger.Logger;
import com.rainful.logger.LoggerFactory;

public class InputStreamCacher {
    Logger logger = LoggerFactory.getLogger();
    /** 
     * 将InputStream中的字节保存到ByteArrayOutputStream中。 
     */  
    private ByteArrayOutputStream byteArrayOutputStream = null;  
      
    public InputStreamCacher(InputStream inputStream) {  
        if (inputStream == null)  
            return;  
          
        byteArrayOutputStream = new ByteArrayOutputStream();  
        byte[] buffer = new byte[1024];    
        int len;    
        try {  
            while ((len = inputStream.read(buffer)) > -1 ) {    
                byteArrayOutputStream.write(buffer, 0, len);    
            }  
            byteArrayOutputStream.flush();  
        } catch (IOException e) {  
            logger.error(e.getMessage());  
        }    
    }  
      
    public InputStream getInputStream() {  
        if (null==byteArrayOutputStream)  
            return null;  
          
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());  
    }  
}
