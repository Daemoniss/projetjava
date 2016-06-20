package main;

import contract.IModel;

public class testThread extends Thread{
	private IModel model;
	public testThread(IModel model){
		setModel(model);
	}
	public void setModel(IModel model){
		this.model = model;
	}
	public void run(){
		while(true){
			long start=System.nanoTime(); 
			while((System.nanoTime()-start)<500000000); 
			this.model.refresh();
		}
	}
}
