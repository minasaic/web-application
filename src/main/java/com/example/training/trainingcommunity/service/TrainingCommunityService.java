package com.example.training.trainingcommunity.service;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.trainingcommunity.repository.TrainingCommunityMapper;
import com.example.training.trainingcommunity.model.TrainingCommunity;
import com.example.training.trainingcommunity.repository.TrainingCommunityRepository;

@Service
public class TrainingCommunityService {

	@Autowired
	private TrainingCommunityRepository repo;

	// レコード個数を取得
	@Autowired
	private TrainingCommunityMapper mapper;

	public int count() {
		return mapper.count();
	}

	public List<TrainingCommunity> getAllUser() {
		// ユーザー一覧を取得
		List<Map<String, Object>> querySet = repo.findAll();
		List<TrainingCommunity> users = new ArrayList<>();
		for (var record : querySet) {
			var trainingCommunity = new TrainingCommunity();
			trainingCommunity.setId((Integer) record.get("id"));
			trainingCommunity.setName((String) record.get("name"));
			trainingCommunity.setEMail((String) record.get("e_Mail"));
			users.add(trainingCommunity);
		}
		return users;
	}

	public List<TrainingCommunity> getUser(Integer userPage) {
		// ページング ユーザー一覧を取得
		List<Map<String, Object>> querySet = repo.findPage(userPage);
		List<TrainingCommunity> users = new ArrayList<>();
		for (var record : querySet) {
			var trainingCommunity = new TrainingCommunity();
			trainingCommunity.setId((Integer) record.get("id"));
			trainingCommunity.setName((String) record.get("name"));
			trainingCommunity.setEMail((String) record.get("e_Mail"));
			users.add(trainingCommunity);
		}
		return users;
	}

	/*
	 * 新規登録
	 * 
	 * @param userEmail 登録するメールアドレス
	 * 
	 * @param userName 登録する名前
	 */
	public boolean createUser(String userName, String userEmail) {
		var trainingCommunity = new TrainingCommunity();
		trainingCommunity.setName(userName);
		trainingCommunity.setEMail(userEmail);

		repo.createUserRecord(trainingCommunity);
		return true;
	}

	/*
	 * 編集
	 */
	public boolean updateUser(Integer id, String userName, String userEmail) {
		var trainingCommunity = new TrainingCommunity();
		trainingCommunity.setId(id);
		trainingCommunity.setName(userName);
		trainingCommunity.setEMail(userEmail);

		repo.updateUserRecord(trainingCommunity);
		return true;
	}

	/*
	 * 削除
	 */
	public boolean deleteUser(Integer id) {
		var trainingCommunity = new TrainingCommunity();
		trainingCommunity.setId(id);
		repo.deleteUserRecord(trainingCommunity);
		return true;
	}

}
