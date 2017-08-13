<%@include file="shared/header.jsp" %>
<h1>Viewing All Files:</h1>
<table class="table table-bordered" style="table-layout:fixed;overflow-wrap:break-word">
    <thead>
        <tr>
            <th>ID</th>
            <th>File Name</th>
            <th>Preview</th>
            <th>Action</th>
        </tr>
    </thead>
    <c:forEach var="file" items="${allfiles}">
        <tr>
            <td>${file.fileId}</td>
            <td>${file.fileName}</td>
            <td>
                <!--<img src="${SITE_URL}/download/${file.fileId}" height="50"/>-->
            </td>
            <td>
                <a href="${SITE_URL}/view/${file.fileId}" class="btn btn-success" title="View file">
                    <span class="glyphicon glyphicon-eye-open"></span>
                </a>
                <a href="${SITE_URL}/download/${file.fileId}" class="btn btn-primary" title="Download file">
                    <span class="glyphicon glyphicon-floppy-disk"></span>
                </a>
                <a href="${SITE_URL}/delete/${file.fileId}" class="btn btn-danger" title="Delete file">
                    <span class="glyphicon glyphicon-trash"></span>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="shared/footer.jsp" %>