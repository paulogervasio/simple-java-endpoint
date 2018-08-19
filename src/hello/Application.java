package hello;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		Map<String, Object> mapProp = new HashMap<String, Object>();
		mapProp.put("server.port", "8085");
		

		SpringApplication app = new SpringApplication(Application.class);
		app.setDefaultProperties(mapProp);
		app.run(args);

	}
	

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Here you can inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
		/*	for (String beanName : beanNames) {
				System.out.println(beanName);
			}
*/
		};
	}

}