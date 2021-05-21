# Wochen-Jochen

## Anwendung

Die Anwendung dient dem Verarbeiten von Klötzen mit aufgeklebten 2D-Codes, die durch eine Kamera erfasst werden. 
Den erfassten Objekten werden durch den hier bereitgestellten Client Zeitslots und die Art des Termins zugeordnet, sodass sie in einen digitalen Kalender übertragen werden können.

### Server

Die Erkennung der 2D-Codes erfolgt über die *reacTIVision vision engine*. Diese muss neben der Anwendung ausgeführt werden.
Die für das jeweilige OS kompilierte Engine kann auf der [offiziellen Seite](http://reactivision.sourceforge.net/) heruntergeladen werden. 
Sie dient hier als Server und sendet erkannte Ereignisse über UDP (Standardport 3333).

### Client

Der Client reagiert auf die Ereignisse des Servers und erstellt, entfernt und aktualisiert Termine. Dabei erfolgen die Zuordnungen

- Objekt-ID zu Terminkategorie
- x-Position zu Tag
- y-Position zu Zeitslot

### Parameter

Der Anwendung können folgende Startparameter übergeben werden

| Parameter     | Befehl                | Standardwert  | Beschreibung  |
| ---           | ---                   | ---           | ---           |
| Port          | -p \<int\>            | 3333          | Port, auf dem der *reacTIVision*-Server sendet. |
| RefreshRate   | -r \<int\>            | 10            | Häufigkeit (alle x Sekunden), mit der der aktuelle Kalender ausgegeben wird. Erkennung der Marker ist davon (noch) nicht betroffen. |
| DayCount      | -d \<int\>            | 7             | Anzahl Tage des Kalenders. Beeinflusst in wie viele Abschnitte in x-Richtung das Kamerabild zur Auswertung geteilt wird. | 
| SlotCount     | -s \<int\>            | 6             | Anzahl Zeitslots pro Tag. Beeinflusst in wie viele Abschnitte in y-Richtung das Kamerabild zur Auswertung geteilt wird.
| Time          | -t \<float\> \<float\>| 8.0 20.0      | Start und Endzeit eines Tages. Beeinflusst die Uhrzeit, die in der Ausgabe angezeigt wird (abhängig von SlotCount). Ganzzahl enstpricht Stunde, Bruchteil entspricht Minuten (8.25 = 08:15).|

ACHTUNG: Bisher keine Fehlerverarbeitung implementiert!