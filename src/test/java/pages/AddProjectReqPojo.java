package pages;

public class AddProjectReqPojo {
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
    private AddTaskPojo data;

    @Override
    public String toString() {
        return "AddProjectReqPojo{" +
                "data=" + data +
                '}';
    }

    public AddTaskPojo getData() {
        return data;
    }

    public void setData(AddTaskPojo data) {
        this.data = data;
    }

    public AddProjectReqPojo(AddTaskPojo data) {
        this.data = data;
    }
}
