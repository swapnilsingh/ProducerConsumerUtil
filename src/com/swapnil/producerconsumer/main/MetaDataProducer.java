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
		log.info("Producer Initlized");
		super.initializeQueue(list);
		this.metaDataConsumer = metaDataConsumer;
	}

	private void pushMetaDataToQueue(SharedEntity entity) throws InterruptedException{
		super.push(entity);
	}

	/* (non-Javadoc)
	 * @see com.swapnil.producerconsumer.interfaces.Producer#setLiveFlag()
	 */
	@Override
	public void stopProducerThread(Boolean flag) {
		super.setLiveFlag(flag);
		log.info("Producer Stopped");
	}

	/* (non-Javadoc)
	 * @see com.swapnil.producerconsumer.interfaces.Producer#performTask()
	 */
	@Override
	public void performTask() throws InterruptedException {
		for(int i=1;i<=10;i++){
			push(new MetaDataSharedEntiry(i,Integer.toString(i)+"_Name"));
		}
		this.metaDataConsumer.setLiveFlag(false);
	}

	
}
