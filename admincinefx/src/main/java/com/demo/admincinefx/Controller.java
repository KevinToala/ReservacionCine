package com.demo.admincinefx;

public interface Controller<T> {
	void setModel(T model);
	T getModel();
	
	default void start(){
	}
}
