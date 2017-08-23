/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.apache.tika.metadata.Metadata;
import org.json.simple.JSONObject;


/**
 *
 * @author kkgarg
 */
public class IndexCreater {
    
    private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
//    private static Analyzer sanalyzer = new SimpleAnalyzer(Version.LUCENE_47);
    
    private IndexWriter writer;

    public static int count=0;
    
    
     private String getIndexPath(){
          String indexLocation="";
        try{
            ConfigFile cf = new ConfigFile();
            indexLocation = cf.getIndexPath();
        } catch(Exception e){
            System.out.println(e);
        }
        return indexLocation;
    }
     
    
    public IndexCreater() throws IOException {
        
        FSDirectory dir = FSDirectory.open(new File(getIndexPath()));
        
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47,analyzer);
        
        
        
//        File fileDir = new File(indexLocation);
//	for(File file: fileDir.listFiles()) 
//	    if (!file.isDirectory()) 
//	        file.delete();
//       
        // Add new documents to an existing index:
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);

        
        writer = new IndexWriter(dir, config);
        
//        try{
//            indexFileOrDirectory(f,fileContent);
//        }
//        catch(Exception e){
//             System.out.println(e);
//            
//        }

        //closeIndex();
        
        
        
    }
    
    
    
    public void indexFileOrDirectory(JSONObject fileDetails) throws IOException{
        
//        String[] metadataNames = (String[]) fileDetails.get("metadata");
//          for(String name : metadataNames) {
//         System.out.println(name+" : "+fileDetails.get(name));  
//        }
//          System.out.println("SUDHANSHU----------------------------"+fileDetails.get("Content-Type"));
          
        

//        for(File f : queue){
            
//            FileReader fr = null;
            try{
                Document doc = new Document();
                
                // add contents of the file
                
//                fr = new FileReader(f);
//                BufferedReader reader = new BufferedReader(fr);                                                 
                //Read br and store a line in 'data', print data
                 // **** key is declared here in this block of code
//                String key = "";
//                String line = reader.readLine();

//                while (line != null) {
//                    key += line;
//                    line = reader.readLine();
//                }       
                //System.out.println("line is "+ fileContent);
                doc.add(new Field("id", "doc_" + count, Field.Store.YES, Field.Index.NOT_ANALYZED_NO_NORMS));
                //doc.add(new Field("contents",fr , Field.TermVector.WITH_POSITIONS_OFFSETS));
                doc.add(new Field("contents", (String) fileDetails.get("contents"), Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.WITH_POSITIONS_OFFSETS));
                doc.add(new StringField("path",(String) fileDetails.get("path"), Field.Store.YES));
                doc.add(new StringField("filename",(String) fileDetails.get("filename"), Field.Store.YES));
                doc.add(new StringField("contentType",(String) fileDetails.get("Content-Type"), Field.Store.YES));
//                doc.add(new Field())
                /*
                doc.Add(new Field("Id", corpusDoc.Id, Field.Store.YES,
					Field.Index.NOT_ANALYZED_NO_NORMS));

				// Add title field
				var titleField = new Field("Title", corpusDoc.Title, Field.Store.YES,
					Field.Index.ANALYZED, Field.TermVector.WITH_POSITIONS_OFFSETS);
				titleField.SetBoost(3.0f);
				doc.Add(titleField);

				doc.Add(new Field("Content", content, Field.Store.COMPRESS,
					Field.Index.ANALYZED, Field.TermVector.WITH_POSITIONS_OFFSETS));
                */
                
                
                writer.addDocument(doc);
                System.out.println("Added: "+(String) fileDetails.get("filename"));
                count++;
            }
            catch(Exception e){
                System.out.println("Could not add :"+(String) fileDetails.get("filename"));
            }
//            finally{
//                fr.close();
//            }
//        }
        
        
//        int newNumDocs = writer.numDocs();
//        System.out.println("");
//        System.out.println("************************");
//        System.out.println((newNumDocs - originalNumDocs) + " documents added.");
//        System.out.println("************************");
        
//        queue.clear();
    }
    /*
    private void addFiles(File file){
        
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
            
            if(filename.endsWith(".htm") || filename.endsWith(".html")
                || filename.endsWith(".xml") || filename.endsWith(".txt")){
                queue.add(file);
                
            }
            else{
                System.out.println("Skipped"+ filename);
            }
        }
        
    }
    
    */
    public void closeIndex() throws IOException{
        writer.close();
    }
    
    
    
    
    
}
