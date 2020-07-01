/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * @author lxz35
 *
 */
public class TalkS {
	public static void main(String[] args) {
		new Thread(new TalkSend(9999)).start();//接受
	}

}
