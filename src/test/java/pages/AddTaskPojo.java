package pages;

public class AddTaskPojo {

    private String project;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public AddTaskPojo(String project) {
        this.project = project;
    }
    @Override
    public String toString() {
        return "AddTaskPojo{" +
                "project='" + project + '\'' +
                '}';
    }
}
