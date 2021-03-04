package tests;

import com.github.crud.models.Person;

import java.util.List;

public class MockDataDao {

    public static List<Person> readAll = List.of(new Person(1, "Fname", "Lname", 77, "c1"),
            new Person(2, "Fname2", "Lname2", 11, "c2"),
            new Person(3, "Fname3", "Lname3", 22, "c3"),
            new Person(4, "Fname4", "Lname4", 33, "c4"),
            new Person(5, "Fname5", "Lname5", 77, "c5")
    );

    public static List<Person> readThree = List.of(new Person(1, "Fname", "Lname", 77, "c1"),
            new Person(2, "Fname2", "Lname2", 11, "c2"),
            new Person(3, "Fname3", "Lname3", 22, "c3")
    );

    public static List<Person> readTwo = List.of(new Person(1, "Fname", "Lname", 77, "c1"),
            new Person(2, "Fname2", "Lname2", 88, "c2")
    );

    public static List<Person> readOne = List.of(new Person(1, "Fname", "Lname", 77, "c1")
    );

    public static List<Person> readNull = List.of(new Person(1, null, "Lname", 77, "c1")
    );

    public static List<Person> readEmpty = List.of(new Person(1, "", "Lname", 77, "c1")
    );
}

