1

```java
java.lang.NoSuchMethodError: org.apache.tomcat.InstanceManager.backgroundProcess()V
	at org.apache.catalina.core.StandardContext.backgroundProcess(StandardContext.java:5556)
	at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1353)
	at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1357)
	at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1357)
	at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.run(ContainerBase.java:1335)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.runAndReset(FutureTask.java:308)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$301(ScheduledThreadPoolExecutor.java:180)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:294)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)
	at java.lang.Thread.run(Thread.java:748)
```

2

```java
ERROR c.cody.blog.interceptor.ControllerExceptionHandler - Request URL : http://localhost:8080/admin/types, Exception : [org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.readWithMessageConverters(AbstractMessageConverterMethodArgumentResolver.java:225), org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.readWithMessageConverters(RequestResponseBodyMethodProcessor.java:158), org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor.resolveArgument(RequestResponseBodyMethodProcessor.java:131), org.springframework.web.method.support.HandlerMethodArgumentResolverComposite.resolveArgument(HandlerMethodArgumentResolverComposite.java:121), org.springframework.web.method.support.InvocableHandlerMethod.getMethodArgumentValues(InvocableHandlerMethod.java:167), org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:134), org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:105), org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:878), org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:792), org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87), org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040), org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943), org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006), org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909), javax.servlet.http.HttpServlet.service(HttpServlet.java:660), org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883), javax.servlet.http.HttpServlet.service(HttpServlet.java:741), org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231), org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166), org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53), org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193), org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166), org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100), org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119), org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193), org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166), org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93), org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119), org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193), org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166), org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201), org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119), org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193), org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166), org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202), org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97), org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541), org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143), org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92), org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78), org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343), org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374), org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65), org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868), org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1590), org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49), java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142), java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617), org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61), java.lang.Thread.run(Thread.java:748)]
2020-11-15 21:58:35.463 [http-nio-8080-exec-3] WARN  o.s.w.s.m.m.a.ExceptionHandlerExceptionResolver - Resolved [org.springframework.web.HttpMediaTypeNotSupportedException: Content type 'application/x-www-form-urlencoded;charset=UTF-8' not supported]
```

3

```java
错误：@Notblank无法使用
@requestBody无法使用
```



