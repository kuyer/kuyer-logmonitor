#!/bin/sh
#
# logmonitor - this script start or stop the logmonitor daemon
# 
# chkconfig:	-85 15
# description: logmonitor
# processname: logmonitor
# pidfile: /var/run/logmonitor.pid
#
########## set java-1.8 start ##########
# JAVA_HOME=/usr/local/jdk
# PATH=$JAVA_HOME/bin:$PATH
# export JAVA_HOME PATH
########## set  java-1.8  end ##########

source /etc/profile

start() {
	for pid in `ps -ef | grep logmonitor | grep -v grep | grep -v "/etc/init.d/logmonitor" | awk '{print $2}'`; do
		kill $pid
	done
	rm -rf /var/run/logmonitor.pid;
	if [ ! -f /var/run/logmonitor.pid ]; then
		nohup java -Xms512m -Xmx1024m -jar /usr/local/logmonitor.jar >> /dev/null 2>&1 &
		echo $! > /var/run/logmonitor.pid
		echo "start logmonitor:								[ OK ]"
	else
		echo "logmonitor is running:								[ OK ]"
	fi
}
stop() {
}
status() {
	if [ -f /var/run/logmonitor.pid ]; then
		pid=`cat /var/run/logmonitor.pid`;
		runpid = `ps -ef | grep logmonitor | grep -v "grep" | awk -F " " '{print $2}' | head -1`;
		if [[ $pid = $runpid ]]; then
			echo "logmonitor is running."
		else
			echo "logmonitor is stoped."
		fi
	else
		echo "logmonitor is stoped."
	fi
}
restart() {
	if [ -f /var/run/logmonitor.pid ]; then
		stop
		sleep 3
		start
	else
		echo "Stop logmonitor:								[Failed]"
		sleep 3
		start
	fi
}
case "$1" in
	start)
		start || exit 0
		;;
	stop)
		stop || exit 0
		;;
	restart)
		restart
		;;
	status)
		status
		;;
	*)
		echo $"Usage: $0 {start|stop|restart|status}"
		exit 2
esac