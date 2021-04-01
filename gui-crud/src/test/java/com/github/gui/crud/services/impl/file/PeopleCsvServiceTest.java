package com.github.gui.crud.services.impl.file;

import com.github.gui.crud.config.FormatsConfig;
import com.github.gui.crud.config.type.FileType;
import com.github.gui.crud.entity.Person;
import com.github.gui.crud.exceptions.CrudException;
import com.github.gui.crud.exceptions.NotValidParameterException;
import com.github.gui.crud.services.IPeopleService;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.After;
import org.junit.Before;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;

public class PeopleCsvServiceTest {

    private IPeopleService instance;

    private File csvFile;

    private FileType format = FileType.CSV;

    private Person firstPerson = new Person(1, "N1", "L1", 11, "C1");

    private Person secondPerson = new Person(2, "N2", "L2", 12, "C2");

    private Person thirdPerson = new Person(3, "N3", "L3", 13, "C3");


    @Before
    public void setUp() throws IOException {
        this.instance = FormatsConfig.newInstance(format,"people.csv");
        this.csvFile = new File("people.csv");
        boolean s = this.csvFile.createNewFile();
    }

    @After
    public void tearDown() {
        this.csvFile.delete();
    }

    @Test
    public void readAllMany() {
        List<Person> exp = new ArrayList<>(5);
        exp.add(this.instance.create(new Person(1l, "N1", "L1", 11, "C1")));
        exp.add(this.instance.create(new Person(2l, "N2", "L2", 12, "C2")));
        exp.add(this.instance.create(new Person(3l, "N3", "L3", 13, "C3")));
        exp.add(this.instance.create(new Person(4l, "N4", "L4", 14, "C4")));
        exp.add(this.instance.create(new Person(5l, "N5", "L5", 15, "C5")));
        this.instance.clear();
        List<Person> act = this.instance.readAll();
        Assert.assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void readAllZero() {
        List<Person> act = this.instance.readAll();
        Assert.assertTrue(act.isEmpty());
    }

    @Test
    public void create() {
        Person data = new Person(1l, "Name1", "LName1", 12, "City1");
        Person act = this.instance.create(data);
        List<Person> array = this.instance.getPeople();
        Assert.assertTrue(array.contains(act));
    }

    @Test(expected = NotValidParameterException.class)
    public void createNull() {
        this.instance.create(null);
    }

    @Test(expected = UndeclaredThrowableException.class)
    public void createFirstNameNull() {
        Person data = new Person(1l, null, "xz", 12, "xz");
        this.instance.create(data);
    }

    @Test
    public void updatePerson() {
        instance.create(firstPerson);
        instance.create(secondPerson);
        instance.create(thirdPerson);
        instance.update(2, new Person(2, "test", "C2", 12, "C2"));
        instance.update(3, new Person(3, "N3", "test", 13, "C3"));
        List<Person> act = instance.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(new Person(2, "test", "C2", 12, "C2"));
        exp.add(new Person(3, "N3", "test", 13, "C3"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test(expected = NotValidParameterException.class)
    public void updatePersonNull() throws CrudException {
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