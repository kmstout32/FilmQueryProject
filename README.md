# Film Query App

## Description
This program is a command-line application that displays a menu for the user to choose from, allowing the user to retrieve information from the film data-base. Once the menu is displayed the terminal, choose the action you would like for the application to process. 

If the user chooses option #1, the program will prompt the user for an ID number. If the number entered is less than 1 OR greater than 1000, the program will inform the user that there is no film associated with stated number. However, if the I.D. number entered was within 1 - 1000, a film will be displayed by (Title, year released, film description, and the language).

If the user chooses option #2, the program will prompt the user for a keyword of their choice to search for within the film title OR description. Once the word is entered, the program will search within the database for anything that matches the keyword, then returns a list of films that do match.

The program will continue to run, looping around back to the main menu, until the user enters 0 to exit the program. When this option is chosen, the program will prompt them to ensure they have exited successfully.



## Technologies Used
Java
SQL
Maven
JDBC

## Lessons Learned
The biggest challenge I had in creating this program was how to properly use JDBC to collect the data I needed from the database to add the language name to display with the films. I was able to successfully display information solely from the film table. I then, neglected to add the language field into my Film class, so I had no way for the result set to gather the information needed to display.

