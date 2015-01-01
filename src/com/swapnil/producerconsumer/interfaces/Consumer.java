/**
 * 
 */
package com.swapnil.producerconsumer.interfaces;

/**
 * @author "Swapnil Singh"
 *
 */
public interface Consumer extends Runnable {
public void consumeSharedEntity(SharedEntity sharedEntity);
public void performTask();
}
