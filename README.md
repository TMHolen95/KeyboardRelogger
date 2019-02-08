# KeyboardRelogger

A project that uses keyhooks to intercept keyboard events and modify them. The main functionality of the project comes from [jnativehook](https://github.com/kwhat/jnativehook) and [java.awt.Robot](https://docs.oracle.com/javase/7/docs/api/java/awt/Robot.html)

Intercepted keyboard events along with the duration of a keypress are used in a profile that creates a new event with a different function as specified in the profile. 

For an example of what it can be used for see: KeyboardRelogger/src/main/java/profiles/CapsProfile.java
In the example keys that are pressed for 0-150ms trigger what they normally would keypresses from 150-300ms trigger the letter capitalized. Anything more than 300ms will trigger a function, such as the key "e" would open the windows file manager.

Run the project from: KeyboardRelogger/src/main/java/DefaultKeyboardProfileExecutioner.java

This project works on Windows. I do not know how it fares on Mac OS or Linux.
