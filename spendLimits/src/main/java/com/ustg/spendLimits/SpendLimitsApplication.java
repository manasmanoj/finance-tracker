package com.ustg.spendLimits;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = { "com.ustg.spendLimits","com.ustg.category"})
public class SpendLimitsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpendLimitsApplication.class, args);
	}

}
