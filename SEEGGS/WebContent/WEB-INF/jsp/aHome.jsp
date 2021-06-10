
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | HOME</title>
</head>
<body>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | HOME</title>
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


  <!--Creates the popup body-->
  <div class="popup-overlay">
    <!--Creates the popup content-->
     <div class="popup-content">
        <p>マイプロフィール</p>
       <!--popup's close button-->
       <!-- <button class="close">とじる</button> -->   </div>
  </div>
  <!--Content shown when popup is not displayed-->
  <!--<h2>jQuery Pop-Up Example</h2>-->
  <button class="open"><img src="images/プロフィール.png" width="200" height="300" alt="SEEGGS"></button>

  <!--ユーザー情報リンクボタンここから-->

    <div class="form-wrapper2">
        <div class="button-panel">
          <input type="submit" class="button" title="Login" value="ユーザー情報"></input>
        </div>
    </div>

  <!--ユーザー情報リンクボタンここまで-->

  <!--掲示板リンクボタンここから-->

    <div class="form-wrapper3">
      <div class="button-panel">
        <input type="submit" class="button" title="Login" value="掲示板"></input>
      </div>
    </div>

  <!--掲示板リンクボタンここまで-->

  <!-- メイン（ここまで） -->


  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy; D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->

</div>




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

  /* [リセット]ボタンをクリックしたときの処理
  $('#reset').on('click', function() {
    $('#error_message').text(null);
  }); */

});

(function($) {
  var $nav   = $('#navArea');
  var $btn   = $('.toggle_btn');
  var $mask  = $('#mask');
  var open   = 'open'; // class
  // menu open close
  $btn.on( 'click', function() {
    if ( ! $nav.hasClass( open ) ) {
      $nav.addClass( open );
    } else {
      $nav.removeClass( open );
    }
  });
  // mask close
  $mask.on('click', function() {
    $nav.removeClass( open );
  });
} )(jQuery);

//「マイプロフィール」ボタンがクリックされたときに、activeを .popup および .popup-content に追加
$(".open").on("click", function(){
  $(".popup-overlay, .popup-content").addClass("active");
});

//「閉じる」ボタンがクリックされたときに、activeを .popup および .popup-content から削除
$(".close, .popup-overlay").on("click", function(){
  $(".popup-overlay, .popup-content").removeClass("active");
});


</script>
</body>
</html>
