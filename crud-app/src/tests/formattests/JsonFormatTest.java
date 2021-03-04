package tests.formattests;

import com.github.crud.config.InstanceSelection;
import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JsonFormatTest {

    private BaseFormat format = InstanceSelection.jsonFormat();

    @Test
    public void stringToFormat() {
        String exp = "\t{\n" +
                "\t\t\"id\": 1,\n" +
                "\t\t\"name\": \"Test\",\n" +
                "\t\t\"lastName\": \"Test\",\n" +
                "\t\t\"age\": 25,\n" +
                "\t\t\"city\": \"Test\"\n" +
                "\t}";
        Person data = new Person(1, "Test", "Test", 25, "Test");
        String act = this.format.toFormat(data);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void stringToFormatNull() {
        String act = this.format.toFormat(null);
        Assert.assertNull(act);
    }

    @Test
    public void fromFormat() {
        Person exp = new Person(21, "Test", "Test1", 24, "Test2");
        String data = "\t{\n\t\t\"id\": 21,\n\t\t\"name\": \"Test\",\n\t\t\"lastName\": \"Test1\",\n\t\t\"age\": 24,\n\t\t\"city\": \"Test2\"\n\t}";
        Person act = this.format.fromFormat(data);
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatNull() {
        Person act = this.format.fromFormat(null);
        Assert.assertNull(act);
    }

    @Test
    public void toFormatArray() {
        List<Person> data = new ArrayList<>();
        Person newData = new Person(1, "Test", "Test", 25, "Test");
        Person newData2 = new Person(2, "Test2", "Test2", 25, "Test2");
        Person newData3 = new Person(3, "Test3", "Test3", 69, "Test3");
        data.add(newData);
        data.add(newData2);
        data.add(newData3);
        String act = this.format.toFormatArray(data);
        String exp = "[\n" +
                "\t{\n" +
                "\t\t\"id\": 1,\n" +
                "\t\t\"name\": \"Test\",\n" +
                "\t\t\"lastName\": \"Test\",\n" +
                "\t\t\"age\": 25,\n" +
                "\t\t\"city\": \"Test\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": 2,\n" +
                "\t\t\"name\": \"Test2\",\n" +
                "\t\t\"lastName\": \"Test2\",\n" +
                "\t\t\"age\": 25,\n" +
                "\t\t\"city\": \"Test2\"\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"id\": 3,\n" +
                "\t\t\"name\": \"Test3\",\n" +
                "\t\t\"lastName\": \"Test3\",\n" +
                "\t\t\"age\": 69,\n" +
                "\t\t\"city\": \"Test3\"\n" +
                "\t}\n" +
                "]";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void toFormatArrayNull() {
        String act = this.format.toFormatArray(null);
        String exp = "";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void fromFormatArray() {
        Person newPerson = new Person(1, "Test", "Test", 25, "Test");
        String data = "[\n{\n\"id\": 1,\n\"name\": \"Test\",\n\"lastName\": \"Test\",\n\"age\": 25,\n\"city\": \"Test\"\n}\n";
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
