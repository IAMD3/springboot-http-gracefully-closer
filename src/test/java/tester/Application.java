package tester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import tyk.springboot.closer.KillSignalProcessor;

import javax.jws.WebService;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;


@SpringBootApplication
//@Import(KillSignalProcessor.class)
public class Application {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ConfigurableApplicationContext app = SpringApplication.run(Application.class, args);
        ServletWebServerApplicationContext appServlet = (ServletWebServerApplicationContext) app;
    }

}
