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

//���ɶ�Ӧ��ߵĳ�ʼͼƬ

              randomText = VerifyCode.drawRandomText(width,height,verifyImg);
                       /*System.out.println(randomText);*/
//������һ���෽�������ڴ��븴�ÿ��ǣ������˷�װ��

//������������֤���ַ���������㣬�����ߣ�����ֵΪ��֤���ַ�                   

                       request.getSession().setAttribute("verifyCode", randomText);

                       response.setContentType("image/png");//����������Ӧ��������ΪͼƬ������ǰ̨��ʶ��

                       OutputStream os = response.getOutputStream(); //��ȡ�ļ������    

                       ImageIO.write(verifyImg,"png",os);//���ͼƬ��

                       os.flush();

                       os.close();//�ر���

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
				System.out.println("ʧ��");
				return 0;
			}else{
				request.getSession().setAttribute("Users",dengLu);
				request.getSession().setAttribute("name",dengLu.getLoginName());
				request.getSession().setAttribute("Uid",dengLu.getUid());
				/*System.out.println(dengLu.getLoginName());*/
				System.out.println("�ɹ�");
				return 1;
			}
		}else{
			System.out.println("ʧ��");
			return 0;
		}
	}
	
	
}
