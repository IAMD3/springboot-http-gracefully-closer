package tyk.springboot.closer;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class KillSignalProcessor implements ApplicationListener<ContextClosedEvent>, WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");

    }

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.err.println("signal processor: received TERM signal");
        HttpInterceptor.closed.compareAndSet(false, true);
    }
}
