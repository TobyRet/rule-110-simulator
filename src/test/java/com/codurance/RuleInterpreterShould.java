package com.codurance;

import org.junit.Before;
import org.junit.Test;

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
    public void apply_rule_for_111() {
        ruleInterpreter.assess("111");
        verify(console).print("   ");
    }

    @Test
    public void apply_rule_for_110() {
        ruleInterpreter.assess("110");
        verify(console).print(" * ");
    }

    @Test
    public void apply_rule_for_101() {
        ruleInterpreter.assess("101");
        verify(console).print(" * ");
    }

    @Test
    public void apply_rule_for_100() {
        ruleInterpreter.assess("100");
        verify(console).print("   ");
    }

    @Test
    public void apply_rule_for_010() {
        ruleInterpreter.assess("010");
        verify(console).print(" * ");
    }

    @Test
    public void apply_rule_for_001() {
        ruleInterpreter.assess("001");
        verify(console).print(" * ");
    }

    @Test
    public void apply_rule_for_000() {
        ruleInterpreter.assess("111");
        verify(console).print("   ");
    }

    @Test
    public void interpret_a_line_of_5_characters() {
        ruleInterpreter.assess("00100");
        verify(console).print("-**--");
    }
}
