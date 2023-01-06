# LOOP DEPENDENCY CHECK

#### Author: Shvetsov Danil
#### Group: BPI219
#### Date: 25/12/2022

### Structure and decomposition description.
The program has 4 classes and 2 enums. The classes are divided by following dependency: Main -> Handler -> FileManager + ConsoleLogger.

Classes:
* Main -> the base class of the program which has the entry point.
* Handler -> the class is responsible for program flow and indication of functions on abstract level.
* FileManager -> class which contains particular implementations of functions and the logic of the program.
* ConsoleLogger -> class which prints logs to the console.

Enums:
* ConsoleLogs -> string representation of handler logs concerning determined cases based on common program flow.
* FileManagerLogs -> string representation of file manager logs concerning determined cases.

The so-called architecture seems to be similar to monolithic architecture which usually consists of 3 layers (Handler -> Business logic -> Data layer).

All implementations in project are hidden under the layers below, and you can not access the data or behavior, so encapsulation done. The classes are well decomposed and also each class has its only responsibility.

### About algorithm.
1) Program gets the initial absolute path to the root directory where all files and dependencies are located and validates it.
2) Program finds all files in directory, reads them. If dependency to another file is found, program recursively checks that file. If there are no dependencies, program traverses all directories and does the same operations. If no loop dependencies found file is added to the united consequence. Otherwise, if loop dependency was indicated, the user gets notification about that and program finishes with exit(0).
3) If no loop dependency found, program gets the absolute path to the output directory.
4) File in entered directory with name 'output.txt' is created or overwritten. In that file all data of united files is written.

### Note.
Dependencies in file should be written by the following template (with quotes and .txt extension):
* require 'Folder name/File name.txt'
