package tyk.springboot.closer;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicBoolean;

public class HttpInterceptor extends HandlerInterceptorAdapter {
    public static AtomicBoolean closed = new AtomicBoolean(false);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(closed.get()){
            //http code 503
            response.sendError(503);
            response.getWriter().flush();
            return false;
        }
        return true;
    }
}
