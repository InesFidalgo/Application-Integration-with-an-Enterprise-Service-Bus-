
<!DOCTYPE html>
<html>
<body>
		<div class="w3-container">
			<form class="w3-form" method="post" action="EditarProfessores">
                <input type="hidden" name="order" value="1" />
				<div class="w3-row">
			<div class="w3-col w3-half">
				<div class="w3-container">
					<h3>Editar Professor</h3>
					   <div class="w3-input-group">
							<label>ID</label>
							<input class="w3-input" name="id" type="number" />
						</div>
						<div class="w3-input-group">
							<label>Name</label>
							<input class="w3-input" name="name" type="text" />
						</div>
						<div class="w3-input-group">
							<label>E-mail</label>
							<input class="w3-input" name="email" type="text" />
						</div>
						<div class="w3-input-group">
							<label>Password</label>
							<input class="w3-input" name="password" type="password" />
						</div>
                        
                        <div class="w3-input-group">
							<label>Data</label>
							<input class="w3-input" name="data" type="text" />
						</div>
                        
                        <div class="w3-input-group">
							<label>Email Alternativo</label>
							<input class="w3-input" name="alternate" type="text" required/>
						</div>
                        
                        <div class="w3-input-group">
							<label>Address</label>
							<input class="w3-input" name="address" type="text" required/>
						</div>
                        
                        <div class="w3-input-group">
							<label>Telefone</label>
							<input class="w3-input" name="tel" type="number" required/>
						</div>
                        
                        <div class="w3-input-group">
							<label>Internal Number</label>
							<input class="w3-input" name="internalnumber" type="number" required/>
						</div>
                        
                        <div class="w3-input-group">
							<label>Categoria</label>
							<input class="w3-input" name="categoria" type="text" required/>
						</div>
                        
                        <div class="w3-input-group">
							<label>Office</label>
							<input class="w3-input" name="office" type="text" required/>
						</div>
                        
                        <div class="w3-input-group">
							<label>Numero de Interno</label>
							<input class="w3-input" name="numerointerno" type="number" required/>
						</div>
  
<div class="w3-input-group">
							<label>Salario</label>
							<input class="w3-input" name="salario" type="number" />
						</div>
                        <br>
						
						<input type="submit" class="w3-btn w3-cyan" value="Editar"/>
					
				</div>
			</div>
			</form>
	</div>
</body>
</html>