//Pramod
package axela.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInit {

	@RequestMapping("/")
	public void init(HttpServletRequest request) {

		System.out.println("1235");

		// ConfigurableApplicationContext Context = new AnnotationConfigApplicationContext();
		// AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();

		// String prefix = System.getProperty("wtp.deploy");
		// String file = System.getProperty("logging.file");
		System.out.println("prefix==" + request.getServletContext().getRealPath("/"));
		// System.setProperty("logging.file", prefix + "/axelacrm/WEB-INF/logs/axela.log");
		// System.out.println("LOG===" + System.getProperty("wtp.deploy"));
		// // if the log4j-init-file context parameter is not set, then no point in trying
		// if (file != null) {
		// PropertyConfigurator.configure(prefix + file);
		// System.out.println("Log Logging started: " + prefix + file);
		// }
		// else {
		// System.out.println("Log Is not configured for your Application: " + prefix + file);
		// }
		// System.out.println("current direct==" + System.getProperty("logging.file"));

	}
}
