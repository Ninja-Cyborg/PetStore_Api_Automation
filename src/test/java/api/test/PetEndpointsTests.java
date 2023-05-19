package api.test;

import api.endpoints.PetEndpoints;
import api.endpoints.StoreEndpoints;
import api.payload.Pet;
import api.payload.Store;
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

public class PetEndpointsTests extends BaseClass {

    Faker faker;
    Pet pet;
    public static int statusCode;
    @BeforeClass
    public void setup() throws IOException {
        faker = new Faker();
        statusCode = getStatusCode();
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1,dataProvider = "pets",dataProviderClass = Staticprovider.class)
    public void testPostPet(String id,
                            String name,
                            String category,
                            String photoUrls,
                            String tags,
                            String status){
    pet = new Pet();
    pet.setId(id);
    pet.setName(name);
    pet.setStatus(status);

        logger.info("************   Adding Pet to Store **************");
        Response response = PetEndpoints.createPet(pet);
        assertEquals(response.getStatusCode(), statusCode);
        logger.info("************   Success in Adding Pet named:"+ pet.getName() + " **************");
    }

    @Test(priority = 2,dataProvider = "petId",dataProviderClass = Staticprovider.class)
    public void testGetPetById(String id){
        int petId = (int)Math.round(Float.parseFloat(id));
        logger.info("************   Getting Pet with id:"+ petId + " **************");
        Response response = PetEndpoints.getPetById(petId);

        assertEquals(response.getStatusCode(), statusCode);

    }

    @Test(priority = 3,dataProvider = "petId",dataProviderClass = Staticprovider.class)
    public void testDeletePetById(String id){
        int petId = (int)Math.round(Float.parseFloat(id));
        logger.info("************   Deleting Pet from store with id:"+ petId + " **************");
        Response response = PetEndpoints.deletePetById(petId);

        assertEquals(response.getStatusCode(), statusCode);

    }

}
