
package com.goat.interceptor;

import com.goat.annotation.PassToken;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


/**
     * @Description:
     * @author: Goat
     * http://localhost:8203/random1
     * @Date:   2018/11/12
*/
@Component
public class CustomInterceptor1 implements HandlerInterceptor {

    /**
     * 进入controller方法之前
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) {
        System.out.println("CustomInterceptor1拦截器开始工作，拦截到当前请求地址：" + httpServletRequest.getRequestURL().toString());
        if(!(o instanceof HandlerMethod)){  // 如果不是映射到方法直接通过
            return true;
        }
        HandlerMethod methods = (HandlerMethod) o;
        Method method=methods.getMethod();
        //检查是否有 passtoken 注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        System.out.println("-- MethodName:" + methods.getMethod().getName());
        System.out.println("-- ReturnType:" + methods.getMethod().getReturnType());
        System.out.println("-- MethodParameters:" + methods.getMethodParameters());
        MethodParameter[] parameters = methods.getMethodParameters();
        if (null != parameters) {
            for (MethodParameter parameter : parameters) {
                System.out.println("  -- parameterIndex:" + parameter.getParameterIndex() + ",parameterName:" + parameter.getParameterName() + ",parameterType:" + parameter.getParameterType());
            }
        }
        // 只有返回true才会继续向下执行，返回false取消当前请求
        return true;
    }

    /**
     * 调用完controller之后，视图渲染之前
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {
        System.out.println("CustomInterceptor.postHandle:" + o + ", modelAndView:" + modelAndView);
    }

    /**
     * 整个完成之后，通常用于资源清理
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e)  {
        // 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
        System.out.println("CustomInterceptor.afterCompletion:" + o);
        // 清理session
//        HttpSession session = httpServletRequest.getSession();
//        Map<String, Object> map = (Map<String, Object>) session.getAttribute("map1");
//        if (! CollectionUtils.isEmpty(map)) {
//            session.removeAttribute("map1");
//            System.out.println("清理map1...");
//        }
//        System.out.println("afterCompletion资源清理完成...");
    }
}
