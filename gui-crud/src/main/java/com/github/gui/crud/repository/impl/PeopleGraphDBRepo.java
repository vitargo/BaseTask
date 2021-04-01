package com.github.gui.crud.repository.impl;

import com.github.gui.crud.entity.Person;
import com.github.gui.crud.repository.IPeopleRepo;
import org.eclipse.rdf4j.model.Value;
import org.eclipse.rdf4j.query.*;
import org.eclipse.rdf4j.repository.RepositoryConnection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PeopleGraphDBRepo implements IPeopleRepo {

    private final RepositoryConnection connection;

    public PeopleGraphDBRepo(RepositoryConnection connection) {
        this.connection = connection;
    }

    @Override
    public Person save(Person p) {
        return null;
    }

    @Override
    public List<Person> findAll() {

        List<Person> people = new ArrayList<>();
        List<Value> id = new ArrayList<>();
        List<Value> firstName = new ArrayList<>();
        List<Value> lastName = new ArrayList<>();
        List<Value> age = new ArrayList<>();
        List<Value> city = new ArrayList<>();

        try {
            TupleQuery tupleQuery = connection.prepareTupleQuery(QueryLanguage.SPARQL,
                    "select * where { \n" +
                            "\t?s ?p ?o .\n" +
                            "} limit 100 ");
            TupleQueryResult tupleQueryResult = tupleQuery.evaluate();
            String namePrev = "p";
            while (tupleQueryResult.hasNext()) {
                BindingSet bindingSet = tupleQueryResult.next();
                for (Binding binding : bindingSet) {
                    String name = binding.getName();
                    Value value = binding.getValue();
                    if (namePrev.equals("http://purl.org/dc/elements/1.1/id") && name.equals("o")){
                        id.add(value);
                    } else if (namePrev.equals("http://purl.org/dc/elements/1.1/first_name") && name.equals("o")){
                        firstName.add(value);
                    } else if (namePrev.equals("http://purl.org/dc/elements/1.1/last_name") && name.equals("o")) {
                        lastName.add(value);
                    } else if (namePrev.equals("http://purl.org/dc/elements/1.1/age") && name.equals("o")) {
                        age.add(value);
                    } else if (namePrev.equals("http://purl.org/dc/elements/1.1/city") && name.equals("o")) {
                        city.add(value);
                    }
                    namePrev = String.valueOf(value);
                    System.out.println(name + " = " + value);
                }
            }
            tupleQueryResult.close();
        } finally {
            connection.close();
        }

        String regex = "\"(.*?)\"";
        Pattern pattern = Pattern.compile(regex);

        int size = id.size();
        for(int i = 0; i < size; i++){
            Matcher q1 = pattern.matcher(String.valueOf(id.get(i)));
            long idG = 0;
            if(q1.find()){
                String qq1 = q1.group().trim();
                qq1 = qq1.substring(1, qq1.length()-1);
                idG = Long.parseLong(qq1);
            }

            String firstNameG = String.valueOf(firstName.get(i));
            firstNameG = firstNameG.substring(1, firstNameG.length()-1);
            String lastNameG = String.valueOf(lastName.get(i));
            lastNameG = lastNameG.substring(1, lastNameG.length()-1);
            Matcher q4 = pattern.matcher(String.valueOf(age.get(i)));
            int ageG = 0;
            if(q4.find()) {
                String qq4 = q4.group().trim();
                qq4 = qq4.substring(1, qq4.length()-1);
                ageG = Integer.parseInt(qq4);
            }
            String cityG = String.valueOf(city.get(i));
            cityG = cityG.substring(1, cityG.length()-1);
            Person per = new Person(idG, firstNameG, lastNameG, ageG, cityG);
            people.add(per);
        }
        System.out.println(Arrays.toString(people.toArray()));
        return people;
    }

    @Override
    public void update(long id, Person p) {

    }

    @Override
    public void remove(long id) {

    }
}
