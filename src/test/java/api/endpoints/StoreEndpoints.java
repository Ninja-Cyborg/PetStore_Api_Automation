package api.endpoints;

import api.payload.Pet;
import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndpoints {

    public static Response getStoreInventory(){
        Response response = given()
                .when()
                .get(Routes.getStoreInventory_url);
        return response;
    }

    public static Response createOrder(Store payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postOrderInStore_url);
        return response;
    }

    public static Response getOrderById(int orderId){
        Response response = given()
                .pathParam("orderId",orderId)
                .when()
                .get(Routes.getOrderFromStore_url);

        return response;
    }

    public static Response deleteOrderById(int orderId){
        Response response = given()
                .pathParam("orderId",orderId)
                .when()
                .delete(Routes.deleteOrderFromStore_url);
        return response;
    }

}
