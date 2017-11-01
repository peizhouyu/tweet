package cn.mrpei.tweetadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan(basePackages = "cn.mrpei.tweetadmin")
@SpringBootApplication
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class TweetadminApplication {

	public static void main(String[] args) {
		SpringApplication.run(TweetadminApplication.class, args);
	}
}
