# Writing your first command
There are three different types of application commands for Discord, those being:

* Slash commands
* User commands
* Message commands

Tiramisu splits the command into two different parts, those being the executor and the declarator. The executor contains
all the necessary code to execute the command, while the declarator adds the necessary information to upsert the command
and prevent certain users from executing it.

