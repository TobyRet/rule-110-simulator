package com.codurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RuleInterpreter {

    private Console console;
    private final HashMap<String, String> lookUp = new HashMap<String, String>();

    public RuleInterpreter(Console console) {
        this.console = console;
        populateLookup();
    }


    public void assess(String input) {
        List<Character> characterArray = new ArrayList();

        characterArray.add('0');
        for (char c : input.toCharArray()) {
            characterArray.add(c);
        }
        characterArray.add('0');

        String output = "";

        while(characterArray.size() > 2) {
            String groupOfThree = String.valueOf(characterArray.get(characterArray.size() - 3))
                                    + String.valueOf(characterArray.get(characterArray.size() - 2))
                                    + String.valueOf(characterArray.get(characterArray.size() - 1));

            output += lookUp.get(groupOfThree);

            characterArray.remove(characterArray.size() - 1);
        }

        System.out.println("unformatted: " + output);
        String formattedOutput = new StringBuilder(output).reverse().toString();
        System.out.println("formated: " + formattedOutput);

        console.print(formattedOutput);
    }

    private void populateLookup() {
        lookUp.put("111", "-");
        lookUp.put("110", "*");
        lookUp.put("101", "*");
        lookUp.put("100", "-");
        lookUp.put("011", "*");
        lookUp.put("010", "*");
        lookUp.put("001", "*");
        lookUp.put("000", "-");
    }
}
