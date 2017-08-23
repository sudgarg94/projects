/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import org.bouncycastle.util.test.Test;

/**
 *
 * @author kkgarg
 */
public class ConfigFile {
    
    
  
   public String getIndexPath() throws UnsupportedEncodingException, URISyntaxException{
       
        URL url = Test.class.getProtectionDomain().getCodeSource().getLocation();
        File f = new File(url.toURI());
        String decodedPath = f.getParentFile().getParentFile().getParentFile().getPath();
        String indexPath = decodedPath+"/Files/indexDir";
//        INDEXLOCATION = indexPath;
        return indexPath;
//        return INDEXLOCATION;
   }
   
   public String getFilePath() throws UnsupportedEncodingException, URISyntaxException{
       
        URL url = Test.class.getProtectionDomain().getCodeSource().getLocation();
        File f = new File(url.toURI());
        String decodedPath = f.getParentFile().getParentFile().getParentFile().getPath();
        String filePath = decodedPath+"/Files/fileLocation";
//        INDEXLOCATION = indexPath;
        return filePath;
//        return INDEXLOCATION;
   }
   
   public String getLineIndexPath() throws UnsupportedEncodingException, URISyntaxException{
       
        URL url = Test.class.getProtectionDomain().getCodeSource().getLocation();
        File f = new File(url.toURI());
        String decodedPath = f.getParentFile().getParentFile().getParentFile().getPath();
        String lineIndexPath = decodedPath+"/Files/lineIndexDir";

        return lineIndexPath;

   }
   
   public String getTopicsFile()throws UnsupportedEncodingException, URISyntaxException{
       
        URL url = Test.class.getProtectionDomain().getCodeSource().getLocation();
        File f = new File(url.toURI());
        String decodedPath = f.getParentFile().getParentFile().getParentFile().getPath();
        String lineIndexPath = decodedPath+"/Files/precisionRecall/topicsFile.txt";

        return lineIndexPath;
       
   }
   
   public String getQrelsFile()throws UnsupportedEncodingException, URISyntaxException{
       
       URL url = Test.class.getProtectionDomain().getCodeSource().getLocation();
        File f = new File(url.toURI());
        String decodedPath = f.getParentFile().getParentFile().getParentFile().getPath();
        String lineIndexPath = decodedPath+"/Files/precisionRecall/qrels.txt";
        
        return lineIndexPath;
   }
   
}
