<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>SEEGGS | THREAD</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>

<body>
<div class="wrapper">
  <!-- ヘッダー（ここから） -->

    <!--左上ロゴここから
      a href以下に遷移先のServletを記述してください。 -->

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

  <!--スクロールボックスここから-->

<table>
<tb>
<div class=mother6>
<div class="scrollArea3">

  <!--スレッドここから
	action以下に遷移先のサーブレットを記述してください。
	対象のEL式を記述してください。
  name以下に記述してください-->

<c:forEach var="e" items="${BoardList}" varStatus="status"><!--Userテーブルから結果をインポートするときの名称-->
  <form method="POST" action="AThreadServlet">
  <div class="TexitBox_before" >${e.m_number} </div>
  <div class="textBox">${e.contents}</div>
      <!-- 更新・削除ボタン -->
        <input type= "submit" name = "SUBMIT" value = "更新" onclick="alertFunction1()">
 	    <input type= "submit" name = "SUBMIT" value = "削除" onclick="alertFunction1()">
   </c:forEach>
    </div>
   </div>
  </form>

  <!--スレッドここまで-->

</div>
<!--スクロール閉じタグ-->
</div><!--スクロールボックスここまで-->
</tb>

  <!--投稿フォームここから-->
  <tb>
  <div class=mother7>
  <form method="POST" enctype="multipart/form-data"  action="RegistServlet">
    <div class="form-wrapper6">
      <div class="textBox2">
        <div class="TexitBox2_before" ></div>
        <input type="text" name="contents" title="内容を書き込んで投稿してみよう！" value="書き込む"></input>
      </div>

        <div class="button-panel2">
          <input type="submit" class="button" title="内容を投稿しますか？" value="投稿"></input>
        </div>
    </div>
    <!--hidden属性を付与ここから-->
    <input type="hidden" name="type" value="${e.type}"></input>
    <!--hidden属性を付与ここまで-->
  </form>
  </div>
  </tb>
  </table>
  </div>
  <!--投稿フォームここまで-->

  <!-- メイン（ここまで） -->


  <!-- フッター（ここから） -->
  <div id="footer">
    <p>&copy; D1ユニコーンのたまご. All rights reserved.</p>
  </div>
  <!-- フッター（ここまで） -->



<!--お気に入りボタンSVGアニメーションここから-->
<svg xmlns="http://www.w3.org/2000/svg" style="display:none"><symbol id="heart" viewBox="0 0 1792 1792"><path d="M896 1664q-26 0-44-18l-624-602q-10-8-27.5-26T145 952.5 77 855 23.5 734 0 596q0-220 127-344t351-124q62 0 126.5 21.5t120 58T820 276t76 68q36-36 76-68t95.5-68.5 120-58T1314 128q224 0 351 124t127 344q0 221-229 450l-623 600q-18 18-44 18z"/></symbol>
</svg>
<!--お気に入りボタンSVGアニメーションここまで-->

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
