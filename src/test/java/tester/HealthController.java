package tester;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

@RequestMapping
@RestController
public class HealthController {

    @Autowired
    private Executor asyncServiceExecutor;
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(value = "/ok", method = { RequestMethod.GET})
    public int status() throws InterruptedException {
       Executor bean = applicationContext.getBean(Executor.class);
        Thread.sleep(5);
        return 1;
    }


}
