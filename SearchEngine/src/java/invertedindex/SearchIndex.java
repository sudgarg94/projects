/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CachingTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.search.highlight.TextFragment;
import org.apache.lucene.search.highlight.TokenSources;
import org.apache.lucene.search.spans.SpanNearQuery;
import org.apache.lucene.search.spans.SpanScorer;
import org.apache.lucene.search.spans.SpanTermQuery;
import org.apache.lucene.search.spans.Spans;
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;
import org.apache.lucene.search.vectorhighlight.FieldQuery;
import org.apache.lucene.search.vectorhighlight.FragListBuilder;
import org.apache.lucene.search.vectorhighlight.FragmentsBuilder;
import org.apache.lucene.search.vectorhighlight.ScoreOrderFragmentsBuilder;
import org.apache.lucene.search.vectorhighlight.SimpleFragListBuilder;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.jsoup.Jsoup;

/**
 *
 * @author kkgarg
 */
public class SearchIndex {
    
    private static Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
//    private static Analyzer sAnalyzer = new SimpleAnalyzer(Version.LUCENE_47);
//    private static ConfigFile cf = new ConfigFile();
    private static int topDocs = 100;
    private ArrayList<SearchResults> searchResulsAL;
    private ArrayList<String> lineNumbersList;
    private ArrayList<ArrayList<String>> lineNumberArrayList;
    private String lineNumber;
    private boolean insideLoopFlag= false;
    private int totalHits=0;
    private String indexLocation;
    
    private String getIndexLocation(){
        try{
            ConfigFile cf = new ConfigFile();
            indexLocation = cf.getIndexPath();
        } catch(Exception e){
            System.out.println(e);
        }
        return indexLocation;
    }
    
    
            
    public ArrayList<SearchResults> search(String keyword) throws IOException{
        
    String indexLocation = this.getIndexLocation();
//    System.out.println("Inside search method");

//        indexLocation = "";
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
	    try {
                IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(indexLocation)));
                IndexSearcher searcher = new IndexSearcher(reader);
                TopScoreDocCollector collector = TopScoreDocCollector.create(topDocs, true);

                String query = keyword;
                
                query = "\""+query+"\"";
		
		Query q = new QueryParser(Version.LUCENE_47, "contents",analyzer).parse(query);
                

                SimpleFragListBuilder fragListBuilder = new SimpleFragListBuilder();
                ScoreOrderFragmentsBuilder fragBuilder = new ScoreOrderFragmentsBuilder();
                FastVectorHighlighter fvh= new FastVectorHighlighter(FastVectorHighlighter.DEFAULT_PHRASE_HIGHLIGHT,
                        FastVectorHighlighter.DEFAULT_FIELD_MATCH,fragListBuilder,fragBuilder);
                fvh = new FastVectorHighlighter(FastVectorHighlighter.DEFAULT_PHRASE_HIGHLIGHT,
                        FastVectorHighlighter.DEFAULT_FIELD_MATCH,
                        fragListBuilder,
                                fragBuilder
                );
                
//		System.out.println(q);
                
//                



		searcher.search(q, collector);
//                searcher.search(q, null,topDocs);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
               
