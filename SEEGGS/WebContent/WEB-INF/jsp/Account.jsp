<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | ACCOUNT</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div class="wrapper">
  <!-- ヘッダー（ここから） -->


    <!--真ん中ロゴここから
      a href以下に遷移先のServletを記述してください。-->

    <h1 id="logo">
     <a href="/SEEGGS/LoginServlet"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></a>
   </h1>
   <!-- 真ん中ロゴ（ここまで） -->

  <!-- ヘッダー（ここまで） -->

  <!-- メイン（ここから） -->

  <!--アカウント作成フォームここから
    action以下に遷移先のServletを記述してください。
    a href以下に遷移先のServletを記述してください。-->

<div class="scrollArea2">
<form method="POST" enctype="multipart/form-data"  action="AccountServlet">
<div class="form-wrapper4">
  <h1>新規アカウント作成</h1>

    <div class="form-item">
      <label for="ID">ログインID</label>
      <input type="text" name="id" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
      <label for="PASSWORD">ログインパスワード</label>
      <input type="password" name="password" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="PHOTO">顔写真の登録</label>
        <input type="file" name="photo" accept="image/jpeg, image/png">
    </div>

    <div class="form-item">
    	<label for="NAME">名前</label>
    	<input type="text" name="name" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
    	<label for="COMPANY">会社名</label>
    	<input type="text" name="company" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="NICKNAME">ニックネーム</label>
        <input type="text" name="nickname" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="HOBBY">趣味は？</label>
        <input type="text" name="hobby" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="BIRTHPLACE">出身地</label>
        <input type="text" name="birthplace" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="THISISME">自分を一文字で表すと…</label>
        <input type="text" name="thisisme" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="FUTURE">コロナが収まったらやりたいことは？</label>
        <input type="text" name="future" required="required" placeholder=""></input>
    </div>

    <div class="form-item">
        <label for="WORD">研修の意気込みをどうぞ！</label>
        <input type="text" name="word" required="required" placeholder=""></input>
    </div>

</div>

    <div class="button-panel2">
      <input type="submit" class="button" title="Regist" value="登録"></input>
    </div>

  </form>


  <div class="form-footer">
    <p><a href="LoginServlet">ログイン画面にもどる</a></p>
  </div>
</div>

  <!--アカウント作成フォームここまで-->
</div>
  <!-- メイン（ここまで） -->



  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy;Copyright D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->




<!-- 以下js及びjQuery処理の記述 -->

<script src="js/jquery-3.4.1.min.js"></script>
<script>
'use strict';

$(document).ready(function() {
  /* [ログイン]ボタンをクリックしたときの処理 */
  $('#submit').on('click', function() {
    if (!$('#user_id').val() || !$('#password').val()) {
      $('#error_message').text('※IDとパスワードを入力してください！');
      return false;	/* 送信しない */
    }
    $('error_message').text(null);
    return true;	/* 送信する */
  });

});


</script>
</body>
</html>
