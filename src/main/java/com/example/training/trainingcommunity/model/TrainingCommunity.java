package com.example.training.trainingcommunity.model;

import lombok.Data; //setメソットやgetメソット　勝手に作ってくれる
// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;

@Data
public class TrainingCommunity {
	private int id;
	private String name;
	private String eMail;
}
