/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Admin
 * Created: 23-mag-2016
 */


INSERT INTO venditore (id, nome, cognome, username, password, tipo, conto) 
VALUES
(default, 'Mario', 'Rossi', 'Mariotto', 'cicale', 'venditore', 300.10),
(default, 'Gino', 'Rossi', 'Ginetto', 'pollo', 'venditore', 44.70),
(default, 'Ralf', 'Break', 'Ralfio', 'cipolla', 'venditore',500);


INSERT INTO cliente (id, nome, cognome, username, password, tipo, conto) 
VALUES
(default, 'Proxy', 'Nell', 'Pronell', 'olio', 'cliente', 100.70),
(default, 'Elena', 'Fenzi', 'Elepi', 'cavolo', 'cliente', 700),
(default, 'Serena', 'Bulli', 'Serel', 'uovo', 'cliente', 600.50);


INSERT INTO oggetto (id, categoria, nome, url, descrizione, prezzo, quantita, venditore_id ) 
VALUES
(default, 'RAM', 'RAM 4GB DDR3 Hyper', 'img/ram.jpg', 'Test ram', 50, 5, 1),
(default, 'Processore', 'Processore Intel i5', 'img/process.jpg', 'Test processore', 80, 3, 2),
(default, 'SchedaMadre', 'Scheda Madre UltraX', 'img/scheda_madre.jpg', 'Test scheda_madre', 110.50, 2, 2);