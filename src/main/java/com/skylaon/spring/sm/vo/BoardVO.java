package com.skylaon.spring.sm.vo;

import lombok.Data;

@Data
public class BoardVO {
	
	private int b_no;
	private String b_title;
	private String b_id;
	private String b_datetime;
	private int b_hit;
	private String b_text;
	private int b_reply_count;
	private int b_reply_ori;
	private String b_category;
}
