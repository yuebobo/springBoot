package org.springframework.boot;

/**
 * {@link SpringBootApplication} ==> {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration}==> {@link org.springframework.boot.autoconfigure.AutoConfigurationImportSelector#selectImports} ==> META-INF/spring.factories
 *                                     《A》 ==> {@link org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration}
 *                                     《B》==> {@link org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration}
 *
 *
 * ####################### 生成 BeanDefinition #######################
 * 《A》又 Import {@link org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfigureRegistrar}
 *              实现了 {@link org.springframework.context.annotation.ImportBeanDefinitionRegistrar}
 * 方法 {@link org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfigureRegistrar#registerBeanDefinitions(AnnotationMetadata, BeanDefinitionRegistry)}
 * 被执行时 会重新扫描项目 扫描（启动类包下） 实现了接口 {@link Repository} 和 注解了{@link RepositoryDefinition} .class文件
 * 把扫描到的符合条件的文件 装换成 BeanDefinition  加工处理 BeanDefinition
 *  beanClass="org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean"
 * 最后注册到 beanFactory中
 *####################### 生成 BeanDefinition #######################
 *
 * ####################### 添加 BeanDefinition 到 mergedBeanDefinitions 中  更新 resolvedTargetType 属性 #######################
 * 其他的一些配置执行时会调用到 {@link org.springframework.boot.autoconfigure.condition.BeanTypeRegistry#getNamesForType(Class)}
 *                              内部调用 {@link org.springframework.boot.autoconfigure.condition.BeanTypeRegistry#addBeanTypeForNonAliasDefinition(String)}
 *             1.执行 {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#getMergedBeanDefinition(String)}
 *  *                会把 对应的 BeanDefinition 添加 到 {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#mergedBeanDefinitions} 中
 *           2.执行  {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#isFactoryBean(String)}
 *                再调 {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#predictBeanType(String, RootBeanDefinition, Class[])}
 *                会确定 Bean 的 类型  设置{@link org.springframework.beans.factory.support.RootBeanDefinition#resolvedTargetType} 为 {@link JpaRepositoryFactoryBean#getClass()}
 * * ####################### 添加 BeanDefinition 到 mergedBeanDefinitions 中  更新 resolvedTargetType 属性 #######################
 *
 *
 * ####################### bean 实例化 #######################
 *
 * 《B》又 Import {@link RepositoryRestMvcConfiguration} 且 又再次 Import {@link org.springframework.hateoas.config.HypermediaSupportBeanDefinitionRegistrar}
 *      实现了 {@link org.springframework.context.annotation.ImportBeanDefinitionRegistrar}
 * 方法 {@link org.springframework.hateoas.config.HypermediaSupportBeanDefinitionRegistrar#registerBeanDefinitions(AnnotationMetadata, BeanDefinitionRegistry)}
 * 被执行 时会调用 {@link org.springframework.beans.factory.support.DefaultListableBeanFactory#getBeanNamesForType(Class)}
 * 被执行 时会调用 {@link org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory#getSingletonFactoryBeanForTypeCheck(String, RootBeanDefinition)}
 * 这个方法里 对于 BeanDefinition 的 resolvedTargetType 属性为 {@link org.springframework.beans.factory.FactoryBean}类型 的 bd 进行实例化处理
 *
 * 《B》又 @ComponentScan(basePackageClasses = RepositoryRestController.class,
 * 		includeFilters = @Filter(BasePathAwareController.class), useDefaultFilters = false)
 * {@link org.springframework.data.rest.webmvc.RepositoryRestController}
 *
 * 《B》 有 @Bean {@link RepositoryRestMvcConfiguration#repositories()}
 * ####################### bean 实例化 #######################
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
