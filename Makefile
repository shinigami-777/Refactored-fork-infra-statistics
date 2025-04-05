GROOVY=groovy
GROOVYC=groovyc
TEST_DIR=test
OUT_DIR=out
TEST_SOURCES=$(wildcard $(TEST_DIR)/*.groovy)

# Run tests
.PHONY: test
test:
	@echo "Running tests..."
	@mkdir -p $(OUT_DIR)
	@groovyc -d $(OUT_DIR) $(TEST_SOURCES)
	@groovy runtests.groovy
	@echo "All tests completed..."
	@rm -rf $(OUT_DIR)

# Clean temporary files or directories if needed
.PHONY: clean
clean:
	@echo "Cleaning temporary files..."
	@rm -rf tmp/ target/ out/

# Start the MongoDB container needed for the scripts
.PHONY: start-mongo
start-mongo:
	@echo "🔍 Checking for existing MongoDB container..."
	@if [ $$(docker ps -a -q -f name=mongodb) ]; then \
		echo "Stopping and removing existing mongodb container..."; \
		docker stop mongodb > /dev/null; \
		docker rm mongodb > /dev/null; \
	fi
	@echo "Starting MongoDB container..."
	@docker run -d --name mongodb -p 27017:27017 --network host mongo:2
	@echo "MongoDB container is up!"
