<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | HOME</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div class="wrapper">
  <!-- ヘッダー（ここから） -->

    <!--左上ロゴここから
      a href以下に遷移先のServletを記述してください。-->

       <a href="/SEEGGS/AHomeServlet""><div style="position:absolute; top:20px; left:30px;"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></div></a>

      <!-- 左上ロゴ（ここまで） -->

  <!-- ヘッダー（ここまで） -->

  <!-- メイン（ここから） -->

  <!--右側ハンバーガーメニューここから
      a href以下に遷移先のServletを記述してください。-->

  <div id="navArea">

    <nav>
      <div class="inner">
        <ul>
          <li><a href="AHomeServlet">ホーム</a></li>
          <li><a href="ProfileServlet">マイプロフィール</a></li>
          <li><a href="AUserServlet">ユーザー情報</a></li>
          <li><a href="ABoardServlet">掲示板</a></li>
          <li><a href="AFavorServlet">お気に入り一覧</a></li>
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

  <!--プロフィールのポップアップここから
  a href以下に遷移先のServletを記述してください。-->


  <div class="popup-overlay">
    <!--以下プロフィール中身を記述してください-->
     <div class="popup-content">
        <p>マイプロフィール</p>
     </div>
  </div>
  <!--以下オープンのためのボタン-->
  <button class="open"><img src="images/プロフィール.png" width="200" height="300" alt="SEEGGS"></button>

  <!--プロフィールのポップアップここまで-->

<div class="mother">
  <!--ユーザー情報リンクボタンここから-->
    <div class="form-wrapper2">
        <div class="button-panel">
          <a href="/SEEGGS/UserServlet"><input type="submit" class="button" title="Login" value="ユーザー情報"></input></a>
        </div>
    </div>
  <!--ユーザー情報リンクボタンここまで-->

  <!--掲示板リンクボタンここから-->

    <div class="form-wrapper3">
      <div class="button-panel">
          <a href="/SEEGGS/BoardServlet"><input type="submit" class="button" title="Login" value="掲示板"></input></a>
      </div>
    </div>

  <!--掲示板リンクボタンここまで-->
</div>
  <!-- メイン（ここまで） -->


  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy; D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->

</div>




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

//ハンバーガーメニューここから

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

//ハンバーガーメニューここまで



//プロフィールポップアップのjs

//「マイプロフィール」ボタンがクリックされたときに、activeを .popup および .popup-content に追加
$(".open").on("click", function(){
  $(".popup-overlay, .popup-content").addClass("active");
});

//「閉じる」ボタンがクリックされたときに、activeを .popup および .popup-content から削除
$(".close, .popup-overlay").on("click", function(){
  $(".popup-overlay, .popup-content").removeClass("active");
});

//プロフィールポップアップのjsここまで

</script>
</body>
</html>
