package cn.mrpei.tweetadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Create by 裴周宇
 * Date:2017/10/5
 * Time:15:25
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("Public/login");
       // registry.addViewController("/index").setViewName("index");
        //转发默认请求到主页面
        registry.addRedirectViewController("/","/index");
    }
}
