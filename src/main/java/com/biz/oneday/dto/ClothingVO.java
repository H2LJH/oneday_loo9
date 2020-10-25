package com.biz.oneday.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ClothingVO {

	private String io_user; // NVARCHAR2(50),
    private long io_seq;      // NUMBER 
    private String  io_pname; // NVARCHAR2(30),
    
    private String  io_input; // CHAR(1),
    private String io_date; // VARCHAR2(10),
    private String io_time; // VARCHAR2(10),
    
    private int io_price; // NUMBER,   
    private int io_quan;  // NUMBER,
    private int io_total; // NUMBER
	
}
