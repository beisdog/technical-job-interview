package ch.sbb.trs.assessment.springshop;

import ch.sbb.trs.assessment.springshop.entities.ProductEntity;
import ch.sbb.trs.assessment.springshop.entities.ProductRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
//@ComponentScan(basePackages = "ch.sbb.trs.assessment.springshop")
@EnableJpaRepositories(basePackageClasses = ProductRepo.class)
@EntityScan(basePackageClasses = ProductEntity.class)
@EnableScheduling
@EnableConfigurationProperties
public class SpringShopApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringShopApplication.class, args);
    }

}
