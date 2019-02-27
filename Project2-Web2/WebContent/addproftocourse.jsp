
<!DOCTYPE html>
<html>
<body>
		<div class="w3-container">
			<form class="w3-form" method="post" action="AddProftoCourse">
                <input type="hidden" name="order" value="1"/>
				<div class="w3-row">
			<div class="w3-col w3-half">
				<div class="w3-container">
					<h3>Adicionar Professor a um Curso</h3>
						<div class="w3-input-group">
							<label>ID do Curso</label>
							<input class="w3-input" name="idc" type="number" required />
						</div>
                        <div class="w3-input-group">
							<label>ID do Professor</label>
							<input class="w3-input" name="idp" type="number" required />
						</div>
						<br>
						<input type="submit" class="w3-btn w3-cyan" value="Adicionar"/>
				</div>
			</div>
			</form>
	</div>
</body>
</html>