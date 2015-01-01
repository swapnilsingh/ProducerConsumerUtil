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
		log.info("Consumer Initlized.");
		super.initializeQueue(list);
		super.linkChildObject(this);
	}
	@Override
	public void consumeSharedEntity(SharedEntity sharedEntity) {
		log.info("Data received from consumer thread : "+sharedEntity);
	}
	/* (non-Javadoc)
	 * @see com.swapnil.producerconsumer.interfaces.Consumer#stopConsumerThread(java.lang.Boolean)
	 */
	@Override
	public void stopConsumerThread(Boolean flag) {
		super.setLiveFlag(flag);	
		log.info("Consumer Stopped");
	}
	/* (non-Javadoc)
	 * @see com.swapnil.producerconsumer.interfaces.Consumer#performTask()
	 */
	@Override
	public void performTask() {
		// TODO Auto-generated method stub
		
	}
}
