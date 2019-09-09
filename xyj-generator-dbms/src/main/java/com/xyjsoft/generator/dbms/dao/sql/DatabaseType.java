package com.xyjsoft.generator.dbms.dao.sql;

import com.xyjsoft.generator.dbms.converter.CommonMetaDataConverter;
import com.xyjsoft.generator.dbms.converter.MySQL5MetaDataConverter;
import com.xyjsoft.generator.dbms.converter.OracleMetaDataConverter;
import com.xyjsoft.generator.dbms.dao.IMetaDataConverter;

/**
 * 数据库查询语句文件
 * @author Louis
 * @date Nov 10, 2018
 */
public enum DatabaseType {

	Oracle {

		@Override
		public String getFileName() {
			return FOLDER + "/Oracle.xml";
		}

		@Override
		public IMetaDataConverter getConverter() {
			return OracleMetaDataConverter.getInstance();
		}
		
	},
	
	MySql5 {
		@Override
		public String getFileName() {
			return FOLDER + "/MySQL5.xml";
		}

		@Override
		public IMetaDataConverter getConverter() {
			return MySQL5MetaDataConverter.getInstance();
		}
	}, 
	
	MSSQLServer {
		@Override
		public String getFileName() {
			return FOLDER + "/MSSQL.xml";
		}
	};
	
	private static final String FOLDER	= 
			DatabaseType.class.getPackage().getName().replace('.', '/');
	
	abstract public String getFileName();
	
	public IMetaDataConverter getConverter() {
		return CommonMetaDataConverter.getInstance();
	}
}
