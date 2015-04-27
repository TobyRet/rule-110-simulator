package com.codurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RuleInterpreter {

    private Console console;
    private final HashMap<String, String> lookUp = new HashMap<>();
    private String inputToProcess;

    public RuleInterpreter(Console console) {
        this.console = console;
        populateLookup();
    }


    public void assess(String input) {

        inputToProcess = input;

        for(int i=0; i < 10; i++) {


            List<String> characterArray = new ArrayList();

            characterArray.add("-");
            for (String c : inputToProcess.split("")) {
                characterArray.add(c);
            }
            characterArray.add("-");

            String output = "";

            while(characterArray.size() > 2) {
                String groupOfThree = String.valueOf(characterArray.get(characterArray.size() - 3))
                        + String.valueOf(characterArray.get(characterArray.size() - 2))
                        + String.valueOf(characterArray.get(characterArray.size() - 1));

                output += lookUp.get(groupOfThree);

                characterArray.remove(characterArray.size() - 1);
            }

            String formattedOutput = new StringBuilder(output).reverse().toString();

            System.out.println(formattedOutput);

            console.print(formattedOutput);

            inputToProcess = formattedOutput;
        }

    }

    private void populateLookup() {
        lookUp.put("***", "*");
        lookUp.put("**-", "*");
        lookUp.put("*-*", "*");
        lookUp.put("*--", "-");
        lookUp.put("-**", "*");
        lookUp.put("-*-", "*");
        lookUp.put("--*", "*");
        lookUp.put("---", "-");
    }
}
