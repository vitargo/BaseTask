package com.github.gui.crud.services.impl.file;

import com.github.gui.crud.config.FormatsConfig;
import com.github.gui.crud.config.type.FileType;
import com.github.gui.crud.entity.Person;
import com.github.gui.crud.exceptions.NotValidParameterException;
import com.github.gui.crud.services.IPeopleService;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeopleJsonServiceTest {

    private IPeopleService instance;

    private File jsonFile;

    private FileType format = FileType.JSON;

    final private Person firstPerson = new Person(1, "a", "b", 1, "c");

    final private Person secondPerson = new Person(2, "b", "c", 2, "d");

    final private Person thirdPerson = new Person(3, "c", "c", 3, "c");


    @Before
    public void setUp() throws IOException {
        this.instance = FormatsConfig.newInstance(format,"people.json");
        this.jsonFile = new File("people.json");
        boolean s = this.jsonFile.createNewFile();
    }

    @After
    public void tearDown() {
        this.jsonFile.delete();
    }

    @Test
    public void createPerson() {
        instance.create(firstPerson);
        instance.create(secondPerson);
        List<Person> act = instance.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(secondPerson);
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test(expected = Exception.class)
    public void createPersonNull() {
        instance.create(null);
    }

    @Test
    public void readFile() {
        instance.create(firstPerson);
        instance.create(secondPerson);
        List<Person> act = instance.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(secondPerson);
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test
    public void updatePerson() {
        instance.create(firstPerson);
        instance.create(secondPerson);
        instance.create(thirdPerson);
        instance.update(2, new Person(2, "test", "c", 2, "d"));
        instance.update(3, new Person(3, "six", "meter", 3, "kuk"));
        List<Person> act = instance.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(new Person(2, "test", "c", 2, "d"));
        exp.add(new Person(3, "six", "meter", 3, "kuk"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));

    }

    @Test(expected = NotValidParameterException.class)
    public void updatePersonNull() throws NullPointerException {
        instance.create(firstPerson);
        instance.update(0, null);
    }

    @Test
    public void deletePerson() {
        instance.create(firstPerson);
        instance.create(secondPerson);
        instance.create(thirdPerson);
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(thirdPerson);
        instance.delete(2);
        List<Person> act = instance.getPeople();
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

}