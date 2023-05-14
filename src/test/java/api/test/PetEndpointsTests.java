package api.test;

import api.endpoints.PetEndpoints;
import api.endpoints.StoreEndpoints;
import api.payload.Pet;
import api.payload.Store;
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

public class PetEndpointsTests {

    Faker faker;
    Pet pet;
    public Logger logger;
    @BeforeClass
    public void setup() throws IOException {
        faker = new Faker();
        ExtentReportManager.setExtent();
        logger = LogManager.getLogger(this.getClass());
    }

    @Test
    public void testAddPet(){

    }

    @Test
    public void testUpdatePet(){

    }

    @Test
    public void testGetPetById(int petId){
        logger.info("************   Getting Pet with id:"+ petId + " **************");
        Response response = PetEndpoints.getPetById(petId);

        assertEquals(response.getStatusCode(), 500);

    }

    @Test
    public void testDeletePetById(int petId){
        logger.info("************   Deleting Pet from store with id:"+ petId + " **************");
        Response response = PetEndpoints.deletePetById(petId);

        assertEquals(response.getStatusCode(), 500);

    }

    @AfterClass
    public void afterSuite() {
        ExtentReportManager.endReport();
    }
}
