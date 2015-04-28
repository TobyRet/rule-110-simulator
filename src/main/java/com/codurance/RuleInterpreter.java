package com.codurance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;

public class RuleInterpreter {

    private static final String EXTRA_0 = "-";
    private Console console;
    private final HashMap<String, String> lookUp = new HashMap<>();
    private List<String> inputAsList = new ArrayList<>();
    private String lineOutput = "";
    private String lineToPrint;
    private String inputToParse;

    public RuleInterpreter(Console console) {
        this.console = console;
        populateLookup();
    }


    public void assess(String input) {
        inputToParse = input;

        for(int i = 0; i < input.length(); i++ ) {
            prepareInput(inputToParse);
            parseInput();
            console.print(lineToPrint);
            reset();
        }
    }

    private void reset() {
        inputToParse = lineToPrint;
        lineOutput = "";
    }

    private void parseInput() {
        while(inputAsList.size() > 2) {
            String groupOfThreeFormatted = get3ValuesFromInput(inputAsList);
            lineOutput += lookUp.get(groupOfThreeFormatted);
            lineToPrint = new StringBuilder(lineOutput).reverse().toString();
            inputAsList.remove(inputAsList.size() - 1);
        }
    }

    private String get3ValuesFromInput(List<String> inputAsList) {
        String lastIndexValue = inputAsList.get(inputAsList.size() - 1);
        String secondToLastIndexValue = inputAsList.get(inputAsList.size() - 2);
        String thirdToIndexValue = inputAsList.get(inputAsList.size() - 3);

        List<String> groupOfThreeList = asList(thirdToIndexValue, secondToLastIndexValue, lastIndexValue);

        String groupOfThree = "";

        for(String value : groupOfThreeList) {
            groupOfThree += value;
        }

        return groupOfThree;
    }

    private void prepareInput(String input) {
        inputAsList = new ArrayList<>(asList(input.split("")));
        inputAsList.add(EXTRA_0);
        inputAsList.add(0, EXTRA_0);
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
