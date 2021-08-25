package com.technical.terchnicalsummary.utils;

import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexRequest;
import org.elasticsearch.action.admin.indices.open.OpenIndexResponse;
import org.elasticsearch.action.admin.indices.refresh.RefreshRequest;
import org.elasticsearch.action.admin.indices.refresh.RefreshResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.*;
import org.elasticsearch.common.settings.Setting;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * @ClassName ElasticUtils
 * @Description elasticsearch工具类
 * @Author shuai_yu
 * @Date 2021/8/17 11:03
 **/
@Component
public class ElasticUtils {

    @Autowired
    RestHighLevelClient client;

    /**
     * 创建索引
     * @param indexName
     */
    public void createIndex(String indexName) {
        CreateIndexRequest indexRequest = new CreateIndexRequest(indexName);
        //setting
        indexRequest.settings(Settings.builder().
                 put("index.number_of_shards", 3).
                 put("index.number_of_replicas", 2));
        //mapping
        Map<String, Object> message = new HashMap<>();
        message.put("type", "text");
        Map<String, Object> properties = new HashMap<>();
        properties.put("message", message);
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("properties", properties);
        indexRequest.mapping(mapping);
        //alias
        indexRequest.alias(new Alias("twitter_alias").filter(QueryBuilders.termQuery("user", "kimchy")));
        indexRequest.setTimeout(TimeValue.timeValueMinutes(2));
        try {
            GetIndexRequest getIndexRequest = new GetIndexRequest(indexName);
            boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
            if (!exists) {
                CreateIndexResponse createIndexResponse = client.indices().create(indexRequest, RequestOptions.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除索引
     * @param indexName
     */
    public void deleteIndex(String indexName) {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(indexName);
        deleteIndexRequest.timeout(TimeValue.timeValueMinutes(1));
        try {
            AcknowledgedResponse acknowledgedResponse = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭索引
     * 针对部分索引，我们暂时不需要对其进行读写，可以临时关闭索引，以减少es服务器的开销
     */
    public void closeIndex(String indexName) {
        CloseIndexRequest closeIndexRequest = new CloseIndexRequest(indexName);
        try {
            CloseIndexResponse closeIndexResponse = client.indices().close(closeIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打开索引
     * 针对部分索引，我们暂时不需要对其进行读写，可以临时关闭索引，以减少es服务器的开销
     */
    public void openIndex(String indexName) {
        OpenIndexRequest openIndexRequest = new OpenIndexRequest(indexName);
        try {
            OpenIndexResponse OpenIndexResponse = client.indices().open(openIndexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 刷新索引
     */
    public void refreshIndex(String indexName) {
        RefreshRequest refreshRequest = new RefreshRequest(indexName);
        RefreshRequest refreshMultipleRequest = new RefreshRequest("index1","index2");
        RefreshRequest refreshAllRequest = new RefreshRequest();
        try {
            //同步
            RefreshResponse refreshResponse = client.indices().refresh(refreshRequest, RequestOptions.DEFAULT);
            //异步
            ActionListener<RefreshResponse> listener = new ActionListener<RefreshResponse>() {
                @Override
                public void onResponse(RefreshResponse refreshResponse) {

                }

                @Override
                public void onFailure(Exception e) {

                }
            };
            client.indices().refreshAsync(refreshRequest, RequestOptions.DEFAULT,listener);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
