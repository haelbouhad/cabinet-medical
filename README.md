# Get the project

Just run : git clone  https://github.com/haelbouhad/cabinet-medical.git

# Launch script to create datasource

Go to bin/ directory of your (glassfish) server and run the following command :

    $ ./asadmin multimode --file asadmin-commands.txt

The file ['asadmin-commands.txt'](asadmin-commands.txt) is available in the root of the project.

You have to edit the second line, specifically the database access :

    jdbc:mysql://localhost:3306/DB_NAME?user=USER&password=PWD 
