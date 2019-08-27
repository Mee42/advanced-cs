#this is stuff that is per-project
MAIN_FILE_NAME = "RationalNum"








# this is Makefile stuff. You shouldn't have to edit this, but if you do edit it edit the base.Makefile as well
SOURCE_FILES   := $(wildcard *.java)
CLASS_FILES    := $(SOURCE_FILES:.java=.class)

.PHONY: run
	

%.class: %.java
	javac -g $<

run: $(CLASS_FILES)
	java $(MAIN_FILE_NAME)
