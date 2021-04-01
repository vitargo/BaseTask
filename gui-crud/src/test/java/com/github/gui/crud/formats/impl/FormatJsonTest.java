package com.github.gui.crud.formats.impl;

import com.github.gui.crud.config.FormatsConfig;
import com.github.gui.crud.config.ServicesConfig;
import com.github.gui.crud.config.type.FileType;
import com.github.gui.crud.formats.IFormats;
import com.github.gui.crud.services.IPeopleService;
import com.github.gui.crud.entity.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FormatJsonTest {

    private IPeopleService instance;

    private File jsonFile;

    private IFormats format;

    private FileType formats = FileType.JSON;

    @Before
    public void setUp() throws IOException {
        this.format = ServicesConfig.jsonFormat();
        this.instance = FormatsConfig.newInstance(formats,"people.json");
        this.jsonFile = new File("people.json");
        boolean s = this.jsonFile.createNewFile();
    }

    @After
    public void tearDown() {
        this.jsonFile.delete();
    }

    @Test
    public void stringToFormat() {
        String exp = "[\n" + "\n" + "  {\n" + "    \"id\":\"1\",\n" + "    \"firstName\":\"Test\",\n" +
                "    \"lastName\":\"Test\",\n" + "    \"age\":\"25\",\n" + "    \"city\":\"Test\"\n" + "  }\n" + "]\n";

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
        Person exp = new Person(1, "Test", "Test", 24, "Test");
        String data = "[\n" + "\n" + "  {\n" + "\t\"id\":\"1\",\n" + "\t\"firstName\":\"Test\",\n" +
                "\t\"lastName\":\"Test\",\n" + "\t\"age\":\"24\",\n" + "\t\"city\":\"Test\"\n" + "  }\n" + "]";
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
        data.add(newData);
        data.add(newData2);
        String act = this.format.toFormatArray(data);
        String exp = "[\n" + "\n" + "  {\n" + "    \"id\":\"1\",\n" + "    \"firstName\":\"Test\",\n" + "    \"lastName\":\"Test\",\n" +
                "    \"age\":\"25\",\n" + "    \"city\":\"Test\"\n" + "  },\n" + "  {\n" +
                "    \"id\":\"2\",\n" + "    \"firstName\":\"Test2\",\n" + "    \"lastName\":\"Test2\",\n" +
                "    \"age\":\"25\",\n" + "    \"city\":\"Test2\"\n" + "  }\n" + "]\n";
        Assert.assertEquals(exp, act);
    }

    @Test
    public void toFormatArrayNull() {
        String act = this.format.toFormatArray(null);
        String exp = null;
        Assert.assertEquals(exp, act);
    }

    @Test
    public void fromFormatArray() {
        Person newPerson = new Person(1, "Test", "Test", 25, "Test");
        String data = "[\n" + "\n" + "  {\n" + "\t\"id\":\"1\",\n" + "\t\"firstName\":\"Test\",\n" +
                "\t\"lastName\":\"Test\",\n" + "\t\"age\":\"25\",\n" + "\t\"city\":\"Test\"\n" + "  }\n" + "]";
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