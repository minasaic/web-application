package com.example.training.trainingcommunity.repository;

import java.util.List;

import org.apache.ibatis.annotations.*;
import com.example.training.trainingcommunity.model.TrainingCommunity;

@Mapper
public interface TrainingCommunityMapper {
	// ユーザー一覧取得
	@Select("select count(*) from training_users")
	int count();
}
