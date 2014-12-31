/**
 * 
 */
package com.swapnil.producerconsumer.main;

import com.swapnil.producerconsumer.interfaces.SharedEntity;

/**
 * @author "Swapnil Singh"
 *
 */
public class MetaDataSharedEntiry implements SharedEntity {
private int id;
private String name;

/**
 * @param id
 * @param name
 */
public MetaDataSharedEntiry(int id, String name) {
	this.id = id;
	this.name = name;
}
public final int getId() {
	return id;
}
public final void setId(int id) {
	this.id = id;
}
public final String getName() {
	return name;
}
public final void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "MetaDataSharedEntiry [id=" + id + ", name=" + name + "]";
}

}
