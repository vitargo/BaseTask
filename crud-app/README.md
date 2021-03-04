# CRUD APPLICATION

The CRUD APP lets you create, view, edit and delete records of Person. App designed to run with Binary, JSON, CSV, YML and XML files. App has the next lines for Persons: id, Firstname, Lastname, age and city. User can use 4 available commands with space-separated 'filename.extension':

  'create' - create a new Person from console and save it in a chosen file,

  'update' - change info about Person by id and save it in a chosen file,
WARNING - you cannot enter invalid characters specified below: < > ( ) { } | \\ / ; : , . + = % $ # @ ^ & * \

  'read' - print info from chosen file to console,

  'delete' -  delete info about Person from file by id,

and use 3 additional commands without filename:

  'switch' - go to main menu,

  'help' - print info about APP,

  'exit' - close app.

Developers: Nadopta Volodymyr, Anufriev Andriy, Boyko Mykola, Zhmurchyk Vasyl, Redko Viktoria.

#  CRUD Приложение

Создать приложение, обеспечивающее взаимодействие с пользователем через консоль. Client -> class Scanner (command line interface).

После запуска пользователь должен ввести одну из поддерживаемых команд
Commands: CRUD (create, read, update, delete) + helpers (exit, help, switch).
Для CRUD команд через пробел указывается имя файла с расширением. В зависимости от расширения определяется формат данных.

Container for data -> File (Binary, JSON, CSV, XML, YAML).

Хранимые данные: Data -> Persons (id, fname, lname, age, city);

После команды exit осуществляется выход из приложения.
После команды help осуществляется вывод доступных команд и их формат.
После команды switch осуществляется возврат в главное меню
