<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>早餐店的點餐系統</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		
	</head>
	<body style="padding: 20px">
		<div>
			<h2>早餐店的點餐系統</h2>
			<form class="pure-form" method="POST" action="/JavaWeb/breakfast">
				<fieldset>
					<legend>選擇主餐</legend>
					<!-- 單選 Servlet 後台使用 req.getParamter("mainDish") 會得到 String -->
					<input type="radio" name="mainDish" value="蛋餅" checked>蛋餅(35 元)<p />
					<input type="radio" name="mainDish" value="漢堡">漢堡(40 元)<p />
					<input type="radio" name="mainDish" value="三明治">三明治(30 元)<p />
				</fieldset>
				<fieldset>
					<legend>選擇飲料</legend>
					<!-- 單選 Servlet 後台使用 req.getParamter("drink") 會得到 String -->
					<input type="radio" name="drink" value="豆漿" checked>豆漿(15 元)<p />
					<input type="radio" name="drink" value="紅茶" >紅茶(20 元)<p />
					<input type="radio" name="drink" value="牛奶" >牛奶(25 元)<p />
				</fieldset>
				<fieldset>
					<legend>加配料(10元)</legend>
					<!-- 多選 Servlet 後台使用 req.getParamterValues("toppings") 會得到 String[] -->
					<input type="checkbox" name="toppings" value="蛋"> 蛋<p />
					<input type="checkbox" name="toppings" value="起司"> 起司<p />
					<input type="checkbox" name="toppings" value="肉鬆"> 肉鬆<p />
					<input type="checkbox" name="toppings" value="肉片"> 肉片<p />
				</fieldset>
				<button type="submit" class="pure-button pure-button-primary">結帳</button>
			</form>
		</div>
	</body>
</html>