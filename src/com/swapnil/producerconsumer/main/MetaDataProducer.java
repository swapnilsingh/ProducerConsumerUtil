/**
 * 
 */
package com.swapnil.producerconsumer.main;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.swapnil.producerconsumer.domain.DataGenerator;
import com.swapnil.producerconsumer.interfaces.SharedEntity;

/**
 * @author "Swapnil Singh"
 *
 */
public class MetaDataProducer extends DataGenerator<SharedEntity> {
	
	private static final Logger log = Logger.getLogger(MetaDataProducer.class);
	
	private MetaDataConsumer metaDataConsumer ;
	/**
	 * @param blockingDeque
	 */
	public MetaDataProducer(LinkedBlockingQueue<SharedEntity> list,MetaDataConsumer metaDataConsumer) {
		super.initializeQueue(list);
		this.metaDataConsumer = metaDataConsumer;
		log.info("Producer Initlized");
	}

	private void pushMetaDataToQueue(SharedEntity entity) throws InterruptedException{
		super.push(entity);
	}

	
	@Override
	public void performTask() throws InterruptedException {
		log.info("Producer Thread performTaskMethod called.");
		for(int i=1;i<=10;i++){
			pushMetaDataToQueue(new MetaDataSharedEntiry(i,Integer.toString(i)+"_Name"));
		}
		this.metaDataConsumer.setLiveFlag(false);
	}

	
}
