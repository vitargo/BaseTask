package tests.formattests;

import com.github.crud.config.InstanceSelection;
import com.github.crud.dao.IDaoPerson;
import com.github.crud.exeptions.NotValidParameterException;
import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;

public class BinFormatTest {

    private IDaoPerson instance;

    private File binFile;

    private BaseFormat baseFormat;

    @Before
    public void setUp() throws IOException {
        this.baseFormat = InstanceSelection.dataFormat();
        this.instance = InstanceSelection.daoPersonData("people.bin");
        this.binFile = new File("people.bin");
        boolean s = this.binFile.createNewFile();
    }

    @After
    public void tearDown() {
        this.binFile.delete();
    }

    @Test
    public void loadObjectBig() {
        List<Person> exp = new ArrayList<>(5);
        exp.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        exp.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        exp.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        exp.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        exp.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        this.baseFormat.saveObject(exp, this.binFile.getAbsolutePath());
        this.instance.clear();
        List<Person> act = this.baseFormat.loadObject(this.binFile.getAbsolutePath());
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void loadObjectBigVer2() {
        List<Person> exp = new ArrayList<>(5);
        exp.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        exp.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        exp.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        exp.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        exp.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        this.baseFormat.saveObject(exp, this.binFile.getAbsolutePath());
        this.instance.clear();
        List<Person> act = this.baseFormat.loadObject(this.binFile.getAbsolutePath());
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void loadObjectOne() {
        List<Person> exp = new ArrayList<>();
        exp.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        this.baseFormat.saveObject(exp, this.binFile.getAbsolutePath());
        this.instance.clear();
        List<Person> act = this.baseFormat.loadObject(this.binFile.getAbsolutePath());
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void loadObjectNull() {
        List<Person> exp = new ArrayList<>();
        this.baseFormat.saveObject(exp, this.binFile.getAbsolutePath());
        this.instance.clear();
        List<Person> act = this.baseFormat.loadObject(this.binFile.getAbsolutePath());
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test(expected = NotValidParameterException.class)
    public void loadObjectNull2() {
        List<Person> exp = new ArrayList<>();
        exp.add(this.instance.create(new Person(1, "One", null, 21, "Lviv")));
        this.instance.clear();
    }

    @Test
    public void saveObjectBig() throws IOException, ClassNotFoundException {
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "One", "One", 21, "Lviv"));
        exp.add(new Person(2, "Two", "Two", 32, "Kyiv"));
        exp.add(new Person(3, "Three", "Three", 43, "Poltava"));
        exp.add(new Person(4, "Four", "Four", 54, "Kharkiv"));
        exp.add(new Person(5, "Five", "Five", 65, "Pomokli"));
        this.baseFormat.saveObject(exp, this.binFile.getAbsolutePath());
        this.instance.clear();
        FileInputStream fileIn = new FileInputStream(this.binFile.getAbsolutePath());
        ObjectInputStream in = new ObjectInputStream(fileIn);
        List<Person> act = (ArrayList) in.readObject();
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void saveObjectBig2() throws IOException, ClassNotFoundException {
        List<Person> exp = new ArrayList<>();
        exp.add(this.instance.create(new Person(1, "One", "One", 21, "Lviv")));
        exp.add(this.instance.create(new Person(2, "Two", "Two", 32, "Kyiv")));
        exp.add(this.instance.create(new Person(3, "Three", "Three", 43, "Poltava")));
        exp.add(this.instance.create(new Person(4, "Four", "Four", 54, "Kharkiv")));
        exp.add(this.instance.create(new Person(5, "Five", "Five", 65, "Pomokli")));
        this.instance.clear();
        FileInputStream fileIn = new FileInputStream(this.binFile.getAbsolutePath());
        ObjectInputStream in = new ObjectInputStream(fileIn);
        List<Person> act = (ArrayList) in.readObject();
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void saveObjectOne() {
        List<Person> exp = new ArrayList<>();
        exp.add(new Person(1, "One", "One", 21, "Lviv"));
        this.baseFormat.saveObject(exp, this.binFile.getAbsolutePath());
        this.instance.clear();
        List<Person> act = this.baseFormat.loadObject(this.binFile.getAbsolutePath());
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }

    @Test
    public void saveObjectBigNull() {
        List<Person> exp = new ArrayList<>();
        this.baseFormat.saveObject(exp, this.binFile.getAbsolutePath());
        this.instance.clear();
        List<Person> act = this.baseFormat.loadObject(this.binFile.getAbsolutePath());
        assertThat(act, IsIterableContainingInAnyOrder.containsInAnyOrder(exp.toArray()));
    }
}
