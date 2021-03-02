package org.springframework.boot;

/**
 *
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration}
 * 常用的 自动配置
 *
 * servlet 相关
 * {@link org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration}
 *          @Import {@link org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryConfiguration}
 *              @Bean  加载 servletWeb 容器工厂  {@link org.springframework.boot.web.servlet.server.ServletWebServerFactory#getWebServer(ServletContextInitializer...)}
 *                            获取出 {@link WebServer} 例如 {@link org.springframework.boot.web.embedded.tomcat.TomcatWebServer}
 *                              在 {@link ServletWebServerApplicationContext#createWebServer()} 中被运用
 *
 *
 * jpa 相关
 * {@link org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration}
 *          @Import {@link JpaRepositoriesRegistrar#registerBeanDefinitions(AnnotationMetadata, BeanDefinitionRegistry, BeanNameGenerator)}
 * {@link org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration}
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * @author : zyb
 * 时间 : 2020/8/6 17:05.
 */
public class EnableAutoConfigInfo {
}
