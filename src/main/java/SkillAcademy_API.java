import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SkillAcademy_API {


    @Test(groups = "GET", description = "using Search Query, page = 0, page size = 0")
    public void GET_Search_Query(){

        RestAssured.baseURI = "https://skillacademy.com";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("page","15")
                .param("pageSize","0")
                .param("searchQuery","Keyword");
//                .param("minPrice","-")
//                .param("maxPrice","-")
//                .param("minDuration","-")
//                .param("maxDuration","-")
//                .param("sortBy","-")
//                .param("orderBy","");
        Response response = httpRequest.request(Method.GET, "/api/skillacademy/discovery/search");

        int statusCode = response.getStatusCode();
        ResponseBody body = response.getBody();

        body.prettyPrint();
        Reporter.log(body.prettyPrint());
        System.out.println("Response status code is "+statusCode);
        Assert.assertEquals(response.getStatusCode(), 200);


        Headers header = response.getHeaders();
        System.out.println("Headers of the response body are "+header);

    }


    @Test(groups = "GET", description = "using min price = 0 - maxprice = 200000")
    public void GET_Search_Price(){

        RestAssured.baseURI = "https://skillacademy.com";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("page","0")
                .param("pageSize","0")
//                .param("searchQuery","Keyword")
                .param("minPrice","0")
                .param("maxPrice","200000");
//                .param("minDuration","-")
//                .param("maxDuration","-")
//                .param("sortBy","-")
//                .param("orderBy","");
        Response response = httpRequest.request(Method.GET, "/api/skillacademy/discovery/search");

        int statusCode = response.getStatusCode();
        ResponseBody body = response.getBody();

        body.prettyPrint();
        Reporter.log(body.prettyPrint());
        System.out.println("Response status code is "+statusCode);
        Assert.assertEquals(response.getStatusCode(), 200);


        Headers header = response.getHeaders();
        System.out.println("Headers of the response body are "+header);

    }

    @Test(groups = "GET", description = "using max duration = 3 hours")
    public void GET_Search_Duration(){

        RestAssured.baseURI = "https://skillacademy.com";

        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.param("page","0")
                .param("pageSize","0")
//                .param("searchQuery","Keyword")
//                .param("minPrice","0")
//                .param("maxPrice","200000")
//                .param("minDuration","-")
                .param("maxDuration","3");
//                .param("sortBy","-")
//                .param("orderBy","");
        Response response = httpRequest.request(Method.GET, "/api/skillacademy/discovery/search");

        int statusCode = response.getStatusCode();
        ResponseBody body = response.getBody();

        body.prettyPrint();
        Reporter.log(body.prettyPrint());
        System.out.println("Response status code is "+statusCode);
//        String courseDescription = response.getBody().jsonPath().getJsonObject("courseDescription");
//        System.out.println(courseDescription);
        Assert.assertEquals(response.getStatusCode(), 200);


        Headers header = response.getHeaders();
        System.out.println("Headers of the response body are "+header);

    }

}