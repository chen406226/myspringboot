package com.soul.index;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.common.settings.Settings;


public class TestSetting {

	static TransportClient client;
	static String clusterName = "elasticsearch";
	static String serverhost = "localhost";
	static int serverPort = 9300;
	public static void main(String[] args) throws Exception{
		Settings settings = Settings.builder().put("cluster.name",clusterName).build();
		client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(serverhost),serverPort));
		System.out.println("****创建了Elasticserarch******");
		
		
		
		//调用 indicesAdminClient.putMapping()方法设定索引库结构
		String indexName = "cms";
		
		//使用 IndicesAdminClient.prepareDelete()方法删除索引
//		IndicesAdminClient adminClient = client.admin().indices();
//		adminClient.prepareDelete(indexName).execute().actionGet().isAcknowledged();
		
		IndicesAdminClient ac = client.admin().indices();
		CreateIndexRequestBuilder builder = ac.prepareCreate(indexName);
		//设置分片数量
		Settings.Builder setting = Settings.builder().put("number_of_shards", 1);
		builder.setSettings(setting);
		//创建索引库
		CreateIndexResponse indexResponse = (CreateIndexResponse) client.admin().indices()
				//这个索引库的名称不能包含大写字母
				.prepareCreate(indexName).setSettings(setting.build()).execute()
				.actionGet();
		//然后设定索引库结构
		
		String type = "article";
		XContentBuilder mapping = getMapping(type);
		PutMappingRequest mappingRequest = Requests
				.putMappingRequest(indexName).type(type).source(mapping);
		PutMappingResponse mappingResponse = client.admin().indices()
				.putMapping(mappingRequest).actionGet();
		//看是否成功设定索引结构
		System.out.println("PUtMappingResponse"+mappingResponse.isAcknowledged());
		

		
		client.close();
	}

	//首先定义索引库结构
	private static XContentBuilder getMapping(String indexType) throws Exception {
		XContentBuilder mapping = XContentFactory.jsonBuilder().startObject()
				.startObject(indexType).startObject("properties")
				//定义标题列
				.startObject("title").field("type","text")
				.field("store",true).field("analyzer","standard").endObject()
				//定义内容列
				.startObject("body").field("type","text")
				.field("store",true).field("analyzer","standard")
				.endObject()
				.endObject() // 属性结束
				.endObject() // 索引类型结束
				.endObject();
		return mapping;
	}
	
	
}