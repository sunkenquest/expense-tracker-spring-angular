
seed:
	@echo "Seeding the database..."
	mvn spring-boot:run -Dspring-boot.run.arguments="--spring.profiles.active=dev --run-seeder"
