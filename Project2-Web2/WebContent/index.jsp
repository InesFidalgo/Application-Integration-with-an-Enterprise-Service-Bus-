<%@ page pageEncoding="UTF-8" %>
<html>
<html lang="en">
    <head>
        <title>Upload File</title>
        <style>label { float: left; display: block; width: 75px; }</style>
    </head>
    <body>
        <form action="Materiais" method="post" enctype="multipart/form-data">
            <input type="hidden" name="order" value="1" />
           <h3>Adicionar Material</h3>
					
						<div class="w3-input-group">
							<label>Nome</label>
							<input class="w3-input" name="name" type="text" required/>
						</div>
						<div class="w3-input-group">
							<label>ID do Curso</label>
							<input class="w3-input" name="idcourse" type="number" required/>
						</div>
						
                        
                       
                        <label for="file">File:</label>
                        <input type="file" id="file" name="file" />
                        <br>
                        <input type="submit" value="Upload!" />
        </form>
    </body>
</html>