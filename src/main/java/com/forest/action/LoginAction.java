package com.forest.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.forest.biz.LoginBiz;
import com.forest.entity.Staff;

@Controller
public class LoginAction {
	
	private static Logger log = Logger.getLogger(LoginAction.class);
	
	@Autowired
	private LoginBiz lb;
	
	@RequestMapping("/find")
	public String find() {
		//System.out.println(111);
		return "a_login";
	}
	@RequestMapping("/findshop")
	public String findShop() {
		return "c_shop";
	}
	@RequestMapping("/findstaff")
	public String findStaff() {
		return "c_staff";
	}
	@RequestMapping("/finduser")
	public String findUser() {
		return "c_user";
	}
	@RequestMapping("/findposition")
	public String findPosition() {
		return "c_position-of-authority";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> queryNameAndPwd(@RequestBody Staff user, HttpSession session) {
		log.info("页面传回的user对象为：" + user);
		String randomCode = user.getRandomCode();
		
		Map<String, String> map = new HashMap<String, String>();
		
		//执行查询，验证用户名和密码
		user = lb.queryNameAndPwd(user);
		if (user == null) {
			map.put("code", "1");
			map.put("message", "登录失败，用户名或密码输入错误！");
			return map;
		}
		
		//获取session中保存的验证码
		String randomJson = (String) session.getAttribute("randomCode");
		if (!randomJson.equalsIgnoreCase(randomCode)) {
			map.put("code", "2");
			map.put("message", "登录失败，验证码输入错误！");
			return map;
		}
		
		session.setAttribute("account", user);
		System.out.println("保存进session：" + user);

		map.put("code", "3");
		map.put("message", "登录成功！");
		return map;
	}
	
	
	
	
	
	//获取校验码
    @RequestMapping("/getRandomCode")
    public void generate(HttpServletResponse resp, HttpSession session) {
    	
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String randomCode = drawImg(output);
        // 将校验码保存到session中
        session.setAttribute("randomCode", randomCode);
        log.info("随机数：" + randomCode);
        
        /*resp.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
        resp.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expire", 0);*/

        try {
            ServletOutputStream out = resp.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            log.info("<--验证码前端写出.出现异常-->");
            e.printStackTrace();
        }
    }
    
    //绘制验证码
    private String drawImg(ByteArrayOutputStream output) {
        String code = "";
        // 随机产生4个字符
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        int width = 90;
        int height = 35;
        BufferedImage bi = new BufferedImage(width, height, 
        		BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        // 调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66, 2, 82);
        g.setColor(color);
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    //获取随机参数
    private char randomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
    
    //尚未继续开发
}
