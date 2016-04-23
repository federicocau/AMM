<%-- 
    Document   : cliente
    Created on : 20-apr-2016, 16.25.00
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
        <%@ include file="blocchi_dinamici/nav.jsp" %>
     
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
                <td>${oggetto.url}</td>
                <td>${oggetto.quantita}</td>
                <td>${oggetto.prezzo}</td>
                <button class="cliente_button" onclick="location.href='cliente.html'">Aggiungi al carrello</button>        
                </tr>
            </c:forEach>
            <!--
            <tr>
                <td>Scheda Madre MSI Z97 Gaming 5 Nero</td>
                <td>
                    <img title="scheda_madre" alt="scheda_madre" src="img/scheda_madre.jpg" width="140" height="140">
                </td>
                <td> 44</td>
                <td>150,40 €</td>
                <td>
                    <button class="cliente_button" onclick="location.href='cliente.html'">Aggiungi al carrello</button>
                </td>
            </tr>
            
            <tr>

                <td>Scheda Video Msi GTX N750, 2 GB GDDR5, PCIe, Nero/Antracite</td>
                <td>
                    <img title="scheda_video" alt="scheda_video" src="img/scheda_video.jpg" width="140" height="140">
                </td>
                <td> 20</td>
                <td>119,90 €</td>
                <td>
                    <button class="cliente_button" onclick="location.href='cliente.html'">Aggiungi al carrello</button>
                </td>
            </tr>
            
            <tr>

                <td>2 Memorie RAM HyperX FURY Kit 8GB, 2133MHz, DDR4, Non-ECC CL14 DIMM, Nero/Antracite, Compatibili con Skylake</td>
                <td>
                    <img title="RAM" alt="RAM" src="img/ram.jpg" width="140" height="140">
                </td>
                <td> 38</td>
                <td>44,23 €</td>
                <td>
                    <button class="cliente_button" onclick="location.href='cliente.html'">Aggiungi al carrello</button>
                </td>
            </tr>
            
            <tr>

                <td>Intel Processore Core i5-6600K (Skylake) Quad-Core</td>
                <td>
                    <img title="processore" alt="processore" src="img/process.jpg" width="140" height="140">
                </td>
                <td> 29</td>
                <td>254,60 €</td>
                <td>
                    <button class="cliente_button" onclick="location.href='cliente.html'">Aggiungi al carrello</button>
                </td>
            </tr>
            
            <tr>

                <td> Alimentatore Corsair VS650 ATX Serie VS da 650 Watt</td>
                <td>
                    <img title="alimentatore" alt="alimentatore" src="img/alim.jpg" width="140" height="140">
                </td>
                <td> 64</td>
                <td>56,08 €</td>
                <td>
                    <button class="cliente_button" onclick="location.href='cliente.html'">Aggiungi al carrello</button>
                </td>
            </tr>
            -->
    </table>
    </div>
        
        <div id="cliente_480table">
            <h1 id="cliente_title_480table">Prodotti</h1>
            <table id="on_off_480table">
                <tr>
                <th rowspan="4"><img title="img" alt="scheda_madre" src="img/scheda_madre_whitebg.jpg" width="140" height="140"></th>
                <td>Nome: Scheda Madre MSI Z97 Gaming 5 Nero</td>
                </tr>
                <tr>
                <td>Quantità: 44</td>
                </tr>
                <tr>
                <td>Prezzo: 150.40 €</td>
                </tr> 
                <tr>
                <td><button class="cliente_button_min" onclick="location.href='cliente.html'">Aggiungi al carrello</button></td>
                </tr>
                
                <tr>
                <th rowspan="4"><img title="img" alt="scheda_video" src="img/scheda_video.jpg" width="140" height="140"></th>
                <td>Nome: Scheda Video Msi GTX N750, 2 GB GDDR5, PCIe, Nero/Antracite</td>
                </tr>
                <tr>
                <td>Quantità: 20</td>
                </tr>
                <tr>
                <td>Prezzo: 119,90 €</td>
                </tr> 
                <tr>
                <td><button class="cliente_button_min" onclick="location.href='cliente.html'">Aggiungi al carrello</button></td>
                </tr>
                
                <tr>
                <th rowspan="4"><img title="img" alt="RAM" src="img/ram_whitebg.jpg" width="140" height="140"></th>
                <td>Nome: 2 Memorie RAM HyperX FURY Kit 8GB, 2133MHz, DDR4, Non-ECC CL14 DIMM, Nero/Antracite, Compatibili con Skylake</td>
                </tr>
                <tr>
                <td>Quantità: 38</td>
                </tr>
                <tr>
                <td>Prezzo: 44,23 €</td>
                </tr> 
                <tr>
                <td><button class="cliente_button_min" onclick="location.href='cliente.html'">Aggiungi al carrello</button></td>
                </tr>
                
                 <tr>
                <th rowspan="4"><img title="img" alt="processore" src="img/process.jpg" width="140" height="140"></th>
                <td>Nome: Intel Processore Core i5-6600K (Skylake) Quad-Core</td>
                </tr>
                <tr>
                <td>Quantità: 29</td>
                </tr>
                <tr>
                <td>Prezzo: 254,60 €</td>
                </tr> 
                <tr>
                <td><button class="cliente_button_min" onclick="location.href='cliente.html'">Aggiungi al carrello</button></td>
                </tr>
                
                 <tr>
                <th rowspan="4"><img title="img" alt="alimentatore" src="img/alim_whitebg.jpg" width="140" height="140"></th>
                <td>Nome: Alimentatore Corsair VS650 ATX Serie VS da 650 Watt</td>
                </tr>
                <tr>
                <td>Quantità: 64</td>
                </tr>
                <tr>
                <td>Prezzo: 56,08 €</td>
                </tr> 
                <tr>
                <td><button class="cliente_button_min" onclick="location.href='cliente.html'">Aggiungi al carrello</button></td>
                </tr>
                
                
            </table>
        </div>
    
   <%@ include file="blocchi_dinamici/footer.jsp" %> 
        
    </div>    
    </body>
</html>

