# Project settings
SCALA_VERSION = 2.13.10          # Specify your Scala version here
SCALA_SRC = src                  # Source directory for Scala files
SCALA_BIN = bin                  # Output directory for compiled classes
JAR_FILE = MyApp.jar             # Name of the output JAR file

# Scala compiler settings
SCALAC = scalac                  # The Scala compiler command
SCALA = scala                    # The Scala runner command
SCALAC_FLAGS = -deprecation -encoding utf8 -feature -unchecked # Compiler flags

# Find all Scala files in the source directory
SOURCES = $(shell find $(SCALA_SRC) -name "*.scala")

# Default target: compile and package
all: $(JAR_FILE)

# Compile all Scala files to the bin directory
compile:
	@mkdir -p $(SCALA_BIN)
	$(SCALAC) $(SCALAC_FLAGS) -d $(SCALA_BIN) $(SOURCES)

# Package the compiled classes into a JAR file
$(JAR_FILE): compile
	@echo "Packaging JAR file: $(JAR_FILE)"
	jar cf $(JAR_FILE) -C $(SCALA_BIN) .

# Clean up compiled classes and JAR files
clean:
	@echo "Cleaning up..."
	rm -rf $(SCALA_BIN)/*.class $(JAR_FILE)

# Run the Scala program from the JAR file
run: $(JAR_FILE)
	@echo "Running the application..."
	$(SCALA) -classpath $(JAR_FILE) CcWc $(RUN_ARGS)

# Phony targets
.PHONY: all clean compile run

