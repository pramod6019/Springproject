package axela.config;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.beans.factory.annotation.Autowired;

@WebListener
public class Session_Listener implements HttpSessionListener {

	@Autowired
	HttpSession session;
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("SessionListener======sessionCreated============");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("SessionListener======sessionDestroyed============");
	}

}
