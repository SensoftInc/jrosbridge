jrosbridge [![Build Status](https://api.travis-ci.org/rctoris/jrosbridge.png)](https://travis-ci.org/rctoris/jrosbridge)
==========

#### A Native Java EE rosbridge Client -- modified version which works on android

### Example Usage


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
