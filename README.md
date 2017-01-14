#sumk-http-demo
本工程用于展示sumk-http和sumk-orm的最基础功能。用html模拟移动端的接口调用。<BR>
本人不做前端很久了，界面很丑，将就着看吧^_^

###项目搭建：
1. 导入sumk-http-demo到本地eclipse中，文件编码是UTF-8
1. 在mysql客户端执行test.sql文件，创建demouser表，以便测试
1. 在src/db/sumk.ini中配置数据库的地址、用户名、密码。
1. 执行com.test.Main类，启动web服务器。sumk内置了jetty，不需要tomcat

###app.properties文件说明：
1. sumk.ioc：需要被ioc扫描的包，会解析@Bean、@Inject、@Table等注解（必须）
1. http：需要扫描@Web、@Login等http注解的包（必须，否则就不会启动web服务）
1. http.port：http的端口号（必须）
1. http.resource：静态资源的路径，既可以是相对路径，也可以是绝对路径。在正式环境上，推荐使用绝对路径。因为相对路径会受部署环境影响（可选）

###jar包说明：
* libs/sumk-core下面的包，只要你有使用sumk.jar，就要引入这些包。如果想使用log4j，可以去掉jcl-over-slf4j-1.7.21.jar和slf4j-simple-1.7.21.jar包
* libs/http是sumk-http需要依赖的包。其作用相当于tomcat

###登陆以及获取用户信息：
http://localhost:8080/intf/user.html

###插入及查询：
http://localhost:8080/intf/db.html