package api.endpoints;

// api URLs
public class Routes {

    public static String baseUrl = "https://petstore3.swagger.io/api/v3";

    // User Model
    public static String postUser_url = baseUrl +  "/user";
    public static String getUser_url = baseUrl + "/user/{username}";
    public static String updateUser_url = baseUrl + "/user/{username}";
    public static String deleteUser_url = baseUrl + "/user/{username}";
    public static String loginUser_url = baseUrl + "/user/login";
    public static String logoutUser_url = baseUrl + "/user/logout";
    public static String postUserList_url = baseUrl + "/user/createWithList";
    // Store Model
    public static String getStoreInventory_url = baseUrl + "/store/inventory";
    public static String postOrderInStore_url = baseUrl + "/store/order";
    public static String getOrderFromStore_url = baseUrl + "/store/order/{order}";
    public static String deleteOrderFromStore_url = baseUrl + "/store/order/{order}";
    // Pet Model
    public static String postPet_url = baseUrl + "/pet";
    public static String updatePet_url = baseUrl + "/pet";
    public static String getPet_url = baseUrl + "/pet/{petId}";
    public static String deletePet_url = baseUrl + "/pet/{petId}";
//    upload image in responseBody
//    public static String postPetImage_url = baseUrl + "/pet/{petId}/uploadImage";
}
