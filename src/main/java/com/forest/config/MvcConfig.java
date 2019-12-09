package com.forest.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;

@SuppressWarnings("deprecation")
@Configuration
public class MvcConfig implements WebMvcConfigurer {
	//extends WebMvcConfigurationSupport
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //和页面有关的静态目录都放在项目的static目录下
		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
		//上传的头像图片在D盘>Git>HeadPortraitImages目录下，head表示访问的前缀，以下是真实路径
		registry.addResourceHandler("/head/**").addResourceLocations("file:/D:/Git/HeadPortraitImages/");
		//上传的商品图片在D盘>Git>CommodityMainImages目录下，commodity表示访问的前缀，以下是真实路径
		registry.addResourceHandler("/commodity/**").addResourceLocations("file:/D:/Git/CommodityMainImages/");
		//上传的商品图片在D盘>Git>ColorImages目录下，color表示访问的前缀，以下是真实路径
		registry.addResourceHandler("/color/**").addResourceLocations("file:/D:/Git/ColorImages/");
		
		//super.addResourceHandlers(registry);	改为实现WebMvcConfigurer接口后必须 注释/删除 这一句
	}

	/*@Autowired
	LoginInterceptor loginI;
	
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	// TODO Auto-generated method stub
    	List<String> pathPattern = new ArrayList<String>();
    	pathPattern.add("/login");
    	pathPattern.add("/register");
    	
    	pathPattern.add("/assets/**");
    	pathPattern.add("/css/**");
    	pathPattern.add("/scss/**");
    	pathPattern.add("/umeditor-1.2.3/**");	//百度富文本编辑器下的全部静态文件
    	pathPattern.add("/uploading.css");		//商品编辑页面 抽取出的CSS文件
    	pathPattern.add("/js/**");
    	pathPattern.add("/uploading.js");		//商品编辑页面 抽取出的JS代码
    	
    	pathPattern.add("/images/**");
    	pathPattern.add("/picture/**");
    	pathPattern.add("/head/**");
    	pathPattern.add("/commodity/**");
    	pathPattern.add("/color/**");
    	
    	pathPattern.add("/error");		//这些个error，有点烦
    	
		registry.addInterceptor(loginI).addPathPatterns("/**").excludePathPatterns(pathPattern);
    	WebMvcConfigurer.super.addInterceptors(registry);
    }*/
	
	/**
     * - 修改自定义消息转换器
     * @param converters
     */
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        converter.setSupportedMediaTypes(getSupportedMediaTypes());
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(
            // String null -> ""
            SerializerFeature.WriteNullStringAsEmpty,
            // Number null -> 0
            SerializerFeature.WriteNullNumberAsZero,
            //禁止循环引用
            SerializerFeature.DisableCircularReferenceDetect
        );
        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

	private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);
        return supportedMediaTypes;
    }

}
