<%@ page import="cn.edu.seig.pojo.Music" %><%--
  Created by IntelliJ IDEA.
  User: SarahDong
  Date: 2024/3/19
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!-- 下面表单用来显示并可修改音乐信息 -->
<form action="updateMusic" method="post">
    <input type="hidden" name="id" value="${music.id}"/>
    音乐名称：<input type="text" name="musicname" value="${music.musicname}"/><br>
    演唱者：<input type="text" name="singer" value="${music.singer}"/><br>
    歌曲排名：<input type="text" name="ranking" value="${music.ranking}"/><br>
    <input type="submit" value="修改"/><input type="reset" value="重置"/>
</form>


</body>
</html>
