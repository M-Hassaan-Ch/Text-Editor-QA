package persistence;

import org.junit.Test;
import dal.DatabaseConnection;
import static org.junit.Assert.*;

public class SingletonTest {

    @Test
    public void returnsSameInstance() {
        DatabaseConnection instance1 = DatabaseConnection.getInstance();
        DatabaseConnection instance2 = DatabaseConnection.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void notNull() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        assertNotNull(instance);
    }

    @Test
    public void connectionNotNull() {
        DatabaseConnection instance = DatabaseConnection.getInstance();
        assertNotNull(instance.getConnection());
    }

    @Test
    public void multipleCallsSameObject() {
        DatabaseConnection a = DatabaseConnection.getInstance();
        DatabaseConnection b = DatabaseConnection.getInstance();
        DatabaseConnection c = DatabaseConnection.getInstance();
        assertSame(a, b);
        assertSame(b, c);
    }
}
