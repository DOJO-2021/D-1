<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<div class="wrapper">
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

   <div class="popup-overlay">
    <!--以下プロフィール中身を記述してください-->
  <div class="popup-content">
    <p>マイプロフィール</p>
  <!--Userテーブルから結果をインポートするときの名称-->
    <form method="POST" action="UserServlet">
        <table>
        <tr>
            <td>
                写真<input type="text" name="photo" value="photo"><br>
        </td>
        <td>
                名前<input type="text" name="name" value="name"><br>
        </td>
    </tr>
    <tr>
        <td>
                会社<input type="text" name="company" value="company"><br>
                </td>
        <td>
                ニックネーム<input type="text" name="nickname" value="nickname"><br>
        </td>
    </tr>
    <tr>
        <td>
                出身地<input type="text" name="birthplace" value="bithplace"><br>
        </td>
        <td>
                自分を一文字で表すと…<input type="text" name="address" value="thisisme"><br>
        </td>
    </tr>
    <tr>
        <td>
                趣味は？<input type="text" name="zip_code" value="hobby"><br>
        </td>
        <td>
                今後やりたいこと<input type="text" name="tel" value="future"><br>
        </td>
    </tr>
    <tr>
        <td>
                研修への意気込みをどうぞ！<input type="text" name="fax" value="word"><br>
        </td>
        <td>
    </tr>
    </table>
    		<input type="button" name="update" value="登録">
    </form>

  </div>
 </div>
</div>
</body>
</html>