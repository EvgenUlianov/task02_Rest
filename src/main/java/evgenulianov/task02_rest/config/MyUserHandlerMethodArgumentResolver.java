package evgenulianov.task02_rest.config;

import evgenulianov.task02_rest.model.MyUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

public class MyUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ConvertToUser.class) != null;
    }

    @Override
    public MyUser resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) {
        HttpServletRequest request
                = (HttpServletRequest) webRequest.getNativeRequest();
        String userName = request.getParameter("user");
        String password = request.getParameter("password");
        return new MyUser(userName, password);
    }
}
