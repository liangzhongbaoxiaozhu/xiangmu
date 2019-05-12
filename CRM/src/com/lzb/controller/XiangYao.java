package com.lzb.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzb.entity.Users;
import com.lzb.service.UsersService;
import com.lzb.service.VerifyCode;


@Controller
public class XiangYao {
	
	@Autowired
	private UsersService usersService;
	
	private String randomText;
	@RequestMapping("/getVerifyCode ")
    public void getVerificationCode(HttpServletResponse response,HttpServletRequest request) {

              try {

                       int width=180;

                       int height=50;

              BufferedImage verifyImg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

//生成对应宽高的初始图片

              randomText = VerifyCode.drawRandomText(width,height,verifyImg);
                       /*System.out.println(randomText);*/
//单独的一个类方法，出于代码复用考虑，进行了封装。

//功能是生成验证码字符并加上噪点，干扰线，返回值为验证码字符                   

                       request.getSession().setAttribute("verifyCode", randomText);

                       response.setContentType("image/png");//必须设置响应内容类型为图片，否则前台不识别

                       OutputStream os = response.getOutputStream(); //获取文件输出流    

                       ImageIO.write(verifyImg,"png",os);//输出图片流

                       os.flush();

                       os.close();//关闭流

              } catch (IOException e) {

                      /* this.logger.error(e.getMessage());*/

                       e.printStackTrace();
              }
	}
	
	@RequestMapping(value="/DengLu",method={RequestMethod.POST})
	@ResponseBody
	public Integer DengLu(String name,String password,String YanZhengMa,HttpServletRequest request){
		
		if(randomText.equals(YanZhengMa)){
			Users users=new Users();
			users.setLoginName(name);
			users.setPassWord(password);
			Users dengLu = usersService.DengLu(users);
			/*System.out.println(dengLu);*/
			if(dengLu==null){
				System.out.println("失败");
				return 0;
			}else{
				request.getSession().setAttribute("Users",dengLu);
				request.getSession().setAttribute("name",dengLu.getLoginName());
				request.getSession().setAttribute("Uid",dengLu.getUid());
				/*System.out.println(dengLu.getLoginName());*/
				System.out.println("成功");
				return 1;
			}
		}else{
			System.out.println("失败");
			return 0;
		}
	}
	
	
}
