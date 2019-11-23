package com.cn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import com.cn.domain.Prep;
import com.cn.service.PrepService;
import com.cn.service.impl.PrepServiceImpl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import cn.hutool.poi.excel.StyleSet;

/**
 * 
 * @ClassName: ExportExcelServlet 
 * @Description: 管理员  将所有订单信息导出为excel
 * @author: ljy
 * @date: 2019年11月24日 上午2:04:49
 */
public class ExportExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从数据库中拉取数据
		PrepService prepService = new PrepServiceImpl();
		List<Prep> rows = prepService.getAll();

		
		
		// 通过工具类创建writer
		ExcelWriter writer = ExcelUtil.getWriter();
		

		// 设置单元格样式 (好像没用，待修复)
		StyleSet style = writer.getStyleSet();
		CellStyle cellStyle = style.getHeadCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER); // 水平居中  
		cellStyle.setShrinkToFit(true); //设置单元格列宽自适应
		cellStyle.setDataFormat((short) 2);
		
		

		//自定义标题别名
		writer.addHeaderAlias("prepId", "订单ID");
		writer.addHeaderAlias("trainId", "车次ID");
		writer.addHeaderAlias("pmemberId", "会员资料ID");
		writer.addHeaderAlias("startStation", "起始站");
		writer.addHeaderAlias("endStation", "终点站");
		writer.addHeaderAlias("trainNumber", "火车车次");
		writer.addHeaderAlias("startTime", "开车时间");
		writer.addHeaderAlias("endTime", "到站时间");
		writer.addHeaderAlias("price", "车票价格");
		writer.addHeaderAlias("way", "付款情况");
		writer.addHeaderAlias("booktime", "订票时间");
		
		// 合并单元格后的标题行，使用默认标题样式
		writer.merge(10, "订单中心");
		// 一次性写出内容，使用默认样式，强制输出标题
		writer.write(rows, true);
		
		//out为OutputStream，需要写出到的目标流

		//response为HttpServletResponse对象
		response.setContentType("application/vnd.ms-excel;charset=utf-8"); 
		//test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
		response.setHeader("Content-Disposition","attachment;filename=preps.xls"); 
		ServletOutputStream out=response.getOutputStream(); 

		writer.flush(out, true);
		// 关闭writer，释放内存
		writer.close();
		//此处记得关闭输出Servlet流
		IoUtil.close(out);

		
	}



}
