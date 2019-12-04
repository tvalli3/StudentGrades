<%-- 
    Document   : StudentGrade
    Created on : Aug 28, 2019, 10:19:02 PM
    Author     : Tom Valli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Grade</title>
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
        <h1>Grade Results for Student:</h1>
        <table>
            <tr id="gRow"><td colspan="2">${s.fname} ${s.lname}'s Report Card</td></tr>            
            <tr>
                <td>Student Name:</td><td>${s.fname} ${s.lname}</td>
            </tr>
            <tr>
                <td>Student ID:</td><td>${s.sno}</td>
            </tr>            
            <tr id="gRow">
                <td>Letter Grade:</td><td>${s.lgrade}</td>
            </tr>
            <tr>
                <td>Quiz Average:</td><td>${s.qavg}</td>
            </tr>
            <tr id="gRow"r>
                <td>Problems:</td><td>${s.pr}</td>
            </tr>
            <tr>
                <td>Mid-Term:</td><td>${s.mt}</td>
            </tr>
            <tr id="gRow">
                <td>Final Exam:</td><td>${s.fe}</td>
            </tr>
            <tr>
                <td colspan="2"><a href="./students.jsp">&larr; Go Back</a></td>
            </tr>
        </table>
        
    </body>
</html>
