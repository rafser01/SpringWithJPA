<%-- 
    Document   : cartList
    Created on : Oct 24, 2019, 6:13:20 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-12">
        <div class="row">
            <h4>Cart Items</h4>
        </div>
        <div class="row">
            <table border="1" >
                <tr>
                    <td>Name</td>
                    <td>Quantity</td>
                    <td>Price</td>
                    <td>Sub Total</td>
                </tr>


                <c:forEach var="item" items="${sessionScope.cart}" varStatus="loop">
                    <tr>
                        <td>
                            ${item.product.name}
                        </td>
                        <td>
                            ${item.quantity}
                        </td>
                        <td>
                            ${item.product.price}
                        </td>
                        <td>
                            ${item.quantity*item.product.price}
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>

