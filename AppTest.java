package Yang.MavenJava;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
	private App myApp = new App();;
	
    @Test
    public void shouldAnswerWithTrue()
    {
        assertEquals("", myApp.process("1"));
        assertEquals("g h i", myApp.process("0,4"));
        assertEquals("ad ae af bd be bf cd ce cf", myApp.process("2, 3, "));
        assertEquals("jmw jmx jmy jmz jnw jnx jny jnz "
        		    +"jow jox joy joz jmw jmx jmy jmz "
        		    +"jnw jnx jny jnz jow jox joy joz "
        		    +"kmw kmx kmy kmz knw knx kny knz "
        		    +"kow kox koy koz kmw kmx kmy kmz "
        		    +"knw knx kny knz kow kox koy koz "
        		    +"lmw lmx lmy lmz lnw lnx lny lnz "
        		    +"low lox loy loz lmw lmx lmy lmz "
        		    +"lnw lnx lny lnz low lox loy loz", myApp.process("5,6,9"));
        assertEquals("Only accept 0-9 and ','", myApp.process("s,2,3"));
    }
}
