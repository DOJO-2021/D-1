<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>SEEGGS | USER</title>
<link rel="stylesheet" type="text/css" href="css/User.css">
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
</div>
  <!--右側ハンバーガーメニューここまで-->


  <!--スクロールボックスここから
  a href以下に遷移先のServletを記述してください。-->

<div class="scrollArea4">

    <c:forEach var="e" items="${UserList}" ><!--Userテーブルから結果をインポートするときの名称-->
    <form method="POST" action="UserUpdateDeleteServlet">
    	<div style="text-align: center">
  		<table>
  		<tr>
  			<td>
				<c:set var="path" value="upload\\" />
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
  				自分を一文字で表すと<input type= "text" name ="thisisme" value="${e.thisisme}"><br>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				趣味は？<input type ="text" name="hobby" value="${e.hobby}"><br>
  			</td>
  			<td>
  				今後やりたいこと<input type="text" name ="future" value="${e.future}"><br>
  			</td>
  		</tr>
  		<tr>
  			<td>
  				研修への意気込みをどうぞ!<input type="text" name="word" value="${e.word}">
  			</td>
  		</tr>
  		</table>

    <!-- 更新・削除ボタン -->
        <input type= "submit" name = "SUBMIT" value = "更新" onclick="alertFunction1()">
 	    <input type= "submit" name = "SUBMIT" value = "削除" onclick="alertFunction1()">
  	</form>
    </c:forEach>

    <!--プロフィールのポップアップここから
        a href以下に遷移先のServletを記述してください。-->

            <!--以下オープンのためのボタン-->
            <button class="open"><img src="images/プロフィール.png" width="200" height="300" alt="SEEGGS"></button>
    <!--プロフィールのポップアップここまで-->
</div>

    <!--スクロールボックスここまで-->


    <!-- メイン（ここまで） -->


    <!-- フッター（ここから） -->
        <div id="footer">
            <p>&copy; D1ユニコーンのたまご. All rights reserved.</p>
        </div>
    <!-- フッター（ここまで） -->

<!--/div-->




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