		// 4. display results
		System.out.println("Found " + hits.length + " hits.");
                totalHits = hits.length;
                searchResulsAL = new ArrayList<>();
                
                
		for (int i = 0; i < hits.length; ++i) {
                    int docId = hits[i].doc;
                    FieldQuery fq = fvh.getFieldQuery(q);
//                    System.out.println("fq "+fq);
                   
                    String[] fragments = fvh.getBestFragments(fq, searcher.getIndexReader(), docId, "contents", 50,10);
                    //String[] lineFragments = fvh.getBestFragments(fq, searcher.getIndexReader(), docId, "contents", 18,10);
		    
		    Document d = searcher.doc(docId);

                    String filePath = d.get("path");

                    
                    for (int j=0; j< fragments.length ; j++) {
//                                    System.out.println("FRAGMENT iS "+fragments[j]);
//                                int k=0;
//                                for(k=0;k<lineFragments.length;k++){
//                                    fragments[j].getSc
                                    String temp = Jsoup.parse(fragments[j]).text();
//                                    
                                    LineNumberSearcher lns = new LineNumberSearcher();
                                    
                                    //lineNumbersList = new ArrayList<>();
                                    lineNumberArrayList = new ArrayList<>();
                                    lineNumber = "null";
                                    boolean g = Pattern.compile("\\n").matcher(fragments[j]).find();
                                    if(!g){
//                                        System.out.println("NO G");
                                        lineNumbersList = lns.search(temp,filePath);
//                                        for(String s : lineNumbersList){
//                                            System.out.println("s is "+s);
//                                        }
//                                        if(lineNumbersList.get(0).isEmpty()){
//                                            lineNumber = "Not Found";
//                                        }else {
                                            if(!lineNumbersList.isEmpty()){
//                                                System.out.println("in line number");
                                                lineNumber = lineNumbersList.get(0);
                                            }
                                        
//                                        }
                                        
                                    }
                                            
                                            //here is the tried code for enter space
                                      /*       
                                    else{
                                        System.out.println("YES G");
                                         String lines[] = fragments[j].split("\\r?\\n");
//                                         ArrayList<String> newLines = new ArrayList<>();
                                        ArrayList<String> newLines = new ArrayList<>(Arrays.asList(lines));
                                        System.out.println("Here 3");
                                        int special = 0;
                                         for(String line : newLines){
                                             if(Pattern.compile("^$").matcher(line).find()){
                                                 newLines.remove(line);
                                                 special++;
                                             }
                                         }
                                         System.out.println("Here 4");
//                                          List<String> list = Arrays.asList(lines);
//                                          if(list.contains(temp)){
//                                              
//                                          }
                                        
//                                        for(String line: newLines){
//                                            System.out.println("LINE IS "+line);
//                                        }
                                        if(newLines.size()==1){
//                                            System.out.println("Yes G but NOT G");
                                            lineNumbersList = lns.search(temp,filePath);
                                            if(!lineNumberArrayList.isEmpty()){
                                                lineNumber = lineNumbersList.get(0);
                                            }
                                            System.out.println("Here 1");
                                        }else{
                                            System.out.println("Here 2");
                                                ArrayList<String> a0 = lns.search(Jsoup.parse(newLines.get(0)).text(),filePath);
                                        ArrayList<String> a1 = lns.search(Jsoup.parse(newLines.get(1)).text(),filePath);
                                        int k,l;
                                        outerloop:
                                        for(k=0;k<a0.size();k++){
                                            for(l=0;l<a1.size();l++){
                                                int secondline = Integer.parseInt(a1.get(l));
//                                                System.out.println("second line is"+ secondline);
                                                int firstline = Integer.parseInt(a0.get(k));
//                                                System.out.println("first line is"+firstline);
                                                int diff = secondline - firstline;
//                                                System.out.println("DIFFERENCE IS "+diff);
//                                                System.out.println("Special IS "+special);
                                                if(diff == special+1){
                                                    insideLoopFlag = true;
//                                                    System.out.println("K IS "+k);
//                                                    System.out.println("IN BREAK ");
                                                    break outerloop;
                                                }
                                            }
//                                            System.out.println("K IS "+k);
                                        }
//                                        System.out.println("OUT OF FOR LOOP");
//                                        System.out.println("K IS "+k);
                                        if(insideLoopFlag==true){
                                        lineNumber = String.valueOf(a0.get(k));
                                        }
//                                        System.out.println("LINE NUMBER IS "+lineNumber);
                                        }
                                        
                                        
                                     }
                                     */   
                                        
                                    
//                                }
                                fragments[j] = fragments[j].replaceAll("\\n", " ");
//                                System.out.println("\t\t" + fragments[j] + "...");
                                fragments[j] = fragments[j]+"....";
                                if(!(lineNumber.equals("null"))){
//                                    System.out.println("in line number");
                                    fragments[j] = fragments[j]+" at Line "+lineNumber;
                                }
				
                                
			}
                    
                    
                    
                    //Setting Results
                    SearchResults sr = new SearchResults();
                    sr.setFilename(d.get("filename"));
                    sr.setScore(hits[i].score);
                    sr.setFragments(fragments);
                    sr.setPath(filePath);
                    sr.setContentType(d.get("contentType"));
//                    sr.setLineNumber(lineNumber);

                    searchResulsAL.add(sr);
                    
                    
//                    
		}
//		writer.close();
              reader.close(); 

	    } catch (Exception e) {
		System.out.println("Error searching in search index " + e + " : "
			+ e.getMessage());
//		break;
	    } 
            
        
