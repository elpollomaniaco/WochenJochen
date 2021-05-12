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