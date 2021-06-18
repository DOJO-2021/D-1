<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SEEGGS | SEARCH RESULT</title>
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

  <!--スクロールボックスここから-->


  <div class="scrollArea3">

  <!--検索結果ここから
　action以下に遷移先のサーブレットを記述してください。
  ${#} ${e.}に対象のEL式を記述してください。
  name以下に記述してください-->

  <c:forEach var="e" items="${#}" ><!--Userテーブルから結果をインポートするときの名称-->
  <form method="POST" action="/SEEGGS/#">
    <div class="textBox" name="" value=${e.}>
      <div class="TexitBox_before" value=${e.}>投稿者名</div>
      あっとほーむSEEGGS!</div>
        <!--お気に入りボタンここから-->
        <div class="mother4">
          <div class="product__fav-item">
            <button type="button" class="favorite-button" {favorite_button_attribute product_id=$product.id added_class="fav-items"}>
              <svg role="img" aria-hidden="true"><use xlink:href="#heart"></use></svg>
              お気に入り
            </button>
          </div>
        </div>
        <!--お気に入りボタンここまで-->
      </c:forEach>
  </div>
<!--検索結果ここまで-->
　<!--スクロールボックスここまで-->


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

</script>
</body>
</html>
