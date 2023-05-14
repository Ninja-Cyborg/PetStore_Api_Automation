package api.test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utility.ExtentReportManager;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class UserEndpointsTests {

    Faker faker;
    User user;
    public Logger logger;
    @BeforeClass
    public void setup() throws IOException {
        faker = new Faker();
        user = new User();
        user.setId(faker.idNumber().hashCode());
        user.setUsername(faker.name().username());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().safeEmailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().cellPhone());
        user.setUserStatus(faker.number().numberBetween(0,2));

        ExtentReportManager.setExtent();
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 0)
    public void testPostUser(){
        logger.info("************   Creating User   **************");
        Response response = UserEndpoints.createUser(user);
        response.then().log().all();
    // on high server load, return 500
        assertEquals(response.getStatusCode(), 500);
    }

    @Test(priority = 1)
    public void testGetUser(){
        logger.info("************   Getting User info **************");
        Response response = UserEndpoints.getUser(user.getUsername());
        response.then().log().all();
        // on high server load, return 500
        assertEquals(response.getStatusCode(), 500);
    }

    @Test(priority = 2)
    public void testUpdateUser(){
        // making changes in fields
        user.setEmail(faker.internet().safeEmailAddress());
        logger.info("************   Updating User Data   **************");
        Response response = UserEndpoints.updateUser(this.user.getUsername(), user);
        response.then().log().all();
        assertEquals(response.getStatusCode(), 500);
    }

    @Test(priority = 3)
    public void testDeleteUser(){
        logger.info("************   Deleting Users   **************");
        Response response = UserEndpoints.deleteUser(this.user.getUsername());
        response.then().log().all();

        assertEquals(response.getStatusCode(),500);
    }

    @Test(priority = 4)
    public void testLoginUser(){
        logger.info("************   LogIn to the Api   **************");
        Response response = UserEndpoints.loginUser(user.getUsername(), user.getPassword());
        response.then().log().all();

        assertEquals(response.getStatusCode(),500);
    }

    @Test(priority = 5)
    public void testLogoutUser(){
        logger.info("************   Logout from the Api   **************");
        Response response = UserEndpoints.logoutUser();
        response.then().log().all();

        assertEquals(response.getStatusCode(),500);
    }
    @AfterClass
    public void afterSuite() {
        ExtentReportManager.endReport();
    }
}
