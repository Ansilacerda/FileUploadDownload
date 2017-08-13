<%@include file="shared/header.jsp" %>
<h1>Upload Files to Database</h1>
<form method="post" action="${SITE_URL}/doUpload" enctype="multipart/form-data">
    <table>
        <tr>
            <td><b>Pick a File: &nbsp;</b></td>
            <td><input type="file" name="fileUpload" size="50"/></td>
        </tr>
        <!--                    <tr>
                                <td>Pick File #2:</td>
                                <td><input type="file" name="fileUpload" size="50"/></td>
                            </tr>-->
        <tr>
            <td><input type="submit" class="btn btn-success" value="Upload"/></td>
        </tr>
    </table>
</form>
<%@include file="shared/footer.jsp" %>