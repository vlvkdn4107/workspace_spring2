package com.example.demo31.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InGame {
	
	@JsonProperty("game_name")
	private String gameName;
	private String lv;
	
	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getLv() {
		return lv;
	}
	public void setLv(String lv) {
		this.lv = lv;
	}

	
}
