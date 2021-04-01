import com.github.gui.crud.config.ServicesConfig;
import com.github.gui.crud.exceptions.NotValidParameterException;
import com.github.gui.crud.services.IPeopleService;
import org.junit.Test;

public class ServicesConfigTest {

    @Test(expected = NotValidParameterException.class)
    public void personNotNull() {
        IPeopleService instance = ServicesConfig.servicePeoplePostgreSQL();
        instance.create(null);
    }

}