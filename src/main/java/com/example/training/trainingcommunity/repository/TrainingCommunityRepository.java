package com.example.training.trainingcommunity.repository;

import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.training.trainingcommunity.model.TrainingCommunity;

@Repository
public class TrainingCommunityRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> findAll() {
		// 研修生一覧を抽出クエリ
		String query = "select * from training_users ;";
		List<Map<String, Object>> users = jdbcTemplate.queryForList(query);
		return users;
	}

	/*
	 * ページング
	 */
	public List<Map<String, Object>> findPage(Integer Page) {
		String query = "select * from training_users limit 10 offset ?;";
		List<Map<String, Object>> usersPage = jdbcTemplate.queryForList(query, (Page - 1) * 10);
		return usersPage;
	}

	/*
	 * 研修生1名の新規登録
	 */
	public boolean createUserRecord(TrainingCommunity training) {
		String query = "insert into training_users(name,e_mail,user_image_path) values(?,?,?);";
		jdbcTemplate.update(query, training.getName(), training.getEMail(), training.getPath());
		return true;
	}

	/*
	 * 研修生1名の編集
	 */

	public boolean updateUserRecord(TrainingCommunity training) {
		String query = "update training_users set name = ?, e_mail = ? where id = ?";
		jdbcTemplate.update(query, training.getName(), training.getEMail(),
				training.getId());
		return true;
	}

	/*
	 * 研修生の削除
	 */
	public boolean deleteUserRecord(TrainingCommunity training) {
		String query = "delete from training_users where id = ?;";
		jdbcTemplate.update(query, training.getId());
		return true;
	}

}
