/**
 * 
 */
package com.swapnil.producerconsumer.main;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.swapnil.producerconsumer.domain.DataConsumer;
import com.swapnil.producerconsumer.interfaces.SharedEntity;

/**
 * @author "Swapnil Singh"
 * 
 */
public class MetaDataConsumer extends DataConsumer<SharedEntity> {

	private static final Logger log = Logger.getLogger(MetaDataConsumer.class);
	
	public MetaDataConsumer(LinkedBlockingQueue<SharedEntity> list) {
		super.initializeQueue(list);
		super.linkChildObject(this);
		log.info("Consumer Initlized.");
	}
	@Override
	public void consumeSharedEntity(SharedEntity sharedEntity) {
		log.debug("Data received from consumer thread : "+sharedEntity);
	}
	/* (non-Javadoc)
	 * @see com.swapnil.producerconsumer.interfaces.Consumer#performTask()
	 */
	@Override
	public void performTask() {
		log.info("Consumer Thread performTaskMethod called.");
	}
}
