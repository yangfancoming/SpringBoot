# springboot  添加 启动外置Tomcat 配置步骤

    第一步：工程的打包方式为war。
    
    第二步：将spring-boot-starter-tomcat的范围设置为provided，设置为provided是在打包时会将该包排除，因为要放到独立的tomcat中运行，是不需要的。
    
    第三步：修改代码，设置启动配置。需要集成SpringBootServletInitializer，然后重写configure，将Spring Boot的入口类设置进去。
    
    
    
#  项目启动后 默认访问 页面路径 为 WEB-INF/index.jsp
