
<!DOCTYPE html>
<html>
<body>
		<div class="w3-container">
			<form class="w3-form" method="post" action="DeleteMaterial">
                <input type="hidden" name="order" value="1"/>
				<div class="w3-row">
			<div class="w3-col w3-half">
				<div class="w3-container">
					<h3>Apagar Material</h3>
						<div class="w3-input-group">
							<label>ID do Material</label>
							<input class="w3-input" name="id" type="number" required />
						</div>
						<br>
						<input type="submit" class="w3-btn w3-cyan" value="Apagar"/>
				</div>
			</div>
			</form>
	</div>
</body>
</html>