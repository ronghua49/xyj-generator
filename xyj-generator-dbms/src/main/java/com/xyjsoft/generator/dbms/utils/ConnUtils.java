package com.xyjsoft.generator.dbms.utils;

import com.xyjsoft.generator.dbms.dao.DatabaseDAOFactory;
import com.xyjsoft.generator.dbms.dao.IDatabaseDAO;
import com.xyjsoft.generator.dbms.exception.DAOException;
import com.xyjsoft.generator.dbms.vo.ConnParam;

/**
 * 连接工具类
 * @author Louis
 * @date Nov 10, 2018
 */
public class ConnUtils {

	/**
	 * 测试数据库连接
	 * @param connParam
	 * @return
	 */
	public static boolean testConnection(ConnParam connParam) {
		IDatabaseDAO dao = DatabaseDAOFactory.getDAO(connParam);
		if (dao != null) {
			try {
				dao.openConnection();
				System.out.println("数据库连接成功!");
				return true;
			} catch (Exception e) {
				System.out.println("数据库连接失败,请检查端口号、用户名或密码 !");
			} finally {
				try {
					dao.closeConnection();
				} catch (DAOException e) {
				}
			}
		}
		return false;
	}
}
