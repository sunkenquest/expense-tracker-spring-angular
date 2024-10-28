
seed:
	@echo "Seeding the database..."
	mvnw spring-boot:run -Dspring-boot.run.arguments=seed

back:
	mvnw spring-boot:run
	
front:
	cd frontend && npm start