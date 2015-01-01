/**
 * 
 */
package com.swapnil.producerconsumer.domain;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.log4j.Logger;

import com.swapnil.producerconsumer.interfaces.Consumer;
import com.swapnil.producerconsumer.interfaces.SharedEntity;

/**
 * @author "Swapnil Singh"
 *
 */
public abstract class DataConsumer <T> implements Consumer {

	private static final Logger log = Logger.getLogger(DataConsumer.class);
	private BlockingQueue<T> sharedEntity;
	private Consumer childConsumer;
	private Boolean liveFlag = true;
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		log.info("Data Consumer Thread Started.");
		while(this.liveFlag || !this.sharedEntity.isEmpty()){
			try {
				this.childConsumer.consumeSharedEntity((SharedEntity) this.sharedEntity.take());				
			} catch (InterruptedException e) {
				log.fatal(e);	
			}
		}
		log.info("Data Consumer Thread Processing Finished");
	}
	protected void initializeQueue(LinkedBlockingQueue<T> list){
		this.sharedEntity = list;
		log.info("Data Consumer thread linked to the shared BlockingQueue.");
	}
	protected void linkChildObject(Consumer consumer){
		this.childConsumer=consumer;
		log.info("Child Consumer linked to Consumer Thread.");
	}
	/**
	 * @param liveFlag the liveFlag to set
	 */
	public void setLiveFlag(Boolean liveFlag) {
		this.liveFlag = liveFlag;
	}
}
