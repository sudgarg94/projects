/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invertedindex;

import java.util.ArrayList;

/**
 *
 * @author kkgarg
 */
public class SearchResults {
    
    private Float score;
    private String filename;
    private String[] fragments;
    private String lineNumber;
    private String path;
    private String contentType;
    
    public SearchResults(){
        fragments = null;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String[] getFragments() {
        return fragments;
    }

    public void setFragments(String[] fragments) {
        this.fragments = fragments;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    

    

    
    
    
    
    
}
