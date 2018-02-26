package com.demo.admincinefx.servicios.base;

import org.apache.http.HttpHost;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateFactory implements FactoryBean<RestTemplate>, InitializingBean {
	
	@Value("${server.rest.protocol}")
	protected String protocol;
	
	@Value("${server.rest.hostname}")
	protected String hostname;
	
	@Value("${server.rest.port}")
	protected Integer port;
	
	@Value("${server.rest.username}")
	protected String username;
	
	@Value("${server.rest.password}")
	protected String password;
	
	private RestTemplate restTemplate;

    public RestTemplateFactory() {
        super();
    }
    
    @Override
    public RestTemplate getObject() {
        return restTemplate;
    }

    @Override
    public Class<RestTemplate> getObjectType() {
        return RestTemplate.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
    
    @Override
    public void afterPropertiesSet() {
        HttpHost host = new HttpHost(hostname, port, protocol);
        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactoryBasicAuth(host);
        restTemplate = new RestTemplate(requestFactory);
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(username, password));
    }
}
