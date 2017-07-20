### 基于spring扩展自定义的schema

步骤：
1. 编写Java Bean .例：User

2. 编写xsd 例：META-INF/user.xsd

3. 编写spring.handlers和spring.schemas
    例：META-INF/spirng.handlers/META-INF/spring.schemas

4. 编写applicationContext.xml 例：spring/spring-schema-test.xml

5. 编写NamespaceHandler 和 BeanDefinitionParser
    例如:UserNamespaceHandler和UserBeanDefinitionParser
    
    注：继承AbstractSingleBeanDefinitionParser,该抽象类为spring对BeanDefinitionParser的简单实现。
        也可以实现BeanDefinitionParser，需要创建BeanDefinition对象，然后注入Registry中。