package clickUp;

import org.apache.http.util.EntityUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.entity.StringEntity;
import org.json.JSONObject;
import org.json.JSONArray;

public class createTask {

    public static void createClickUpTask(String taskName, String taskDescription) throws java.io.IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();

        String listId = "174680483";
        HttpPost request = new HttpPost("https://api.clickup.com/api/v2/list/" + listId + "/task?custom_task_ids=true&team_id=36607994");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", "pk_88800087_F2NBC795ZOSXU5G4FEH8MD1X0VM6A9SE");

        JSONObject payload = new JSONObject();
        payload.put("name", taskName);
        payload.put("description", taskDescription);
        payload.put("status", "in progress");
        payload.put("priority", 1);  // 1,2,3,4

        JSONArray assigneesArray = new JSONArray();
        assigneesArray.put(50201528);
        payload.put("assignees", assigneesArray);

        payload.put("due_date", JSONObject.NULL);
        payload.put("due_date_time", false);
        payload.put("time_estimate", JSONObject.NULL);
        payload.put("start_date", JSONObject.NULL);
        payload.put("start_date_time", false);
        payload.put("notify_all", true);
        payload.put("parent", JSONObject.NULL);
        payload.put("links_to", JSONObject.NULL);
        payload.put("check_required_custom_fields", true);

        request.setEntity(new StringEntity(payload.toString()));
        String response = EntityUtils.toString(httpClient.execute(request).getEntity());

        System.out.println("ClickUp Task created with response: " + response);
    }
}
