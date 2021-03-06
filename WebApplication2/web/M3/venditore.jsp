<%-- 
    Document   : venditore
    Created on : 20-apr-2016, 16.25.36
    Author     : Admin
--%>

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
        <%@ include file="blocchi_dinamici/header.jsp" %>
        <%@ include file="blocchi_dinamici/nav.jsp" %>
    
        <!-- form di input che comprende: nome, url immagine, descrizione, prezzo e quantità dell'oggetto messo in vendita
             Ho inserito input e label dentro dei paragrafi solo per avere un minimo di chiarezza nella visualizzazione
             della pagina, li rimuoverò quando faremo i CSS.
        -->
        <div class="venditore">
        <h3 class="venditore_title">Inserisci un nuovo oggetto</h3>
        <form method="GET">
            <!-- tutti i campi devono essere compilati (required) -->
            <label for="nome_oggetto" class="venditore_form">Nome oggetto</label> <input name="nome_oggetto" id="nome_oggetto" type="text" required/>
            <label for="url_immagine" class="venditore_form">URL immagine</label> <input name="url_immagine" id="url_immagine" type="url" required/>
            <label for="descrizione_oggetto" class="venditore_form">Descrizione</label> <textarea rows="7" cols="60"  name="descrizione_oggetto" id="descrizione_oggetto" required></textarea>
            <label for="prezzo" class="venditore_form">Prezzo</label>      <input name="prezzo" id="prezzo" type="number" min="0" required/>
            <label for="quantity" class="venditore_form">Quantità  </label> <input name="quantity" id="quantity" type="number" min="0" required/>
            
            <input id="venditore_insert" type="submit" value="Inserisci"/>
            <!--<input id="venditore_delete" type="submit" value="Pulisci campi"/>-->
        </form>
       </div>
        
     <%@ include file="blocchi_dinamici/footer.jsp" %> 
    </div>
    </body>
</html>

