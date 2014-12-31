/**
 * 
 */
package com.swapnil.producerconsumer.main;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.swapnil.producerconsumer.core.ProducerConsumerServiceImpl;
import com.swapnil.producerconsumer.interfaces.ProducerConsumerService;
import com.swapnil.producerconsumer.interfaces.SharedEntity;

/**
 * @author "Swapnil Singh"
 *
 */
public class ServiceRunner {

	private static final Logger log = Logger.getLogger(ServiceRunner.class);
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		LinkedBlockingQueue<SharedEntity> blockingQeque = new LinkedBlockingQueue<>();
		MetaDataConsumer metaDataConsumer = new MetaDataConsumer(blockingQeque);
		MetaDataProducer metaDataProducer = new MetaDataProducer(blockingQeque,metaDataConsumer);
		ProducerConsumerService producerConsumerService = new ProducerConsumerServiceImpl(metaDataProducer,metaDataConsumer);
		producerConsumerService.startService();
		//producerConsumerService.stopService();
	}

}
