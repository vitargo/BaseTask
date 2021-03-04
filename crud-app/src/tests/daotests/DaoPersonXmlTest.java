package tests.daotests;

import com.github.crud.config.InstanceSelection;
import com.github.crud.dao.IDaoPerson;
import com.github.crud.models.Person;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tests.MockDataDao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DaoPersonXmlTest {
    private List<Person> people = new ArrayList<>();

    private File ymlFile;

    private IDaoPerson iDao;

    @Before
    public void setUp() throws IOException {
        this.iDao = InstanceSelection.daoPersonXml("testfile.yml");
        this.ymlFile = new File("testfile.yml");
        boolean s = this.ymlFile.createNewFile();
    }

    @Test
    public void createOne() {
        iDao.create(new Person(1, "Fname", "Lname", 77, "c1"));
        List<Person> act = iDao.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test
    public void createTwo() {
        List<Person> exp = MockDataDao.readTwo;
        List<Person> act = new ArrayList<>();
        act.add(iDao.create(new Person(1, "Fname", "Lname", 77, "c1")));
        act.add(iDao.create(new Person(2, "Fname2", "Lname2", 88, "c2")));
        Assert.assertThat(act, IsIterableContainingInOrder.contains(exp.toArray()));
    }

    @Test
    public void createMany() {
        iDao.create(new Person(1, "Fname", "Lname", 77, "c1"));
        iDao.create(new Person(2, "Fname2", "Lname2", 88, "c2"));
        iDao.create(new Person(3, "Fname3", "Lname3", 22, "c3"));
        iDao.create(new Person(4, "Fname4", "Lname4", 33, "c4"));
        iDao.create(new Person(5, "Fname5", "Lname5", 77, "c5"));
        List<Person> act = iDao.getPeople();
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
        iDao.create(null);
    }

    @Test
    public void readFile() {
        iDao.create(new Person(1, "Fname", "Lname", 77, "c1"));
        iDao.create(new Person(2, "Fname2", "Lname2", 88, "c2"));
        List<Person> act = iDao.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        exp.add(new Person(2, "Fname2", "Lname2", 88, "c2"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test
    public void updatePerson() {
        iDao.create(new Person(1, "Fname", "Lname", 77, "c1"));
        iDao.create(new Person(2, "Fname2", "Lname2", 11, "c2"));
        iDao.create(new Person(3, "Fname3", "Lname3", 22, "c3"));
        iDao.update(new Person(2, "test", "c", 2, "d"));
        iDao.update(new Person(3, "six", "meter", 3, "kuk"));
        List<Person> act = iDao.getPeople();
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        exp.add(new Person(2, "test", "c", 2, "d"));
        exp.add(new Person(3, "six", "meter", 3, "kuk"));
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @Test
    public void deletePerson() {
        iDao.create(new Person(1, "Fname", "Lname", 77, "c1"));
        iDao.create(new Person(2, "Fname2", "Lname2", 11, "c2"));
        iDao.create(new Person(3, "Fname3", "Lname3", 22, "c3"));
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "Fname", "Lname", 77, "c1"));
        exp.add(new Person(3, "Fname3", "Lname3", 22, "c3"));
        iDao.delete(2);
        List<Person> act = iDao.getPeople();
        Assert.assertThat(exp, IsIterableContainingInOrder.contains(act.toArray()));
    }

    @After
    public void deleteFile() {
        File file = new File("testfile.yml");
        file.delete();
        Assert.assertFalse(file.exists());
    }
}