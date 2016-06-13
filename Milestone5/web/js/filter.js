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
                    img.setAttribute("title", listaOggetti[oggetto].nome);
                    img.setAttribute("src", listaOggetti[oggetto].url);
                    img.setAttribute("alt", listaOggetti[oggetto].nome);
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
                    var a = document.createElement("a");
                    a.setAttribute("href", "Cliente_log?oggettoId=" + listaOggetti[oggetto].id);       
                    button.setAttribute("id", "button");
                    button.setAttribute("class", "cliente_button");
                    button.setAttribute("type", "Submit");
                    button.innerHTML = 'Aggiungi al carrello';
                    a.appendChild(button);
                    td.appendChild(a);
                    tr.appendChild(td);
                    // inserisce la riga appena creata nella tabella
                    document.getElementById("tabella").appendChild(tr);
                    
                                
                    /***** creazione tabella 480 *****/
                    
                    // riga per la tabella
                    var tr = document.createElement("tr");
                    
                    // parte destra immagine
                    var td = document.createElement("td");
                    var img = document.createElement("img");
                    img.setAttribute("title", listaOggetti[oggetto].nome);
                    img.setAttribute("src", listaOggetti[oggetto].url);
                    img.setAttribute("alt", listaOggetti[oggetto].nome);
                    img.setAttribute("width", 140);
                    img.setAttribute("height", 140);
                    td.appendChild(img);
                    tr.appendChild(td);
                    
                    
                    document.getElementById("on_off_480table").appendChild(tr);
                    
                    // parte destra quantita
                    var td = document.createElement("td");
                    var txt = document.createTextNode("Quantità: " + listaOggetti[oggetto].quantita);
                    td.appendChild(txt);
                    tr.appendChild(td);
                    
                    // parte destra prezzo
                    var td = document.createElement("td");
                    var txt = document.createTextNode("Prezzo: " + listaOggetti[oggetto].prezzo + "€");
                    td.appendChild(txt);
                    tr.appendChild(td);
                    
                     // parte destra link acquisto
                    var td = document.createElement("td");
                    var a = document.createElement("a");
                    var button = document.createElement("button");
                    
                    // immagine 
                    var img = document.createElement("img");
                    img.setAttribute("title", listaOggetti[oggetto].categoria);
                    img.setAttribute("src", "img/carrello.png");
                    img.setAttribute("alt", "Immagine di " + listaOggetti[oggetto].nome);
                    img.setAttribute("width", 30);
                    img.setAttribute("height", 30);
                    
                    // a con href
                    a.setAttribute("href", "Cliente_log?oggettoId=" + listaOggetti[oggetto].id); 
                    button.setAttribute("id", "button");
                    button.setAttribute("class", "cliente_button_min_js");
                    button.setAttribute("type", "Submit");
                    button.appendChild(img);
                    a.appendChild(button);
                    td.appendChild(a);
                    tr.appendChild(td);
                    // inserisce la riga appena creata nella tabella 480
                    document.getElementById("on_off_480table").appendChild(tr);
                }
            
            }
            
            else{
                    // 
                    $("tr:not(.titoli)").remove();
                    $("#error").remove();
                    // stampo un messaggio di errore nel caso non ci siano oggetti
                    var div = document.getElementById("notfound");
                    var div2 = document.getElementById("notfound480");
                    var p = document.createElement("p");
                    p.setAttribute("class","oggetto_non_trovato");
                    var txt = document.createTextNode("Nessun oggetto trovato");
                    p.appendChild(txt);
                    p.setAttribute("id", "error");
                    div.appendChild(p);
                    div2.appendChild(p);
            } 
        }
    }); 
});