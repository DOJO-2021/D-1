<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | LOGIN</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>


<body>
<div class="wrapper">

  <!-- ヘッダー（ここから） -->
  <h1 id="logo">
    <a href="login.html"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></a>
  </h1>
  <!-- ヘッダー（ここまで） -->



  <!-- メイン（ここから） -->

    <!--右側ハンバーガーメニューここから-->
  <div id="navArea">

    <nav>
      <div class="inner">
        <ul>
          <li><a href="#">マイプロフィール</a></li>
          <li><a href="#">ユーザ情報</a></li>
          <li><a href="#">掲示板</a></li>
          <li><a href="#">お気に入り一覧</a></li>
          <li><a href="#">ログアウト</a></li>
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

  <!-- タイトル -->>

<div class="form-wrapper">
  <h1>ログイン</h1>


    <!-- ログインIDとPWを入力するform。LoginServletからLoginテーブルへPOSTする （ここから）-->>

    <div class="form-item">
    	<form class="form" method="POST" action="/SEEGGS/LoginServlet" name="ID" required="required" placeholder="ID">
		ID<input type="text" name="ID"><br>
      <label for="ID"></label>
    </div>
    <div class="form-item">
	PW<input type="password" name="PW"><br>
    </div>
    <div class="button-panel">
      <input type="submit" name="LOGIN" value="ログイン" id="button"><br>
    </div>
	  </form>

    <!-- ログインIDとPWを入力するform。LoginServletからLoginテーブルへPOSTする （ここまで）-->>

    <!-- 新規アカウント追加ページに飛ぶ(ここから) -->>

  <div class="form-footer">
    <p><a href="/SEEGGS/WEB-INF/jsp/Account.jsp">新規アカウント追加はこちら</a></p>
  </div>
</div>

    <!-- 新規アカウント追加ページに飛ぶ(ここまで) -->>


  <!-- メイン（ここまで） -->



  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy;Copyright D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->


</div>
<script src="scripts/jquery-3.4.1.min.js"></script>


<!-- 以下JavaScript -->>

<script>
'use strict';

<script>
$(function(){
    $('.menu-btn').on('click', function(){
      $('.menu').toggleClass('is-active');
    });
  }());
  </script>

</body>
</html>