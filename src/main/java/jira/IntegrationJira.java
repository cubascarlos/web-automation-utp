package jira;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

import static util.Util.getFromConfigFile;

public class IntegrationJira {
    private static final String JIRA_HOST = getFromConfigFile("jira.host");
    private static final String XRAY_PROJECT_KEY = getFromConfigFile("jira.xray.project.key");
    private static final String JIRA_USER_NAME = getFromConfigFile("jira.user.name");
    private static final String JIRA_PASSWORD = getFromConfigFile("jira.password");


    public void updateEvidence(){
        RestAssured.baseURI = JIRA_HOST;
        RestAssured.authentication = RestAssured.basic(JIRA_USER_NAME,JIRA_PASSWORD);

        

    }

//    private static void updateTestExecutionResults() {
//        String updateExecutionUrl = "/rest/raven/1.0/api/testexec/" + TEST_EXECUTION_ID + "/test";
//        String requestBody = "{ \"status\": \"PASS\", \"comment\": \"La prueba pasó exitosamente\" }";
//
//        Response response = RestAssured.given()
//                .contentType("application/json")
//                .body(requestBody)
//                .put(updateExecutionUrl);
//
//        System.out.println("Ejecución de prueba actualizada: " + response.getBody().asString());
//    }

}


