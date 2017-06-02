# Footballfx 
Footballfx besteht aus einem Spring Backend, dass Fussballspieler verwaltet.
Mit einer Angular Frontend Applikation kann über eine GUI Fussballspieler verwaltet werden.
Zusätlich gibt es einen Java native client mit dem die Fussballspieler verwaltet werden können.
Beide GUIs laden beim Starten alle persisiterte Fussballspielder vom Backend.

## Starten des Backends 'footballfx-core'

1. 'mvn clean install' ausführen
2. Ausführen der Main Klasse

## Starten des Fronten 'foobtallfx-frontend'

1. cd zu footballfx-core
2. 'gulp browserify' ausführen um die 
3. 'gulp' ausführen zum frontend server starten
4. localhost:4000 im Browser aufrufen

## Starten des Java native client

1. mvn clean install
2. FootallFX Backend starten
3. Main Klasse des clients ausführen


## Abgabe
- Klasse 2Ibb: Dienstag, 13.6.2017, 15:00 Uhr
- Klasse 2Ia und 2iCa: Mittwoch, 14.6.2017, 8:00 Uhr


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
