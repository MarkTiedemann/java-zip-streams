SHELL := cmd.exe

JAVA_HOME := $(USERPROFILE)\scoop\apps\adoptopenjdk-openj9\current
JAVAC := $(JAVA_HOME)\bin\javac.exe
JAVA := $(JAVA_HOME)\bin\java.exe

.PHONY:
all: $(JAVA) Example.class
	$(JAVA) -cp . Example

Example.class: $(JAVAC) Example.java
	$(JAVAC) Example.java

$(JAVAC) $(JAVA):
	scoop bucket add java
	scoop install adoptopenjdk-openj9
