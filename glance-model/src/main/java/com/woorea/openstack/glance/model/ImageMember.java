package com.woorea.openstack.glance.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ImageMember implements Serializable {

	@JsonProperty("can_share")
	private boolean canShare;
	
	@JsonProperty("member_id")
	private String memberId;

	public ImageMember() {
		
	}

	public ImageMember(boolean canShare, String memberId) {
		this.canShare = canShare;
		this.memberId = memberId;
	}

	/**
	 * @return the canShare
	 */
	public boolean isCanShare() {
		return canShare;
	}

	/**
	 * @param canShare the canShare to set
	 */
	public void setCanShare(boolean canShare) {
		this.canShare = canShare;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

}
