package com.sedwt.icloud.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhang yijun
 * @date : 2021/3/17 11:27
 * @description : TODO
 */
@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private int port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Bean
    public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost("/");
        return connectionFactory;
    }

    /**
     * 设置队列名称
     * @return
     */
    @Bean
    public Queue directQueue(){
        // 1. durable: 是否持久化，默认为false,如果为true,即使重启数据也不会丢失
        // 2. exclusive: 只能被当前创建的连接使用，而且当连接关闭后队列即被删除, 默认为false, 此参考优先级高于durable
        // 3. autoDelete: 是否自动删除，当没有生产者或者消费者使用此队列，该队列会自动删除, 默认为false,

        return new Queue("miaosha-queue", true);
    }

    /**
     * 设置直连交换机的名称
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("miaosha-exchange", true, false);
    }

    /**
     * 将队列和交换机绑定，并生成路由key
     * @return
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("miaosha-routing");
    }
}
