<%-- 
    Document   : cliente
    Created on : 20-apr-2016, 16.25.00
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <!-- Meta informazioni della pagina: autore, descrizione sito, parole chiave -->
        <title>Techware Cliente</title>
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
        <%@ include file="blocchi_dinamici/nav_logged.jsp" %>
        <c:choose>
        <c:when test="${client_loggedin}">
        <h3>Bentornato, ${cliente.nome} ${cliente.cognome} (${cliente.tipo}) - Saldo: ${cliente.conto}€ </h3> 
     
        <!-- Tabella che contiene: nome, foto, quantità e prezzo dei vari prodotti in vendita -->
        <div id="cliente">
        <h1 class="cliente_title">Prodotti</h1>
        <table>
            <tr>
            <th>Nome</th>
            <th>Foto</th>
            <th>Quantità</th>
            <th>Prezzo</th>
            <th>Aggiungi al carrello</th>
            </tr>
            <c:forEach var="oggetto" items="${listaOggetti}">
                <tr>
                <td>${oggetto.nome}</td>
                <td><img title="${oggetto.categoria}" alt="${oggetto.categoria}" src="${oggetto.url}" width="140" height="140"></td>
                <td>${oggetto.quantita}</td>
                <td>${oggetto.prezzo}€</td>
                <td><button class="cliente_button" type="Submit" onclick="location.href='Carrello?oggettoId=${oggetto.id}'">Aggiungi al carrello</button> </td>
                </tr>
            </c:forEach>       
        </table>
    </div>
        
        <div id="cliente_480table">
            <h1 id="cliente_title_480table">Prodotti</h1>
            <table id="on_off_480table">
                <c:forEach var="oggetto" items="${listaOggetti}">
                <tr>
                <th rowspan="4"><img title="${oggetto.categoria}" alt="${oggetto.categoria}" src="${oggetto.url}" width="140" height="140"></th>
                <td>Nome: ${oggetto.nome}</td>
                </tr>
                <tr>
                <td>Quantità: ${oggetto.quantita}</td>
                </tr>
                <tr>
                <td>Prezzo: ${oggetto.prezzo}€</td>
                </tr> 
                <tr>
                <td><button class="cliente_button_min" onclick="location.href='Carrello?oggettoId=${oggetto.id}'">Aggiungi al carrello</button></td>
                </tr>
                </c:forEach>    
            </table>
        </div>
        </c:when>
        
        <c:when test="${!client_loggedin}">
            <h3 class="accessonegato">Accesso negato, verrai reindirizzato alla pagina di login.</h3> 
            <meta http-equiv="refresh" content="1.5;url=login.jsp">
        </c:when>
        </c:choose>
    
   <%@ include file="blocchi_dinamici/footer.jsp" %> 
        
    </div>    
    </body>
</html>

