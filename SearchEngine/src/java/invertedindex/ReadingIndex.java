/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.Fields;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.index.MultiFields;
import org.apache.lucene.index.Terms;
import org.apache.lucene.index.TermsEnum;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.BytesRef;

/**
 *
 * @author kkgarg
 */
public class ReadingIndex {
    
//    private static ConfigFile cf = new ConfigFile();
//    static String indexLocation = cf.INDEXLOCATION;
    
    private String getIndexLocation(){
         String indexLocation="";
        try{
            ConfigFile cf = new ConfigFile();
            indexLocation = cf.getIndexPath();
        } catch(Exception e){
            System.out.println(e);
        }
        return indexLocation;
    }
    
    public Map<String, Set<Integer>> printingIndex() throws IOException{
        try{
     MatchAllDocsQuery query = new MatchAllDocsQuery();
     IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(getIndexLocation())));
     IndexSearcher searcher = new IndexSearcher(reader);
     TopDocs hits = searcher.search(query, Integer.MAX_VALUE);
     Map<String, Set<Integer>>  invertedIndex = new HashMap<>();


        if (null == hits.scoreDocs || hits.scoreDocs.length <= 0) {
            System.out.println("No Hits Found with MatchAllDocsQuery");
            return null;
        }

        for (ScoreDoc hit : hits.scoreDocs) {
            Document doc = searcher.doc(hit.doc);

            List<IndexableField> allFields = doc.getFields();

            for(IndexableField field:allFields){



            //Single document inverted index 
            Terms terms = searcher.getIndexReader().getTermVector(hit.doc,field.name());

            if (terms != null )  {
                TermsEnum termsEnum = terms.iterator(null);
                
                while(termsEnum.next() != null){
                if(invertedIndex.containsKey(termsEnum.term().utf8ToString())){
                    Set<Integer> existingDocs = invertedIndex.get(termsEnum.term().utf8ToString());
                    existingDocs.add(hit.doc);
//                    existingDocs.add(Integer.parseInt((searcher.doc(hit.doc).get("lineNumber"))));
                    invertedIndex.put(termsEnum.term().utf8ToString(),existingDocs);

                }else{
                    Set<Integer> docs = new TreeSet<>();
                    docs.add(hit.doc);
//                    docs.add(Integer.parseInt((searcher.doc(hit.doc).get("lineNumber"))));
                    invertedIndex.put(termsEnum.term().utf8ToString(), docs);
                }
                }
            }
        }
        }

        //System.out.println("Printing Inverted Index:");
        
        //invertedIndex.forEach((key , value) -> {System.out.println(key+":"+value);
        //}); 
     
     
     return invertedIndex;
        
    }
        catch(Exception e){
            return null;
    }
    }
    

}
