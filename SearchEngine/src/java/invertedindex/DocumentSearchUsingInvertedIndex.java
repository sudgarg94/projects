/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.simple.JSONObject;
/**
 *
 * @author kkgarg
 */
public class DocumentSearchUsingInvertedIndex {
    
    
    private static ArrayList<File> queue = new ArrayList<File>();
    

    
      private String getFileLocation(){
          String fileLocation="";
        try{
            ConfigFile cf = new ConfigFile();
            fileLocation = cf.getFilePath();
        } catch(Exception e){
            System.out.println(e);
        }
        return fileLocation;
    }
    
    
    public void indexBuilder() throws IOException{
        try{
            addFiles(new File(getFileLocation()));
            IndexCreater indexCreater = new IndexCreater();
            LineIndexing lI = new LineIndexing();
            for(File f : queue){
                TikaParser tikaParser = new TikaParser();
                JSONObject fileDetails = tikaParser.tika(f);
                indexCreater.indexFileOrDirectory(fileDetails);   
                
            }
            
            
            System.out.println("Creating Full Index");
            System.out.println("************************");
            System.out.println(indexCreater.count + " documents added.");
            System.out.println("************************");
            indexCreater.closeIndex();
            
            System.out.println("Creating Line Index");
            
            lI.indexFileOrDirectory(queue);
            lI.closeIndex();
            
            
//            SearchIndex searchIndex = new SearchIndex();
//            searchIndex.search();
            
            
//            String content = tikaParser.tika();
//            System.out.println("Content is "+ content);
//            IndexCreater indexCreater = new IndexCreater();
//            SearchIndex searchIndex = new SearchIndex();
//            searchIndex.search();
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
     private static void addFiles(File file){
        
        if(!file.exists()){
            System.out.println(file+" does not exists.");
        }
        
        if(file.isDirectory()){
            for(File f : file.listFiles()){
                addFiles(f);
            }
        }else{
            String filename = file.getName().toLowerCase();
            
            //only index text files
            
//            if(filename.endsWith(".ds_store") || filename.endsWith(".html")
//                || filename.endsWith(".xml") || filename.endsWith(".txt"))
//            {
            if(!filename.endsWith(".ds_store"))
            {  
                queue.add(file);
                
            }
//            else{
//                System.out.println("Skipped"+ filename);
//            }
        }
        
    }
    
}
