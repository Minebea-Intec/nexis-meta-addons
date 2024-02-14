PROGRAM := rastertostarm

CFLAGS += -Wall

CFLAGS += -Wall -fPIC -O2
LDLIBS += -lcupsimage -lcups

all: $(PROGRAM)

OBJS = rastertostarm.o

$(PROGRAM): $(OBJS)
	$(CC) $(LDFLAGS) $^ $(LDLIBS) -o $@

#.PHONY: install
#install: $(PROGRAM)
#	install -d $(DESTDIR)/usr/bin
#	install -m 0755 $(PROGRAM) $(DESTDIR)/usr/bin/

.PHONY: clean
clean:
	-rm -f *.o $(PROGRAM)
