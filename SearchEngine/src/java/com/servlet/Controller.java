/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import invertedindex.ConfigFile;
import invertedindex.DocumentSearchUsingInvertedIndex;
import invertedindex.LineNumberSearcher;
import invertedindex.ReadingIndex;
import invertedindex.SearchIndex;
import invertedindex.SearchResults;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kkgarg
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        DocumentSearchUsingInvertedIndex dsuii = new DocumentSearchUsingInvertedIndex();
//        dsuii.indexBuilder();
        
//        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
//            String filePath = new File("").getAbsolutePath();
//            System.out.println("FILEPATH IS "+filePath);
            HttpSession session = request.getSession();
            String referrer = request.getHeader("referer");
//            System.out.println("ref "+referrer);
            
            if(referrer.equals("http://localhost:8080/TryWebApplication2/MultipleQuerySearch.jsp")){
                
                String radio = request.getParameter("multiple");
                String[] trying = request.getParameterValues("search");
                String query1 = trying[0];
                String query2 = trying[1];
                session.setAttribute("query", query1+" "+radio+" "+query2);
                
                SearchIndex searchIndex = new SearchIndex();
                ArrayList<SearchResults> searchResults =  searchIndex.multipleSearch(query1,query2,radio);
                int totalHits = searchIndex.totalHits();
//                int snippetHits = searchIndex.snipperHits();
                session.setAttribute("totalHits", totalHits);
//                session.setAttribute("snippetHits", snippetHits);
                session.setAttribute("searchResults", searchResults);
                ReadingIndex rI = new ReadingIndex();
            Map<String,Set<Integer>> map = rI.printingIndex();
            if(map==null){
                response.sendRedirect("ErrorNoIndex.jsp");
            }
            else{
            session.setAttribute("IndexMap", map);
            session.setAttribute("TotalKeys", map.size());

            }
                response.sendRedirect("Welcome.jsp");
                
                
            }
            
            else{
                
            
            String query = request.getParameter("search");
            session.setAttribute("query", query);

            SearchIndex searchIndex = new SearchIndex();
          
            ArrayList<SearchResults> searchResults =  searchIndex.search(query);
            int totalHits = searchIndex.totalHits();
//            int snippetHits = searchIndex.snipperHits();
            session.setAttribute("totalHits", totalHits);
//            session.setAttribute("snippetHits", snippetHits);
            session.setAttribute("searchResults", searchResults);
            ReadingIndex rI = new ReadingIndex();
            Map<String,Set<Integer>> map = rI.printingIndex();
            if(map==null){
                response.sendRedirect("ErrorNoIndex.jsp");
            }
            else{
            session.setAttribute("IndexMap", map);
            session.setAttribute("TotalKeys", map.size());

            }
            response.sendRedirect("Welcome.jsp");
            }
            
            
    
            
            
            
            
            

    }

    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
