import adapters.ProjectAdapter;
import models.Project;
import models.ResponseStatus;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class apiTest {

    @Test
    public void negativeApiTest(){
        Project project = Project.builder()
                .title("Blabla")
                .code("!!!!!")
                .build();

        ResponseStatus actual = new ProjectAdapter().post(project,422);

        ResponseStatus expected = ResponseStatus.builder()
                .status(false)
                .errorMessage("Data is invalid.")
//                .errorFields(ErrorFields.builder()
//                        .field("code")
//                        .error("Project code can contain only latin alphabet symbols.")
//                        .build())
                .build();

        assertEquals(actual, expected);
        assertEquals(actual.isStatus(), expected.isStatus());
        assertEquals(actual.getErrorMessage(), expected.getErrorMessage());
    }

    @Test
    public void getProjectWithWrongTest(){

        ResponseStatus actual = new ProjectAdapter().getProject(404, "WRONGCODE");
        System.out.println(actual);

        ResponseStatus expected = ResponseStatus.builder()
                .status(false)
                .errorMessage("Project is not found.")
                .build();

        assertEquals(actual.getErrorMessage(), expected.getErrorMessage());
    }

    @Test
    public void getEmptyProject(){

        ResponseStatus actual = new ProjectAdapter().getProject(200, "GOLDEMPTY");
        System.out.println(actual);

        ResponseStatus expected = ResponseStatus.builder()
                .status(true)
                .cases(0)
                .build();

        assertEquals(actual.getCases(), expected.getCases());
    }

    @Test
    public void getWithOneCaseProject(){

        ResponseStatus actual = new ProjectAdapter().getProject(200, "GOLDWITHCA");
        System.out.println(actual);

        ResponseStatus expected = ResponseStatus.builder()
                .status(true)
                .cases(1)
                .build();

        assertEquals(actual.getCases(), expected.getCases());
    }

//    @Test
//    public void positiveApiTest(){
//        Project project = Project.builder()
//                .title("ForApiTestproject")
//                .code("QWERTY")
//                .build();
//
//        String actual = new ProjectAdapter().post(project, 200);
//
//        assertEquals(actual, "{\"status\":true,\"result\":{\"code\":\"QWERTY\"}}");
//
//        given().
//                header("Token", "90a17697e9272f0bb8faf4114230b49a0aedd325").
//                header("Content-Type", "application/json").
//                body("{\"title\" : \"ForApiTestproject\", \"code\" : \"QWERTY\"}").
//                log().all().
//        when().
//                log().all().
//                post("https://api.qase.io/v1/project").
//        then().
//                statusCode(200).
//                log().all().
//                body("status", equalTo(true)).
//                body(equalTo("[status:true, result:[code:QWERTY]]"));
//
//    }
}
