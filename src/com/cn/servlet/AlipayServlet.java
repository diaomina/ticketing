package com.cn.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.cn.domain.Prep;

/**
 * 
 * @ClassName: AlipayServlet 
 * @Description: 支付宝支付接口 PC端
 * @author: ljy
 * @date: 2019年11月14日 上午1:10:23
 */
public class AlipayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL = "https://openapi.alipaydev.com/gateway.do";	//沙箱环境使用
		//String URL = "https://openapi.alipay.com/gateway.do"; 	//外网真实环境使用
		String APP_ID = "2016101400683589";  // 即创建应用后生成
		String APP_PRIVATE_KEY = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCHuMiTsXiHv1CS+VnqpiY90+iT1PZRHAFcKFb7Zoe2+1Re1/TNTlZ1CGSlJ1XKub5jRZKsL+a+Eqd2sDBBojv639nQj9yuf5on2PsNopzJLVnDyvH+WQHjZJiW/3kGNsj4oI9tB1dBIxLO1DaB3jtuVBi1wDlJRdK3pIeibgwy3jGOnPHE8wtq901KejI1XSJMrClvJfQ0f5G10GVA9Rl3dfnph/VrAm3v21Qkj6rM3HJ58/CYf/tqbl2VPrCjn+7AmuximGgD/GHRpjZtJJZ9nhDguRnPGWwsyQdAu91hWoOMEKCkur7CYyHajjmAFFjtLvLf6tdFMpxvKzCIrOnDAgMBAAECggEAe73V4hKkud+MLvR5Lp9drnFOU7qO+VR3SPbel0fb5NExE2gCIk2SNhH48Trz1WmUVB5So/rofdO0K1poJO8tkIYXqTgBFHfyrPH/s2bXW/SlKwYVrLiqKBDHrqQuS6QXh9eb7OQMga7grwJ8z9s2hFjYTp17nXqzrAuuPkHnjVgBTcvK4G9hmnYl1kSwu+swCRADutGawZab07B66y6poAy0pMLerS14XhIfjwxo1H4FVKZtQtG5IJGyWfhrRVceEiCFgH6R7gjpzR3oInSFrX1Vej4q4F1QbvPARKv/6/HDy6nKmDy3NgAtfJpnDc7kyNT63F+kJ4EpVBbmpjkHwQKBgQDUCWHLBQuv6Fm8eZlD0ONqwQAnbxAhtnmI/hU1ukEzceua0nlnjA/VCY4DLlxZ0dyen0FG8+4Eh+xOhjYQdMAAO0mR5WNS+vQqM5QhohVuwj5FHGiwg+1jDsI5NMsYDo1HMjQcQMa4uKI6Y7CNorqZWRZUuRM78G0LXqPAESAhxwKBgQCj3LabZ1PUQM79LLDHdBaK3fdKGlEpo9KzgAzVrPsrgKnZne5a8CLMZle++r31kK7lfpW589F+S6bSyZ1s4g3hQEJ6zlplsuvN0aff8Ik+AIc72RGzTLassZAC1A3Q+ijJD5kJgYBQRCBhHr7O5I6foqfNjFqjSV6ioAmaoze4JQKBgQCW4Aom9PMo+zMHKptFJxj7OFPMu3mGE5qNQQaEkYCdg507MDLU3FPTqhXT66QpAWxzriw7uYyOysz53wQPV5PbVlR2LPws6obclJD+EaAgjLTUZm+T0nwS9Uh8fjVZa9lZZL6xr+H3ROGinJbfYYBXZ429QWgPSXe+FFx+aXEstwKBgQCe8lKDbfhH1FG0Dayw3G+dZnAghmSiQpH4okZQ4omFCjo3qFV0CqmGoeONkkW/NQgh/ucXyGU24AVDRGSbIK+cBqw12YKgUa0gKbVwqS9HYFXNfOMJjGlKHLb3t2BrjK0RUzr8mIyxz1OlQaCOqe+a87lXzkSBTYMptpl6UcaTrQKBgQDTUOCkM5OOC8PvgjVP996vlBcY3DISH5FVtiaxbyR58SnxlAkTgZsRzEb36V5RaqS0bcjE3UOEaFKM5EBPFuGxWOca85mFcwFkiIgbvP8K9kaOYNVecGIU5HdDLTwfIEGAR1OsQBLFnEjvVI13XSMAyfjrmiyFT5llgTLBuZvR6Q=="; //开发者私钥，由开发者自己生成
		String FORMAT = "json"; // 参数返回格式，只支持 json
		String CHARSET = "UTF-8"; // 编码集，支持 GBK/UTF-8
		String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvjme7kFbZAMU9TDn6iZBvOFAGUaQu47mXNhZ7EgD6s5K3/NkVTDOCaqRAZ7qBpKwNdsYOeCl2JsugIZzEPtIbuPZhYSUgXlLg4+nTt5k4IHu6hQylTX82nLVlMAaCw7xmMc8OH99ym/mLvf/Os1UQVvvtbta+19bFzuaHn8fem8IXtIP3PN1NuHpYVTzKTtbJIwgM9yDCD5lfg9qIRWiSlnrzc+t+R5+aUwolORg/eyea0i/sMghbPyb/rUY6LPVKgZXhvIE8k0ebnVoVREGzilFb3L8fZWfsenLvEuiubjFJ4CpEOV7YbmorsC9KsKNMfFg3UMqimSCY+4y6hDYHQIDAQAB"; //支付宝公钥，由支付宝生成
		String SIGN_TYPE = "RSA2"; // 商户生成签名字符串所使用的签名算法类型，目前支持 RSA2 和 RSA，推荐使用 RSA2

		// 从PayServlet获取的订单信息
		Prep prep = (Prep) request.getAttribute("prep");
		
		
		
        String out_trade_no = String.valueOf(new Date()) + String.valueOf(prep.getPrepId());  // 商户订单号，商户网站订单系统中唯一订单号，必填
        String total_amount = String.valueOf(prep.getPrice())+".00";  // 付款金额，必填
        String subject = prep.getStartStation()+"站 - "+prep.getEndStation() + "站    火车票";  // 商品名称
        //String returnUrl = "http://localhost:8080/ticketing/PayServlet?temp=1&prepId="+prep.getPrepId()+""; // 回跳地址
        String returnUrl = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/ticketing/PayServlet?temp=1&prepId="+prep.getPrepId()+"";
        
		AlipayClient alipayClient = new DefaultAlipayClient(URL, APP_ID, APP_PRIVATE_KEY, FORMAT, CHARSET, ALIPAY_PUBLIC_KEY, SIGN_TYPE); // 获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		alipayRequest.setReturnUrl(returnUrl);
		alipayRequest.setNotifyUrl("http://domain.com/CallBack/notify_url.jsp");// 在公共参数中设置回跳和通知地址
		alipayRequest.setBizContent("{" + "    \"out_trade_no\":\""+out_trade_no+"\","
				+ "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," + "    \"total_amount\":"+total_amount+","
				+ "    \"subject\":\""+subject+"\"," + "    \"body\":\""+subject+"\","
				+ "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\","
				+ "    \"extend_params\":{" + "    \"sys_service_provider_id\":\"2088511833207846\"" + "    }" + "  }");// 填充业务参数
		String form = "";
		try {
			form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
		} catch (AlipayApiException e) {
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=" + CHARSET);
		response.getWriter().write(form);// 直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
