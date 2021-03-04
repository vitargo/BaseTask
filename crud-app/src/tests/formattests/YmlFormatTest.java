package tests.formattests;

import com.github.crud.config.InstanceSelection;
import com.github.crud.formats.BaseFormat;
import com.github.crud.models.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class YmlFormatTest {

    private BaseFormat format = InstanceSelection.ymlFormat();

    @Test
    public void toFormat() {
        String exp = "- Person:\n" +
                "\tid: 1 \n" +
                "\tfirstname: Test1 \n" +
                "\tlastname: Testov1 \n" +
                "\tage: 777 \n" +
                "\tcity: Zajopinsk \n";
        Person data = new Person(1, "Test1", "Testov1", 777, "Zajopinsk");
        String act = this.format.toFormat(data);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void toFormatNull() {
        String act = this.format.toFormat(null);
        assertNull(act);
    }

    @Test
    public void fromFormat() {
        String data = "- Person:\n\tid: 11 \n\tfirstname: Test1 \n\tlastname: Testov1 \n\tage: 777 \n\tcity: Zajopinsk \n";
        Person exp = new Person(11, "Test1", "Testov1", 777, "Zajopinsk");
        Person act = this.format.fromFormat(data);
        Assert.assertEquals(act, exp);
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
        String exp =
                "- Person:\n" +
                        "\tid: 1 \n" +
                        "\tfirstname: Test1 \n" +
                        "\tlastname: Testov1 \n" +
                        "\tage: 111 \n" +
                        "\tcity: Za \n" +
                        "- Person:\n" +
                        "\tid: 2 \n" +
                        "\tfirstname: Test2 \n" +
                        "\tlastname: Testov2 \n" +
                        "\tage: 222 \n" +
                        "\tcity: Jo \n" +
                        "- Person:\n" +
                        "\tid: 3 \n" +
                        "\tfirstname: Test3 \n" +
                        "\tlastname: Testov3 \n" +
                        "\tage: 333 \n" +
                        "\tcity: Pinsk \n";
        List<Person> data = new ArrayList<>();
        data.add(new Person(1L, "Test1", "Testov1", 111, "Za"));
        data.add(new Person(2L, "Test2", "Testov2", 222, "Jo"));
        data.add(new Person(3L, "Test3", "Testov3", 333, "Pinsk"));

        String act = this.format.toFormatArray(data);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void toFormatArrayNull() {
        String act = this.format.toFormatArray(null);
        String exp = "";
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatArray() {
        Person newPerson = new Person(11, "Test", "Testov", 777, "Zajopinsk");
        String data = "- Person:\n\tid: 11 \n\tfirstname: Test \n\tlastname: Testov \n\tage: 777 \n\tcity: Zajopinsk \n";
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