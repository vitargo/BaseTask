package tests.formattests;

import com.github.crud.config.InstanceSelection;
import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CsvFormatTest {

    private BaseFormat format = InstanceSelection.csvFormat();

    @Test
    public void toFormat() {
        String exp = "1,N1,L1,11,C1\n";
        Person data = new Person(1, "N1", "L1", 11, "C1");
        String act = this.format.toFormat(data);
        assertEquals(exp, act);
    }

    @Test
    public void toFormatNull() {
        String act = this.format.toFormat(null);
        assertNull(act);

    }

    @Test
    public void fromFormat() {
        String data = "1,N1,L1,11,C1\n";
        Person exp = new Person(1L, "N1", "L1", 11, "C1");
        Person act = this.format.fromFormat(data);
        boolean res = exp.equals(act);
        assertTrue(res);
    }

    @Test
    public void fromFormatNull() {
        Person act = this.format.fromFormat(null);
        assertNull(act);
    }

    @Test
    public void fromFormatEmpty() {
        Person act = this.format.fromFormat("");
        assertNull(act);
    }

    @Test
    public void toFormatArray() {
        String exp = "1,N1,L1,11,C1\n" + "2,N2,L2,12,C2\n" + "3,N3,L3,13,C3\n" + "4,N4,L4,14,C4\n" + "5,N5,L5,15,C5\n";
        List<Person> data = new ArrayList<>();
        data.add(new Person(1L, "N1", "L1", 11, "C1"));
        data.add(new Person(2L, "N2", "L2", 12, "C2"));
        data.add(new Person(3L, "N3", "L3", 13, "C3"));
        data.add(new Person(4L, "N4", "L4", 14, "C4"));
        data.add(new Person(5L, "N5", "L5", 15, "C5"));
        String act = this.format.toFormatArray(data);
        assertEquals(exp, act);
    }

    @Test
    public void toFormatArrayNull() {
        String act = this.format.toFormatArray(null);
        String exp = "";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void toFormatArrayEmpty() {
        String act = this.format.toFormatArray(new ArrayList<>());
        String exp = "";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void fromFormatArray() {
        Person newPerson = new Person(1L, "N1", "L1", 11, "C1");
        String data = "1,N1,L1,11,C1\n";
        List<Person> act = this.format.fromFormatArray(data);
        List<Person> exp = new ArrayList<>();
        exp.add(newPerson);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void fromFormatArrayNull() {
        List<Person> actOne = this.format.fromFormatArray("");
        List<Person> actTwo = this.format.fromFormatArray(null);
        List<Person> exp = new ArrayList<>();
        Assert.assertEquals(exp, actOne);
        Assert.assertEquals(exp, actTwo);
    }
}