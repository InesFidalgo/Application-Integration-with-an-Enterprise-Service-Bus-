<html>
<html lang="en">
    <head>
        <title>Upload File</title>
        <style>label { float: left; display: block; width: 75px; }</style>
    </head>
    <body>
        <form action="DownloadMaterial" method="post" enctype="multipart/form-data">
            <input type="hidden" name="order" value="1" />
           <h3>Download Material</h3>

                    <div class="w3-input-group">
                        <label>Nome do ficheiro</label>
                        <input class="w3-input" name="filename" type="text" required/>
                    </div>

                    <br>
                    <input type="submit" value="Download!" />
        </form>
    </body>
</html>