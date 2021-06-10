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


    <!--真ん中ロゴここから
      a href以下に遷移先のServletを記述してください。-->

    <h1 id="logo">
     <a href="login.html"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></a>
   </h1>
   <!-- 真ん中ロゴ（ここまで） -->

  <!-- ヘッダー（ここまで） -->

  <!-- メイン（ここから） -->

  <!--右側ハンバーガーメニューここから
      a href以下に遷移先のServletを記述してください。-->

  <div id="navArea">

    <nav>
      <div class="inner">
        <ul>
          <li><a href="home.html">ホーム</a></li>
          <li><a href="#">マイプロフィール</a></li>
          <li><a href="user.html">ユーザー情報</a></li>
          <li><a href="board.html">掲示板</a></li>
          <li><a href="favor.html">お気に入り一覧</a></li>
          <li><a href="login.html">ログアウト</a></li>
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

  <!--ログインフォームここから
    action以下に遷移先のServletを記述してください。
    a href以下に遷移先のServletを記述してください。-->

  <form method="GET" action="home.html">
<div class="form-wrapper">
  <h1>ログイン</h1>
  <form>
    <div class="form-item">
      <label for="ID"></label>
      <input type="ID" name="ID" required="required" placeholder="ID"></input>
    </div>
    <div class="form-item">
      <label for="PW"></label>
      <input type="PW" name="PW" required="required" placeholder="PW"></input>
    </div>
    <div class="button-panel">
      <input type="submit" class="button" title="Login" value="Login"></input>
    </div>
  </form>
  <div class="form-footer">
    <p><a href="#"><u>新規アカウント登録はこちら</u></a></p>
  </div>
</div>

  <!--ログインフォームここまで-->

  <!-- メイン（ここまで） -->


  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy;Copyright D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->

</div>


<!-- 以下js及びjQuery処理の記述 -->

<script src="scripts/jquery-3.4.1.min.js"></script>
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

//ハンバーガーメニューのjs

(function($) {
  var $nav   = $('#navArea');
  var $btn   = $('.toggle_btn');
  var $mask  = $('#mask');
  var open   = 'open'; // class指定
  // menuオープン
  $btn.on( 'click', function() {
    if ( ! $nav.hasClass( open ) ) {
      $nav.addClass( open );
    } else {
      $nav.removeClass( open );
    }
  });
  // ポップアップ閉じる
  $mask.on('click', function() {
    $nav.removeClass( open );
  });
} )(jQuery);

//ハンバーガーメニューのjsここまで

</script>
</body>
</html>
