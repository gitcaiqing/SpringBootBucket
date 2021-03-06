package com.caiqing.bootvue;


import org.apache.jasper.servlet.JspServlet;
import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.annotation.WebServlet;

/**
 * 配置这个servlet是为了覆盖默认的jasper解析器的映射路径
 * 因为springboot默认是不直接支持jsp的
 * 必须添加额外的解析器支持，额外的解析器默认也不支持直接 xxx.jsp访问jsp必须通过controller访问
 * 所以覆盖JspServlet的映射路径 就可以直接通过url访问xxx.jsp文件并解析了
 * 同时 需要注意的是 在Springboot框架中，访问静态资源默认的web项目根目录对应的是
 * classpath:static classpath:WEB-INF/resources classpath:public 等
 * 而对于原生的servlet来说 web项目的根目录是不一样的 对应的是classpath:/ 或者 部署在Tomcat webapps底下具体webapp对应文件夹的根目录
 */
@ServletComponentScan
@WebServlet(urlPatterns = "*.jsp", name = "rqjspServlet")
public class rqJspServlet extends JspServlet {
}
