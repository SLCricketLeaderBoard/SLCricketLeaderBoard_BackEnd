package com.gp.cricket.config;

import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/aws-config.xml")
@EnableRdsInstance(databaseName = "club_cricket", 
dbInstanceIdentifier = "mysqldb", 
password = "123456789")
public class AwsResourceConfig {

}
