package com.demo.admincinefx;

import org.springframework.web.client.RestClientResponseException;

import javafx.concurrent.Task;

public interface CallbackHelper<T> {
	default void onStart(Task<T> task){}
	
	void onSuccess(T result);
	
	default void onEnd(){}
	
	default void onFail(RestClientResponseException exception){}
	
	default void onFail(){}
	
	default void allways(){}
}
