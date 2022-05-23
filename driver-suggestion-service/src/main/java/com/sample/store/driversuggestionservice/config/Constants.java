package com.sample.store.driversuggestionservice.config;

public class Constants {

	public static final String TOPIC_NAME 
	= "#{@environment.getProperty('kafka.topic.driver')}";

	public static final String GROUP_ID 
	= "#{@environment.getProperty('kafka.consumer.driver.group')}";

}
