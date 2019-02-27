
<!DOCTYPE html>
<html>
<body>
		<div class="w3-container">
			<form class="w3-form" method="post" action="EditarAdmin">
                <input type="hidden" name="order" value="1"/>
				<div class="w3-row">
			<div class="w3-col w3-half">
				<div class="w3-container">
					<h3>Editar Admin</h3>
					<form class="w3-form" method="post" action="Main">
						<div class="w3-input-group">
							<label>Name</label>
							<input class="w3-input" name="name" type="text" required/>
						</div>
						<div class="w3-input-group">
							<label>Id</label>
							<input class="w3-input" name="id" type="number" required/>
						</div>

                        <br>
						<input type="submit" class="w3-btn w3-cyan" value="Confirmar"/>
					</form>
				</div>
			</div>
			</form>
	</div>
</body>
</html>