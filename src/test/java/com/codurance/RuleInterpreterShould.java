package com.codurance;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RuleInterpreterShould {

    private Console console = mock(Console.class);
    private RuleInterpreter ruleInterpreter;

    @Before
    public void setUp() {
        ruleInterpreter = new RuleInterpreter(console);
    }

    @Test
    public void interpret_a_line_of_5_characters() {
        ruleInterpreter.assess("----------*");
        verify(console, atLeast(1)).print("---------**");
        verify(console, atLeast(1)).print("--------***");
        verify(console, atLeast(1)).print("-------****");
        verify(console, atLeast(1)).print("------*****");
        verify(console, atLeast(1)).print("-----******");
        verify(console, atLeast(1)).print("----*******");
        verify(console, atLeast(1)).print("---********");
        verify(console, atLeast(1)).print("--*********");
        verify(console, atLeast(1)).print("-**********");
    }
}
