/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrecisionRecall;

import invertedindex.ConfigFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import org.apache.lucene.benchmark.quality.Judge;
import org.apache.lucene.benchmark.quality.QualityBenchmark;
import org.apache.lucene.benchmark.quality.QualityQuery;
import org.apache.lucene.benchmark.quality.QualityQueryParser;
import org.apache.lucene.benchmark.quality.QualityStats;
import org.apache.lucene.benchmark.quality.trec.TrecJudge;
import org.apache.lucene.benchmark.quality.trec.TrecTopicsReader;
import org.apache.lucene.benchmark.quality.utils.SimpleQQParser;
import org.apache.lucene.benchmark.quality.utils.SubmissionReport;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 *
 * @author kkgarg
 */
public class PrecisionRecallMain {
    
    
     private String getTopicsFile(){
          String topicsFile="";
        try{
            ConfigFile cf = new ConfigFile();
            topicsFile = cf.getTopicsFile();
        } catch(Exception e){
            System.out.println(e);
        }
        return topicsFile;
    }
     
      private String getQrelsFile(){
          String qrelsFile="";
        try{
            ConfigFile cf = new ConfigFile();
            qrelsFile = cf.getQrelsFile();
        } catch(Exception e){
            System.out.println(e);
        }
        return qrelsFile;
    }
    
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
    
    
    public BeanPrecisionRecall caculate() throws Throwable {  
        
        
        
        
  File topicsFile = new File(getTopicsFile());  
         File qrelsFile = new File(getQrelsFile());  
         Directory dir = FSDirectory.open(new File(getIndexPath()));  

        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
         String docNameField = "filename";  

         PrintWriter logger = new PrintWriter(System.out, true);  

         TrecTopicsReader qReader = new TrecTopicsReader();   
         QualityQuery qqs[] = qReader.readQueries(                        
                 new BufferedReader(new FileReader(topicsFile)));  

         Judge judge = new TrecJudge(new BufferedReader(          
                new FileReader(qrelsFile)));                                          

         judge.validateData(qqs, logger);                                          

         QualityQueryParser qqParser = new SimpleQQParser("title", "contents");  

         QualityBenchmark qrun = new QualityBenchmark(qqs, qqParser, searcher, docNameField);  
   SubmissionReport submitLog = null;  
   
         QualityStats stats[] = qrun.execute(judge,                   
                   submitLog, logger);  
   
    
        QualityStats avg = QualityStats.average(stats);          
        
        
        BeanPrecisionRecall bpr = new BeanPrecisionRecall();
        
        bpr.setAveragePrecision(avg.getAvp());
        bpr.setMmr(avg.getMRR());
        bpr.setRecall(avg.getRecall());
        bpr.setSearchTime(avg.getSearchTime());
        
        
   dir.close();  
   return bpr;
  }  
    
    
}
