package com.dj.boot.student.poling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class BCDataPoller {

	class Poller implements Runnable{

		int interval=10;
		@Override
		public void run() {
			
			
		}
		
		public Object getDataPolled() {
			
			RestTemplate rTemplate=new RestTemplate();
			//rTemplate.
			
			return null;
		}
		
	}
	
	@Scheduled(fixedDelay=5000)
	public void recurringCall()
	{
		System.out.println("This is recurringCall"+Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
