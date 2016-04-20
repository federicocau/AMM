<%-- 
    Document   : login
    Created on : 17-apr-2016, 12.21.24
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!-- Meta informazioni della pagina: autore, descrizione sito, parole chiave -->
        <title>Techware Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Techware: negozio online per la vendita di prodotti hardware per PC!">
        <meta name="author" content="Federico M. Cau">
        <meta name="keywords" content="HDD, SSD, USB, CPU, ALIMENTATORI, DISSIPATORI, RAM, SCHEDE MADRI, 
              SCHEDE VIDEO, SCHEDE AUDIO, MOUSE, KEYBOARD, CASE">
        <link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
    </head>
    <body>
    <!-- contenitore principale -->
    <div id="box">
        <%@ include file="blocchi_dinamici/header.jsp" %>
        <%@ include file="blocchi_dinamici/nav.jsp" %>
        
        <!-- form di input che contiene nome utente e password -->
        <div class="login">
            <h2 class="logformtitle">Accedi</h2>
        <form name="form_login" method="GET">
            <!-- placeholder: scritta presente nel form; es. placeholder="Username" -->
            <!-- tutti i campi devono essere compilati (required) -->
            <label for="user" class="login_label">Username</label> <input name="user" id="user"  type="text" required>
            <label for="password" class="login_label">Password</label> <input name="password" id="password" type="password" required>
            <button id="login_button" type="submit">Accedi</button>
        </form>
        </div>
        
        <%@ include file="blocchi_dinamici/footer.jsp" %> 
    </div>
    </body>
</html>
