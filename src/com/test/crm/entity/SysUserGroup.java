package com.test.crm.entity;

import java.io.Serializable;
/**
  po����,��Ӧ���ݿ��ֵ
 */
public class SysUserGroup implements Serializable {
	
	private static final long serialVersionUID = 2055830812290335432L;
	private Integer id;
	private String  remark;//��ע
	private String name;//��������
	
	private String principal;//���Ÿ�����
	private String incumbent;//����ְ��
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getIncumbent() {
		return incumbent;
	}
	public void setIncumbent(String incumbent) {
		this.incumbent = incumbent;
	}
} 