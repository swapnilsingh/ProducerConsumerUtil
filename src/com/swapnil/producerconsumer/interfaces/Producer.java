/**
 * 
 */
package com.swapnil.producerconsumer.interfaces;

/**
 * @author "Swapnil Singh"
 *
 */
public interface Producer extends Runnable {
	public void performTask() throws InterruptedException;
}
