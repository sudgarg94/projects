/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;
import org.apache.lucene.search.vectorhighlight.FieldQuery;
import org.apache.lucene.search.vectorhighlight.ScoreOrderFragmentsBuilder;
import org.apache.lucene.search.vectorhighlight.SimpleFragListBuilder;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.jsoup.Jsoup;

/**
 *
 * @author kkgarg
 */
public class LineNumberSearcher {
    
     private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
//    private static ConfigFile cf = new ConfigFile();
    private static int topDocs = 100;
    private ArrayList<String> lineNumbersList;
    
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
    
    public ArrayList<String> search(String keyword,String filePath) throws IOException{
        
    String indexLocation = getLineIndexLocation();
//    System.out.println("Inside LINE search method");


	    try {
                IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(indexLocation)));
                IndexSearcher searcher = new IndexSearcher(reader);
                TopScoreDocCollector collector = TopScoreDocCollector.create(topDocs, true);

                String queryContent = keyword;
                
                queryContent = "\""+queryContent+"\"";
//		queryContent = "*" + queryContent + "*";
                
                String queryFilePath = filePath;
//                System.out.println("FIELPATH "+queryFilePath);
                queryFilePath = "\""+queryFilePath+"\"";
//		queryFilePath = "*" + queryFilePath + "*";
                
                QueryParser queryParserContent = new QueryParser(Version.LUCENE_47, "contents",analyzer);
                QueryParser queryParserFilePath = new QueryParser(Version.LUCENE_47, "path",analyzer);
                
               queryParserContent.setAllowLeadingWildcard(true);
               //queryParserFileName.setAllowLeadingWildcard(true);
//               Query q = queryParser.parse(query);
		Query qContent = queryParserContent.parse(queryContent);
                Query qFileName = queryParserFilePath.parse(queryFilePath);
//                System.out.println("FIELPATH "+qFileName);
                BooleanQuery q = new BooleanQuery();
                q.add(qContent, Occur.MUST); // MUST implies that the keyword must occur.
                q.add(qFileName, Occur.MUST); 
                
		searcher.search(q, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
               
//		System.out.println("Found " + hits.length + " hits.");
                lineNumbersList = new ArrayList<>();
		for (int i = 0; i < hits.length; ++i) {
                    int docId = hits[i].doc;
		    Document d = searcher.doc(docId);
//		    System.out.println((i + 1) + ". " + d.get("filename")
//			    + " score=" + hits[i].score);
//                    System.out.println("Line Number is "+d.get("lineNumber"));
//                    System.out.println("Content is "+d.get("contents"));
//                    String filePath = d.get("path");
                    lineNumbersList.add(d.get("lineNumber"));
		}
                    
              reader.close(); 
              return lineNumbersList;

	    } catch (Exception e) {
		System.out.println("Error searching in line number search " + indexLocation + " : "
			+ e.getMessage());

	    } 
            
        

        
        
        return lineNumbersList;
    
    }
}
