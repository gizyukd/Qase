package adapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    Gson gson = new Gson();

    public String post(String body, int statusCode, String url){//вместо урла было codeProject

        return given().
                log().all().
                header("Token", "90a17697e9272f0bb8faf4114230b49a0aedd325").
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body(body).
        when().
                post("https://api.qase.io/v1/" + url).
        then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();
    }

    public String get(int statusCode, String url){

        return given().
                log().all().
                header("Token", "90a17697e9272f0bb8faf4114230b49a0aedd325").
                header("Content-Type", "application/json").
        when().
                get("https://api.qase.io/v1/" + url).
        then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();
    }
}
