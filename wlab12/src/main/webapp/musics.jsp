<%@ page import="java.util.List" %>
<%@ page import="cn.edu.seig.pojo.Music" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>音乐管理系统</title>
    <style>
        table,th{
            border-spacing: 0em;
            margin-left: 1px;
            border: 1px solid #220808;
            border-collapse: collapse;
        }/*设置表格最外层边框实线*/
        th{
            color: white;
            background-color: rgba(38, 45, 59, 0.767);
        }
        td{
            border: 1px dashed;
        }/*设置单元格边框纵向虚线*/
        tr{
            vertical-align: top;
            border: 1px dashed;
        }/*设置单元格边框横向虚线*/
    </style>
</head>
<body>

<form action="" method="post">
    按歌名查找：<input type="text" name="musicName"/>
    <input type="submit" value="搜索"/>
</form>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="addMusic.jsp">添加音乐</a>
<%--<%
    List<Music> musics=(List<Music>) session.getAttribute("allMusics");
    //5.获取并输出查询结果
    out.println("<table width='50%' style='border-spacing: 0em;margin-left: 1px;border: 1px solid #220808;border-collapse: collapse;'>");
    out.println("<tr><th>id</th><th>歌名</th><th>演唱者</th><th>排名</th><th>编辑</th></tr>");
    for (Music music : musics) {
        out.println("<tr>");
        out.println("<td>"+music.getId()+"</td>");
        out.println("<td>"+music.getMusicname()+"</td>");
        out.println("<td>"+music.getSinger()+"</td>");
        out.println("<td>"+music.getRanking()+"</td>");
        out.println("<td>");
            out.println("<a href='findMusicById?id="+music.getId()+"'>修改</a>");
            out.println("<a href='deleteMusic?id="+music.getId()+"'>删除</a>");
        out.println("</td>");
        out.println("</tr>");
    }
out.println("</table>");

%>--%>
<table>
    <tr>
        <th>序号</th>
        <th>歌名</th>
        <th>演唱者</th>
        <th>排名</th>
        <th>编辑</th>
    </tr>
    <c:forEach items="${allMusics}" var="music" varStatus="s">
        <tr>
            <td>${s.index+1}</td>
            <td>${music.musicname}</td>
            <td>${music.singer}</td>
            <td>${music.ranking}</td>
            <td>
                <a href='findMusicById?id=${music.id}'>修改</a>
                <a href='deleteMusic?id=${music.id}'>删除</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
