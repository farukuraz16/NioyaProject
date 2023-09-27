package pages;

public class ProjectPojo {
    /*
  curl --request POST \
     --url https://app.asana.com/api/1.0/projects \
     --header 'accept: application/json' \
     --header 'authorization: Bearer 1/1205543491884173:59c403d909d21bf0455d3cffe8db0327' \
     --header 'content-type: application/json' \
     --data '
{
  "data": {
    "name": "Marvel",
    "workspace": "1205543498728328"
  }
}
'
     */
    private String workspace;
    private String name;

    @Override
    public String toString() {
        return "ProjectPojo{" +
                "workspace='" + workspace + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public ProjectPojo(String workspace, String name) {
        this.workspace = workspace;
        this.name = name;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
