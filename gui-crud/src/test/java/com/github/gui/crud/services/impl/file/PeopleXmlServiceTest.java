package com.github.gui.crud.services.impl.file;

import com.github.gui.crud.config.FormatsConfig;
import com.github.gui.crud.config.type.FileType;
import com.github.gui.crud.services.IPeopleService;
import com.github.gui.crud.entity.Person;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PeopleXmlServiceTest {

    private IPeopleService instance;

    private File xmlFile;

    private FileType format = FileType.XML;

    public static List<Person> readTwo = List.of(new Person(1, "Fname", "Lname", 77, "c1"),
            new Person(2, "Fname2", "Lname2", 88, "c2")
    );

    @Before
    public void setUp() throws IOException {
        this.instance = FormatsConfig.newInstance(format,"people.xml");
        this.xmlFile = new File("people.xml");
        boolean s = this.xmlFile.createNewFile();
    }

    @After
    public void tearDown() {
        this.xmlFile.delete();
    }

    @Test
    public void createOne() {
        instance.create(new Person(1, "Fname", "Lname", 77, "c1"));
        List<Person> act = instance.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test
    public void createTwo() {
        List<Person> exp = readTwo;
        List<Person> act = new ArrayList<>();
        act.add(instance.create(new Person(1, "Fname", "Lname", 77, "c1")));
        act.add(instance.create(new Person(2, "Fname2", "Lname2", 88, "c2")));
        Assert.assertThat(act, IsIterableContainingInOrder.contains(exp.toArray()));
    }

    @Test
    public void createMany() {
        instance.create(new Person(1, "Fname", "Lname", 77, "c1"));
        instance.create(new Person(2, "Fname2", "Lname2", 88, "c2"));
        instance.create(new Person(3, "Fname3", "Lname3", 22, "c3"));
        instance.create(new Person(4, "Fname4", "Lname4", 33, "c4"));
        instance.create(new Person(5, "Fname5", "Lname5", 77, "c5"));
        List<Person> act = instance.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        exp.add(new Person(2, "Fname2", "Lname2", 88, "c2"));
        exp.add(new Person(3, "Fname3", "Lname3", 22, "c3"));
        exp.add(new Person(4, "Fname4", "Lname4", 33, "c4"));
        exp.add(new Person(5, "Fname5", "Lname5", 77, "c5"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test(expected = Exception.class)
    public void createPersonNull() throws Exception {
        instance.create(null);
    }

    @Test
    public void readFile() {
        instance.create(new Person(1, "Fname", "Lname", 77, "c1"));
        instance.create(new Person(2, "Fname2", "Lname2", 88, "c2"));
        List<Person> act = instance.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        exp.add(new Person(2, "Fname2", "Lname2", 88, "c2"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test
    public void updatePerson() {
        instance.create(new Person(1, "Fname", "Lname", 77, "c1"));
        instance.create(new Person(2, "Fname2", "Lname2", 11, "c2"));
        instance.create(new Person(3, "Fname3", "Lname3", 22, "c3"));
        instance.update(2, new Person(2, "test", "c", 2, "d"));
        instance.update(3, new Person(3, "six", "meter", 3, "kuk"));
        List<Person> act = instance.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        exp.add(new Person(2, "test", "c", 2, "d"));
        exp.add(new Person(3, "six", "meter", 3, "kuk"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test
    public void deletePerson() {
        instance.create(new Person(1, "Fname", "Lname", 77, "c1"));
        instance.create(new Person(2, "Fname2", "Lname2", 11, "c2"));
        instance.create(new Person(3, "Fname3", "Lname3", 22, "c3"));
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        exp.add(new Person(3, "Fname3", "Lname3", 22, "c3"));
        instance.delete(2);
        List<Person> act = instance.getPeople();
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

}