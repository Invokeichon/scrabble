# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---
This program cannot be run yet, as full functionality and graphical interface has not been implemented. However, a test suite
for each implemented type can be executed. These are found in src/test.

This program assumes that:
- The _TBinary_ class receives Strings composed of 0's and 1's, and between 2 and 32 characters to represent a binary.
- Different length binaries that represent the same number (ex. 0001010 and 01010) are _different_ binaries for TBinary.
- Binaries will _only_ represent integers.

This assignment aims to create a simplified _Scratch_ clone.
To acheive this,  multiple data types have been implemented to create, store and operate.
They are the following types:
- _TString_, which stores a Java String
- _TBool_, which stores a boolean
- _TFloat_, which stores a double
- _TInt_, which stores an int
- _TBinary_, which stores a String representing a binary (see above)


These types can transform into each other (with restrictions), and operate with each other (following mostly how their respective Java values operate).



