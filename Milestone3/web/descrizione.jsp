<%--  
    Document   : descrizione
    Created on : 20-apr-2016, 16.25.26
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
        <title>Techware: componenti per Pc</title>
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
            
        
        
        
      
        <!-- barra di navigazione laterale a sinistra -->
        <aside>
         <ul id="descrizione_aside">
             <li id="categorie">Categorie</li>
             
             <li><a href="#">Archiviazione</a>
            <ul>
                <li><a href="#harddisk">Hard Disk Drive (HDD)</a></li>
                <li><a href="#solidstate">Solid State Drive (SSD)</a></li>
                <li><a href="#usb">Chiavi USB</a></li>             
            </ul>
            </li>
            
            <li><a href="#processori">Processori</a></li>
            <li><a href="#alim">Alimentatori</a></li>
            <li><a href="#diss">Dissipatori</a></li>

            <li><a href="#">Schede/Memorie</a>
            <ul>
                <li><a href="#ram">Memoria RAM</a></li>
                <li><a href="#schedemadri">Schede Madri</a></li>
                <li><a href="#schedevid">Schede Video</a></li>
                <li><a href="#schedeaux">Schede Audio</a></li>   
            </ul>
            </li>
                  
            <li><a href="#">Accessori</a>
            <ul>
                <li><a href="#mouse">Mouse</a></li>
                <li><a href="#keyboard">Tastiere</a></li>
                <li><a href="#case">Case</a></li>
                <li><a href="#dvdmaster">Masterizzatori DVD</a></li>
            </ul>
            </li>
        </ul>
        </aside>
        
        <!-- contenuto della pagina a destra --> 
        
        <div id="descrizione_content">
            
        <p>
            <strong>Techware</strong> è un sito che dà la possibilità di acquistare tutte le componenti per chi vuole migliorare le prestazioni
            del proprio pc oppure per chi ha la necessità di assemblarne uno. Consente inoltre agli utenti di mettere in vendita dei componenti hardware nuovi/usati.
         </p>
        <h2>I nostri prodotti:</h2>
        
        <a id="harddisk">
        <h3> Hard Disk Drive (HDD) </h3>     
        </a>
        <p>
        Un disco rigido o disco fisso, anche chiamato hard disk drive (abbreviazioni comuni: "hard disk", "HDD") o fixed disk drive[4] 
        (abbreviazioni comuni: "fixed disk", "FDD"), è un dispositivo di memoria di massa di tipo magnetico che utilizza uno o più dischi 
        magnetizzati per l'archiviazione dei dati (file, programmi e sistemi operativi). Il disco rigido è una periferica di input-output 
        del computer ed è uno dei tipi di dispositivi di memoria di massa attualmente più utilizzati essendo presente nella maggior parte dei 
        computer ed anche in altri dispositivi elettronici, come ad esempio il PVR. Il disco rigido è stato per lungo tempo l'unica scelta 
        sui personal computer, ma sta conoscendo una perdita di quote di mercato a favore dei più recenti dischi a stato solido (SSD).
            
       
        </p>
        
        <a id="solidstate">
        <h3> Solid State Drive (SSD) </h3>     
        </a>
        <p>
        In elettronica e informatica un'unità a stato solido o drive a stato solido (in sigla SSD dal corrispondente termine inglese solid-state drive) 
        è una tipologia di dispositivo di memoria di massa basata su semiconduttore, che utilizza memoria allo stato solido (in particolare memoria flash)
        per l'archiviazione dei dati, anziché supporti di tipo magnetico come nel caso dell'hard disk classico. 
        Ne consegue che l'altra importante differenza con i classici dischi rigidi è la possibilità di memorizzare in maniera non volatile 
        grandi quantità di dati, senza l'utilizzo di organi meccanici (piatti, testine, motori ecc.) come fanno invece gli hard disk tradizionali. 
        La maggior parte delle unità a stato solido utilizza la tecnologia delle memorie flash NAND, che permette una distribuzione uniforme dei 
        dati e di "usura" dell'unità.
            
        </p>
        
        <a id="usb">
        <h3> Chiavi USB </h3>     
        </a>
        <p>
        Una chiave USB o chiavetta USB o penna USB (anche in inglese USB flash drive, o pendrive) è una memoria di massa portatile di dimensioni 
        molto contenute (qualche centimetro in lunghezza e intorno al centimetro in larghezza) che si collega al computer mediante la porta USB. 
        Molti modelli dispongono di un occhiello per permetterne l'aggancio all'anello di un comune portachiavi. 
        Nella chiave USB i dati sono memorizzati in una memoria flash, tipicamente di tipo NAND, contenuta al suo interno. 
        La capacità è limitata unicamente dalla densità delle memorie flash impiegate, con il costo per megabyte che aumenta rapidamente 
        per alte capacità. Nella primavera 2013 la Kingston Technology ha reso disponibile sul mercato una chiave dalla capacità di 1 terabyte: 
        si tratta del modello DataTraveler HyperX Predator 3.0, che grazie al supporto dello standard USB 3.0 è capace di raggiungere una velocità 
        massima teorica in scrittura di 160 MB/s e in lettura di 240 MB/s. La Kingston Technology ritiene che la capacità di 1 TB la renda la chiave 
        di maggior capacità attualmente disponibile sul mercato
           
        </p>
       
        <a id="processori">
        <h3> Processori </h3>     
        </a>
        <p>
        In informatica ed elettronica l'unità di elaborazione o processore è un tipo di dispositivo hardware del computer che si 
        contraddistingue per essere dedicato all'esecuzione di istruzioni. In altri termini l'unità di elaborazione è il dispositivo 
        che nel computer esegue materialmente l'elaborazione dati tipicamente sotto la supervisione del sistema operativo attraverso il 
        cosiddetto ciclo di fetch-execute. Le altre componenti del computer sono ausiliarie all'unità di elaborazione oppure costituiscono 
        l'interfaccia di input o l'interfaccia di output (periferiche). L'unità di elaborazione, l'interfaccia di input e l'interfaccia di 
        output sono infatti le tre componenti logiche sempre presenti nel computer. Un computer può essere dotato anche di più processori 
        che collaborano tra loro. In tal caso si parla di "computer multiprocessore" e l'elaborazione dati viene anche chiamata, con 
        termine più specifico, "multielaborazione" o "multiprocessing".[3] Il processore, in quanto sistema elettronico digitale, tipicamente 
        lavora ad una certa frequenza di clock che rappresenta uno dei suoi parametri prestazionali in termini di capacità di processamento.    
            
        </p>
        
        <a id="alim">
        <h3> Alimentatori </h3>     
        </a>
        <p>
        Un alimentatore elettrico è un convertitore AC-DC, ovvero un apparato elettrico, semplice o composto, che serve a raddrizzare 
        in uscita la tensione elettrica in ingresso (da alternata AC a continua DC) in modo da fornire energia elettrica adattandola 
        all'uso di altre apparecchiature elettriche (es. elettrodomestici), modificando eventualmente anche i livelli di tensione e corrente, 
        e dunque potenza, in uscita attraverso un trasformatore. 
        Gli alimentatori differiscono ampiamente in funzione della potenza gestita, così anche per le caratteristiche di qualità della corrente 
        elettrica fornita all'uscita. Un alimentatore con pari valori di tensione e potenza è più complesso e costoso quanto più la tensione 
        fornita è precisa e stabile, e quanto maggiore è la sua affidabilità. Esistono anche alimentatori da laboratorio, in cui la tensione 
        di uscita è regolabile a piacere dall'utilizzatore in base alla necessità. Questi alimentatori hanno anche una limitazione della corrente 
        massima fornita, in alcuni casi regolabile, utile per evitare problemi in caso di cortocircuito e per speciali circuiti con alimentazione 
        in corrente costante. In molti casi l'alimentatore fornisce più di una tensione di uscita a seconda della necessità. È il caso degli 
        alimentatori per incubatrici, che forniscono tensioni di 9,3, ±32, ±100 V. Un crescente numero di case costruttrici adotta la certificazione 
        80 Plus per verificare la stabilità della tensione in uscita e la quantità di energia dissipata in calore, sotto varie condizioni di carico dell'alimentatore.    
            
        </p>
        
        <a id="diss">
        <h3> Dissipatori </h3>     
        </a>
        <p>
        In elettronica un dissipatore è un dispositivo, montato generalmente su una scheda elettronica, che consente l'abbassamento della 
        temperatura dei componenti elettrici e/o elettronici presenti che sprigionano calore come transistor e processori, evitando che 
        il surriscaldamento degli stessi ne provochi il malfunzionamento o l'arresto.
                 
        </p>
          
        <a id="ram">
        <h3> Memoria RAM </h3>     
        </a>
        <p>
         La RAM, acronimo dell'inglese Random Access Memory ovvero memoria ad accesso casuale, è un tipo di memoria volatile caratterizzata 
         dal permettere l'accesso diretto a qualunque indirizzo di memoria con lo stesso tempo di accesso. 
         La memoria ad accesso casuale si affianca ad altre tipologie di memoria come la memoria ad accesso sequenziale e alla memoria 
         ad accesso diretto. Per le sue caratteristiche viene utilizzata come memoria primaria nei più comuni computer.
         Il tipo di memoria ad accesso casuale più comune attualmente è a stato solido, a lettura-scrittura e volatile, ma rientrano nel 
         tipo di memoria ad accesso casuale la maggior parte dei tipi di RAM (memoria a sola lettura), la NOR Flash (un tipo di memoria flash), 
         oltre a vari tipi di memorie informatiche utilizzate ai primordi dell'informatica e oggi non più utilizzate come ad esempio la memoria 
         a nucleo magnetico. L'acronimo RAM (non il termine "memoria ad accesso casuale") ha anche una seconda accezione più ristretta, 
         ma attualmente più diffusa, che identifica le schede fisiche che vengono installate negli odierni computer (vedi moduli DIMM, SIMM, SO-DIMM, etc..)   
            
        </p>
        
        <a id="schedemadri">
        <h3> Schede Madri </h3>     
        </a>
        <p>
        La scheda madre o scheda di sistema, anche conosciuta con i termini inglesi motherboard ("scheda madre") mainboard ("scheda principale"), o 
        meno conosciuta come planar board ( scheda piana ), abbreviata MB, M/B, mobo, è una parte fondamentale di un moderno personal computer: 
        sotto forma di scheda elettronica principale raccoglie in sé tutta la circuiteria elettronica e i collegamenti di interfaccia tra i vari 
        componenti interni principali del PC (CPU, memoria e le altre schede elettroniche montate o alloggiate sopra) comprendendo quindi anche i 
        bus di espansione e le interfacce verso le periferiche esterne. 
        È responsabile dunque della trasmissione e temporizzazione corretta di molte centinaia di segnali diversi, tutti ad alta frequenza 
        e sensibili ai disturbi, tra processore e RAM, schede di espansione e periferiche esterne attraverso i vari bus di sistema. 
        La sua buona realizzazione è quindi un fattore chiave per le prestazioni e l'affidabilità dell'intero computer.    
            
        </p>
        
        <a id="schedevid">
        <h3> Schede Video</h3>     
        </a>
        <p>
         In informatica ed elettronica una scheda video[1] è un componente hardware del computer, sotto forma di scheda elettronica che ha 
         lo scopo di elaborazione del segnale video ovvero generare, a partire da un segnale elettrico in input dal processore, un determinato 
         segnale elettrico in output che possa essere poi inviato in input a video (display o monitor) per essere tradotto da quest'ultimo in 
         segnale ottico visivo e mostrato all'utente. A seconda del tipo di computer questo dispositivo può essere più o meno potente: 
         i primi modelli di scheda video potevano visualizzare solo testo; successivamente si sono diffuse anche schede video in grado di
         mostrare output grafici (immagini non testuali) e, recentemente, anche modelli tridimensionali texturizzati in movimento e in tempo reale. 
         Questi ultimi tipi di scheda provvedono anche ad elaborare e modificare l'immagine nella propria memoria interna, mentre le schede 2D 
         possono mostrare immagini 3D solo con l'aiuto della CPU che deve eseguire da sola tutti i calcoli necessari.   
            
        </p>
        
        
        <a id="schedeaux">
        <h3> Schede Audio </h3>     
        </a>
        <p>
        In elettronica una scheda audio è una scheda di espansione di un computer che si occupa di elaborare un flusso audio digitale in input 
        (da una memoria o trasferito attraverso una rete) in un segnale analogico o digitale da inviare in output ad una periferica audio 
        (ad es. un set di altoparlanti o cuffie audio) per essere riprodotto/trasdotto in un segnale sonoro a favore dell'utente. 
        La maggior parte delle schede audio attuali è anche in grado di operare in maniera inversa ovvero ricevere segnali in input 
        (da microfoni o strumenti musicali) e inviarli all'unità di elaborazione della scheda per l'elaborazione e successiva memorizzazione 
        in output su vari possibili supporti.    
            
        </p>
             
        <a id="mouse">
        <h3> Mouse </h3>     
        </a>
        <p>
         In informatica il mouse è un dispositivo (o periferica di input di un computer) in grado di inviare al sistema un comando da parte 
         dell'utente in modo tale che a un suo movimento su una base solida lineare ne corrisponda uno analogo da parte di un indicatore sullo 
         schermo del monitor detto cursore. È dotato di uno o più tasti ai quali possono essere assegnate varie funzioni. L'etimologia del nome 
         è dall'inglese topo, in relazione alla somiglianza tra il dispositivo col suo cavo di collegamento e il roditore.
                 
        </p>
        
        <a id="keyboard">
        <h3> Tastiere </h3>     
        </a>
        <p>
         In informatica la tastiera è una periferica di input del computer destinata all'inserimento manuale di dati, numerici o alfanumerici, 
         nella memoria del computer e al controllo del computer stesso. La tastiera può essere incorporata nell'unità centrale del computer 
         come ad esempio avviene negli home computer e nei computer portatili) o essere una periferica esterna.
                 
        </p>
        
        <a id="case">
        <h3> Case </h3>     
        </a>
        <p>
         La cassa del computer, anche nota come scocca, cabinet, chassis o case[1], è l'organo preposto ad accogliere i principali componenti di 
         un elaboratore, ovvero: scheda madre, schede elettroniche (scheda video, scheda CPU, scheda audio, scheda di rete, scheda di memoria ecc.), 
         unità di memoria (lettori di dischetti floppy, dischi rigidi, lettori CD, masterizzatori, ecc.) e alimentatore. 
         Normalmente la scocca è in lamiera metallica e più precisamente in SECC (dall'inglese "Steel Electrogalvanized Cold-rolled Coil", 
         un tipo di acciaio apprezzato per il basso costo e l'elevata conducibilità termica), oppure in alluminio, o in rame. Esistono 
         tuttavia anche scocche in plastica o in legno.
                 
        </p>
        
        <a id="dvdmaster">
        <h3> Masterizzatori DVD </h3>     
        </a>
        <p>
         Un masterizzatore, in informatica ed elettronica, è un dispositivo hardware utilizzato per creare o duplicare Compact Disc (CD) o DVD di dati, 
         audio e/o video attraverso un processo di masterizzazione di tipo ottico su supporto di memorizzazione tramite un'ottica laser. 
         Tali dispositivi hardware vennero immessi sul mercato a partire dagli anni novanta del XX secolo.
                 
        </p>
        </div>
        
        <%@ include file="blocchi_dinamici/footer.jsp" %> 
        
    </div>
    </body>
</html>

