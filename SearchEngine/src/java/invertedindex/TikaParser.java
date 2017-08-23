/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;
import org.json.simple.JSONObject;

    


/**
 *
 * @author kkgarg
 */
public class TikaParser {
    
    
   
   
    
    
    //detecting the file type
    public JSONObject tika(File f) throws FileNotFoundException, IOException, SAXException, TikaException{
      String content = "";
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      ParseContext pcontext = new ParseContext();
      InputStream inputstream = new FileInputStream(new File(f.getPath())); 
      
      
//      if(filename.endsWith(".pdf")){
//          PDFParser parser = new PDFParser();
//          parser.parse(inputstream, handler, metadata,pcontext);
//      }
//      else if(filename.endsWith(".doc")){
//          OOXMLParser  parser = new OOXMLParser ();
//          parser.parse(inputstream, handler, metadata,pcontext);
//      }
//      else{
      AutoDetectParser parser = new AutoDetectParser();
      parser.parse(inputstream, handler, metadata);
//      }
//      System.out.println("TITLE IS "+ metadata.);
      
//        System.out.println("File : " +f.getName());
        content += handler.toString();
        //content = unwrapText(content);
//       System.out.println("Contents of the document:" + handler.toString());
//       System.out.println("Metadata of the document:");
       String[] metadataNames = metadata.names();
       Map<String,String> myMetdataMap = new HashMap<String, String>();
       for(String name: metadataNames){
           myMetdataMap.put(name, metadata.get(name));
       }
//        for(String name : metadataNames) {
//         System.out.println(name + ":   " + metadata.get(name));  
//        }
//        
//          System.out.println("TIKA ENDS HERE");
        
    JSONObject jsonHolder = new JSONObject();
    jsonHolder.put("filename",f.getName().toLowerCase());
    jsonHolder.put("path", f.getPath());
    jsonHolder.put("contents", content);
    //Setting map values in json
    Iterator it = myMetdataMap.entrySet().iterator();
    while (it.hasNext()) 
    {
    Map.Entry pairs = (Map.Entry)it.next();
    jsonHolder.put(pairs.getKey(), pairs.getValue() );
    }
    jsonHolder.put("metadata",metadataNames);

      return jsonHolder;
      
    }
    
   
}
