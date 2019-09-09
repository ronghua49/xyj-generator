package com.xyjsoft.generator.dbms.service;

import java.util.List;
import java.util.Map;

import com.xyjsoft.generator.dbms.exception.DAOException;
import com.xyjsoft.generator.dbms.model.Column;
import com.xyjsoft.generator.dbms.model.ForeignKey;
import com.xyjsoft.generator.dbms.model.Index;
import com.xyjsoft.generator.dbms.model.PrimaryKey;
import com.xyjsoft.generator.dbms.model.Table;
import com.xyjsoft.generator.dbms.model.Trigger;
import com.xyjsoft.generator.dbms.vo.ConnParam;

/**
 * 数据库元信息查询服务
 * @author Louis
 * @date Nov 10, 2018
 */
public interface DatabaseService {
	
    /**
     * 通用查询方法
     * @param connParam 连接参数
     * @param sql 要查询的sql语句
     * @param params 查询条件数组
     * @return
     * @throws DAOException
     */
	List<Map<String, String>> query(ConnParam connParam, String sql, String[] params);
	
	/**
     * 查询表集合
     * @param connParam 连接参数
     * @return
     * @throws DAOException
     */
	List<Table> getTables(ConnParam connParam);
	
	/**
     * 查询表的字段集
     * @param connParam 连接参数
     * @param tableName
     * @return
     * @throws DAOException
     */
	List<Column> getColumns(ConnParam connParam, String tableName);
	
	/**
     * 查询主键集
     * @param connParam 连接参数
     * @param tableName
     * @return
     * @throws DAOException
     */
	List<PrimaryKey> getPrimaryKeys(ConnParam connParam, String tableName);
	
	/**
     * 查询外键集
     * @param connParam 连接参数
     * @param tableName
     * @return
     * @throws DAOException
     */
	List<ForeignKey> getForeignKeys(ConnParam connParam, String tableName);
	
	/**
     * 查询索引集
     * @param connParam 连接参数
     * @return 
     * @throws DAOException
     */
	List<Index> getIndexes(ConnParam connParam, String tableName);
	
	/**
     * 查询触发器集
     * @param connParam 连接参数
     * @param tableName
     * @return
     * @throws DAOExeception
     */
	List<Trigger> getTriggers(ConnParam connParam, String tableName);
	
	/**
	 * 测试数据库是否可以连接
	 * @param connParam
	 * @return
	 */
	boolean canConnect(ConnParam connParam);
	
	
}
