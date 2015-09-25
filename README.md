# jms-topic
JMS Application to send messages to Websphere MQ using Topic

Use command ```crtmqm``` to create a queue manager called QMA as follows:

```bash
crtmqm QMA
```

Use ```strmqm``` command to start the queue manager QMA as follow:

```bash
strmqm QMA
```

Start MQSC to define a local topic called MYTOPIC with topic string called News then stop MQSC as follows:

```bash
runmqsc QMA
define topic(MYTOPIC) topicstr(News) cluster(NEWCLUSTER) 
display topic(MYTOPIC) 
end
```

To get the message, Change into the MQ_INSTALLATION_PATH/samp/bin directory and execute the commands:

```bash
cd /opt/mqm/samp/bin/
./amqssub News QMA

```

References:

1. http://sadockobeth.blogspot.in/2014/03/how-to-install-ibm-websphere-mq-75-on.html

2. http://www-01.ibm.com/support/docview.wss?uid=swg27016146

3. http://mqpubsub.blogspot.in/
