package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PersonTest {

    static Person testPerson;

    @BeforeEach
    void setup(){
        testPerson = new Person("Kåre", 69);
    }

    @Test
    void getName() {
        assertEquals(testPerson.getName(), "Kåren");
    }

    @Test
    void setName() {
        assertEquals(testPerson.getName(), "Kåre");
        testPerson.setName("NyKåre");
        assertEquals(testPerson.getName(), "NyKåre");
    }

    @Test
    void getAge() {
        assertEquals(testPerson.getAge(), 69);
    }

    @Test
    void setAge() {
        assertEquals(testPerson.getAge(), 69);
        testPerson.setAge(70);
        assertEquals(testPerson.getAge(), 70);
    }
}