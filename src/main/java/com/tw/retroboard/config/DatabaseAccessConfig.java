package com.tw.retroboard.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jooq.DSLContext;
import org.jooq.ExecuteListenerProvider;
import org.jooq.SQLDialect;
import org.jooq.TransactionProvider;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseAccessConfig {

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig("/hikari.properties");
        HikariDataSource dataSource = new HikariDataSource(config);

        return dataSource;
    }

    @Bean
    public DefaultConfiguration defaultConfiguration(DataSourceConnectionProvider dataSourceConnectionProvider,
                                                     TransactionProvider transactionProvider,
                                                     ExecuteListenerProvider jooqExceptionTranslatorExecuteListenerProvider) {
        DefaultConfiguration defaultConfiguration = new DefaultConfiguration();
        defaultConfiguration.setConnectionProvider(dataSourceConnectionProvider);
        defaultConfiguration.setTransactionProvider(transactionProvider);
        defaultConfiguration.setExecuteListenerProvider(jooqExceptionTranslatorExecuteListenerProvider);
        defaultConfiguration.setSQLDialect(SQLDialect.POSTGRES);
        return defaultConfiguration;
    }

    @Bean
    public DSLContext dslContext(DefaultConfiguration defaultConfiguration) {
        return new DefaultDSLContext(defaultConfiguration);
    }
}
