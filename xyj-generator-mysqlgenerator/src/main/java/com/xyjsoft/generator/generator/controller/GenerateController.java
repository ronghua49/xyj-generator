package com.xyjsoft.generator.generator.controller;

import com.xyjsoft.generator.generator.utils.ZipUtils;
import oracle.jdbc.proxy.annotation.Post;
import org.apache.commons.io.IOUtils;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xyjsoft.generator.core.http.HttpResult;
import com.xyjsoft.generator.dbms.vo.ConnParam;
import com.xyjsoft.generator.generator.service.GenerateService;
import com.xyjsoft.generator.generator.vo.GenerateModel;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * 代码生成控制器
 * @author Louis
 * @date Nov 9, 2018
 */
@RestController
@RequestMapping("")
public class GenerateController {

	@Autowired
	GenerateService generatorService;
	
	@PostMapping("/testConnection")
	public HttpResult testConnection(@RequestBody ConnParam connParam) {
		boolean success = generatorService.testConnection(connParam);
		if(success) {
			return HttpResult.ok(generatorService.testConnection(connParam));
		}
		return HttpResult.error("连接失败,请检查数据库及连接。");
	}

	@GetMapping("/testConnection2")
	public HttpResult testConnection2() {
		ConnParam connParam = new ConnParam();
		connParam.setDbName("SmartCard");
		connParam.setDbType("MySQL");
		connParam.setHost("114.116.212.143");
		connParam.setPassword("rhh123");
		connParam.setPort(3306);
		connParam.setUserName("root");
		return HttpResult.ok(generatorService.getTables(connParam));
	}

	@PostMapping("/getTables")
	public HttpResult getTables(@RequestBody ConnParam connParam) {
		return HttpResult.ok(generatorService.getTables(connParam));
	}
	
	@PostMapping("/getGenerateModel")
	public HttpResult getGenerateModel(@RequestBody GenerateModel generateModel) {
		return HttpResult.ok(generatorService.getGenerateModel(generateModel));
	}
	
	@PostMapping("/generateModels")
	public HttpResult generateModels(@RequestBody GenerateModel generateModel) throws Exception {
		return HttpResult.ok(generatorService.generateModels(generateModel));
	}

	@GetMapping("/download")
	public void download(@RequestParam String path,HttpServletResponse response) throws Exception {
		String folder=System.getProperty("java.io.tmpdir");
		File file = new File(folder, UUID.randomUUID()+".zip");
		File target = file;
		FileOutputStream outputStream = new FileOutputStream(file);
		ZipUtils.toZip(path,outputStream,true);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/octet-stream");
		//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		response.addHeader("Content-Disposition","attachment;filename=" + new String("generatorCode.zip".getBytes(),"utf-8"));
		FileInputStream inputStream = new FileInputStream(target);
		OutputStream outputStream2 = response.getOutputStream();
		IOUtils.copy(inputStream,outputStream2);
		outputStream.flush();
		outputStream.close();
		inputStream.close();

	}

	@GetMapping("/test")
	public void download(HttpServletResponse response) throws Exception {
		String folder=System.getProperty("java.io.tmpdir");
		File file = new File(folder, UUID.randomUUID()+".zip");
		File target = file;
		FileOutputStream outputStream = new FileOutputStream(file);
		ZipUtils.toZip("D:\\ideaWorkingSpace\\svn\\ytl\\alarm_service\\src\\main\\java\\com\\xyjsoft\\alarms\\service\\impl",outputStream,true);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/octet-stream");
		//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
		response.addHeader("Content-Disposition","attachment;filename=" + new String("generatorCode.zip".getBytes(),"utf-8"));
		FileInputStream inputStream = new FileInputStream(target);
		OutputStream outputStream2 = response.getOutputStream();
		IOUtils.copy(inputStream,outputStream2);
		outputStream.flush();
		outputStream.close();
		inputStream.close();

	}




	
}
