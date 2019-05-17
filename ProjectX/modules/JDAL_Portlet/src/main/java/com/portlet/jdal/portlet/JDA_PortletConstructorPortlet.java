package com.portlet.jdal.portlet;

import com.portlet.jdal.constants.JDA_PortletConstructorPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import org.osgi.service.component.annotations.Component;
/**
 * @author ASUS
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + JDA_PortletConstructorPortletKeys.JDA_PortletConstructor,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class JDA_PortletConstructorPortlet extends MVCPortlet {
	String url="https://raw.githubusercontent.com/iGovPhil/igovphil.github.io/master/java-exam-01/uacs-agency.json";
	String uname="joseph";
	String pwd="password";
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		renderRequest.setAttribute("obj", MyGETRequest());
//		ParseJSON(MyGETRequest());
		super.doView(renderRequest, renderResponse);
	}
	
	public String MyGETRequest() throws IOException {
	    URL urlForGetRequest = new URL(url);
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    conection.setRequestProperty(uname, pwd); // set userId its a sample here
	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        StringBuffer response = new StringBuffer();
	        while ((readLine = in .readLine()) != null) {
	            response.append(readLine);
	        } in .close();
	        // print result
	        System.out.println("JSON String Result " + response.toString());
	        return response.toString();
	        //GetAndPost.POSTRequest(response.toString());
	    } else {
	        System.out.println("GET NOT WORKED");
	        return "";
	    }
	}
//	void ParseJSON(String jsonStr) {
//		JSONArray jsonarray = new JSONArray(jsonStr);
//		for (int i = 0; i < jsonarray.length(); i++) {
//		    JSONObject jsonobject = jsonarray.getJSONObject(i);
//		    String department = jsonobject.getString("department");
//		    System.out.println(department);
//		    
//		}
//	}
}