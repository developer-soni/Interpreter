# Interpreter

1	Introduction

1.1	Project Overview:
The goal of this was to build an Interpreter for a language X. The project skeleton and some code was provided with some files and they were already implemented for us. We had to work on the bytecode and create abstract class which were extended and implemented by the different types of bytecode, VirtualMachine, Program, RunTimeStack, and Interpreter class. The Interpreter and the VirtualMachine work together to run the program. 

1.2	Technical Overview:
The ByteCodeLoader class reads the bytecode classes from a file and then loads it into the program and also resolves the addresses with symbols. The Program class uses an ArrayList of bytecodes which are loaded from the ByteCodeLoader class. The RunTimeStack class uses frame stack and runtime stack to push a new frame whenever a function is invoked and removing it after it is processed. The VirtualMachine executes the Program by creating an instance of the RunTimeStack and returnAddress, and executes every bytecode until the program is running. 

1.3	Summary of Work Completed:
Implemented the ByteCode classes : Halt, Pop, FalseBranch, Goto, Store, Load, Lit, Args, Call, Return, Bop, Read, Write, Label and Dump with ByteCode abstraction. Implemented ByteCodeLoader, Program, RuntimeStack and VirtualMachine classes. The Interpreter and CodeTable classes were already implemented for us. The Interpreter class is the entry point.

2	Development Environment:
IntelliJ IDEA Version 2018.3

3	How to Build/Import your Project:
To import the project, clone the project using https or ssh from the given link above and use the root of the repository as the source while importing the project in an IDE. 
you will need to create the run configurations and set the command line arguments. The Interpreter only handles .x.cod files. 

4	How to Run your Project:
You will need to create the run configurations and set the command line arguments. The Interpreter only handles .x.cod files. To use the test files change the command line arguments for the following files given : factorial.x.cod, fib.x.cod, functionArgsTest.cod . 

5	Assumption Made:
Upon reading the instructions for creating the classes for abstract type bytecode, I assumed that extending the abstract class and implementing them would be really challenging because there were multiple classes to implement. According to me, it was a difficult task on how to model the bytecode classes and to also maintain a good object oriented design.

6	Implementation Discussion:
Abstract Class ByteCode:
- Class PopCode : Pops the top of the runTimeStack.
- Class FalseBranchCode : Pops the top of the stack and branches the label if 0, otherwise proceed execution.
- Class GoToCode : Goes to the given label.
- Class StoreCode : Pops the stack and loads it onto the offset.
- Class LoadCode : Pushes offset values in the frame.
- Class LabelCode : No functionality, sole purpose is to mark locations where ByteCode can jump to.
- Class LitCode : Loads the literal value ‘n’ adds it in order to initialize it.
- Class DumpCode : Used to turn dumping ON and OFF
- Class ArgsCode : Initializes the instance of the frame stack.
- Class CallCode : Transfers control to the indicated function.
- Class ReturnCode : Return from the current la given a function name as parameter.
- Class BopCode : Pops the top 2 values of the stack and does the necessary operations.
- Class HaltCode : Alerts the virtual machine to stop the program execution.
- Class ReadCode : Reads an integer, prompts the user for input and adds the value to the stack.
- Class WriteCode : Writes the value on top of the stack.

7	Project Reflection:
With this project I was able to brush up on my knowledge of Abstraction and Encapsulation. Abstracting ByteCode classes was very lengthy and tedious. Passing the .x.cod files in the command line arguments and testing the output was interesting and also much of the skeleton code was given which was helpful. Debugging and finding errors was quite tedious and frustrating. It was turns out to be a silly mistake or error which might have been missed initially.

8	Project Conclusion/Results:
I was successfully able to interpret the bytecode files factorial.x.cod and fib.x.cod. I also tested my work with some expressions that I created, and it successfully passed those as well. The most challenging part for me was to figure out how to model the instructions into code structures and at which point to approach the project first but the coding hints helped a lot because I followed them step by step and everything finally worked out. I used the debugger to optimize my algorithm to pass some tests and to find errors throughout the program.
