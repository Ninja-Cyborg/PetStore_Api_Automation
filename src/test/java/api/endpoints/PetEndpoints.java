package api.endpoints;

import api.payload.Pet;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetEndpoints {

    public static Response createPet(Pet payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postPet_url);
        return response;
    }

    public static Response updatePet(Pet payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.updatePet_url);
        return response;
    }

    public static Response getPetById(int petId){
        Response response = given()
                .pathParam("petId",petId)
                .when()
                .get(Routes.getPet_url);

        return response;
    }

    public static Response deletePetById(int petId){
        Response response = given()
                .pathParam("petId",petId)
                .when()
                .delete(Routes.deletePet_url);

        return response;
    }

}
