package com.atguigu.service;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.web.context.request.async.DeferredResult;

public class DeferredResultQueue {

	private static Queue<DeferredResult<Object>> queue = new ConcurrentLinkedQueue<DeferredResult<Object>>();

	public static void save(DeferredResult<Object> deferredResult){
		queue.add(deferredResult);
	}

	public static DeferredResult<Object> get( ){
		return queue.poll();
	}

}
