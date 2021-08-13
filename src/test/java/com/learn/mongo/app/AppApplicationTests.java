package com.learn.mongo.app;

import com.learn.mongo.app.model.Address;
import com.learn.mongo.app.model.User;
import com.learn.mongo.app.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDataMongodbTutorialApplicationTests {

    @Autowired
    private UserRepository repo;

    @Before
    public void before() {
        repo.deleteAll();
    }
    @Test
    public void createUserWithAddress() {
        User horst = new User();
        horst.setFirstname("Horst");
        horst.setLastname("Mustermann");
        horst.setUsername("horstm");
        Address address = new Address();
        address.setCity("Frankfurt");
        address.setCountry("Germany");
        address.setStreet("Zeil 3");
        address.setZipCode("60384");

        horst.setHomeAddress(address);

        User horstDb = repo.save(horst);
        assertNotNull(horstDb);
        assertNotNull(horstDb.getId());
        assertEquals(horst.getFirstname(), horstDb.getFirstname());
    }

}
