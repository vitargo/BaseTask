package tests.utils;

import com.github.crud.utils.FileUtils;
import org.junit.Assert;
import org.junit.Test;

public class FileUtilsTest {

    @Test
    public void isValidExist(){
        String format = "json";
        boolean exp = true;
        boolean act = FileUtils.isValid(format);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void isValidNotExist(){
        String format = "mlx";
        boolean exp = false;
        boolean act = FileUtils.isValid(format);
        Assert.assertEquals(exp, act);
    }

    @Test
    public void isValidEmpty(){
        String format = "";
        boolean exp = false;
        boolean act = FileUtils.isValid(format);
        Assert.assertEquals(exp, act);
    }
}