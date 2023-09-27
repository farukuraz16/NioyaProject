package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Stepdefinitions {
    public RequestSpecification specification;
    public static Response response;
    //public static String projectGid;
    //public static String taskGid;
    public static List<String> projectsDataList = new ArrayList<>();
    public static List<String> tasksDataList = new ArrayList<>();
    public static JsonPath jsonPath;

    public static Map<String, Object> actualDataMap = new HashMap<>();
    public static Map<String, String> projectsDataMap = new HashMap<>();
    public static Map<String, String> tasksDataMap = new HashMap<>();
    public static String token = "1/1205543491884173:59c403d909d21bf0455d3cffe8db0327";


    @Given("User sets the URL {string}")
    public void userSetsTheURL(String baseURL) {
        specification = new RequestSpecBuilder().setBaseUri(baseURL).build();
    }

    @When("create project with workspace gid {string} project name {string} postPath {string}")
    public void createProjectWithWorkspaceGidProjectNamePostPath(String workspaceGid, String projectName, String postPath) {
      /* https://app.asana.com/api/1.0/projects
                {
                "data": {
                        "workspace": "123456",
                        "name": "Marvel"}    */

        specification.pathParam("postPath", postPath);

        ProjectPojo projectPojo = new ProjectPojo(workspaceGid, projectName);
        ProjectReqPojo projectReqPojo = new ProjectReqPojo(projectPojo);
        System.out.println("projectPojo = " + projectPojo);

        response = given().
                spec(specification).
                body(projectReqPojo).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).
                when().post("/{postPath}");

        actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);
        Map<String, Object> dataMap = (Map<String, Object>) actualDataMap.get("data");
        String projectGid = (String) dataMap.get("gid");
        System.out.println("projectGid = " + projectGid);

        projectsDataMap.put(projectName,projectGid);
        System.out.println("projectsDataMap = " + projectsDataMap);
        projectsDataList.add(projectGid);
        System.out.println("projectsDataList = " + projectsDataList);

        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }


    @Then("assert the new project {string}")
    public void assertTheNewProject(String arg0) {
        response.then().assertThat().statusCode(Integer.parseInt(arg0));

    }
        /*
{
  "data": {
    "workspace": "12345",
    "name": "ironman"
  }
}
         */

    @When("create task with workspace gid {string} and task name {string} postPath {string} addPath {string}")
    public void createTaskWithWorkspaceGidAndTaskNamePostPathAddPath(String workspaceGid, String taskName, String postPath, String addPath) {

        //https://app.asana.com/api/1.0/tasks
        specification.pathParam("postPath", postPath);

        ProjectPojo projectPojo = new ProjectPojo(workspaceGid, taskName);
        TaskReqPojo taskReqPojo = new TaskReqPojo(projectPojo);

        System.out.println("projectPojo = " + projectPojo);

        response = given().
                spec(specification).
                body(taskReqPojo).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).
                when().post("/{postPath}");

        actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);
        Map<String, Object> dataMap = (Map<String, Object>) actualDataMap.get("data");
        String taskGid = (String) dataMap.get("gid");
        System.out.println("taskGid = " + taskGid);

        tasksDataMap.put(taskName,taskGid);
        System.out.println("tasksDataMap = " + tasksDataMap);

        tasksDataList.add(taskGid);
        System.out.println("tasksDataList = " + tasksDataList);

        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }


    @Then("assert the new task {string}")
    public void assertTheNewTask(String arg0) {
        response.then().assertThat().statusCode(Integer.parseInt(arg0));

    }

    @Then("assert the task deleted {string}")
    public void assertTheTaskDeleted(String arg0) {
        response.then().assertThat().statusCode(Integer.parseInt(arg0));

    }



    @Then("assert the project deleted {string}")
    public void assertTheProjectDeleted(String arg0) {
        response.then().assertThat().statusCode(Integer.parseInt(arg0));
    }


    @When("add task to project {int} and task {int} postPath {string} addPath {string}")
    public void addTaskToProjectAndTaskPostPathAddPath(int projectNo, int taskNo, String postPath, String addPath) {
        // ProjectPojo projectPojo = new ProjectPojo(workspaceGid, taskName);
        // TaskReqPojo taskReqPojo = new TaskReqPojo(projectPojo);
        String projectGid = projectsDataList.get(projectNo-1);
        System.out.println("projectGid = " + projectGid);
        String taskGid = tasksDataList.get(taskNo-1);
        System.out.println("taskGid = " + taskGid);

        AddTaskPojo addTaskPojo = new AddTaskPojo(projectGid);
        AddProjectReqPojo addProjectReqPojo = new AddProjectReqPojo(addTaskPojo);

//https://app.asana.com/api/1.0/tasks/{task_gid}/addProject

        specification.pathParams("postPath", postPath, "task_gid", taskGid, "addProject", addPath);

        response = given().
                spec(specification).
                body(addProjectReqPojo).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).
                when().post("/{postPath}/{task_gid}/{addProject}");


        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }

    @When("delete task {int} postPath {string}")
    public void deleteTaskPostPath(int taskNo, String postPath) {
        String taskGid = tasksDataList.get(taskNo-1);
        specification.pathParams("postPath", postPath, "task_gid", taskGid);
        https:
//app.asana.com/api/1.0/tasks/{task_gid}

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).
                when().delete("/{postPath}/{task_gid}");

        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }

    @When("delete project {int} with project postPath {string}")
    public void deleteProjectWithProjectPostPath(int projectNo, String postPath) {
        //https://app.asana.com/api/1.0/projects/{project_gid}
        String projectGid = projectsDataList.get(projectNo-1);

        specification.pathParams("postPath", postPath, "projectGid", projectGid);

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).
                when().delete("/{postPath}/{projectGid}");

        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }

    @When("add task to project {string} and task {string} postPath {string} addPath {string}")
    public void addTaskToProjectAndTaskPostPathAddPath(String projectName, String taskName, String postPath, String addPath) {
        // ProjectPojo projectPojo = new ProjectPojo(workspaceGid, taskName);
        // TaskReqPojo taskReqPojo = new TaskReqPojo(projectPojo);

        String projectGid = projectsDataMap.get(projectName);
        System.out.println("projectGid = " + projectGid);
        String taskGid = tasksDataMap.get(taskName);
        System.out.println("taskGid = " + taskGid);

        AddTaskPojo addTaskPojo = new AddTaskPojo(projectGid);
        AddProjectReqPojo addProjectReqPojo = new AddProjectReqPojo(addTaskPojo);
        System.out.println("addProjectReqPojo = " + addProjectReqPojo);

//https://app.asana.com/api/1.0/tasks/{task_gid}/addProject

        specification.pathParams("postPath", postPath, "task_gid", taskGid, "addProject", addPath);

        response = given().
                spec(specification).
                body(addProjectReqPojo).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).
                when().post("/{postPath}/{task_gid}/{addProject}");


        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }

    @When("delete task {string} postPath {string}")
    public void deleteTaskPostPath(String taskName, String postPath) {
        String taskGid = tasksDataMap.get(taskName);

        specification.pathParams("postPath", postPath, "task_gid", taskGid);
        //app.asana.com/api/1.0/tasks/{task_gid}

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).
                when().delete("/{postPath}/{task_gid}");

        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }

    @When("delete project {string} postPath {string}")
    public void deleteProjectPostPath(String projectName, String postPath) {
        String projectGid = projectsDataMap.get(projectName);

        specification.pathParams("postPath", postPath, "projectGid", projectGid);
        //https://app.asana.com/api/1.0/projects/{project_gid}

        response = given().
                spec(specification).
                contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).
                when().delete("/{postPath}/{projectGid}");

        System.out.println("RESPONSE Board Creation: ");
        response.prettyPrint();
    }
}


