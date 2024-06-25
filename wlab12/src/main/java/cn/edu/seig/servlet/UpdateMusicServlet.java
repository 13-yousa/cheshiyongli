package cn.edu.seig.servlet;

import cn.edu.seig.mapper.MusicMapper;
import cn.edu.seig.pojo.Music;
import cn.edu.seig.utils.MyBatisUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

@WebServlet(name = "UpdateMusicServlet", value = "/updateMusic")
public class UpdateMusicServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String musicname=request.getParameter("musicname");
        String singer=request.getParameter("singer");
        int ranking=Integer.parseInt(request.getParameter("ranking"));
        int id=Integer.parseInt(request.getParameter("id"));

        Music music=new Music();
        music.setMusicname(musicname);
        music.setRanking(ranking);
        music.setSinger(singer);
        music.setId(id);

        SqlSession session=MyBatisUtil.getSession();
        MusicMapper mapper = session.getMapper(MusicMapper.class);

        int row=mapper.updateMusic(music);
        session.commit();
        response.sendRedirect("showAllMusics");
    }
//2240709435梁永康
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
