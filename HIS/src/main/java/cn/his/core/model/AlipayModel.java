package cn.his.core.model;

import cn.his.common.utils.PropertyUtil;

public class AlipayModel {

	private String open_api_domain = PropertyUtil.getProperty("open_api_domain");
	private String mcloud_api_domain = PropertyUtil.getProperty("mcloud_api_domain");
	private String pid = PropertyUtil.getProperty("pid");
	private String return_url = PropertyUtil.getProperty("return_url");
	private String appid = PropertyUtil.getProperty("appid");
	private String private_key = PropertyUtil.getProperty("private_key");
	private String public_key = PropertyUtil.getProperty("public_key");
	private String alipay_public_key = PropertyUtil.getProperty("alipay_public_key");
	private String sign_type = PropertyUtil.getProperty("sign_type");
	private String max_query_retry = PropertyUtil.getProperty("max_query_retry");
	private String query_duration = PropertyUtil.getProperty("query_duration");
	private String max_cancel_retry = PropertyUtil.getProperty("max_cancel_retry");
	private String cancel_duration = PropertyUtil.getProperty("cancel_duration");
	private String heartbeat_delay = PropertyUtil.getProperty("heartbeat_delay");
	private String heartbeat_duration = PropertyUtil.getProperty("heartbeat_duration");
	
	public String getOpen_api_domain() {
		return open_api_domain;
	}
	public void setOpen_api_domain(String open_api_domain) {
		this.open_api_domain = open_api_domain;
	}
	public String getMcloud_api_domain() {
		return mcloud_api_domain;
	}
	public void setMcloud_api_domain(String mcloud_api_domain) {
		this.mcloud_api_domain = mcloud_api_domain;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getReturn_url() {
		return return_url;
	}
	public void setReturn_url(String return_url) {
		this.return_url = return_url;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPrivate_key() {
		return private_key;
	}
	public void setPrivate_key(String private_key) {
		this.private_key = private_key;
	}
	public String getPublic_key() {
		return public_key;
	}
	public void setPublic_key(String public_key) {
		this.public_key = public_key;
	}
	public String getAlipay_public_key() {
		return alipay_public_key;
	}
	public void setAlipay_public_key(String alipay_public_key) {
		this.alipay_public_key = alipay_public_key;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getMax_query_retry() {
		return max_query_retry;
	}
	public void setMax_query_retry(String max_query_retry) {
		this.max_query_retry = max_query_retry;
	}
	public String getQuery_duration() {
		return query_duration;
	}
	public void setQuery_duration(String query_duration) {
		this.query_duration = query_duration;
	}
	public String getMax_cancel_retry() {
		return max_cancel_retry;
	}
	public void setMax_cancel_retry(String max_cancel_retry) {
		this.max_cancel_retry = max_cancel_retry;
	}
	public String getCancel_duration() {
		return cancel_duration;
	}
	public void setCancel_duration(String cancel_duration) {
		this.cancel_duration = cancel_duration;
	}
	public String getHeartbeat_delay() {
		return heartbeat_delay;
	}
	public void setHeartbeat_delay(String heartbeat_delay) {
		this.heartbeat_delay = heartbeat_delay;
	}
	public String getHeartbeat_duration() {
		return heartbeat_duration;
	}
	public void setHeartbeat_duration(String heartbeat_duration) {
		this.heartbeat_duration = heartbeat_duration;
	}
	@Override
	public String toString() {
		return "AlipayModel [open_api_domain=" + open_api_domain + ", mcloud_api_domain=" + mcloud_api_domain + ", pid="
				+ pid + ", return_url=" + return_url + ", appid=" + appid + ", private_key=" + private_key
				+ ", public_key=" + public_key + ", alipay_public_key=" + alipay_public_key + ", sign_type=" + sign_type
				+ ", max_query_retry=" + max_query_retry + ", query_duration=" + query_duration + ", max_cancel_retry="
				+ max_cancel_retry + ", cancel_duration=" + cancel_duration + ", heartbeat_delay=" + heartbeat_delay
				+ ", heartbeat_duration=" + heartbeat_duration + "]";
	}

}
