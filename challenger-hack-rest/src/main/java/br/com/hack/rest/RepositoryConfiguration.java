package br.com.hack.rest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"br.com.hack.rest.model"})
@EnableJpaRepositories(basePackages = {"br.com.hack.rest.repository"})
@EnableTransactionManagement
public class RepositoryConfiguration {

}
