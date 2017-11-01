Title         : Welcome
Author        : MrPei
Logo          : True


# tweet 

## 关于
`tweet`是一个类似百度贴吧的吐槽平台，注册用户可以发布图文吐槽贴，评论，点赞。<br>
游客可以无限制访问已发布的内容。

##说明

###tweet 为API接口服务程序，负责从数据库获取数据返回给客户端，将客户端用户发的数据持久化.<br>
环境参数：Nginx Tomcat SpringMVC Spring Mybatis Redis <br>

###tweetadmin 为服务端管理系统，负责监控服务运行状态，查看当前所有数据，对内容进行审查，违规内容进行处理。
环境参数：Nginx Tomcat SpringBoot Mybatis <br>

## 补充
目前 Android客户端正在开发中，原生开发，后期考虑用ReactNative整合Android IOS