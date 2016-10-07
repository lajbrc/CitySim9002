/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Program.CitySim9002;
import junit.framework.Assert;
//import static org.hamcrest.CoreMatchers.any;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author AsphaltPanthers
 * @author lajbrc_Jinrong Liu
 * 
 */
public class ValidatorTest {
    
    //Test for method validateNumberOfArguments
    //The input seed should be one argument.
    @Test
    public void ifOneArgumentIsProvidedReturnTrue() {
        Assert.assertTrue(new Validator().validateNumberOfArguments(new String[] { "1" }));
    }
    
    //The input should not have more than one argument.
    @Test
    public void ifOneArgumentIsNotProvidedReturnFalse() {
        Assert.assertFalse(new Validator().validateNumberOfArguments(new String[] { "1", "2" }));
    }
    
    //The input should not be empty.
    @Test
    public void ifEmptyArgumentIsProvidedReturnFalse(){
        Assert.assertFalse(new Validator().validateArguments(new String[] {""}));
//      Assert.assertFalse(new Validator().validateNumberOfArguments(new String[] {""}));
    }
    
    //Test for method validateArgumentType
    //The input seed should be an integer.
    @Test
    public void ifArgumentIsAnIntegerReturnTrue() {
        Assert.assertTrue(new Validator().validateArgumentType(new String[] { "1" }));
    }
    
    //The input seed should not be a non-integer.
    @Test
    public void ifArgumentIsNotAnIntegerReturnFalse() {
        Assert.assertFalse(new Validator().validateArgumentType(new String[] { "test" }));
    }
    
    //Test for method validateArgument
    //The input seed should be one argument which is an integer
    @Test
    public void ifArgumentLengthAndArgumentTypeIsCorrect(){
        Validator mockValidator = mock(Validator.class);
        when(mockValidator.validateNumberOfArguments(any(String[].class))).thenReturn(true);
        when(mockValidator.validateArgumentType(any(String[].class))).thenReturn(true);
        when(mockValidator.validateArguments(any(String[].class))).thenCallRealMethod();
        
        Assert.assertTrue(mockValidator.validateArguments(new String[0]));
    }
    @Test
    public void ifArgumentLengthAndArgumentTypeIsWrong(){
	Assert.assertFalse(new Validator().validateArguments(new String[] {"2a"}));
    }
    
    //Test for method Visitor
    //The return value of method Visitor(3) should be "BusinessPerson"
    @Test
    public void test1Visitor(){
        CitySim9002 mockCS = mock(CitySim9002.class);
	String a1 = mockCS.Visitor(3);
	Assert.assertEquals("BusinessPerson", a1);
    }

    //The return value of method Visitor(1) should be "Student"
    @Test
    public void test2Visitor(){
        CitySim9002 mockCS = mock(CitySim9002.class);
	String a2 = mockCS.Visitor(1);
	Assert.assertEquals("Student", a2);
    }
	
    //Test for method Location
    //The return value of method Location(2) should be "Squirrel Hill"
    @Test
    public void test1Location(){
        CitySim9002 mockCS = mock(CitySim9002.class);
        String b1 = mockCS.Location(2);
	Assert.assertEquals("Squirrel Hill", b1);
    }
	
    //The return value of method Location(4) should be "Downtown"
    @Test
    public void test2Location(){
        CitySim9002 mockCS = mock(CitySim9002.class);
	String b2 = mockCS.Location(4);
	Assert.assertEquals("Downtown", b2);
    }
	
    //Test for method Preference
    //Preference(3, 1) means that the Visitor is "BusinessPerson",
    //and the visitor is going to "The Cathedral of Learning".
    //The "BusinessPerson" should not like "The Cathedral of Learning".
    @Test
    public void test1Preference(){
        CitySim9002 mockCS = mock(CitySim9002.class);
        String c1 = mockCS.Preference(3, 1);
        Assert.assertEquals("did not like", c1);
    }

    //Preference(2, 4) means that the Visitor is "Professor",
    //and the visitor is going to "Downtown".
    //The "Professor" should like "Downtown".
    @Test
    public void test2Preference(){
        CitySim9002 mockCS = mock(CitySim9002.class);
        String c2 = mockCS.Preference(2, 4);
        Assert.assertEquals("did like", c2);
    }

    
}
