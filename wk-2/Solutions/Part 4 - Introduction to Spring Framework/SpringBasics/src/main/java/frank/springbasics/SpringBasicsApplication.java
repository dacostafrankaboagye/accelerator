package frank.springbasics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringBasicsApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		MessagePrinter printer = ctx.getBean(MessagePrinter.class);

		printer.printMessage();
	}

}
