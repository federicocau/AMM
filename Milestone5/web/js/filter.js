/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
   $("#filtra").keyup(function()
    {  
        // Preleva il valore
        var text = $("#filtra").val();
       
        $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaOggetti(data);
            },
            error : function(data, state){
            }
        });
        
       // Funzione che viene richiamata in caso di successo
        function aggiornaListaOggetti(listaOggetti)
        {
            
            if(listaOggetti.length !== 0){
            
                // rimuove tutto tranne i titoli
                $("tr:not(.titoli)").remove();
                // rimuove i messaggi di errore precedenti
                $("#error").remove();

                // per ogni oggetto che rispetta la query
                for(var oggetto in listaOggetti)
                {

                    // riga per la tabella
                    var tr = document.createElement("tr");

                    // colonna per il nome
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaOggetti[oggetto].nome);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    // colonna per l'immagine 
                    var td = document.createElement("td");
                    var img = document.createElement("img");
                    img.setAttribute("title", listaOggetti[oggetto].categoria);
                    img.setAttribute("src", listaOggetti[oggetto].url);
                    img.setAttribute("alt", "Immagine di " + listaOggetti[oggetto].nome);
                    img.setAttribute("width", 140);
                    img.setAttribute("height", 140);
                    td.appendChild(img);
                    tr.appendChild(td);

                    // colonna per la quantità
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaOggetti[oggetto].quantita);
                    td.appendChild(txt);
                    tr.appendChild(td);

                    // colonna per il prezzo
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaOggetti[oggetto].prezzo + "€");
                    td.appendChild(txt);
                    tr.appendChild(td);

                    // colonna per il link all'acquisto
                    var td = document.createElement("td");
                    var button = document.createElement("button");

                    button.setAttribute("id", "button");

                    button.setAttribute("class", "cliente_button");
                    button.setAttribute("type", "Submit");

                    button.innerHTML = 'Aggiungi al carrello';
                    button.onclick = function () {carrello(this); };
                    td.appendChild(button);
                    tr.appendChild(td);
                    // inserisce la riga appena creata nella tabella
                    document.getElementById("tabella").appendChild(tr);
                    
                    // funzione per reindirizzare al carrello
                    function carrello(idOggetto){ location.href="Cliente_log?oggettoId=" + listaOggetti[oggetto].id + ""; }
                   /* 
                    // per la tabella piccola:
                    // 
                    // parte sinistra con immagine
                    var tr = document.createElement("tr");
                    var th = document.createElement("th");
                    
                    document.getElementById("immagine_span").rowSpan = "4";
                    
                    //th.setAttribute("rowspan", 4);
                    var img = document.createElement("img");
                    img.setAttribute("title", listaOggetti[oggetto].categoria);
                    img.setAttribute("src", listaOggetti[oggetto].url);                 
                    img.setAttribute("alt", "Immagine di " + listaOggetti[oggetto].nome);
                    img.setAttribute("width", 140);
                    img.setAttribute("height", 140);
                    th.appendChild(img);
                    // parte destra nome
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaOggetti[oggetto].nome);
                    td.appendChild(txt);
                    tr.appendChild(th);
                    
                    // parte destra quantita
                    var tr = document.createElement("tr");
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaOggetti[oggetto].quantita);
                    td.appendChild(txt);
                    tr.appendChild(td);
                    
                    // parte destra prezzo
                    var tr = document.createElement("tr");
                    var td = document.createElement("td");
                    var txt = document.createTextNode(listaOggetti[oggetto].quantita);
                    td.appendChild(txt);
                    tr.appendChild(td);
                    
                    // parte destra link acquisto
                    var tr = document.createElement("tr");
                    var td = document.createElement("td");
                    var button = document.createElement("button");
                    button.setAttribute("id", "button");
                    button.setAttribute("class", "cliente_button_min");
                    button.setAttribute("type", "Submit");
                    button.innerHTML = 'Aggiungi al carrello';
                    button.onclick = function () {carrello(this); };
                    td.appendChild(button);
                    tr.appendChild(td);
                    
                    // inserisce la riga appena creata nella tabella
                    //document.getElementById("on_off_480table").appendChild(th);
                    document.getElementById("on_off_480table").appendChild(tr);*/
                }
            
            }
            
            else{
                    // 
                    $("tr:not(.titoli)").remove();
                    $("#error").remove();
                    // stampo un messaggio di errore nel caso non ci siano oggetti
                    var div = document.getElementById("notfound");
                    var p = document.createElement("p");
                    p.setAttribute("class","oggetto_non_trovato");
                    var txt = document.createTextNode("Nessun oggetto trovato");
                    p.appendChild(txt);
                    p.setAttribute("id", "error");
                    div.appendChild(p);
            } 
        }
    }); 
});