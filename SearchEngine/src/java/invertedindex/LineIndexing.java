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
import java.util.ArrayList;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.json.simple.JSONObject;

/**
 *
 * @author kkgarg
 */
public class LineIndexing {
    
    private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
    private IndexWriter writer;
//    private static ConfigFile cf = new ConfigFile();
//    static String indexLocation = cf.LINEINDEXLOCATION;
//    public static int count=0;
    
         private String getLineIndexLocation(){
         String lineIndexLocation="";
        try{
            ConfigFile cf = new ConfigFile();
            lineIndexLocation = cf.getLineIndexPath();
        } catch(Exception e){
            System.out.println(e);
        }
        return lineIndexLocation;
    }
    
    public LineIndexing() throws IOException {
        FSDirectory dir = FSDirectory.open(new File(getLineIndexLocation()));
        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47,analyzer);
        config.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        writer = new IndexWriter(dir, config);
        
    }
    
    
    
    public void indexFileOrDirectory(ArrayList<File> queue) throws IOException{
        //addFiles(new File(filename));
        
        int count=0;
        for(File f: queue){
            BufferedReader b = new BufferedReader(new FileReader(f));
            String lineText = null;
            int line_number = 1; 
//            System.out.println("IF ITS HERE ");
            while ((lineText = b.readLine()) != null) {
//                System.out.println("READING "+lineText+" Line Number is "+line_number);
                
                try{
                    Document doc = new Document();
                    doc.add(new Field("id", "doc_" + count, Field.Store.YES, Field.Index.NOT_ANALYZED_NO_NORMS));
                    doc.add(new Field("contents", lineText, Field.Store.YES, Field.Index.ANALYZED, Field.TermVector.WITH_POSITIONS_OFFSETS));
                    doc.add(new StringField("lineNumber",String.valueOf(line_number), Field.Store.YES));
                    doc.add(new Field("path",f.getPath(), Field.Store.YES,Field.Index.ANALYZED));
                    doc.add(new StringField("filename",f.getName(), Field.Store.YES));

                    writer.addDocument(doc);
//                    System.out.println("Added: "+(String) fileDetails.get("filename"));
                    line_number++;
                    count++;
                }
                catch(Exception e){
                    System.out.println("Could not add :"+e);
                }
            }//while ends
            b.close();
        }//for loop ends
            

    }//method ends
    
    public void closeIndex() throws IOException{
        writer.close();
    }
    
    
}
