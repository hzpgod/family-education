package com.fzu.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.fzu.token.SQLHelper;
import com.opensymphony.xwork2.ActionSupport;

public class Query extends ActionSupport{
	
	private String sql;
	private String paras;
	
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getParas() {
		return paras;
	}

	public void setParas(String paras) {
		this.paras = paras;
	}

	public String execute() throws Exception{
		String []param=paras.split("-");
		SQLHelper sqlhelper=new SQLHelper();
		Boolean flag=true;
		
		flag=sqlhelper.ExecuteQuery(sql, param);
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		out.print(flag.toString());
		return null;
	}
}
