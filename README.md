# myJavaMath

In the following I am trying to build a raw calculator, with functioning similar to Java Math class.
Doing so, I want to avoid any usage of external libraries.

This code can be copied, used and modified always citing the author: @GuglielmoDelSarto

I am collaborating with @LeonardoScoppitto from CS course at University of Pisa


** Code style and function names **

We try to stick with usual Java convention of CamelCase names.
Function here are presented in the following way:
 - getSomethingYouWant(...) if they are supposed to be called by the user
 - performSomethingYouWant(...) if they are just some auxiliary functions
 
 ** Warnings to bear in mind **
 
We usually present two version of the same function: one working with integers
and one working with double. The return values are kept consistent with the 
input. So that:
 - getSum(integers) --> return integer
 - getSum(doubles) --> return double

Up to now, we do not throw exemption if an overflow occours. So it should be
the user to monitor the situation!
