package org.arunm;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(SpringBootJasyptApplication.TopSecret.class)
@EnableEncryptableProperties
public class SpringBootJasyptApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext configApp =  SpringApplication.run(SpringBootJasyptApplication.class,args);
        System.out.println(configApp.getBean(TopSecret.class).getPassword());
    }

    @ConfigurationProperties(prefix="app")
    public static class TopSecret {

        private String password;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
