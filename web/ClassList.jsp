<%-- 
    Document   : ClassList
    Created on : Sep 10, 2019, 9:29:08 PM
    Author     : Tom Valli
--%>

<%@page import="business.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Class List</title>
        <style>
            body {
                font-family: Consolas, "Lucida Console", "Courier New", monospace;
            }
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }
            th, td {
                padding: 15px;
                text-align: left;
            }
            tr#gRow {  
                background-color: #D8D8D8;
            }
        </style>
    </head>
    <body>
        <h1>Students on file:</h1>
        <br>
        <%
            ArrayList<Student> stulist = 
                    (ArrayList<Student>) request.getAttribute("stulist");
			boolean isGray = true;
            if (stulist != null) {
        %>
                <table>
                    <tr><th colspan="15">Class List</th></tr>
                    <tr>
                            <th>Student#</th>
                            <th>Last Nm.</th>
                            <th>First Nm.</th>
                            <th>Qz 1</th>
                            <th>Qz 2</th>
                            <th>Qz 3</th>
                            <th>Qz 4</th>
                            <th>Qz 5</th>
                            <th>Qz Mk.Up</th>
                            <th>Qz Avg</th>
                            <th>Mid-Term</th>
                            <th>Probs</th>
                            <th>Final Ex.</th>
                            <th>Course Avg</th>
                            <th>Grade</th>
                    </tr>
                    <%
                        for (int i = 0; i < stulist.size(); i++) {
                            String[] svals = stulist.get(i).toString().split(",");
                            if (isGray) {
                    %>          <tr id="gRow"><%
                            } else {
                    %>		<tr><%
                            }
                            isGray = !isGray;
                            for (int j = 0; j < svals.length; j++) {
                    %>		<td><%= svals[j]  %></td><%
                            }
                    %>      </tr><%
                        }
                    %>
                    <tr><td colspan="15"><a href="./students.jsp">&larr; Go Back</a></td></tr>
                </table>
                    <%
            } else {
        %>
                <p>Student List returned null.</p><%
            }
        %>
        <br>
        ${msg}
    </body>
            
            
            
            
</html>
