jrosbridge [![Build Status](https://api.travis-ci.org/rctoris/jrosbridge.png)](https://travis-ci.org/rctoris/jrosbridge)
==========

#### A Native Java EE rosbridge Client -- modified version which works on android

### Example Usage

In order to use this library on android, compile it as jar (or use the .jar from the /build folder) and add it to your android project. The gradle dependencies should look like this:
```
compile files('libs/jrosbridge.jar')
compile group: 'org.glassfish', name: 'javax.json', version: '1.0.4'
compile 'org.java-websocket:Java-WebSocket:1.3.0'
```

```java
public static void main(String[] args) throws InterruptedException {
	final Ros ros = new Ros("localhost");

	ros.connect(new ConnectionCallback() {
		public void onOpen(ServerHandshake serverHandshake) {
			Topic topic = new Topic(ros, "/echo_back", "std_msgs/String");
			topic.subscribe(new TopicCallback() {
				public void handleMessage(Message message) {
					System.out.println(message);
				}
			});
		}

		public void onClose(int i, String s, boolean b) {
			System.out.println("on close");
		}

		public void onError(Exception e) {
			System.out.println("on error");
			e.printStackTrace();
		}
	});
}
```

### License
jrosbridge is released with a BSD license. For full terms and conditions, see the [LICENSE](LICENSE) file.

### Authors
See the [AUTHORS](AUTHORS.md) file for a full list of contributors.
