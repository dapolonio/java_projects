# Text Analysis Exercise

A little exercise to parse text from a text file in Java.

## Background

You work evenings as an intern in a historical semantics research institute. Your boss would like you to build a program to analyze the frequency of verbal tics in historical recorded speech.

The institute has hired a firm to convert the recorded [speech into text](https://en.wikipedia.org/wiki/Speech_recognition). Now you need to be able to take these text transcripts and analyze them for verbal tics.

## The program

The program must be able to open any text file specified by the user, and analyze the frequency of verbal tics in the text. Since there are different kinds of verbal tics (such as "`like`", "`uh`", "`um`", etc) the program must ask the user what tics to look for. 

- A user can enter multiple tics, separated by commas.
- Any spaces entered by the user before or after each tic MUST be ignored. 
- You can assume all tics are single words.

The program should output:

- the total number of tics found in the text
- the density of tics (proportion of all words in the text that are tics)
- the frequency of each of the verbal tics
- the percentage that each tic represents out of all the total number of tics

## Example input and output

This example shows suggested input/output of such a program. 
User responses are shown with "`>`" in front of them for your convenience, although this character should not be output by the program or entered by the user. 
WARNING: Data analysis numbers below are placeholder only and are NOT meant to be '_real_'.

```
What file would you like to open?
> data/trump_speech_010621.txt
What words would you like to search for?
> uh,like, um,so

...............................Analyzing text.................................

Total number of tics: 66=======--
Density of tics: 0.2

...............................Tic breakdown..................................

uh        / 0 occurrences      / 0% of all tics
like      / 33 occurrences     / 12% of all tics
um        / 63 occurrences     / 23% of all tics
so        / 138 occurrences    / 50% of all tics
```

## Requirements

- The program must be able to analyze any text file, but an example file must be included in the submission. For convenience, the text file `trump_speech_010621.txt` was included in the data folder, and you may use it as the example file.
- The user must be able to enter as many tics as they would like, separated by commas, with or without spaces.
- You may assume all tics are single words, such as "uh" and "like". Multi-word tics such as "uh huh" and "you know" are not allowed.
- The search for tics MUST be case insensitive.
- The list of tics entered by the user MUST be stored in an array. Do not an ArrayList or any other array-like data structure.
- You MUST use separate methods for each component of the analysis. At the very minimum, this includes
  1. asking the user which text file to open.
  1. opening the file and importing its contents.
  1. soliciting tic words or phrases from the user and separating them into an array.
  1. counting the occurrences of each tic.
  1. calculating the percent of all tics that each tic consumes.
  1. calculating tic density.
- The output must be formatted so that all output lines up nicely as in the example
  - the tic word column consumes 10 spaces
  - the number of occurrences column consumes 20 spaces
  - the percentage column consumes as much space as necessary
  - columns are separated by the `/` characters - note that the text within any column should always be separated one space away from this separator - see example output
- Round all occurrences and percentages to the nearest integer.
- Limit the density to two decimal places.

## Helpful hints

You _may_ find it useful to split strings by more than one separator.

```java
String someText = "this;text,has-various?separators+in!it";
String[] values = someText.split("[.,?!-]+"); // an array of the parts of the String separated by any of the indicated separators
```

To make a string consume a fixed amount of space, use the `String.format()` function, e.g.:

```java
// format a string
String old = "hello";
String new = String.format("%10s", old); // returns "hello     "
```

```java
// format an integer
int old = 6;
String new = String.format("%10d", old); // returns "6         "
```

```java
// format a floating point number
double old = 6.0;
String new = String.format("%10f", old); // returns "6.0       "
```

```java
// limit the number of decimal places in a floating point number
double old = 3.14159265; // pi!
String new = String.format("%.2f", old); // returns "3.14";
```

## Folder structure

This project has several important directories:

- `data` - contains any text files analyzed by this program.
- `src` - contains the Java source code for the project (i.e. `.java` files)
- `test` - contains code that will help us determine whether the code you have written works correctly. Do not touch this directory!
- `bin` - contains the compiled code (i.e. `.class` files)
- `lib` - contains any dependencies (other libraries of code that the project depends upon to work)

If your project has no dependencies and has not been compiled, you may not see the `lib` or `bin` directories.


## How to test your work

Automated tests that can help determine whether you have done the work correctly have been included within the `test` directory. Use them as follows. A [video tutorial](https://www.youtube.com/watch?v=Af6Ka0Bmflo) shows how to do this and overcome any problems:

- Click the Run and Debug icon in the Visual Studio Code activity bar, then click the play button to run your code without using the automated tests. Do this prior to running the tests to make sure your program seems to behave correctly yourself.
- Open the relevant test file, located within the `test` directory.
- Click the Test icon (a beaker) in the Visual Studio Code activity bar and click the play button to run those tests. Tests that pass will be marked with a green checkmark, while those that fail will be marked with a red "X".
- Each test that fails will show a message with some indication of what went wrong - these messages may help you pinpoint the source of the error.

If you have trouble running the tests from within Visual Studio Code, you can do them from within a Terminal window, assuming the project directory is the current working directory (change `TestClassName` to the relevant name fo the test class.)

```bash
java -cp "bin:lib/*" org.junit.runner.JUnitCore edu.nyu.cs.TestClassName
```

Windows users should replace the `:` in `"bin:lib/*"` with a semi-colon, `;`, i.e. `"bin;lib/*"`. You may also have to add the flag --enable-preview in front of java to make it work.

## How to submit this assignment
Submit on Brightspace a zip file named "A3_complete_NYUnetID" containing your project folder called "A3_project_directory_NYUnetID", where NYUnetID should be replaced with your actual NYU net ID. The project folder should contain your source code and compiled code within the src and bin folders. It should also contain the same test folder as was when you download the assignment 3 zip file.
