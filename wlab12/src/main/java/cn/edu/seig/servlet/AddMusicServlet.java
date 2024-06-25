package cn.edu.seig.servlet;

import cn.edu.seig.mapper.MusicMapper;
import cn.edu.seig.pojo.Music;
import cn.edu.seig.utils.MyBatisUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addMusic")
public class AddMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1 收集信息
        request.setCharacterEncoding("utf-8");
        String musicname=request.getParameter("musicname");
        String singer=request.getParameter("singer");
        int ranking=Integer.parseInt(request.getParameter("ranking"));

        //2 使用Mybatis将音乐信息添加到数据表中
        SqlSession session= MyBatisUtil.getSession();
        Music music=new Music();
        music.setMusicname(musicname);
        music.setRanking(ranking);
        music.setSinger(singer);
        //int rows = session.insert("cn.edu.seig.mapper.MusicMapper.addMusic", music);
        MusicMapper mapper = session.getMapper(MusicMapper.class);
        int i = mapper.addMusic(music);

        session.commit();

        //3 跳转到ShowAllMusicsServlet
        response.sendRedirect("showAllMusics");
//2240709435梁永康
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
