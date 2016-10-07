# IS2545 - DELIVERABLE 2: Unit Testing

The program CitySim9002 is runnable with the command 'java -jar CitySim9002.jar n' where n is any int.

## ISSUES

1. My original Validate method cannot deal with the non-number input like "k", "3a", etc.

  I used "Integer.parseInt(args[0])" in the if statement of the Validate method, but the input seed could be a String, so I use the code of Validator.java from @AsphaltPanthers whose "validateArgumentType" method uses try-catch statement, problem solved.

2. Cannot stub the method in CitySim9002 test.

  The method cannot be static if I want to stub the method in the test code. I have to put the validate methods in a new class then import the class in CitySim.class, problem solved.
  
3. Empty input test cannot be done in NetBeans.

  When I tried to convert my Eclipse project to NetBeans project, the test for empty input failed. I change the test from "Assert.assertFalse(new Validator().validateNumberOfArguments(new String[] {""}));" to "Assert.assertFalse(new Validator().validateArguments(new String[] {""}));", problem solved.
