package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;

public interface RolesService {

	/**
	 * ��ѯ����
	 * @param fen
	 * @return
	 */
	FenYe SelectRoles(FenYe fen);
	/**
	 * ����
	 * @param roles
	 * @return
	 */
	Integer InsertRoles(Roles roles);
}
