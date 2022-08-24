<%-- 
    Document   : product_form
    Created on : 28-Nov-2018, 8:34:38 PM
    Author     : TVD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product form</title>
    </head>
    <body>

        <div class="page-container">	

            <div class="left-content">

                <div class="mother-grid-inner">

                    <jsp:include page="header.jsp"></jsp:include>

                        <div class="inner-block">
                            <div class="inbox">
                                <h2>Product Details</h2>
                                <div class="col-md-12 compose-right">
                                    <div class="inbox-details-default">
                                        <div class="inbox-details-heading">
                                            Compose New Message 
                                        </div>
                                        <div class="inbox-details-body">
                                            <div class="alert alert-info">
                                                Please fill details to send a new message
                                            </div>
                                            <form class="com-mail">
                                                <label>Serial</label>
                                                <input type="text" placeholder="serial...">
                                                <label>Name</label>
                                                <input type="text" placeholder="name...">
                                                <label>Price</label>
                                                <input type="text" placeholder="price...">
                                                <label>URL</label>
                                                <input type="text" placeholder="url..." disabled="">
                                                <label>Description</label>
                                                <textarea rows="6" placeholder="description..."></textarea>
                                                <div class="form-group">
                                                    <div class="btn btn-default btn-file">
                                                        <i class="fa fa-paperclip"> </i> Attachment
                                                        <input type="file" name="attachment">
                                                    </div>
                                                </div>
                                                <input type="submit" value="Save"> 
                                            </form>
                                        </div>
                                    </div>
                                </div>

                                <div class="clearfix"> </div>     
                            </div>
                        </div>

                    <jsp:include page="footer.jsp"></jsp:include>

                    </div>

                </div>

            <jsp:include page="navigation.jsp"></jsp:include>

        </div>

    </body>
</html>
