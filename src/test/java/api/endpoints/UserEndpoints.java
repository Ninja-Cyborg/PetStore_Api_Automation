package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

// executing CRUD on User model
public class UserEndpoints {

    public static Response createUser(User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.postUser_url);
        return response;
    }

    public static Response getUser(String username){
        Response response = given()
                .pathParam("username",username)
                .when()
                .get(Routes.getUser_url);
        return response;
    }

    public static Response updateUser(String username, User payload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .put(Routes.updateUser_url);
        return response;
    }

    public static Response deleteUser(String username){
        Response response = given()
                .pathParam("username",username)
                .when()
                .delete(Routes.deleteUser_url);
        return response;
    }

    public static Response loginUser(String username, String password){
        Response response = given()
                .queryParam("username",username)
                .queryParam("password", password)
                .when()
                .get(Routes.loginUser_url);
        return response;
    }

    public static Response logoutUser(){
        Response response = given()
                .when()
                .get(Routes.logoutUser_url);
        return response;
    }

    public static Response createUserList(List<User> usersPayload){
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(usersPayload)
                .when()
                .post(Routes.postUser_url);
        return response;
    }

}
