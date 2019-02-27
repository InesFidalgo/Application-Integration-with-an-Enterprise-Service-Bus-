
<!DOCTYPE html>
<html>
<body>
		<div class="w3-container">
			<form class="w3-form" method="post" action="EditarMaterial">
                <input type="hidden" name="order" value="1"/>
				<div class="w3-row">
			<div class="w3-col w3-half">
				<div class="w3-container">
					<h3>Editar Material</h3>
					
						<div class="w3-input-group">
							<label>Nome</label>
							<input class="w3-input" name="name" type="text" />
						</div>
						<div class="w3-input-group">
							<label>ID do Curso</label>
							<input class="w3-input" name="idc" type="number" />
						</div>
						<div class="w3-input-group">
							<label>Content</label>
							<input class="w3-input" name="content" type="text" />
						</div>
                        
                        <div class="w3-input-group">
							<label>Tamanho</label>
							<input class="w3-input" name="size" type="number" />
						</div>
                        <div class="w3-input-group">
							<label>ID do Material</label>
							<input class="w3-input" name="idc" type="number" />
						</div>
                        <br>
                        
						
						<input type="submit" class="w3-btn w3-cyan" value="Add"/>
					
				</div>
			</div>
			</form>
	</div>
</body>
</html>