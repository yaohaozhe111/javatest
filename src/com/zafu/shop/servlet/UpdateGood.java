package com.zafu.shop.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zafu.shop.bean.Good;
import com.zafu.shop.dao.GoodDao;

/**
 * Servlet implementation class UpdateGood
 */
@WebServlet("/UpdateGood")
public class UpdateGood extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void utf8(HttpServletResponse response,HttpServletRequest request)
    {
    	response.setContentType("text/html;charset=UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	 if (request != null) {
             try {
                 request.setCharacterEncoding("UTF-8");
             } catch (UnsupportedEncodingException e) {
                 e.printStackTrace();
             }
         }
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateGood() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		utf8(response,request);
		Good good=new Good();
//		set gname=?,gtuan=?,gmen=?,"
//				+ "gcombo=?,gnotice=?,gphoto=? where gid=?"
		int gid=Integer.parseInt(request.getParameter("gid"));		
		good=GoodDao.SelectGoodById(gid);
		
		if(request.getParameter("gtuan")!=null&&request.getParameter("gtuan")!="")
		{	
			int gtuan=Integer.parseInt(request.getParameter("gtuan"));
			good.setGtuan(gtuan);
		}
		if(request.getParameter("gmen")!=null&&request.getParameter("gmen")!="")
		{	
			int gmen=Integer.parseInt(request.getParameter("gmen"));
			good.setGmen(gmen);
		}
		
		if(request.getParameter("gname") != null&&request.getParameter("gname")!="")
		{	
			String gname=request.getParameter("gname");
			good.setGname(gname);
		}
		
		if(request.getParameter("gcombo") != null&&request.getParameter("gcombo")!="")
		{	
			String gcombo=request.getParameter("gcombo");
			good.setGcombo(gcombo);
		}
		
		if(request.getParameter("gnotice") != null&&request.getParameter("gnotice")!="")
		{	
			String gnotice=request.getParameter("gnotice");
			good.setGnotice(gnotice);
		}
		
		if(request.getParameter("gphoto") != null&&request.getParameter("gphoto")!="")
		{	
			String gphoto=request.getParameter("gphoto");
			good.setGphoto(gphoto);
		}
		
		int rs=GoodDao.updateGood(good);
		 PrintWriter writer=response.getWriter();
		 if(rs==0)
		 {
			 writer.println("�޸�ʧ��");
		 }
		 else {
			 writer.print("�޸ĳɹ�");
		 }
		 writer.write(JSON.toJSONString(good));
		 
	}

}
