import model.Person;
import org.junit.Assert;
import org.junit.Test;
import reflections_home_work.JsonMapper;

import static org.junit.Assert.*;


public class JsonMapperTest {

    @Test
    public void testFromJson() {
        String json = "{\"name\": \"Jeka\",\"age\": 42}";
        Person person = JsonMapper.convertFromJson(json, Person.class);
        Assert.assertEquals(42,person.getAge());
        Assert.assertEquals("Jeka",person.getName());
    }

    @Test
    public void testToJson() {
        Person person = new Person("Jeka", 42);
        String json = JsonMapper.convertToJson(person);
        System.out.println("json = " + json);
     //   Person person1 = JsonMapper.convertFromJson(json, Person.class); todo not working
     //   Assert.assertEquals(person, person1);
    }



}