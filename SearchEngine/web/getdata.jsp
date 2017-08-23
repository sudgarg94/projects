<%-- 
    Document   : getdata
    Created on : Aug 8, 2017, 3:08:57 PM
    Author     : kkgarg
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="invertedindex.SearchIndex"%>

        <%
	SearchIndex searchIndex = new SearchIndex();

	String query = request.getParameter("q");
	
	ArrayList<String> searched = searchIndex.autoComplete(query);
        for(String search : searched){
            out.println(search);
        }
//	Iterator<String> iterator = countries.iterator();
//	while(iterator.hasNext()) {
//		String country = (String)iterator.next();
//		out.println(country);
//	}
%>
    
