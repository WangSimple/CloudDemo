package org.simple.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

public class AccessFiter extends ZuulFilter {

    /**
     *  filterType：
     * pre 请求被路由之前被调用（一般做一些前置加工）
     * route 在路由请求时调用（将外部请求转发到具体的服务实例上）
     * post 路由请求返回时调用（包装加工返回信息）
     * error 处理请求发生错误时调用
     * @return
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -5;
    }

    /**
     * true过滤，false不过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        System.out.println(request.getRequestURI());
        //不拦截，放行
        if ("/feign/feign/user/info".equalsIgnoreCase(request.getRequestURI())){
            return false;
        }
        return true;

    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String remoteAddr = request.getRemoteAddr();
        System.out.println("访问者IP："+remoteAddr+"访问地址:"+request.getRequestURI());
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            //返回错误信息
            context.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            context.setResponseBody(HttpStatus.UNAUTHORIZED.getReasonPhrase());
            context.setSendZuulResponse(false);
            return null;
        }
        return null;
    }
}
