<%-- 
    Document   : student_info
    Created on : 21 Sept 2025, 10:22:06 am
    Author     : aarya_suthar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Information</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #4facfe, #00f2fe);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .card {
            background: white;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0px 4px 15px rgba(0,0,0,0.2);
            width: 350px;
            text-align: center;
        }
        .card h2 {
            margin-bottom: 20px;
            color: #4facfe;
        }
        .info {
            text-align: left;
            margin: 10px 0;
            font-size: 16px;
        }
        .info span {
            font-weight: bold;
            color: #333;
        }
    </style>
</head>
<body>
    <jsp:useBean id="std" scope="request" class="Bean.StudentBean"/>
    
    <div class="card">
        <h2>Student Information</h2>
        <div class="info"><span>ID:</span> <jsp:getProperty name="std" property="id"/></div>
        <div class="info"><span>Name:</span> <jsp:getProperty name="std" property="name"/></div>
        <div class="info"><span>Email:</span> <jsp:getProperty name="std" property="email"/></div>
        <div class="info"><span>City:</span> <jsp:getProperty name="std" property="city"/></div>
    </div>
</body>
</html>