/**
 * 
 */
package com.swapnil.producerconsumer.core;

import org.apache.log4j.Logger;

import com.swapnil.producerconsumer.interfaces.Consumer;
import com.swapnil.producerconsumer.interfaces.Producer;
import com.swapnil.producerconsumer.interfaces.ProducerConsumerService;

/**
 * @author "Swapnil Singh"
 *
 */
public class ProducerConsumerServiceImpl implements ProducerConsumerService {
	
	private static final Logger log = Logger.getLogger(ProducerConsumerServiceImpl.class);
	private Producer producer;
	private Consumer consumer;
	

	/**
	 * @param producer
	 * @param consumer
	 */
	public ProducerConsumerServiceImpl(Producer producer, Consumer consumer) {
		log.info("Initlizing Producer Consumer Service");
		this.producer = producer;
		this.consumer = consumer;
	}

	/* (non-Javadoc)
	 * @see com.swapnil.producerconsumer.interfaces.ProducerConsumerService#startService()
	 */
	@Override
	public void startService() throws InterruptedException {
		Thread producerThread = new Thread(this.producer);
		Thread consumerThread = new Thread(this.consumer);
		producerThread.start();
		consumerThread.start();
		this.producer.performTask();
		//this.consumer.performTask();
	}
}