//    }
        
        
        return searchResulsAL;
    
    }
    
    public int totalHits(){
        return totalHits;
    }
    
    
    
//    private void GetMoreLikeThis(int docId) throws IOException{
//        String[] fieldName = {"contents"};
//                // GET MORE LIKE THIS
//                IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(cf.INDEXLOCATION)));
//                IndexSearcher searcher = new IndexSearcher(reader);
//                MoreLikeThis mlt = new MoreLikeThis(searcher.getIndexReader());
//                mlt.setAnalyzer(new StandardAnalyzer(Version.LUCENE_47));
//                mlt.setFieldNames(fieldName);
//                mlt.setMinWordLen(4); // improve relevancy
//                Query query = mlt.like(docId);
//                TopScoreDocCollector collector = TopScoreDocCollector.create(topDocs, true);
//                searcher.search(query, collector);
//                ScoreDoc[] hits = collector.topDocs().scoreDocs;
//                
//                for (int i = 0; i < hits.length; ++i) {
//                    int dId = hits[i].doc;
//                    Document d = searcher.doc(dId);
//                    System.out.println("SIMILAR CONTENT FILENAME " + d.get("filename"));
//                }
//                 /*
//			mlt.SetFieldNames(new[] { "Title", "Content" });
//			mlt.SetMinWordLen(4); // improve relevancy
//
//			var query = mlt.Like(indexDocumentId);
//
//			var tsdc = TopScoreDocCollector.create(maxDocs, true);
//			Searcher.Search(query, tsdc);
//			var hits = tsdc.TopDocs().ScoreDocs;
//
//			var ret = new List<CorpusDocument>(maxDocs);
//
//			foreach (var hit in hits)
//			{
//				var d = Searcher.Doc(hit.doc);
//				ret.Add(new CorpusDocument
//				{
//					Id = d.Get("Id"),
//					Title = d.Get("Title"),
//				});
//			}
//                
//                */
//                
//    }
//    
//        private static String highlightField(Query query, String fieldName, String text) throws IOException {
//            
//            CachingTokenFilter tokenStream = new CachingTokenFilter(new StandardAnalyzer().tokenStream(fieldName, new StringReader(text)));
//            // Assuming "<B>", "</B>" used to highlight
//            SimpleHTMLFormatter formatter = new SimpleHTMLFormatter();
//            Highlighter highlighter = new Highlighter(formatter, new SpanScorer(query, fieldName,tokenStream, FIELD_NAME));
//            highlighter.setTextFragmenter(new SimpleFragmenter(Integer.MAX_VALUE));
//            tokenStream.reset();
//            String rv = highlighter.getBestFragments(tokenStream, text, 1, "(FIELD TEXT TRUNCATED)");
//            return rv.length() == 0 ? text : rv;
//        }
       
    
        public ArrayList<String> autoComplete(String keyword) throws IOException{
                IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(this.getIndexLocation())));
                IndexSearcher searcher = new IndexSearcher(reader);
               ArrayList<String> al = new ArrayList<>();
                TopDocs sd = searcher.search(new PrefixQuery(new Term("contents",keyword)),null,5);
                for(ScoreDoc d : sd.scoreDocs ){
//                    System.out.println("SCORE DOC "+ searcher.doc(d.doc).get("contents"));
                    String s = searcher.doc(d.doc).get("contents");
                    //  System.out.println("STRING S "+s);
                    String regex = keyword+"\\w+";
//                    String regex = keyword+"\\s*(\\w+)";
                    Pattern p = Pattern.compile(regex);
                    Matcher m = p.matcher(s);
                    while (m.find())
                    {
                        al.add(m.group());
                        
                    }
//                    for(String ss : al){
//                        System.out.println("AUTO COMPLETE ARRAY IS "+ss);
//                    }
                    Set<String> hs = new HashSet<>();
                    hs.addAll(al);
                    al.clear();
                    al.addAll(hs);
                    
                }
                
                

                
                 
            return al;
            
        }
        
        
