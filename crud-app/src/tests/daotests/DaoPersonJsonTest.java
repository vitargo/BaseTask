package tests.daotests;

import com.github.crud.config.InstanceSelection;
import com.github.crud.dao.IDaoPerson;
import com.github.crud.exeptions.NotValidParameterException;
import com.github.crud.formats.BaseFormat;
import com.github.crud.formats.impl.JsonFormat;
import com.github.crud.models.Person;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoPersonJsonTest {

    final private List<Person> people = new ArrayList<>();

    final private BaseFormat format = new JsonFormat();

    final private String fileName = "testjson.json";

    final private IDaoPerson dao = InstanceSelection.daoPersonJson(fileName);

    final private Person firstPerson = new Person(1, "a", "b", 1, "c");

    final private Person secondPerson = new Person(2, "b", "c", 2, "d");

    final private Person thirdPerson = new Person(3, "c", "c", 3, "c");

    @Before
    public void createFile() throws IOException {
        File file = new File(this.fileName);
        file.createNewFile();
        Assert.assertTrue(file.exists());
    }

    @Test
    public void createPerson() {
        dao.create(firstPerson);
        dao.create(secondPerson);
        List<Person> act = dao.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(secondPerson);
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test(expected = Exception.class)
    public void createPersonNull() throws Exception {
        dao.create(null);
    }

    @Test
    public void readFile() {
        dao.create(firstPerson);
        dao.create(secondPerson);
        List<Person> act = dao.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(secondPerson);
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test
    public void updatePerson() {
        dao.create(firstPerson);
        dao.create(secondPerson);
        dao.create(thirdPerson);
        dao.update(new Person(2, "test", "c", 2, "d"));
        dao.update(new Person(3, "six", "meter", 3, "kuk"));
        List<Person> act = dao.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(new Person(2, "test", "c", 2, "d"));
        exp.add(new Person(3, "six", "meter", 3, "kuk"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));

    }

    @Test(expected = NotValidParameterException.class)
    public void updatePersonNull() throws NullPointerException {
        dao.create(firstPerson);
        dao.update(null);
    }

    @Test
    public void deletePerson() {
        dao.create(firstPerson);
        dao.create(secondPerson);
        dao.create(thirdPerson);
        List<Person> exp = new ArrayList<>();
        exp.add(firstPerson);
        exp.add(thirdPerson);
        dao.delete(2);
        List<Person> act = dao.getPeople();
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @After
    public void deleteFile() {
        File file = new File("testjson.json");
        file.delete();
        Assert.assertFalse(file.exists());
    }
}
