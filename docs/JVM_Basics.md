

## JDK, JRE, and JVM

The JDK (Java Development Kit) is the full package that developers install.
It contains everything needed to write, compile, and run Java programs.
Inside the JDK is the JRE (Java Runtime Environment), which contains the
libraries and tools needed to run Java programs. Inside the JRE is the JVM
(Java Virtual Machine), which is the engine that actually executes the code.

## What is Bytecode?

When you write Java code and compile it, it doesn't get converted directly
into machine code. Instead it becomes bytecode — a middle-level language
stored in .class files. The JVM reads and executes this bytecode.

## Write Once, Run Anywhere

Because Java compiles to bytecode instead of machine-specific code, the same
.class file can run on any operating system — Windows, Mac, or Linux — as
long as that machine has a JVM installed. This is what makes Java platform
independent.