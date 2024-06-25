package cn.edu.seig.servlet;

import cn.edu.seig.mapper.MusicMapper;
import cn.edu.seig.pojo.Music;
import cn.edu.seig.utils.MyBatisUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet(name = "FindMusicByIdServlet", value = "/findMusicById")
public class FindMusicByIdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        SqlSession session= MyBatisUtil.getSession();
        MusicMapper mapper=session.getMapper(MusicMapper.class);
        Music m=mapper.findMusicById(id);
        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("music",m);
        response.sendRedirect("updateMusic.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
