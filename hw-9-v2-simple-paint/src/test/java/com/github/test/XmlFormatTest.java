package com.github.test;

import com.github.paint.CustomLine;
import com.github.paint.config.FormatChooser;
import com.github.paint.formats.IBaseFormat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class XmlFormatTest {

    private File xmlFile;

    private IBaseFormat baseFormat;

    @Before
    public void setUp() throws IOException {
        this.baseFormat = FormatChooser.xmlFormat();
        this.xmlFile = new File("paint.xml");
        boolean s = this.xmlFile.createNewFile();
    }

    @After
    public void tearDown() {
        this.xmlFile.delete();
    }

    @Test
    public void fromFormatMany(){
        List<CustomLine> act = MockData.paintMany;
        this.baseFormat.toFormat(MockData.paintMany, this.xmlFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.xmlFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatTwo(){
        List <CustomLine> act = MockData.paintTwo;
        this.baseFormat.toFormat(MockData.paintTwo, this.xmlFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.xmlFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatOne(){
        List <CustomLine> act = MockData.paintOne;
        this.baseFormat.toFormat(MockData.paintOne, this.xmlFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.xmlFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatEmpty(){
        List <CustomLine> act = MockData.paintEmpty;
        this.baseFormat.toFormat(MockData.paintEmpty, this.xmlFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.xmlFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatNull(){
        List <CustomLine> act = MockData.paintNull;
        this.baseFormat.toFormat(MockData.paintNull, this.xmlFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.xmlFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }
}