package com.example.springcloud.zuuldemo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import io.micrometer.core.instrument.util.JsonUtils;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.asn1.ocsp.ResponseData;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lixiaofeng
 * @date 2019/11/21
 */
public class IPFilter extends ZuulFilter {
    // IP黑名单列表
    private List<String> blackIpList = Arrays.asList("127.0.0.1");
    public IPFilter() {
        super();
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }
    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 1;
    }
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        //可向后面的过滤器传递数据
        ctx.set("msg","msg");
        String ip = "";//IpUtils.getIpAddr(ctx.getRequest());
        // 在黑名单中禁用
        if (StringUtils.isNotBlank(ip) &&
                blackIpList.contains(ip)) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseBody("非法请求");
            ctx.getResponse(). setContentType(
                    "application/json; charset=utf-8");
            return null;
        }
        return null;
    }

}
