package api.test;

import api.endpoints.StoreEndpoints;
import api.endpoints.UserEndpoints;
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

public class StoreEndpointsTests extends BaseClass {

    Faker faker;
    Store store;
    public static int statusCode;
    @BeforeClass
    public void setup() throws IOException {
        faker = new Faker();
        statusCode = getStatusCode();
        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 0)
    public void testGetStoreInventory(){
        logger.info("************   Getting Store Inventory **************");
        Response response = StoreEndpoints.getStoreInventory();

        assertEquals(response.getStatusCode(),statusCode);
    }

    @Test(priority = 1, dataProvider = "orders", dataProviderClass = Staticprovider.class)
    public void testCreateOrder(String orderId, String petId, String quantity,
                                String shipDate, String status, String complete){
    store = new Store();
    String date = "2023-05-13T02:24:59.162Z";
    store.setOrderId(faker.number().numberBetween(1,1000));
    store.setPetID(petId);
    store.setQuantity(faker.number().numberBetween(1,10));
    store.setShipDate(date);
    store.setStatus(status);
    store.setComplete(Boolean.parseBoolean(complete));

    logger.info("**************  Creating Order with id:"+ store.getOrderId()+ "  ***************");
    Response response = StoreEndpoints.createOrder(store);

    assertEquals(response.getStatusCode(),statusCode);
    }

    @Test(priority = 2, dataProvider = "orderId", dataProviderClass = Staticprovider.class)
    public void testGetOrderById(String id){
        int orderId = (int)Math.round(Float.parseFloat(id));
        logger.info("************   Getting Order with id:"+ orderId + " **************");
        Response response = StoreEndpoints.getOrderById(orderId);

        assertEquals(response.getStatusCode(), statusCode);
    }

    @Test(priority = 3, dataProvider = "orderId", dataProviderClass = Staticprovider.class)
    public void testDeleteOrderById(String id){
        int orderId = (int)Math.round(Float.parseFloat(id));
        logger.info("************   Deleting Order with id:"+ orderId + " **************");
        Response response = StoreEndpoints.deleteOrderById(orderId);

        assertEquals(response.getStatusCode(), statusCode);
    }

}
