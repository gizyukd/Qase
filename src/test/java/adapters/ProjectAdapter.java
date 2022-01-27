package adapters;

import models.Project;
import models.ResponseStatus;

public class ProjectAdapter extends BaseAdapter{

    public ResponseStatus post(Project project, int statusCode){
        String response = super.post(gson.toJson(project, Project.class), statusCode, "project");
        return gson.fromJson(response, ResponseStatus.class);
    }

    public ResponseStatus getProject(int statusCode, String codeProject){
        // в адаптере будет только 6 методов(т.к в апи доукментации для projects 6 запросов разных)
        return gson.fromJson(super.get(statusCode, "project/" + codeProject), ResponseStatus.class);
    }
}
