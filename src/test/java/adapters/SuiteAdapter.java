package adapters;

import models.Project;

public class SuiteAdapter extends BaseAdapter{

    public String post(Project project, int statusCode, String codeProject){

        return super.post(gson.toJson(project, Project.class), statusCode, "/suite" + codeProject);
    }
}
