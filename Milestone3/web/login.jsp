<%-- 
    Document   : login
    Created on : 17-apr-2016, 12.21.24
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        
        <c:choose>
            <c:when test="${vendor_loggedin || client_loggedin}">
                <%@ include file="blocchi_dinamici/nav_logged.jsp" %>
            </c:when>
            
            <c:when test="${!vendor_loggedin && !client_loggedin}">
                <%@ include file="blocchi_dinamici/nav.jsp" %>
            </c:when>
        </c:choose>
        
        <!-- credenziali errate -->
        <c:if test="${error}">
            <h3 class="errorlogin">Attenzione, username o password errati.</h3>    
        </c:if>
        
        <!-- logout effettuato -->
        <c:if test="${logout}">
            <h3 class="logout">Logout effettuato con successo.</h3>    
        </c:if>
        
        <!-- cliccare sul cliente mentre loggati col venditore -->
        <c:if test="${vendor_on_client}">
            <h3 class="errorlogin">Accesso negato! Risulti loggato come un venditore.</h3>    
        </c:if>
        
        <!-- cliccare sul venditore mentre loggati col cliente -->    
        <c:if test="${client_on_vendor}">
            <h3 class="errorlogin">Accesso negato! Risulti loggato come un cliente.</h3>    
        </c:if>
        
        <!-- cliccare sul cliente o venditore -->
        <c:if test="${client_click || vendor_click}">
            <h3 class="errorlogin">Accesso negato! Inserisci le credenziali nei rispettivi campi.</h3>    
        </c:if>
      
        <!-- form di input che contiene nome utente e password -->
        <div class="login">
            <h2 class="logformtitle">Accedi</h2>
        <form method="post" action="LoginPage">
            <input type="hidden" name="cmd" value="login">
            <!-- placeholder: scritta presente nel form; es. placeholder="Username" -->
            <!-- tutti i campi devono essere compilati (required) -->
            <label for="user" class="login_label">Username</label> <input name="Username" id="user"  type="text" required>
            <label for="password" class="login_label">Password</label> <input name="Password" id="password" type="password" required>
            <button id="login_button" type="submit" name="Submit">Accedi</button>
        </form>
        
        </div>
        
        <%@ include file="blocchi_dinamici/footer.jsp" %> 
    </div>
    </body>
</html>
