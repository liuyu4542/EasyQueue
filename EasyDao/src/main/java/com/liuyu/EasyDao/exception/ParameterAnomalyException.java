package com.liuyu.EasyDao.exception;
/**参数个数与传值个数不匹配异常*/
public class ParameterAnomalyException extends Exception {
	private static final long serialVersionUID = -4724927453901654587L;
	public ParameterAnomalyException() {
		super();
	}
	public ParameterAnomalyException(String message) {
		super(message);
	}

}
