package com.soul;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

import org.elasticsearch.common.settings.Settings.Builder;

public class Test {
	static TransportClient client;
	static String clusterName = "elasticsearch";
	static String serverhost = "localhost";
	static int serverPort = 9300;
	@SuppressWarnings("resource")
	//和es集群建立连接，测试连接代码如下
	public static void main(String[] args) throws UnknownHostException{
		Settings settings = Settings.builder().put("cluster.name",clusterName).build();
		client = new PreBuiltTransportClient(settings)
				.addTransportAddress(new InetSocketTransportAddress(InetAddress
						.getByName(serverhost),serverPort));
		System.out.println("****创建了Elasticserarch******");
		client.close();
	}
	//首先定义索引库结构
	private static XContentBuilder getMapping(String indexType) throws Exception {
		XContentBuilder mapping = XContentFactory.jsonBuilder().startObject()
				.startObject(indexType).startObject("properties")
				//定义标题列
				.startObject("title").field("type","string")
				.field("store","yes").field("analyzer","standard").endObject()
				//定义内容列
				.startObject("body").field("type","string")
				.field("store","yes").field("analyzer","standard")
				.endObject()
				.endObject() // 属性结束
				.endObject() // 索引类型结束
				.endObject();
		return mapping;
	}
	//然后调用indicesadminclient.putMapping()方法设定索引库结构
	String indexName = "cms";
	IndicesAdminClient ac = client.admin().indices();
	CreateIndexRequestBuilder builder = ac.prepareCreate(indexName);
	//设置分片数量
	Builder setting = Settings.builder().put("number_of_shards", 1);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
