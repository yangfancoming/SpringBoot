package com.goat.tiny.spring.beans;

/**
 * bean的内容及元数据，保存在BeanFactory中，包装bean的实体
 */
public class BeanDefinition {

	private Object bean;

    /**
     class com.goat.tiny.spring.beans.example.HelloWorldServiceImpl
     class com.goat.tiny.spring.beans.example.OutputServiceImpl
    */
	private Class beanClass;

    /**
     com.goat.tiny.spring.beans.example.OutputServiceImpl
     com.goat.tiny.spring.beans.example.HelloWorldServiceImpl
     */
	private String beanClassName;

	private PropertyValues propertyValues = new PropertyValues();

	public BeanDefinition() {
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public String getBeanClassName() {
		return beanClassName;
	}

	public void setBeanClassName(String beanClassName) {
		this.beanClassName = beanClassName;
		try {
			this.beanClass = Class.forName(beanClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Object getBean() {
		return bean;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
}
