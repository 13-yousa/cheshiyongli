package cn.edu.seig.servlet;

import cn.edu.seig.mapper.MusicMapper;
import cn.edu.seig.utils.MyBatisUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet(name = "DeleteMusicServlet", value = "/deleteMusic")
public class DeleteMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        SqlSession session= MyBatisUtil.getSession();
        MusicMapper mapper=session.getMapper(MusicMapper.class);
        int rows=mapper.deleteMusicById(id);
        session.commit();
        session.close();
        response.sendRedirect("showAllMusics");
    }
//2240709435梁永康
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
