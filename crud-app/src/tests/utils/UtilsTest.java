package tests.utils;

import com.github.crud.models.Person;
import com.github.crud.utils.CheckPersonId;
import org.junit.Test;
import tests.MockDataDao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class UtilsTest {

    @Test(expected = NoSuchElementException.class)
    public void checkId() throws NoSuchElementException {
        List<Person> people = MockDataDao.readAll;
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        CheckPersonId.checkForExistingID(people);
    }

    @Test
    public void checkIdSet() throws NoSuchElementException {
        List<Person> people = MockDataDao.readAll;
        System.setIn(new ByteArrayInputStream("6".getBytes()));
        CheckPersonId.checkForExistingID(people);
    }

    @Test(expected = NoSuchElementException.class)
    public void checkIdNotValidSymbol() throws NoSuchElementException {
        List<Person> people = MockDataDao.readAll;
        System.setIn(new ByteArrayInputStream("o".getBytes()));
        CheckPersonId.checkForExistingID(people);
    }
}


