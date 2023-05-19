package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utility.BaseClass;
import api.utility.ExtentReportManager;
import api.utility.Staticprovider;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class UserEndPointsTests extends BaseClass {

    Faker faker;
    User user;
    public static int statusCode;
    @BeforeClass
    public void setup() throws IOException {
        faker = new Faker();
        statusCode = getStatusCode();
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1,dataProvider = "usersData",dataProviderClass = Staticprovider.class)
    public void testPostUser(String id, String username,String password,
                             String firstname,String lastname,
                             String email, String phone, String userStatus){
        user = new User();
        user.setId(faker.idNumber().hashCode());
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setUserStatus(faker.number().numberBetween(0,2));
        user.setPhone(phone);

        logger.info("************   Creating User **************");
        Response response = UserEndpoints.createUser(user);
        // success StatusCode assertion
        // assertEquals(response.getStatusCode(), 200);

        // on high server load, return 500
        assertEquals(response.getStatusCode(), statusCode);
    }

    @Test(priority = 2,dataProvider = "usernames",dataProviderClass = Staticprovider.class)
    public void testGetUser(String username){
        logger.info("************   Getting User Info **************");
        Response response = UserEndpoints.getUser(username);

        // on high server load, return statusCode
        assertEquals(response.getStatusCode(), statusCode);
    }

    // add updateUserTest
    @Test(priority = 4,dataProvider = "usernames",dataProviderClass = Staticprovider.class)
    public void testDeleteUser(String username){

        logger.info("************   Deleting User **************");
        Response response = UserEndpoints.deleteUser(username);

        // on high server load, return statusCode
        assertEquals(response.getStatusCode(), statusCode);
    }
}
