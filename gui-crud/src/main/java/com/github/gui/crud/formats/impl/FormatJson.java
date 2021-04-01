package com.github.gui.crud.formats.impl;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.formats.IFormats;

import java.util.*;

public class FormatJson implements IFormats {

    private static final String SYMBOL_BLOCK_START = "{";
    private static final String SYMBOL_BLOCK_END = "}";

    @Override
    public List<Person> fromFormatArray(String data) {
        if (data == null || data.isBlank()) {
            return new ArrayList<>();
        }

        List<Integer> indexesOfSymbolBlockStart = getIndexesForSymbol(data, SYMBOL_BLOCK_START);
        List<Integer> indexesOfSymbolBlockEnd = getIndexesForSymbol(data, SYMBOL_BLOCK_END);

        return parseBlocksByListIndexes(indexesOfSymbolBlockStart, indexesOfSymbolBlockEnd, data);
    }

    protected List<Person> parseBlocksByListIndexes(List<Integer> indexesOfSymbolBlockStart, List<Integer> indexesOfSymbolBlockEnd, String data) {
        List<Person> parsedPersons = new ArrayList<>();
        for (int i = 0; i < indexesOfSymbolBlockStart.size(); i++) {
            parsedPersons.add(parseBlock(data.substring(indexesOfSymbolBlockStart.get(i) + 1, indexesOfSymbolBlockEnd.get(i) - 1)));
        }
        return parsedPersons;
    }

    protected Person parseBlock(String blockData) {
        String blockDataWithoutQuotes = blockData.replaceAll("\"", "");
        String blockDataAfterTrim = blockDataWithoutQuotes.trim();
        String[] row = blockDataAfterTrim.split(",");

        Person person = new Person();
        person.setId(Long.parseLong(row[0].split(":")[1]));
        person.setFirstName(row[1].split(":")[1]);
        person.setLastName(row[2].split(":")[1]);
        person.setAge(Integer.parseInt(row[3].split(":")[1]));
        person.setCity(row[4].split(":")[1]);

        return person;
    }

    protected List<Integer> getIndexesForSymbol(String data, String symbol) {
        List<Integer> indexesOfSymbol = new ArrayList<>();
        int index = data.indexOf(symbol);
        while (index >= 0) {
            indexesOfSymbol.add(index);
            index = data.indexOf(symbol, index + 1);
        }
        return indexesOfSymbol;
    }

    @Override
    public String toFormatArray(List<Person> people) {
        if (people == null || people.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append("\n");
        sb.append("\n");

        for (Map<String, String> personValues : getListOfPersonsValues(people)) {
            sb.append("  {");
            sb.append("\n");
            for (Map.Entry<String, String> value : personValues.entrySet()) {
                sb.append("    \"").append(value.getKey()).append("\":\"").append(value.getValue()).append("\",");
                sb.append("\n");
            }
            sb.setLength(sb.length() - 2);
            sb.append("\n");

            sb.append("  },");
            sb.append("\n");
        }
        sb.setLength(sb.length() - 2);

        sb.append("\n");
        sb.append("]");
        sb.append("\n");

        return sb.toString();
    }

    protected List<Map<String, String>> getListOfPersonsValues(List<Person> persons) {
        List<Map<String, String>> listOfValues = new ArrayList<>();

        for (Person person : persons) {
            listOfValues.add(getPersonValues(person));
        }

        return listOfValues;
    }

    protected Map<String, String> getPersonValues(Person person) {
        Map<String, String> values = new LinkedHashMap<>();

        values.put("id", String.valueOf(person.getId()));
        values.put("firstName", person.getFirstName());
        values.put("lastName", person.getLastName());
        values.put("age", String.valueOf(person.getAge()));
        values.put("city", person.getCity());

        return values;
    }

    @Override
    public String toFormat(Person person) {
        if (person == null) return null;
        return toFormatArray(Arrays.asList(person));
    }

    @Override
    public Person fromFormat(String str) {
        if (str == null) return null;
        return fromFormatArray(str).get(0);
    }
}
