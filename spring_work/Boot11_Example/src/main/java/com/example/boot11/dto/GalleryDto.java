package com.example.boot11.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GalleryDto {
	private int num;
	private String writer;
	private String caption;
	private String saveFileName;
	private String regdate;
}