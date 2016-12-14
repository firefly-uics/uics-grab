package com.uics.grab.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by tom on 2016/12/14.
 */
@Configuration
@PropertySource({"classpath:/quartz-job.properties"})
public class JobEnv {
    @Autowired
    Environment env;

    public String getProperty(String key){
        return env.getProperty(key);
    }
}
