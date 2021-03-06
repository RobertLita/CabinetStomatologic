## Cabinet Stomatologic

- ### Etapa 1 (1 aprilie)

1. Definirea sistemului:
    - [x] Să se creeze o lista pe baza temei alese cu cel puțin 10 acțiuni/interogări care
      se pot face în cadrul sistemului și o lista cu cel puțin 8 tipuri de obiecte.

2. Implementare: Să se implementeze în limbajul Java o aplicație pe baza celor definite la punctul 1. Aplicația va conține:
    - [x] Clase simple cu atribute private / protected și metode de acces
    - [X] Cel puțin 2 colecții diferite capabile să gestioneze obiectele definite anterior (List, Set, Map, etc.) dintre care cel puțin una sa fie sortata.
      Se vor folosi array-uri uni/bidimensionale in cazul in care nu se parcurg colectiile pana la data checkpoint-ului.
    - [x] Utilizare moștenire pentru crearea de clase adiționale și utilizarea lor în cadrul colecțiilor;
    - [x] Cel puțin o clasa serviciu care sa expună operațiile
    - [x] O clasa main din care sunt făcute apeluri către servicii

Acțiuni:

- Pentru cabinet -> o metoda care afișează stocul de materiale
- Pentru cabinet -> adauga/sterge/modifica medici/asistent
- Pentru cabinet -> o metoda care adauga/elimina materiale in stoc
- Pentru cabinet -> o metoda care modifica salariul unui medic/asistent
- Pentru cabinet -> o metoda prin care se afișează doctorii crescător in funcție de un anumit domeniu (rating, salariu, nr. pacienți etc)
- Pentru un doctor -> o metoda care afișează programările din ziua curenta.
- Pentru un doctor -> o metoda care creeaza următoarea programare a unui pacient.
- Pentru un doctor -> o metoda care elimina programarea curenta a unui pacient. *
- Pentru un pacient -> o metoda care afișează programarea sa viitoare.
- Pentru un pacient -> o metoda care afiseaza recomandarile pe care le are de la medic.
- Pentru un pacient -> o metoda prin care poate da un rating unui doctor.

*Programarile sunt retinute intr-un priorityqueue. Doctorul face programarile astfel:
- pentru un pacient nou, apeleaza o metoda care creeaza o programare (data, subiectul si pacientul ca params)
- pentru un pacient deja existent, apeleaza o metoda care creeaza o noua programare bazata pe cea curenta a pacientului, peste un anumit numar de zile(subiect, nr zile ca param)

Clase: persoana, doctor, asistent, cabinet, pacient, programare, diagnostic, tratament
- ### Etapa 2 (3 mai)
1. Extindeți proiectul din prima etapa prin realizarea persistentei utilizând fișiere.
    - [x] Se vor realiza fișiere de tip csv 1(comma separated values) pentru cel puțin 4 dintre clasele definite in prima etapa.
    - [x] Se vor realiza servicii singleton generice pentru scrierea și citirea din fișiere
    - [x] La pornirea programului se vor încărca datele din fișiere utilizând serviciile create
2. Realizarea unui serviciu de audit
    - [x] se va realiza un serviciu care sa scrie într-un fișier de tip CSV de fiecare data când este executata una dintre acțiunile descrise in prima etapa. Structura fișierului: nume_actiune, timestamp

- ### Etapa 3 (31 mai)
    - [x] Înlocuiți serviciile realizate în etapa a II-a cu servicii care sa asigure persistenta utilizând baza de date folosind JDBC.
    - [x] Să se realizeze servicii care sa expună operații de tip create, read, update, delete pentru cel puțin 4 dintre clasele definite

