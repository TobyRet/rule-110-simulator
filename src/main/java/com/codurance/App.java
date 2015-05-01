package com.codurance;

public class App {

    public static void main(String[] args) {
        Console console = new Console();
        RuleInterpreter ruleInterpreter = new RuleInterpreter(console);

        ruleInterpreter.assess("-------------------------------------------*");
    }
}
