<%--
  Created by IntelliJ IDEA.
  User: SarahDong
  Date: 2024/3/19
  Time: 18:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="addMusic" method="post">
    音乐名称：<input type="text" name="musicname"/><br>
    演唱者：<input type="text" name="singer"/><br>
    歌曲排名：<input type="text" name="ranking"/><br>
    <input type="submit" value="添加"/><input type="reset" value="重置"/>
</form>

</body>
</html>
