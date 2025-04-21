<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>手機資料結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
	</head>
	<body style="padding: 20px">
		<div class="pure-form">
			<h2>手機資料結果</h2>
			<fieldset>
				<legend>Phone Result</legend>
				推薦方案: ${ phoneplan.phoneType }<p />
				通話分鐘數(分鐘): ${ phoneplan.min }<p />
				上網流量: ${ phoneplan.gb }<p />
				<a href="/JavaWeb/phone" class="pure-button pure-button-primary">返回</a>
			</fieldset>
		</div>
	</body>
</html>