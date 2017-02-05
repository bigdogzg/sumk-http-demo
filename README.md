#sumk-http-demo
本工程用于展示sumk-http和sumk-orm的最基础功能。用html模拟移动端的接口调用。
本工程是普通java项目，使用内置的jetty容器提供http功能。
如果你喜欢tomcat方式，请参考"改为tomcat项目"
<BR>
本人不做前端很久了，界面很丑，将就着看吧^_^

###普通项目搭建（此方式不需要tomcat）：
1. 在mysql客户端执行test.sql文件，创建demouser表，以便测试
1. 导入sumk-http-demo到本地eclipse中，文件编码是UTF-8
1. 在src/db/sumk.ini中配置数据库的地址、用户名、密码。
1. 执行com.test.Main类，启动web服务器。sumk内置了jetty，不需要tomcat。

###改为tomcat项目：
如果你想把本项目放置在tomcat容器下，可采用以下步骤进行迁移(不需要上述的那些步骤）:<BR>

1. 在mysql客户端执行test.sql文件，创建demouser表，以便测试
1. 创建一个普通tomcat项目，文件编码是UTF-8
1. 将src文件夹下的文件，复制到tomcat项目中
1. 在app.properties文件中，删除 http.port=8080 和 http.resource=web
1. 在src/db/sumk.ini中配置数据库的地址、用户名、密码。
1. 复制libs/sumk-core底下的所有jar包，以及libs/http下的commons-io-2.2.jar、commons-fileupload-1.3.1.jar包到tomcat工程里
1. 复制web目录下的文件到tomcat的发布目录中
1. 在web.xml中添加<br>
```
<listener>
     <listener-class>org.yx.main.SumkLoaderListener</listener-class>
</listener>
```
完成以上操作后，只需要启动tomat容器，就可以启动本demo

###app.properties文件说明：
1. sumk.ioc：需要被ioc扫描的包，会解析@Bean、@Inject、@Table等注解（必须）
1. http：需要扫描@Web、@Login等http注解的包（必须，否则就不会启动web服务）
1. http.port：jetty的http的端口号。如果使用tomcat等外部容器，请去掉本属性
1. http.resource：静态资源的路径，既可以是相对路径，也可以是绝对路径。在正式环境上，推荐使用绝对路径。因为相对路径会受部署环境影响（可选，仅在使用内置jetty时才有效）

###jar包说明：
* libs/sumk-core下面的包，只要你有使用sumk.jar，就要引入这些包。如果想使用log4j，可以去掉jcl-over-slf4j-1.7.21.jar和slf4j-simple-1.7.21.jar包
* libs/http是sumk-http需要依赖的包。提供类似tomcat的功能

###登陆以及获取用户信息：
http://localhost:8080/intf/user.html

###插入及查询：
http://localhost:8080/intf/db.html