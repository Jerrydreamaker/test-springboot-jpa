package com.iecas.testspringboot.nosql.hbase.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
@Configuration
public class HbaseConfig {
    @Value("hbase.zookeeper.quorum")
    private String quorum;
    @Value("hbase.zookeeper.port")
    private String port;
    @Bean
    public HbaseTemplate hbaseTemplate(){
        HbaseTemplate hbaseTemplate=new HbaseTemplate();
        org.apache.hadoop.conf.Configuration conf=
                new org.apache.hadoop.conf.Configuration();
        conf.set("hbase.zookeeper.quorum",quorum);
        conf.set("hbase.zookeeper.port",port);
        hbaseTemplate.setConfiguration(conf);
        return hbaseTemplate;
    }
}
