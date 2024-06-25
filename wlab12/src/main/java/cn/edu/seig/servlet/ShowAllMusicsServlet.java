package cn.edu.seig.servlet;

import cn.edu.seig.mapper.MusicMapper;
import cn.edu.seig.pojo.Music;
import cn.edu.seig.utils.MyBatisUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

@WebServlet("/showAllMusics")
public class ShowAllMusicsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 使用Mybatis将查询所有音乐信息
        SqlSession session= MyBatisUtil.getSession();
        //List<Music> musics = session.selectList("cn.edu.seig.mapper.MusicMapper.findAllMusics");
        MusicMapper mapper = session.getMapper(MusicMapper.class);
        List<Music> allMusics = mapper.findAllMusics();


        //2 将查询到的音乐信息保存到session中
        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("allMusics",allMusics);

        //3 页面跳转到 musics.jsp
        response.sendRedirect("musics.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
//2240709435梁永康