//        public void searchWithSuggestions() throws IOException{
////             boolean suggestOnlyWhenNoResults  = false;
////            String indexLocation = cf.INDEXLOCATION;
////            System.out.println("Inside search with suggestions method");
////
//////        indexLocation = "";
//////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//////        while (true) {
////	    try {
////                IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(indexLocation)));
////                IndexSearcher searcher = new IndexSearcher(reader);
////                TopScoreDocCollector collector = TopScoreDocCollector.create(topDocs, true);
//////		
////                String query = keyword;
////               
////                query = "\""+query+"\"";
////		
////		Query q = new QueryParser(Version.LUCENE_47, "contents",analyzer).parse(query);
////                
//////               
//////                // Init the highlighter instance
////                SimpleFragListBuilder fragListBuilder = new SimpleFragListBuilder();
////                ScoreOrderFragmentsBuilder fragBuilder = new ScoreOrderFragmentsBuilder();
////                FastVectorHighlighter fvh= new FastVectorHighlighter(FastVectorHighlighter.DEFAULT_PHRASE_HIGHLIGHT,
////                        FastVectorHighlighter.DEFAULT_FIELD_MATCH,fragListBuilder,fragBuilder);
////                fvh = new FastVectorHighlighter(FastVectorHighlighter.DEFAULT_PHRASE_HIGHLIGHT,
////                        FastVectorHighlighter.DEFAULT_FIELD_MATCH,
////                        fragListBuilder,
////                                fragBuilder
////                );
////                
////
////
////		searcher.search(q, collector);
////                
////		ScoreDoc[] hits = collector.topDocs().scoreDocs;
////                
////		System.out.println("Found " + hits.length + " hits.");
//                 File dir = new File("/Users/kkgarg/Desktop/Northeastern/Summer 2017/word");
//
//                 Directory directory = FSDirectory.open(dir);
//
//                SpellChecker spellChecker = new SpellChecker(directory);
//                //spellChecker.indexDictionary(new LuceneDictionary(  my_lucene_reader, a_field));
//                //spellChecker.indexDictionary(new PlainTextDictionary(new File("/Users/kkgarg/Desktop/Northeastern/Summer 2017/words/words.txt")));
//                String wordForSuggestions = "hwllo";
//                int suggestionsNumber = 5;
//                
//                String[] suggestions = spellChecker.
//                suggestSimilar(wordForSuggestions, suggestionsNumber);
//                if (suggestions!=null && suggestions.length>0) {
//                    
//                    for (String word : suggestions) {
//                        System.out.println("Did you mean:" + word);
//                    }
//                }
//                else {
//                    System.out.println("No suggestions found for word:"+wordForSuggestions);
//                }
//
//             
//
//                
//                
//                
//                
//            }
//            catch(Exception e){
//                System.out.println("Exception is "+e);
//                
//            }
//            return null;
        
        public ArrayList<SearchResults> multipleSearch(String keyword1,String keyword2,String radio) throws IOException{
        
            String indexLocation = this.getIndexLocation();

	    try {
                IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(indexLocation)));
                IndexSearcher searcher = new IndexSearcher(reader);
                TopScoreDocCollector collector = TopScoreDocCollector.create(topDocs, true);

                String query1 = keyword1;
                String query2 = keyword2;
                query1 = "\""+query1+"\"";
                query2 = "\""+query2+"\"";
		 
                
		Query q1 = new QueryParser(Version.LUCENE_47, "contents",analyzer).parse(query1);
                Query q2 = new QueryParser(Version.LUCENE_47, "contents",analyzer).parse(query2);
                
                BooleanQuery apiQuery = new BooleanQuery();
                if(radio.equalsIgnoreCase("and")){
                apiQuery.add(q1, BooleanClause.Occur.MUST);
                apiQuery.add(q2, BooleanClause.Occur.MUST);
                }
                else if(radio.equalsIgnoreCase("or")){
                    apiQuery.add(q1,BooleanClause.Occur.SHOULD);
                    apiQuery.add(q2,BooleanClause.Occur.SHOULD);
                }
                else if(radio.equalsIgnoreCase("not")){
                    apiQuery.add(q1,BooleanClause.Occur.MUST);
                    apiQuery.add(q2,BooleanClause.Occur.MUST_NOT);
                }
                
                SimpleFragListBuilder fragListBuilder = new SimpleFragListBuilder();
                ScoreOrderFragmentsBuilder fragBuilder = new ScoreOrderFragmentsBuilder();
                FastVectorHighlighter fvh= new FastVectorHighlighter(FastVectorHighlighter.DEFAULT_PHRASE_HIGHLIGHT,
                        FastVectorHighlighter.DEFAULT_FIELD_MATCH,fragListBuilder,fragBuilder);
                fvh = new FastVectorHighlighter(FastVectorHighlighter.DEFAULT_PHRASE_HIGHLIGHT,
                        FastVectorHighlighter.DEFAULT_FIELD_MATCH,
                        fragListBuilder,
                                fragBuilder
                );
              
		searcher.search(apiQuery, collector);

		ScoreDoc[] hits = collector.topDocs().scoreDocs;
               
		System.out.println("Found " + hits.length + " hits.");
                totalHits = hits.length;
                searchResulsAL = new ArrayList<>();
                
                
		for (int i = 0; i < hits.length; ++i) {
                    int docId = hits[i].doc;
                    FieldQuery fq = fvh.getFieldQuery(apiQuery);
//                    
                   
                    String[] fragments = fvh.getBestFragments(fq, searcher.getIndexReader(), docId, "contents", 50,10);
                    
		    
		    Document d = searcher.doc(docId);
//                    
                    String filePath = d.get("path");
                    
                    
                    for (int j=0; j< fragments.length ; j++) {

                                    String temp = Jsoup.parse(fragments[j]).text();
//                                 
                                    LineNumberSearcher lns = new LineNumberSearcher();
                                    
                                    //lineNumbersList = new ArrayList<>();
                                    lineNumber = "null";
                                    lineNumberArrayList = new ArrayList<>();
                                    boolean g = Pattern.compile("\\n").matcher(fragments[j]).find();
                                    if(!g){
//                                        System.out.println("NO G g");
                                        lineNumbersList = lns.search(temp,filePath);
//                                        for(String s : lineNumbersList){
//                                            System.out.println("s is "+s);
//                                        }
//                                      
                                            if(!lineNumbersList.isEmpty()){
//                                                System.out.println("in line number");
                                                lineNumber = lineNumbersList.get(0);
                                            }
                                        

                                        
                                    }
                                            
                                            
                                fragments[j] = fragments[j].replaceAll("\\n", " ");
//                                System.out.println("\t\t" + fragments[j] + "...");
                                fragments[j] = fragments[j]+" ....";
                                if(!(lineNumber.equals("null"))){
//                                    System.out.println("in line number");
                                    fragments[j] = fragments[j]+" at Line "+lineNumber;
                                }
				
                                
			}
                    
                    SearchResults sr = new SearchResults();
                    sr.setFilename(d.get("filename"));
                    sr.setScore(hits[i].score);
                    sr.setFragments(fragments);
                    sr.setPath(filePath);
                    sr.setContentType(d.get("contentType"));

                    searchResulsAL.add(sr);
                    
                    
		}

              reader.close(); 

	    } catch (Exception e) {
		System.out.println("Error searching in search index " + e + " : "
			+ e.getMessage());

	    } 
            
        

        
        
        return searchResulsAL;
    
    }
        
        

        }


