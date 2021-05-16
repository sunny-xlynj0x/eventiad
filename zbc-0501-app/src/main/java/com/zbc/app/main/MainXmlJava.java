package com.zbc.app.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.zbc.app.config.JavaMainConf;
import com.zbc.app.spring.MemberInfoPrinter;
import com.zbc.app.spring.MemberRegisterService;
import com.zbc.app.spring.RegisterRequest;

public class MainXmlJava {

	public static void main(String[] args) {
		ApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:main-conf.xml");
		MemberRegisterService regSvc =
				ctx.getBean("memberRegSvc", MemberRegisterService.class);
		MemberInfoPrinter infoPrinter =
				ctx.getBean("infoPrinter", MemberInfoPrinter.class);

		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("madvirus@madvirus.net");
		regReq.setName("최범균");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.regist(regReq);

		infoPrinter.printMemberInfo("madvirus@madvirus.net");
	}
}