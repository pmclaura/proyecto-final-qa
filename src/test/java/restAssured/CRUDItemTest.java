package restAssured;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CRUDItemTest {

    @Test
    public void verifyCreateProject(){
        //Auth
        JSONObject body= new JSONObject();

        Response response=given()
                .auth()
                .preemptive()
                .basic("mojix@gmail.com","12345")
                .body(body.toString())
                .log().all()
                .when()
                .get("https://todo.ly/api/authentication/token.json");

        response.then()
                .log().all()
                .statusCode(200)
                .body("UserEmail",equalTo("mojix@gmail.com"));

        String token = response.then().extract().path("TokenString");

        //Create Project
        body.put("Content","Bootcamp");

        response=given()
                .header("Token",token)
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/projects.json");

        response.then()
                .log().all()
                .statusCode(200)
                .body("Content",equalTo("Bootcamp"));

        int idProj = response.then().extract().path("Id");

        //CREATE Item
        body.put("Content","NewItem");
        body.put("ProjectId",idProj);

        response=given()
                .header("Token",token)
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/items.json");

        response.then()
                .log().all()
                .statusCode(200)
                .body("Content",equalTo("NewItem"));

        int idItem = response.then().extract().path("Id");

        //READ Item
        response=given()
                .header("Token",token)
                .log().all()
                .when()
                .get("https://todo.ly/api/items/"+idItem+".json");

        response.then()
                .log().all()
                .statusCode(200)
                .body("Content",equalTo("NewItem"));

        //UPDATE Item
        body.put("Content","BootcampUpdateItem");
        body.put("Checked",true);
        response=given()
                .header("Token",token)
                .body(body.toString())
                .log().all()
                .when()
                .post("https://todo.ly/api/items/"+idItem+".json");

        response.then()
                .log().all()
                .statusCode(200)
                .body("Checked",equalTo(true))
                .body("Content",equalTo("BootcampUpdateItem"));

        //DELETE Item
        response=given()
                .header("Token",token)
                .body(body.toString())
                .log().all()
                .when()
                .delete("https://todo.ly/api/items/"+idItem+".json");

        response.then()
                .log().all()
                .statusCode(200)
                .body("Checked",equalTo(true))
                .body("Content",equalTo("BootcampUpdateItem"))
                .body("ProjectId",equalTo(idProj));

    }
}
