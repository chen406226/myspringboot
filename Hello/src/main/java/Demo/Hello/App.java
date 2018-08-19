package Demo.Hello;

/**
 * Hello world!
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

import Demo.Hello.servlet.MyServlet;

@SpringBootApplication
@ServletComponentScan //启动servlet扫描第二种方法的
public class App {
//
//	@Bean
//	public ServletRegistrationBean myServlet1() {
//		return new ServletRegistrationBean(new MyServlet(), "/myservlet");
//	}
//	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}