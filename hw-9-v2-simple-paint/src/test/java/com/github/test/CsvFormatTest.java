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

public class CsvFormatTest {

    private File csvFile;

    private IBaseFormat baseFormat;

    @Before
    public void setUp() throws IOException {
        this.baseFormat = FormatChooser.csvFormat();
        this.csvFile = new File("paint.csv");
        boolean s = this.csvFile.createNewFile();
    }

    @After
    public void tearDown() {
        this.csvFile.delete();
    }

    @Test
    public void fromFormatMany(){
        List <CustomLine> act = MockData.paintMany;
        this.baseFormat.toFormat(MockData.paintMany, this.csvFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.csvFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatTwo(){
        List <CustomLine> act = MockData.paintTwo;
        this.baseFormat.toFormat(MockData.paintTwo, this.csvFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.csvFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatOne(){
        List <CustomLine> act = MockData.paintOne;
        this.baseFormat.toFormat(MockData.paintOne, this.csvFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.csvFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }

    @Test
    public void fromFormatEmpty(){
        List <CustomLine> act = MockData.paintEmpty;
        this.baseFormat.toFormat(MockData.paintEmpty, this.csvFile.getAbsolutePath());
        List <CustomLine> exp = this.baseFormat.fromFormat(this.csvFile.getAbsolutePath());
        Assert.assertEquals(act, exp);
    }

    @Test (expected = NullPointerException.class)
    public void fromFormatNull(){
        this.baseFormat.toFormat(MockData.paintNull, this.csvFile.getAbsolutePath());
    }
}