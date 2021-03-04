package tests.daotests;

import com.github.crud.config.InstanceSelection;
import com.github.crud.dao.IDaoPerson;
import com.github.crud.exeptions.NotValidParameterException;
import com.github.crud.models.Person;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

public class DaoPersonBinTest {

    private IDaoPerson instance;

    private File binFile;

    @Before
    public void setUp() throws IOException {
        this.instance = InstanceSelection.daoPersonData("people.bin");
        this.binFile = new File("people.bin");
        boolean s = this.binFile.createNewFile();
    }

    @After
    public void tearDown() {
        this.binFile.delete();
    }

    @Test
    public void createOne() {
        List<Person> exp = new ArrayList<>();
        Person personExp = new Person(1, "One", "One", 2, "Skole");
        exp.add(this.instance.create(personExp));
        Person personAct = this.instance.create(personExp);
        Assert.assertEquals(personAct, personExp);
    }

    @Test
    public void createOneArr() {
        List<Person> act;
        Person person = new Person(1, "One", "One", 2, "Skole");
        this.instance.create(person);
        this.instance.clear();
        act = this.instance.readAll();
        List<Person> exp = new ArrayList<>();
        exp.add(this.instance.create(new Person(1, "One", "One", 2, "Skole")));
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test(expected = NotValidParameterException.class)
    public void createOneNull() {
        List<Person> exp = new ArrayList<>();
        Person personExp = new Person(1, "One", null, 2, "Skole");
        exp.add(this.instance.create(personExp));
    }

    @Test(expected = NotValidParameterException.class)
    public void createNull() {
        List<Person> exp = new ArrayList<>();
        Person personExp = new Person();
        exp.add(this.instance.create(personExp));
    }

    @Test(expected = NotValidParameterException.class)
    public void createNull2() {
        List<Person> exp = new ArrayList<>();
        Person personExp = new Person(-1, "One", "One", 2, "Skole");
        exp.add(this.instance.create(personExp));
    }

    @Test
    public void readAllBig() {
        List<Person> exp = new ArrayList<>(5);
        exp.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        exp.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        exp.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        exp.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        exp.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        this.instance.clear();
        List<Person> act = this.instance.readAll();
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void readAllOne() {
        List<Person> exp = new ArrayList<>(1);
        exp.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        this.instance.clear();
        List<Person> act = this.instance.readAll();
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test(expected = NotValidParameterException.class)
    public void readAllNull() {
        List<Person> exp = new ArrayList<>();
        exp.add(this.instance.create(new Person(0, null, null, 0, null)));
        this.instance.clear();
        List<Person> act = this.instance.readAll();
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void readAllNull2() {
        List<Person> exp = new ArrayList<>();
        this.instance.clear();
        List<Person> act = this.instance.readAll();
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test(expected = NotValidParameterException.class)
    public void readAllNull3() {
        List<Person> exp = new ArrayList<>();
        exp.add(this.instance.create(new Person(1, "Fedya", null, 55, "Solonka")));
        this.instance.clear();
    }

    @Test
    public void updateBig() {
        List<Person> act = new ArrayList<>(5);
        act.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        act.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        act.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        act.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        act.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        Person change = new Person(2, "Two2", "Two2", 322, "Kyiv2");
        this.instance.clear();
        this.instance.update(change);
        act = this.instance.readAll();
        List<Person> exp = new ArrayList<>(5);
        exp.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        exp.add(this.instance.create(new Person(2, "Two2", "Two2", 322, "Kyiv2")));
        exp.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        exp.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        exp.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void updateNotExistPerson() {
        List<Person> act = new ArrayList<>(5);
        act.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        act.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        act.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        act.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        act.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        Person change = new Person(6, "Two2", "Two2", 322, "Kyiv2");
        this.instance.clear();
        this.instance.update(change);
    }

    @Test
    public void updateOne() {
        List<Person> act = new ArrayList<>();
        act.add(this.instance.create(new Person(2, "One", "One", 21, "Lviv")));
        Person change = new Person(2, "Two2", "Two2", 322, "Kyiv2");
        this.instance.clear();
        this.instance.update(change);
        act = this.instance.readAll();
        List<Person> exp = new ArrayList<>();
        exp.add(this.instance.create(new Person(2, "Two2", "Two2", 322, "Kyiv2")));
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test(expected = NotValidParameterException.class)
    public void updateOneNull() {
        List<Person> act = new ArrayList<>();
        act.add(this.instance.create(new Person(2, "One", "One", 21, "Lviv")));
        Person change = new Person(2, "Two2", null, 322, "Kyiv2");
        this.instance.clear();
        this.instance.update(change);
        act = this.instance.readAll();
        List<Person> exp = new ArrayList<>();
        exp.add(this.instance.create(new Person(2, "One", "One", 21, "Lviv")));
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void updateNullNotExistPerson() {
        List<Person> act = new ArrayList<>();
        Person change = new Person(2, "Two2", "Two2", 322, "Kyiv2");
        this.instance.clear();
        this.instance.update(change);
    }

    @Test
    public void deleteBig() {
        List<Person> act = new ArrayList<>(5);
        act.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        act.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        act.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        act.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        act.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        this.instance.clear();
        this.instance.delete(3);
        act = this.instance.readAll();
        List<Person> exp = new ArrayList<>(5);
        exp.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        exp.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        exp.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        exp.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void deleteOne() {
        List<Person> act = new ArrayList<>();
        act.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        this.instance.clear();
        this.instance.delete(1);
        act = this.instance.readAll();
        List<Person> exp = new ArrayList<>();
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void deleteNotExistPerson() {
        List<Person> act = new ArrayList<>(5);
        act.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        act.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        act.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        act.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        act.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        this.instance.clear();
        this.instance.delete(6);
    }

    @Test
    public void deleteNullNotExistPerson() {
        List<Person> act = new ArrayList<>();
        this.instance.clear();
        this.instance.delete(6);
    }
}
