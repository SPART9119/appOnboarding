package com.vonage.appOnboarding;

import com.vonage.appOnboarding.Services.SaviyntRestCall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;

@SpringBootApplication
public class AppOnboardingApplication implements CommandLineRunner {
//public class AppOnboardingApplication{

    private static final Logger logger = LogManager.getLogger(AppOnboardingApplication.class);

//    @Value("${csv.file.path}")
//    private String csvFilePath;

    @Autowired
    private ConfigurableApplicationContext context;

//    @Value("${env.file.path}")
//    private String filePath;

    @Autowired
    private SaviyntRestCall saviyntRestCall;


    public static void main(String[] args) {
        SpringApplication.run(AppOnboardingApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//        File csvFile = new File(csvFilePath);
//        if (csvFile.exists() && csvFile.isFile()) {
//            System.out.println(csvFilePath);
//        } else {
//            System.err.println("File Not Found: " + csvFilePath);
//        }
        System.out.println(saviyntRestCall.getEndpoints());
        SpringApplication.exit(context);

    }
}

