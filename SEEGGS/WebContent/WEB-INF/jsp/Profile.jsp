<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div class="wrapper">
<!--  -->
  <!-- ヘッダー（ここから） -->

    <!--左上ロゴここから
      a href以下に遷移先のServletを記述してください。-->

        <a href="/SEEGGS/HomeServlet""><div style="position:absolute; top:20px; left:30px;"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></div></a>

      <!-- 左上ロゴ（ここまで） -->

  <!-- ヘッダー（ここまで） -->

  <!-- メイン（ここから） -->

  <!--右側ハンバーガーメニューここから
      a href以下に遷移先のServletを記述してください。-->

<div id="navArea">

    <nav>
      <div class="inner">
        <ul>
          <li><a href="HomeServlet">ホーム</a></li>
          <li><a href="ProfileServlet">マイプロフィール</a></li>
          <li><a href="UserServlet">ユーザー情報</a></li>
          <li><a href="BoardServlet">掲示板</a></li>
          <li><a href="FavorServlet">お気に入り一覧</a></li>
          <li><a href="LogoutServlet">ログアウト</a></li>
        </ul>
      </div>
    </nav>

    <div class="toggle_btn">
      <span></span>
      <span></span>
      <span></span>
    </div>

    <div id="mask"></div>

  </div>

  <!--右側ハンバーガーメニューここまで-->

  <p>マイプロフィール</p>
  		<c:forEach var= "e" items="${sessionScope.User}">
  	<form method="POST" action="ProfileServlet">
  		<table>
  		<tr>
  			<td>
  			 <c:set var="path" value="upload\\"/>
  			 	写真<img width="128" height="128" alt="プロフィール画像" src="${path}${e.photo}"><br>
  			 	 <input type="file" name="photo" accept="image/jpeg, image/png">
  			</td>
  			<td>
  				名前<input type="text" name="name" value="${e.name}"><br>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				会社<input type="text" name="company" value="${e.company}"><br>
  			</td>
  			<td>
  				ニックネーム<input type ="text" name="nickname" value="${e.nickname}"><br>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				出身地<input type ="text" name="birthplace" value="${e.birthplace}"><br>
  			</td>
  			<td>
  				自分を一文字で表すと<input type= "text" name ="thisisme" value="${e.thisisme }"><br>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				趣味は？<input type ="text" name="hobby" value="${e.hobby}"><br>
  			</td>
  			<td>
  				今後やりたいこと<input type="text" name ="future" value="${e.future }"><br>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				研修への意気込みをどうぞ!<input type="text" name="word" value="${e.word }">
  			</td>
  		</tr>
  		</table>
  		<input type="submit" name="SUBMIT" value="更新" onclick="alertFunction1()">
  	</form>
  		</c:forEach>

  </div>

  <script>
 function alertFunction1(){
	alert("更新しますか？");
 }
  </script>