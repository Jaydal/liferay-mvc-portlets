package CityProfileLoader.portlet;

import CityProfileLoader.constants.CityProfileLoaderPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

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
		"javax.portlet.name=" + CityProfileLoaderPortletKeys.CityProfileLoader,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CityProfileLoaderPortlet extends MVCPortlet {
	private final static String _URL="https://api.registry-staging.apps.gov.ph:8044/registries/City_Profile/records";
	private final static String USERNAME="joseph";
	private final static String PASSWORD="password";
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		connectRemote();
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
	}
	
	void connectRemote() throws IOException {
		URL url = new URL(_URL);
		URLConnection uc = url.openConnection();
		String userpass = USERNAME + ":" + PASSWORD;
		String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
		uc.setRequestProperty ("Authorization", basicAuth);
		InputStream in = uc.getInputStream();
		System.out.println("No Error!");
		
	}
}