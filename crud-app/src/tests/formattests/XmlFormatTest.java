package tests.formattests;

import com.github.crud.formats.BaseFormat;
import com.github.crud.formats.impl.XmlFormat;
import com.github.crud.models.Person;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

public class XmlFormatTest {

    private BaseFormat baseFormat = new XmlFormat();

    @Test
    public void stringToFormat() {
        String exp = "<Person>\n\t<id>1</id>\n\t<Firstname>One</Firstname>\n\t<Lastname>One</Lastname>\n\t<Age>1</Age>\n\t<City>One</City>\n</Person>\n";
        Person data = new Person(1,"One","One",1,"One");
        String act = this.baseFormat.toFormat(data);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void stringToFormatNull() {
        String act = this.baseFormat.toFormat(null);
        Assert.assertNull(act);
    }

    @Test
    public void fromFormat() {
        Person exp = new Person(1, "One", "One", 1, "One");
        String data = "<Person>\\n\\t<id>1</id>\\n\\t<Firstname>One</Firstname>\\n\\t<Lastname>One</Lastname>\\n\\t<Age>1</Age>\\n\\t<City>One</City>\\n</Person>\\n\\n";
        Person act = this.baseFormat.fromFormat(data);
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatNull() {
        Person act = this.baseFormat.fromFormat(null);
        Assert.assertNull(act);
    }

    @Test
    public void toFormatArray() {
        List<Person> data = new ArrayList<>();
        Person newData1 = new Person(1, "One", "One", 1, "One");
        Person newData2 = new Person(2, "Two", "Two", 2, "Two");
        Person newData3 = new Person(3, "Three", "Three", 3, "Three");
        Person newData4 = new Person(4, "Four", "Four", 4, "Four");
        data.add(newData1);
        data.add(newData2);
        data.add(newData3);
        data.add(newData4);
        String act = this.baseFormat.toFormatArray(data);
        String exp = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<People>\n" +
                "<Person>\n\t<id>1</id>\n\t<Firstname>One</Firstname>\n\t<Lastname>One</Lastname>\n\t<Age>1</Age>\n\t<City>One</City>\n</Person>\n\n" +
                "<Person>\n\t<id>2</id>\n\t<Firstname>Two</Firstname>\n\t<Lastname>Two</Lastname>\n\t<Age>2</Age>\n\t<City>Two</City>\n</Person>\n\n" +
                "<Person>\n\t<id>3</id>\n\t<Firstname>Three</Firstname>\n\t<Lastname>Three</Lastname>\n\t<Age>3</Age>\n\t<City>Three</City>\n</Person>\n\n" +
                "<Person>\n\t<id>4</id>\n\t<Firstname>Four</Firstname>\n\t<Lastname>Four</Lastname>\n\t<Age>4</Age>\n\t<City>Four</City>\n</Person>\n\n" +
                "</People>";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void toFormatArrayNull() {
        String act = this.baseFormat.toFormatArray(null);
        Assert.assertNull(act);
    }

    @Test
    public void fromFormatArray() {
        Person newPerson = new Person(1, "One","One", 1, "One");
        String data = "<Person>\n\t<id>1</id>\n\t<Firstname>One</Firstname>\n\t<Lastname>One</Lastname>\n\t<Age>1</Age>\n\t<City>One</City>\n</Person>\n\n";
        List<Person> act = this.baseFormat.fromFormatArray(data);
        List<Person> exp = new ArrayList<>();
        exp.add(newPerson);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void fromFormatArrayNull() {
        List<Person> actOne = this.baseFormat.fromFormatArray("");
        List<Person> actTwo = this.baseFormat.fromFormatArray(null);
        List<Person> exp = new ArrayList<>();
        Assert.assertEquals(exp, actOne);
        Assert.assertEquals(exp, actTwo);
    }
}