# Footballfx 
Footballfx besteht aus einem Spring Backend, einer AngularJS GUI und einem JavaFX native Client.
Mit dem  AngularJS und dem JavaFX client können die Spieler über eine GUI verwaltet werden. 
Die Spieler werden mit dem Server synchronisiert und gespeichert.

## Starten des Backends 'footballfx-core'
1. 'mvn clean install' ausführen
2. Ausführen der Main Klasse

## Starten des Fronten 'foobtallfx-frontend'
!Achtung, Voraussetzung ist, dass NodeJs und gulp installiert ist.

1. mvn clean install
2. FootallFX Backend starten 

3. cd zu footballfx-core
4. 'npm install' ausführen
5. 'gulp browserify' ausführen um die JS Scripts zusammen zu führen. (Nur in dev Phase)
6. 'gulp' ausführen zum frontend server starten
7. localhost:4000 im Browser aufrufen

## Starten des Java native client
1. mvn clean install
2. FootallFX Backend starten
3. Main Klasse des clients ausführen