package com.encodereport;
public class Result {
	
	private String result;
	private String resultText;
	
	public Result(String result,String resultText) {
		this.result = result;
		this.resultText = resultText;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getResult() {
		return this.result;
	}
	
	public void setResultText(String resultText) {
		this.resultText = resultText;
	}
	
	public String getResultText() {
		return this.resultText;
	}	
}