# OOP2 Programmierprojekt

## Hinweise zu Git
Dieses Git-Repository enthält einige Ressourcen als [Submodul](https://git-scm.com/book/de/v1/Git-Tools-Submodule), damit diese bei der Auswertung nicht wieder dutzende Male heruntergeladen werden muss.
Aus diesem Grund muss das Repository mit `git clone --recursive <Pfad zum Repository>` heruntergeladen werden. Falls Sie das beim ersten `clone` vergessen haben, können Sie die Ressourcen mit den folgenden beiden Befehlen nachladen:
1. `git submodule init`
2. `git submodule update`

## FootballplayerFX
Implementieren Sie eine Applikation auf Basis JavaFX gemäss der Aufgabenbeschreibung aus der Lektion (siehe Moodle). 
 - Benutzen Sie zur Umsetzung die vorgegebene Struktur des "Application-Template".
 - Die Verwendung von SceneBuilder und FXML ist nicht erlaubt.


## Abgabe
- Klasse 2Ibb: Dienstag, 13.6.2017, 18:00 Uhr
- Klasse 2Ia und 2iCa: Mittwoch, 14.6.2017, 18:00 Uhr


## Bitte beachten Sie:
 - Wie in der Aufgabenbeschreibung bereits festgelegt, müssen für eine 4.0 folgende Basis-Features implementiert sein:
   - Einlesen der Daten aus Datei
   - Abspeichern der Änderungen
   - Darstellen aller Spieler in Tabelle
   - Editor-Bereich:
     - arbeitet stets auf dem in der Tabelle ausgewählten Spieler
     - Änderungen führen zu unmittelbarer Aktualisierung der Tabelle und des Header-Bereichs
   - Header-Bereich mit Name, Land, Landesflagge, Anzahl der Länderspiele, erstes und letztes Spiel und das Logo des jeweiligen Fussballbundes
   - Layout mit SplitPane
   - sinnvolles Resizing-Verhalten
   - Anlegen eines neuen `Player`
   - Löschen bestehender Einträge  
   
 - Nicht compilierbarer Code wird mit einer 1.0 gewertet.

 - Das Programmierprojekt kann auch in Zweierteams bearbeitet werden. 
   - Es wird erwartet, dass die Lösung gemeinsam erarbeitet und implementiert wird (Stichwort: Pair-Programming).
   - Teams wird bei der Endnote eine Notenstufe (-1) abgezogen.
 
 - Die Teams müssen sich spätestens bis Freitag, den 5.5. gebildet haben.
 
 - Das Team arbeitet dann auf dem Git-Repository eines der Team-Mitglieder.
 
 - Das jeweils andere Team-Mitglied muss als Collaborator in diesem Repository eingetragen sein.
 
 - Collaborator fügt man über `Settings -> Collaborators & teams` hinzu.
 
 - Das Programmierzentrum ist geöffnet und Nachfragen werden zum Beispiel auch per Mail gerne beantwortet.
