package com.groupeisi.devoirsoap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "sectors")
    public DefaultWsdl11Definition sectorsWsdl11Definition(XsdSchema sectorsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("SectorsPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://com.groupeisi/devoirsoap/sectors");
        wsdl11Definition.setSchema(sectorsSchema);
        return wsdl11Definition;
    }

    @Bean(name = "classes")
    public DefaultWsdl11Definition classesWsdl11Definition(XsdSchema classesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ClassesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://com.groupeisi/devoirsoap/classes");
        wsdl11Definition.setSchema(classesSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema sectorsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schema/sectors.xsd"));
    }

    @Bean
    public XsdSchema classesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schema/classes.xsd"));
    }
}