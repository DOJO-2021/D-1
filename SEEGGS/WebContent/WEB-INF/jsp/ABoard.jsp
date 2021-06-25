<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SEEGGS | BOARD</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>

<body>
<div class="wrapper">
  <!-- ヘッダー（ここから） -->

    <!--左上ロゴここから
      a href以下に遷移先のServletを記述してください。-->

        <a href="/SEEGGS/AHomeServlet"><div style="position:absolute; top:20px; left:30px;"><img src="images/logo.png" width="300" height="100" alt="SEEGGS"></div></a>

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

  <!--検索バーここから
  action以下に遷移先を記述してください-->

  <div class="mother">
  <form method="get" action="SerchServlet" class="search_container">
    <input type="text" size="25" placeholder="　キーワード検索">
    <input type="submit" value="&#xf002">
  </form>
  </div>

  <!--検索バーここまで-->

  <!--掲示板カテゴリここから
  a href以下に遷移先を記述してください-->

    <div class="mother2">
      <!--ノウハウ共有スレッドボタンここから-->
        <div class="form-wrapper2">
            <div class="button-panel3">
              <a href="/SEEGGS/AThreadServlet?type=1"><input type="submit" class="button" title="Login" value="ノウハウ共有掲示板"></input></a>
            </div>
        </div>
      <!--ノウハウ共有スレッドボタンここまで-->

      <!--エラー共有スレッドボタンここから-->
        <div class="form-wrapper3">
          <div class="button-panel3">
              <a href="/SEEGGS/AThreadServlet?type=2"><input type="submit" class="button" title="Login" value="エラー共有掲示板"></input></a>
          </div>
        </div>
      <!--エラー共有スレッドボタンここまで-->

      <!--お悩み相談スレッドボタンここから-->
      <div class="form-wrapper3">
        <div class="button-panel3">
            <a href="/SEEGGS/AThreadServlet?type=3"><input type="submit" class="button" title="Login" value="お悩み相談掲示板"></input></a>
        </div>
      </div>
      <!--お悩み相談スレッドボタンここまで-->
    </div>

    <div class="mother3">
      <!--質問スレッドボタンここから-->
        <div class="form-wrapper2">
            <div class="button-panel3">
              <a href="/SEEGGS/AThreadServlet?type=4"><input type="submit" class="button" title="Login" value="講師に質問！"></input></a>
            </div>
        </div>
      <!--質問スレッドボタンここまで-->

      <!--ジモトークスレッドボタンここから-->
        <div class="form-wrapper3">
          <div class="button-panel3">
              <a href="/SEEGGS/AThreadServlet?type=5"><input type="submit" class="button" title="Login" value="ジモトーーーク！"></input></a>
          </div>
        </div>
      <!--ジモトークスレッドスレッドボタンここまで-->

      <!--休日何してるスレッドボタンここから-->
      <div class="form-wrapper3">
        <div class="button-panel3">
            <a href="/SEEGGS/AThreadServlet?type=6"><input type="submit" class="button" title="Login" value="休日何してる？"></input></a>
        </div>
      </div>
      <!--休日何してるスレッドボタンここまで-->
    </div>
  <!--掲示板カテゴリここまで-->

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
