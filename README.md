# Wochen-Jochen

## Translation

[Deutsch](README_DE.md)

## Application

The application is used to process blocks with 2D codes glued on them, which are captured by a camera.
The captured objects are assigned time slots and the type of appointment by the client provided here, so that they can be transferred to a digital calendar.

### Server

2D codes are recognized by the *reacTIVision vision engine*. This must be run alongside the application.
The engine compiled for the respective OS can be downloaded from the [official site](http://reactivision.sourceforge.net/).
It serves as a server here and sends detected events via UDP (default port 3333).

### Client

The client reacts to the events of the server and creates, removes and updates appointments. The following assignments are made

- object ID to event category
- x-position to day
- y-position to time slot

### Parameter

The following start parameters can be passed to the application

| Parameter     | Command               | Default value | Description |
| ---           | ---                   | ---           | --- |
| Port          | -p \<int\>            | 3333          | Port to which the *reacTIVision* server sends messages. |
| RefreshRate   | -r \<int\>            | 10            | Frequency (every x seconds) with which the current calendar is printed. Marker detection is not (yet) affected by this. |
| DayCount      | -d \<int\>            | 7             | Number of days of the calendar. Affects how many sections in x-direction the camera image is divided into for detection. | 
| SlotCount     | -s \<int\>            | 6             | Number of time slots per day. Affects how many sections in y-direction the camera image is divided into for detection.
| Time          | -t \<float\> \<float\>| 8.0 20.0      | Start and end time of a day. Affects the time displayed in the output (taking into account of SlotCount). Integer equals hour, fraction equals minutes (8.25 = 08:15).

ATTENTION: No error processing implemented yet!
