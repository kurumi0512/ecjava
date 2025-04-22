<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>早餐店的點餐系統-訂單結果</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		
	</head>
	<body style="padding: 20px">
		<div class="pure-form">
			<h2>早餐店的點餐系統-訂單結果</h2>
			<fieldset>
				<legend>訂單列表</legend>
				<c:set var="totalPriceSum" value="0" />
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>No</th>
							<th>主餐</th>
							<th>飲料</th>
							<th>配料</th>
							<th>價格</th>
							<th>刪除</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach varStatus="i" var="breakfastOrder"
						items="${ breakfastOrders }">
						<tr>
							<td>${ i.index + 1 }</td>
							<td>${ breakfastOrder.mainDish.name }</td>
							<td>${ breakfastOrder.drink.name }</td>
							<td><c:if
									test="${not empty breakfastOrder.topping.toppings}">
                ${ breakfastOrder.topping.toppings }
            </c:if> <c:if test="${empty breakfastOrder.topping.toppings}">
                無配料
            </c:if></td>
							<td><fmt:formatNumber value="${ breakfastOrder.totalPrice }"
									type="currency" maxFractionDigits="0" /></td>
							<td title="按我一下刪除" style="cursor: pointer;">❌</td>
						</tr>
						<!-- 累加總價 -->
						<c:set var="totalPriceSum"
							value="${ totalPriceSum + breakfastOrder.totalPrice }" />
					</c:forEach>
					</tbody>
					<tfoot>
						<tr style="background-color: #DDDDDD">
							<td colspan="3" style="text-align: right;">總金額</td>
							<td>
								<fmt:formatNumber value="${ totalPriceSum }" type="currency" maxFractionDigits="0" />
							</td>
						</tr>
					</tfoot>
				</table>
				
				<a href="/JavaWeb/breakfast" class="pure-button pure-button-primary">返回</a>
			</fieldset>
		</div>
	</body>
</html>