DataSource是和线程绑定的，动态数据源的配置主要是通过继承AbstractRoutingDataSource类实现的，
实现在AbstractRoutingDataSource类中的 protected Object determineCurrentLookupKey()方法来获取数据源，
所以我们需要先创建一个多线程线程数据隔离的类来存放DataSource，然后在determineCurrentLookupKey()方法中
通过这个类获取当前线程的DataSource，在AbstractRoutingDataSource类中，DataSource是通过Key-value的方式保存的，
我们可以通过ThreadLocal来保存Key，从而实现数据源的动态切换。
1、修改配置文件类 , 加多个数据源
src/main/resources/application.properties
2、创建数据源枚举类，
com/kfy/multipledatasource/dynamicDataSource/DataSourceType.java
3、数据源切换处理，
com/kfy/multipledatasource/dynamicDataSource/DynamicDataSourceContextHolder.java
4、继承AbstractRoutingDataSource
com/kfy/multipledatasource/dynamicDataSource/DynamicDataSource.java
5、注入数据源
com/kfy/multipledatasource/dynamicDataSource/DataSourceConfig.java
6、自定义多数据源切换注解
com/kfy/multipledatasource/dynamicDataSource/MultipleDataSource.java
7、AOP拦截类的实现
com/kfy/multipledatasource/dynamicDataSource/DataSourceAspect.java
8、使用切换数据源注解
com/kfy/multipledatasource/dynamicDataSource/UserController.java
9、掉排除springboot其自动配置类，不然会报循环引用的错误，
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) 

===============
测试多数据切换，只需要dynamicDataSource包，其他包可以删除。