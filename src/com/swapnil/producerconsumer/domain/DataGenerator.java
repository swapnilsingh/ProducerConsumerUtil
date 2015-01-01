/**
 * 
 */
package com.swapnil.producerconsumer.domain;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.swapnil.producerconsumer.interfaces.Producer;

/**
 * @author "Swapnil Singh"
 *
 */
public abstract class DataGenerator <T> implements Producer {

	private static final Logger log = Logger.getLogger(DataGenerator.class);
	private BlockingQueue<T> sharedEntity;
	private Boolean liveFlag = true;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		log.info("Data Generator Thread Started.");
		while(liveFlag && this.sharedEntity.isEmpty()){
			
		}
		log.info("Data Generator Thread Stopped.");
	}
	protected void push(T t) throws InterruptedException{
		log.info("Data Generator Thread Received : "+t);
		this.sharedEntity.put(t);
	}
	protected void initializeQueue(LinkedBlockingQueue<T> list){
		this.sharedEntity = list;
		log.info("Data Generator thread linked to the shared BlockingQueue.");
	}
	
	/**
	 * @param liveFlag the liveFlag to set
	 */
	public void setLiveFlag(Boolean liveFlag) {
		this.liveFlag = liveFlag;
	}
}
