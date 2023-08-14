package org.application.config;

import com.example.infrastructurespringdata.repository.impl.ReportRepositoryImpl;
import com.example.infrastructurespringdata.repository.impl.UserRepositoryImpl;
import org.example.service.ReportServiceImpl;
import org.example.service.UserServiceImpl;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class ApiRestInitializer implements ApplicationContextInitializer {

    private final ConfigurableApplicationContext infraContext;
    public ApiRestInitializer(ConfigurableApplicationContext infraContext) {
        this.infraContext = infraContext;
    }
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableListableBeanFactory registry = applicationContext.getBeanFactory();
        registry.registerSingleton("PlantService", new PlantServiceImpl(infraContext.getBean(PlantRepositoryImpl.class)));
        registry.registerSingleton("UserService", new UserServiceImpl(infraContext.getBean(UserRepositoryImpl.class)));
        registry.registerSingleton("CommentService", new CommentServiceImpl(infraContext.getBean( CommentRepositoryImpl.class)));
    }


}
