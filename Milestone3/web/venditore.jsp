<%--  
    Document   : venditore
    Created on : 20-apr-2016, 16.25.36
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
        <title>Techware Venditore</title>
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
        <c:if test="${!from_session}">
            <meta http-equiv="refresh" content="0;url=Venditore_log">
        </c:if>
        <%@ include file="blocchi_dinamici/header.jsp" %>
        <%@ include file="blocchi_dinamici/nav_logged.jsp" %>
        <c:choose>
        <c:when test="${vendor_loggedin && !inserito}">
         <h3 class="user_stats">Bentornato, ${venditore.nome} ${venditore.cognome} (${venditore.tipo}) - Saldo: ${venditore.conto}€  </h3> 
                    

    
        <!-- form di input che comprende: nome, url immagine, descrizione, prezzo e quantità dell'oggetto messo in vendita
             Ho inserito input e label dentro dei paragrafi solo per avere un minimo di chiarezza nella visualizzazione
             della pagina, li rimuoverò quando faremo i CSS.
        -->
        <div class="venditore">
        <h3 class="venditore_title">Inserisci un nuovo oggetto</h3>
        <form method="post" action="Venditore_log">
            <input type="hidden" name="cmd" value="oggetto">
            <!-- tutti i campi devono essere compilati (required) -->
            <label for="nome_oggetto" class="venditore_form">Nome oggetto</label> <input name="nome_oggetto" id="nome_oggetto" type="text" required/>
            <label for="url_immagine" class="venditore_form">URL immagine</label> <input name="url_immagine" id="url_immagine" type="url" required/>
            <label for="descrizione_oggetto" class="venditore_form">Descrizione</label> <textarea rows="7" cols="60"  name="descrizione_oggetto" id="descrizione_oggetto" required></textarea>
            <label for="prezzo" class="venditore_form">Prezzo</label>      <input name="prezzo" id="prezzo" type="number" min="0" required/>
            <label for="quantity" class="venditore_form">Quantità  </label> <input name="quantity" id="quantity" type="number" min="0" required/>
            
            <input id="venditore_insert" type="submit" value="Inserisci" name="Submit"/>
            <!--<input id="venditore_delete" type="submit" value="Pulisci campi"/>-->
        </form>
       </div>   
        </c:when>
        
        <c:when test="${vendor_loggedin && inserito}">
        <h3 class="user_stats">Bentornato, ${venditore.nome} ${venditore.cognome} (${venditore.tipo}) - Saldo: ${venditore.conto}€  </h3>
        <div id="cliente">
        <h2 class="cliente_title">Oggetto inserito con successo</h2>
        <table>
            <tr>
            <th>Nome</th>
            <th>Foto</th>
            <th>Descrizione</th>
            <th>Quantità</th>
            <th>Prezzo</th>
            </tr>
                <tr>
                <td>${oggetto.nome}</td>
                <td><img title="${oggetto.categoria}" alt="${oggetto.categoria}" src="${oggetto.url}" width="140" height="140"></td>
                <td>${oggetto.descrizione}</td>
                <td>${oggetto.quantita}</td>
                <td>${oggetto.prezzo}€</td>
                </tr>
        </table>
       </div>
       
       <div id="cliente_480table">
            <h1 id="cliente_title_480table">Oggetto inserito con successo</h1>
            <table id="on_off_480table">
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
            </table>
        </div>
        </c:when>
        
        <c:when test="${!vendor_loggedin}">
            <h3 class="accessonegato">Accesso negato, verrai reindirizzato alla pagina di login.</h3> 
            <meta http-equiv="refresh" content="1.5;url=login.jsp">
        </c:when>
    </c:choose>

        
        <%@ include file="blocchi_dinamici/footer.jsp" %> 
    </div>
    </body>
</html>

